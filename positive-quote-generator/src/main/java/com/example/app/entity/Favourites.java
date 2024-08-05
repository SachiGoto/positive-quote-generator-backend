package com.example.app.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "favourites")
public class Favourites {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "favourites_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "quotes_id", nullable = false)
    private AllQuotes allQuotes;

//    @Column(name = "quotes_id", nullable = false)
//    private Long quotes_id;

    @Column(name = "created_at", nullable = false)
    private LocalDate created_at;

    public Favourites(Long id, User user, AllQuotes all_quotes, LocalDate created_at) {
        this.id = id;
        this.user = user;
        this.allQuotes = all_quotes;
        this.created_at = created_at;
    }

    public Favourites() {}

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   
    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

	public AllQuotes getAllQuotes() {
		return allQuotes;
	}

	public void setAllQuotes(AllQuotes allQuotes) {
		this.allQuotes = allQuotes;
	}
    
	 @Override
	    public String toString() {
	        return "Favourites{" +
	                "user_id =" + user.getId() +
	                ", quotes_id =" + allQuotes.getId() +
	                ", created_at=" + created_at +
	                '}';
	    }
 
}
