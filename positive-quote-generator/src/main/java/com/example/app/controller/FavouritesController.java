package com.example.app.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.app.entity.QuotesTranslation;
import com.example.app.service.FavouritesService;

@RestController
@RequestMapping(path = "api/favourites")
public class FavouritesController {

    private final FavouritesService favouritesService;

    public FavouritesController(FavouritesService favouritesService) {
        this.favouritesService = favouritesService;
    }

    @GetMapping("/getQuotes/{userId}")
    public List<QuotesTranslation> getQuotes(@PathVariable("userId") Long userId) {
        return favouritesService.getQuotes(userId);
    }
    
    
//    http://localhost:8080/api/favourites/getQuotes?userId=802
//    @GetMapping("/getQuotes")
//    public List<QuotesTranslation> getQuotes(@RequestParam(name = "userId") Long userId) {
//        return favouritesService.getQuotes(userId);
//    }

    @PostMapping("/addQuote/{userId}/{quoteId}")
    public void addQuote(@PathVariable("userId") Long userId, @PathVariable("quoteId") Long quoteId) {
        favouritesService.addQuote(userId, quoteId);
    }

    @DeleteMapping("/deleteFavourite/{userId}/{quoteId}")
    public void deleteQuote(@PathVariable("userId") Long userId, @PathVariable("quoteId") Long quoteId) {
        favouritesService.deleteByUserAndQuoteId(userId, quoteId);
    }
}
