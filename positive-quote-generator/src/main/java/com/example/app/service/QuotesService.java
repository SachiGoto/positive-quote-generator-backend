package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.entity.Quotes;
import com.example.app.repository.QuotesRepository;


@Service
public class QuotesService {

	private final QuotesRepository quotesRepository;
	
	public QuotesService(QuotesRepository quotesRepository) {
		this.quotesRepository = quotesRepository;
	}
	
	public List<Quotes> getQuotes() {
		// TODO Auto-generated method stub
		return  quotesRepository.findAll();
	
	}

	public void addQuote(Quotes quote) {
        System.out.println("quotes from post request"+  quote);
		quotesRepository.save(quote);
		
		
	}
	
	public void deleteQuote(Long id) {
		boolean exists = quotesRepository.existsById(id);
		if(!exists){
			throw new IllegalStateException("id doesn't exists");
		}
		quotesRepository.deleteById(id);
		
	}

}
