package com.example.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.app.entity.QuotesTranslation;

@Repository
public interface QuotesTranslationRepository extends JpaRepository<QuotesTranslation, Long> {

	    List<QuotesTranslation> findAll();
	    
	    List<QuotesTranslation> findByQuoteId(int quote_id);
	    
	    @Query("SELECT DISTINCT q.quoteId FROM QuotesTranslation q")
	    List<Integer> findAllQuoteIds();
	    
	    @Query("SELECT qt FROM QuotesTranslation qt WHERE qt.quoteId IN :quoteIds")
	    List<QuotesTranslation> findByQuoteIds(@Param("quoteIds") List<Long> quoteIds);

}
