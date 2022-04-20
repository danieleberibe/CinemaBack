package com.example.cinemaBack.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;




@Entity
@Table(name="ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "posto")
    private int posto;

    @Column(name = "tariffa")
    private int tariffa;

    @Column(name = "id_orario")
    private int idOrario;

    @Column(name = "id_utente")
    private int idUtente;

    @Column(name = "id_sala")
    private int idSala;

    public Ticket(){

    }

    public Ticket(int posto, int tariffa, int idOrario, int idUtente, int idSala) {
        this.posto = posto;
        this.tariffa = tariffa;
        this.idOrario = idOrario;
        this.idUtente = idUtente;
        this.idSala = idSala;
    }
  
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPosto() {
        return this.posto;
    }

    public void setPosto(int posto) {
        this.posto = posto;
    }

    public int getTariffa() {
        return this.tariffa;
    }

    public void setTariffa(int tariffa) {
        this.tariffa = tariffa;
    }

    public int getIdOrario() {
        return this.idOrario;
    }

    public void setIdOrario(int idOrario) {
        this.idOrario = idOrario;
    }

    public int getIdUtente() {
        return this.idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public int getIdSala() {
        return this.idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    @Override
	public String toString() {
		return "Tutorial [id=" + id + ", nome=" + posto + ", cognome=" + tariffa + ", email=" + idOrario + ", email=" + idUtente + ", email=" + idSala + " ]";
	}

}
