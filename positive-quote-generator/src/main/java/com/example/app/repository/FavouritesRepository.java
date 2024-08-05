package com.example.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.app.entity.Favourites;

import jakarta.transaction.Transactional;

@Repository
public interface FavouritesRepository extends JpaRepository<Favourites, Long> {

	 @Query("SELECT f.allQuotes.id FROM Favourites f WHERE f.user.id = :userId")
	    List<Long> findQuoteIdsByUserId(@Param("userId") Long userId);

	 @Modifying
	    @Transactional
	    @Query("DELETE FROM Favourites f WHERE f.user.id = :userId AND f.allQuotes.id = :quoteId")
	    void deleteByUserAndQuoteId(@Param("userId") Long userId, @Param("quoteId") Long quoteId);
	 
	 Optional<Favourites> findByUserIdAndAllQuotesId(Long userId, Long quoteId);
	 
	}

