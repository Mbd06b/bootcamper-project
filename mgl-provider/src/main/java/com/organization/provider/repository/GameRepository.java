package com.organization.provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.provider.model.GameImpl;


public interface GameRepository extends JpaRepository<GameImpl, Long>, GameRepositoryCustom {
	
}