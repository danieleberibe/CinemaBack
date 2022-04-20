package com.example.cinemaBack.model;

import java.sql.Date;

import javax.persistence.*;




@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "data_nascita")
    private Date data_nascita;

    public User() {

	}

    public User(String nome, String cognome, String email, String password, Date data_nascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
        this.password = password;
        this.data_nascita = data_nascita;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public Date getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

    @Override
	public String toString() {
		return "Tutorial [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + " ]";
	}
	
    

}