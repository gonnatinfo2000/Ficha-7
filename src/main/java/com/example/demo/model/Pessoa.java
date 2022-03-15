package com.example.demo.model;

public class Pessoa {
	private static int numPessoas = 0;
	private int id;
	private String nome;
	private int idade;
	private String email;
	private Integer empresa_id;
	
	public Pessoa(String nome, int idade, String email) {
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.empresa_id = null;
		id = numPessoas;
		numPessoas++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmpresa_id() {
		return empresa_id;
	}

	public void setEmpresa_id(int empresa_id) {
		this.empresa_id = empresa_id;
	}

}
