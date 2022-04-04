package com.example.demo.services;

import com.exameple.demo.model.Articulo;

public interface BaseDatosI {

	public void iniciar();
	
	public Integer insertarArticulo(Articulo articulo);
	
	public Articulo buscarArticulo(Integer identificador);
	
	
}
