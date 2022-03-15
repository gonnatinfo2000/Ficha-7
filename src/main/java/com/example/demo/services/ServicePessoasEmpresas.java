package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Empresa;
import com.example.demo.model.Pessoa;

@Service
public class ServicePessoasEmpresas {
	List<Empresa> empresas = new ArrayList<>();
	List<Pessoa> pessoas = new ArrayList<>();
	
	public List<Pessoa> addPessoa(Pessoa pessoa){
		System.out.println(pessoa);
		pessoas.add(pessoa);
		return pessoas;
	}
	
	public String updatePessoa(Pessoa pessoa) {
		for(Pessoa pessoaAux: pessoas) {
				if(pessoa.getIdade() > 0) {
					pessoaAux.setIdade(pessoa.getIdade());
				}	
			
				if(pessoa.getNome() != null && !pessoa.getNome().isBlank()) {
					pessoaAux.setNome(pessoa.getNome());
				}
				
				if(pessoa.getEmail() != null && !pessoa.getEmail().isBlank() && pessoa.getEmail().contains("@")){
					pessoaAux.setEmail(pessoa.getEmail());
				}
			return "Sucesso";
		}
		return "id não existe";
	}
	
	public String deletePessoa(String id) {
		try {
			Long id_pessoa = Long.parseLong(id);
			
			for(Pessoa pessoaAux: pessoas) {
				if(pessoaAux.getId() == id_pessoa) {
					pessoas.remove(pessoaAux);
					return "Sucesso";
				}
			}
			return "Id não existe";
		}catch(Exception e){
			return "Id privado";
		}
	}
	
	public List<Pessoa> getAllPessoas(){
		return pessoas;
	}
	
	public Pessoa getPessoaById(String id){
			Long id_pessoa = Long.parseLong(id);
			
			for(Pessoa pessoaAux: pessoas) {
				if(pessoaAux.getId() == id_pessoa) {
					return pessoaAux;
				}
			}
			
			return null;	
	}	
	
	public List<Empresa> addEmpresa(Empresa empresa){
		System.out.println(empresa);
		
		for(Pessoa pessoaAux: pessoas) {
			empresa.setNumeroFuncionariosAtual(empresa.getNumeroFuncionariosAtual() + 1);
			pessoaAux.setEmpresa_id(empresa.getId());
		}	
		
		empresa.setNumeroFuncionariosDesdeCriacao(empresa.getNumeroFuncionariosAtual());

		empresas.add(empresa);
		return empresas;
	}
	
	public String updateEmpresa(Empresa empresa) {
		for(Empresa empresaAux: empresas) {
				if(!(empresa.getNome() == null)  && !empresa.getNome().isBlank()) {
					empresaAux.setNome(empresa.getNome());
				}
				
				if(!(empresa.getMorada() == null) && !empresa.getMorada().isBlank()) {
					empresaAux.setMorada(empresa.getMorada());
				}
			return "Sucesso.";
		}
		return "Id não existe.";
	}
	
	public String deleteEmpresa(String id) {
		try {
			Long id_empresa = Long.parseLong(id);
			
			for(Empresa empresaAux: empresas) {
				if(empresaAux.getId() == id_empresa) {
					for(Pessoa pessoaAux: pessoas) {
						if(pessoaAux.getEmpresa_id() == empresaAux.getId()) {
							pessoas.remove(pessoaAux);
						}
					}
					empresas.remove(empresaAux);
					return "Sucesso.";
				}
			}
		}catch(Exception e){
			return "Id privado";
		}
		return id;
	}
	
	public List<Empresa> getAllEmpresas(){
		return empresas;
	}
	
	public Empresa getEmpresaById(String id){
			Long id_empresa = Long.parseLong(id);
			
			for(Empresa empresaAux: empresas) {
				if(empresaAux.getId() == id_empresa) {
					return empresaAux;
				}
			}
			
			return null;	
	}	
}
