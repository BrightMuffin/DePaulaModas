package com.finalcurso.modas.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalcurso.modas.entidade.Roupa;
import com.finalcurso.modas.repositorio.RoupaRepositorio;

@Service
public class RoupaServiceImpl implements RoupaService {

static List<Roupa> roupa = new ArrayList<Roupa>();
	
	@Autowired
	private RoupaRepositorio roupaRepositorio;
	
		
	public List<Roupa> listarRoupas(){
		return roupaRepositorio.findAll();
	}
	


	@Override
	public Roupa obterRoupa(Long id) {
		return this.roupaRepositorio.getReferenceById(id);
	}




}
