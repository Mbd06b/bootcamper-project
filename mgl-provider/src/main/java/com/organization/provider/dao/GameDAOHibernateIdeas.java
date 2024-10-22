package com.organization.provider.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.organization.provider.model.persistent.GameImpl;
import com.organization.provider.model.persistent.ReviewImpl;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@Repository
public class GameDAOHibernateIdeas extends BaseHibernateDAO {

    // Approach 1: JPA Criteria API with aggregates
    public List<GameImpl> findGamesByMinAvgRatingCriteria(int minRating) {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        
        // Create main query for GameImpl
        CriteriaQuery<GameImpl> query = cb.createQuery(GameImpl.class);
        Root<GameImpl> game = query.from(GameImpl.class);
        Join<GameImpl, ReviewImpl> reviews = game.join("reviews", JoinType.LEFT);
        
        // Group by game attributes we need
        query.groupBy(game.get("id"), game.get("title"), game.get("genre"));
        
        // Where average rating is >= minRating
        query.having(cb.ge(cb.avg(reviews.get("rating")), minRating));
        
        // Select distinct games
        query.select(game).distinct(true);
        
        // Add order by average rating descending
        query.orderBy(cb.desc(cb.avg(reviews.get("rating"))));
        
        return session.createQuery(query)
            .getResultList();
    }
    
    // Alternative Criteria approach returning DTO with rating info
    public List<GameRatingDTO> findGameRatingDetailsCriteria(int minRating) {
        Session session = getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        
        CriteriaQuery<GameRatingDTO> query = cb.createQuery(GameRatingDTO.class);
        Root<GameImpl> game = query.from(GameImpl.class);
        Join<GameImpl, ReviewImpl> reviews = game.join("reviews", JoinType.LEFT);
        
        query.multiselect(
            game.get("id"),
            game.get("title"),
            game.get("genre"),
            cb.avg(reviews.get("rating")).alias("averageRating"),
            cb.count(reviews).alias("reviewCount")
        )
        .groupBy(
            game.get("id"),
            game.get("title"),
            game.get("genre")
        )
        .having(cb.ge(cb.avg(reviews.get("rating")), minRating))
        .orderBy(cb.desc(cb.avg(reviews.get("rating"))));
        
        return session.createQuery(query)
            .getResultList();
    }

    // Approach 2: Modern Hibernate HQL with type safety
    public List<GameImpl> findGamesByMinAvgRatingHQL(int minRating) {
        return getCurrentSession()
            .createSelectionQuery(
                "select distinct g from GameImpl g " +
                "left join g.reviews r " +
                "group by g.id, g.title, g.genre " +
                "having avg(r.rating) >= :minRating " +
                "order by avg(r.rating) desc", 
                GameImpl.class)
            .setParameter("minRating", minRating)
            .getResultList();
    }
    
    // Alternative HQL approach returning DTO
    public List<GameRatingDTO> findGameRatingDetailsHQL(int minRating) {
        return getCurrentSession()
            .createSelectionQuery(
                "select new com.example.GameRatingDTO(" +
                "   g.id, " +
                "   g.title, " +
                "   g.genre, " +
                "   avg(r.rating), " +
                "   count(r)) " +
                "from GameImpl g " +
                "left join g.reviews r " +
                "group by g.id, g.title, g.genre " +
                "having avg(r.rating) >= :minRating " +
                "order by avg(r.rating) desc",
                GameRatingDTO.class)
            .setParameter("minRating", minRating)
            .getResultList();
    }
}

// DTO transformed off the database  for detailed rating information
class GameRatingDTO {
    private Long id;
    private String title;
    private String genre;
    private Double averageRating;
    private Long reviewCount;
    
    public GameRatingDTO(
            Long id, 
            String title, 
            String genre, 
            Double averageRating, 
            Long reviewCount) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
        this.reviewCount = reviewCount;
    }
    
    // getters and setters
}

// Example usage
//	@Service
//	public class GameRatingService {
//	    @Autowired
//	    private GameRatingQueries gameRatingQueries;
//	    
//		@Transactional
//	    public void demonstrateQueries() {
//	        // Get all games with average rating >= 4
//	        List<GameImpl> highlyRatedGames = 
//	            gameRatingQueries.findGamesByMinAvgRatingCriteria(4);
//	            
//	        // Get detailed rating information
//	        List<GameRatingDTO> gameRatings = 
//	            gameRatingQueries.findGameRatingDetailsCriteria(4);
//	            
//	        // Process results
//	        gameRatings.forEach(dto -> 
//	            System.out.printf("Game: %s, Avg Rating: %.2f, Reviews: %d%n",
//	                dto.getTitle(),
//	                dto.getAverageRating(),
//	                dto.getReviewCount())
//	        );
//	    }
//	}
