package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.AllQuotes;

public interface AllQuotesRepository extends JpaRepository<AllQuotes, Long> {

}
