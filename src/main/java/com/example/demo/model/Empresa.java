package com.example.demo.model;

public class Empresa {
	private static int numEmpresas = 0;
	private int id;
	private String nome;
	private String morada;
	private int numeroFuncionariosAtual;
	private int numeroFuncionariosDesdeCriacao;
	
	
	public Empresa(String nome, String morada, int numeroFuncionariosAtual,
			int numeroFuncionariosDesdeCriacao) {
		this.nome = nome;
		this.morada = morada;
		this.numeroFuncionariosAtual = numeroFuncionariosDesdeCriacao;
		this.numeroFuncionariosDesdeCriacao = numeroFuncionariosDesdeCriacao;
		id = numEmpresas;
		numEmpresas++;
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
	public String getMorada() {
		return morada;
	}
	public void setMorada(String morada) {
		this.morada = morada;
	}
	public int getNumeroFuncionariosAtual() {
		return numeroFuncionariosAtual;
	}
	public void setNumeroFuncionariosAtual(int numeroFuncionariosAtual) {
		this.numeroFuncionariosAtual = numeroFuncionariosAtual;
	}
	public int getNumeroFuncionariosDesdeCriacao() {
		return numeroFuncionariosDesdeCriacao;
	}
	public void setNumeroFuncionariosDesdeCriacao(int numeroFuncionariosDesdeCriacao) {
		this.numeroFuncionariosDesdeCriacao = numeroFuncionariosDesdeCriacao;
	}
	
	
}
