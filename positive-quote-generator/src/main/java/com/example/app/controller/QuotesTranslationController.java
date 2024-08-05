package com.example.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.QuotesTranslation;
import com.example.app.service.QuotesTranslationService;

@RestController
@RequestMapping(path = "api/translatedQuotes")
public class QuotesTranslationController {

    private final QuotesTranslationService quotesTranslationService;

    public QuotesTranslationController(QuotesTranslationService quotesTranslationService) {
        this.quotesTranslationService = quotesTranslationService;
    }

    @GetMapping("/getAllQuotes")
    public List<QuotesTranslation> getAllQuotesTranslation() {
        return quotesTranslationService.getAllQuotesTranslation();
    }

    @GetMapping("/getRandomQuotes")
    public List<QuotesTranslation> getRandomThreeQuotes() {
        return quotesTranslationService.getTranslatedQuotesByRandomQuoteId();
    }
}
