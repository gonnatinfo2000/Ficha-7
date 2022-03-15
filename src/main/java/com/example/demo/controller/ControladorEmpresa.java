
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

import com.example.demo.model.Empresa;
import com.example.demo.model.Pessoa;
import com.example.demo.services.ServicePessoasEmpresas;

@RestController
public class ControladorEmpresa {
	ArrayList<Empresa> empresas = new ArrayList<>();
	
	private final ServicePessoasEmpresas servicePessoasEmpresas;
	
	@Autowired
	public ControladorEmpresa(ServicePessoasEmpresas servicePessoasEmpresas) {
		this.servicePessoasEmpresas = servicePessoasEmpresas;
	}
	
    @PostMapping("/addEmpresa")
    public List<Empresa> addEmpresa(@RequestBody Empresa empresa){
    	if(empresa.getNome() == null || empresa.getNome().isBlank() || empresa.getMorada() == null || empresa.getMorada().isBlank()) {
    		return Collections.EMPTY_LIST;
    	}
    	
    	List<Empresa> aux = servicePessoasEmpresas.addEmpresa(empresa);
    	return aux;
    }
    
    @PutMapping("/updateEmpresa")
    public String updateEmpresa(@RequestBody Empresa empresa){
    	return servicePessoasEmpresas.updateEmpresa(empresa);
    }
    
    @DeleteMapping("/deleteEmpresa/{id}")
    public String deleteEmpresa(@PathVariable String id) {
		return servicePessoasEmpresas.deleteEmpresa(id);
    }
    
    @GetMapping("/getAllEmpresas")
    public List<Empresa> getAllEmpresas(){
    	return servicePessoasEmpresas.getAllEmpresas();
    }
    
    @GetMapping("/getEmpresaById/{id}")
    public Empresa getEmpresaById(@PathVariable String id){
    	return servicePessoasEmpresas.getEmpresaById(id);
    }
    
    
    /* @PutMapping("/addPessoaToEmpresa")
    public String updateEmpresa(@PathVariable String pessoa_id, String empresa_id){
    	return servicePessoasEmpresas.addPessoaToEmpresa(pessoa_id, empresa_id);
    } */
    
}