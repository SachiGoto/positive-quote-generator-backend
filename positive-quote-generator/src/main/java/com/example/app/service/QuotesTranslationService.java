package com.example.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.app.entity.QuotesTranslation;
import com.example.app.repository.QuotesTranslationRepository;


@Service
public class QuotesTranslationService {
	
	private final QuotesTranslationRepository quotesTranslationRepository;
	private List<Integer> remainingQuoteIds;
	
	public QuotesTranslationService(QuotesTranslationRepository quotesTranslationRepository) {
		this.quotesTranslationRepository = quotesTranslationRepository;
		this.remainingQuoteIds = new ArrayList<>();
	}

	public List<QuotesTranslation> getAllQuotesTranslation() {
		return quotesTranslationRepository.findAll();
	}
	
    // Method to fetch a random quote_id
    public Integer getRandomQuoteId() {
        if (remainingQuoteIds.isEmpty()) {
            remainingQuoteIds = quotesTranslationRepository.findAllQuoteIds();
            Collections.shuffle(remainingQuoteIds);
        }
       
        return remainingQuoteIds.remove(remainingQuoteIds.size()-1);
    }

    // Method to fetch quotes by quote_id
    public List<QuotesTranslation> getQuotesByQuoteId(Integer randomQuoteId) {
        return quotesTranslationRepository.findByQuoteId(randomQuoteId);
    }

    // Method to fetch three quotes(Japanese, Korean, English) by a random quote_id
    public List<QuotesTranslation> getTranslatedQuotesByRandomQuoteId() {
        Integer randomQuoteId = getRandomQuoteId();
        List<QuotesTranslation> quotes = getQuotesByQuoteId(randomQuoteId);
        return quotes.stream().collect(Collectors.toList());
    }
    
    
	
}
