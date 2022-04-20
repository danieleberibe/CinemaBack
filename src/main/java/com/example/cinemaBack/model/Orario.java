package com.example.cinemaBack.model;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.*;

@Entity
@Table(name="orario")
public class Orario {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "inizio")
    private LocalTime inizio;

    @Column(name = "fine")
    private LocalTime fine;
    
    public Orario() {}

    public Orario(long id, LocalTime inizio, LocalTime fine) {
        this.id = id;
        this.inizio = inizio;
        this.fine = fine;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getinizio() {
        return this.inizio;
    }

    public void setinizio(LocalTime inizio) {
        this.inizio = inizio;
    }

    public LocalTime getfine() {
        return this.fine;
    }

    public void setfine(LocalTime fine) {
        this.fine = fine;
    }

    @Override
	public String toString() {
		return "Tutorial [id=" + id + ", inizio=" + inizio + ", fine=" + fine + " ]";
	}

}