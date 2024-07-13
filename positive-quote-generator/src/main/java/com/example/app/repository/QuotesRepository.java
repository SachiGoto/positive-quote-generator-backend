package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Quotes;

public interface QuotesRepository extends JpaRepository<Quotes, Long> {

}
