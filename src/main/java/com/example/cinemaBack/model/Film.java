package com.example.cinemaBack.model;

import javax.persistence.*;

@Entity
@Table(name="film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "genere")
    private String genere;

    @Column(name = "regista")
    private String regista;

    @Column(name = "produttore")
    private String produttore;

    @Column(name = "durata")
    private int durata;

    @Column(name = "imgpath")
    private String imgpath;

    @Column(name = "attivo")
    private int attivo;

    public Film() {
   
    }
    public Film(String nome, String descrizione, String genere, String regista, String produttore, int durata, String imgpath, int attivo) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.genere = genere;
        this.regista = regista;
        this.produttore = produttore;
        this.durata = durata;
        this.imgpath = imgpath;
        this.attivo = attivo;
	}

    public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

    public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

    public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}

    public String getRegista() {
		return regista;
	}
	public void setRegista(String regista) {
		this.regista = regista;
	}

    public String getProduttore() {
		return produttore;
	}
	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}

    public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}

    public String getImg() {
		return imgpath;
	}
	public void setImg(String imgpath) {
		this.imgpath = imgpath;
	}

    public int getAttivo() {
		return attivo;
	}
	public void setAttivo(int attivo) {
		this.attivo = attivo;
	}

    @Override
	public String toString() {
		return "Tutorial [id=" + id + ", nome=" + nome + ", cognome=" + descrizione + ", email=" + regista + " ]";
	}
    
    
}
