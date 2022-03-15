
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pessoa;
import com.example.demo.services.ServicePessoasEmpresas;

@RestController
public class ControladorPessoa {
	ArrayList<Pessoa> pessoas = new ArrayList<>();
	
	private final ServicePessoasEmpresas servicePessoasEmpresas;
	
	@Autowired
	public ControladorPessoa(ServicePessoasEmpresas servicePessoasEmpresas) {
		this.servicePessoasEmpresas = servicePessoasEmpresas;
	}
	
	@PostMapping("/addPessoa")
    public List<Pessoa> addPessoa(@RequestBody Pessoa pessoa){
    	if(pessoa.getNome() == null || pessoa.getNome().isBlank() || pessoa.getIdade()<=0 || pessoa.getEmail() == null || pessoa.getEmail().isBlank() || !(pessoa.getEmail().contains("@"))) {
    		return Collections.EMPTY_LIST;
    	}
    	
    	List<Pessoa> aux = servicePessoasEmpresas.addPessoa(pessoa);
    	return aux;
    }
    
    @PutMapping("/updatePessoa")
    public String updatePessoa(@RequestBody Pessoa pessoa){
    	return servicePessoasEmpresas.updatePessoa(pessoa);
    }
    
    
    @DeleteMapping("/deletePessoa/{id}")
    public String deletePessoa(@PathVariable String id) {
		return servicePessoasEmpresas.deletePessoa(id);
    }
    
    @GetMapping("/getAllPessoas")
    public List<Pessoa> getAllPessoas(){
    	return servicePessoasEmpresas.getAllPessoas();
    }
    
    @GetMapping("/getPessoaById/{id}")
    public Pessoa getPessoaById(@PathVariable String id){
    	return servicePessoasEmpresas.getPessoaById(id);
    }
}