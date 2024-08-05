package com.example.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.entity.AllQuotes;
import com.example.app.entity.Favourites;
import com.example.app.entity.QuotesTranslation;
import com.example.app.entity.User;
import com.example.app.exception.FavouriteAlreadyExistsException;
import com.example.app.exception.QuoteNotFoundException;
import com.example.app.exception.UserNotFoundException;
import com.example.app.repository.AllQuotesRepository;
import com.example.app.repository.FavouritesRepository;
import com.example.app.repository.QuotesTranslationRepository;
import com.example.app.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class FavouritesService {

    private final FavouritesRepository favouritesRepository;
    private final UserRepository userRepository;
    private final AllQuotesRepository allQuotesRepository;
    private final QuotesTranslationRepository quotesTranslationRepository;

    public FavouritesService(FavouritesRepository favouritesRepository, UserRepository userRepository,
                             AllQuotesRepository allQuotesRepository, QuotesTranslationRepository quotesTranslationRepository) {
        this.favouritesRepository = favouritesRepository;
        this.userRepository = userRepository;
        this.allQuotesRepository = allQuotesRepository;
        this.quotesTranslationRepository = quotesTranslationRepository;
    }

    @Transactional
    public Favourites addQuote(Long userId, Long quoteId) {
        // Ensure that the user exists
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        // Ensure that the quote id exists
        AllQuotes allQuotes = allQuotesRepository.findById(quoteId).orElseThrow(() ->new QuoteNotFoundException("Quote not found"));
        // Only when user and quote both exist, create a favourite object and add it to the favourites table.
        favouritesRepository.findByUserIdAndAllQuotesId(userId, quoteId).ifPresent(favourite -> {
            throw new FavouriteAlreadyExistsException("You already added this quote to your favourite list");
        });
        
        Favourites favourite = new Favourites();
        favourite.setUser(user);
        favourite.setAllQuotes(allQuotes);
        favourite.setCreated_at(LocalDate.now());

        return favouritesRepository.save(favourite);
    }

    public List<QuotesTranslation> getQuotes(Long userId) {
        // Ensure that the user exists
        userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // Fetch all quoteIds from Favourites for the given userId
        List<Long> quoteIds = favouritesRepository.findQuoteIdsByUserId(userId);

        // Fetch and return the quotes translation data for the collected quoteIds
        return quotesTranslationRepository.findByQuoteIds(quoteIds);
    }


    public void deleteByUserAndQuoteId(Long userId, Long quoteId) {
        favouritesRepository.deleteByUserAndQuoteId(userId, quoteId);
    }
}
