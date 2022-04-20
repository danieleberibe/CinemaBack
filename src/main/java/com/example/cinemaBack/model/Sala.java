package com.example.cinemaBack.model;


import javax.persistence.*;

@Entity
@Table(name="sala")

public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "postitot")
    private int postiTot;

    @Column(name = "numerosala")
    private int numSala;

    @Column(name = "attivo")
    private int attivo;

    public Sala(){}

    public Sala(long id, int postiTot, int numSala, int attivo) {
        this.id = id;
        this.postiTot = postiTot;
        this.numSala = numSala;
        this.attivo = attivo;
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPostiTot() {
        return this.postiTot;
    }

    public void setPostiTot(int postiTot) {
        this.postiTot = postiTot;
    }

    public int getNumSala() {
        return this.numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public int getAttivo() {
        return this.attivo;
    }

    public void setAttivo(int attivo) {
        this.attivo = attivo;
    }
    

    @Override
	public String toString() {
		return "Tutorial [id=" + id + ", postitot=" + postiTot + ", numSala=" + numSala + ", attivo=" + attivo + " ]";
	}
    
}
