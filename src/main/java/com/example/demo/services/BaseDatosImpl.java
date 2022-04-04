package com.example.demo.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.exameple.demo.model.Articulo;

@Service
public class BaseDatosImpl implements BaseDatosI {

	private Map<Integer, Articulo> baseDatos; // generamos un mapa fuera para que lo cojan todos.
												// Un mapa lleva siempre registros que se componen de clave y valor
	// ejemplo -> 1 - Articulo1 // 2 - Articulo2 // la clave es un entero y como
	// vamor el articulo

	@Override
	public void iniciar() {
		baseDatos = new HashMap<>(); // inicializo el mapa
		baseDatos.put(1, new Articulo("Camiseta", 20.00)); // voy metiendo articulos
		baseDatos.put(2, new Articulo("Pantalón", 21.00));
		baseDatos.put(3, new Articulo("jersey", 22.00));
		baseDatos.put(4, new Articulo("Chaqueta", 23.00));
		baseDatos.put(5, new Articulo("Falda", 24.00)); // este es mi mapa con los articulos
	}

	@Override
	public Integer insertarArticulo(Articulo articulo) {
		baseDatos.put(baseDatos.size() + 1, articulo);
		return baseDatos.size();
	}

	@Override
	public Articulo buscarArticulo(Integer identificador) {
		return baseDatos.get(identificador); //me devuelve un artículo
	}

	
	
}
