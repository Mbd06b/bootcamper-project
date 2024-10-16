package com.organization.provider.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/*
 * This BaseHibernateDAO is a compromise. It uses the standard JPA EntityManager but then unwraps it to access Hibernate-specific features when needed.
 *  This approach allows:
 *	 - Compliance with JPA standards for most operations
 *	 - Access to Hibernate-specific optimizations when necessary
 */
public abstract class BaseHibernateDAO {

    @PersistenceContext
    protected EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }

    protected SessionFactory getSessionFactory() {
        return entityManager.unwrap(SessionFactory.class);
    }
}