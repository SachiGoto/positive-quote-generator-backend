package com.example.app.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "quotes")
public class Quotes {
	 @Id
	   @SequenceGenerator(
			   name="quotes_sequence",
			   sequenceName="quotes_sequence",
			   allocationSize=1
			   )
	   @GeneratedValue(
			   strategy = GenerationType.SEQUENCE,
			   generator = "quotes_sequence"
			   )
		private Long id;
		private String quote;
		private String category;
		private String author;
		private LocalDate created_at;


		public Quotes(String quote, String category, String author, LocalDate created_at) {
			this.quote = quote;
			this.category = category;
			this.author = author;
			this.created_at = created_at;
		}
		
		public Quotes() {
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getQuote() {
			return quote;
		}

		public void setQuote(String quote) {
			this.quote = quote;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public LocalDate getCreated_at() {
			return created_at;
		}

		public void setCreated_at(LocalDate created_at) {
			this.created_at = created_at;
		}

		

		

}
