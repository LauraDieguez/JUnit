package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.exameple.demo.model.Articulo;

public class CarritoCompraServiceImpl implements CarritoCompraServiceI {

	@Autowired
	private BaseDatosI baseDatos; // implementamos la variable de datos

	// generamos la variable Cesta con la lista de articulos
	private List<Articulo> cesta = new ArrayList<>();

	@Override // sobrescribe la logica porque no tienen lógica ninguna
	public void limpiarCesta() {
		cesta.clear(); // logica de limpiar cesta

	}

	@Override
	public void addArticulo(Articulo articulo) {
		cesta.add(articulo);

	}

	@Override
	public Integer getNumArticulos() {
		return cesta.size();
	}

	@Override
	public List<Articulo> getArticulos() {
		return cesta;
	}

	@Override
	public Double totalPrice() { // inicializamos con 00 al ser un Double más la D de Double (si fuese Long sería
									// una L, etc. ;
		Double total = 0D;
		for (Articulo articulo : cesta) { // recorremos la cesta con un bucle
			total = total + articulo.getPrecio();
		}
		return total;
	}

	@Override
	public Double calculadorDescuento(Double precio, Double porcentaje) {

		return precio - precio * porcentaje / 100;
	}

	@Override
	public Double aplicarDescuento(Integer idArticulo, Double porcentaje) {
		baseDatos.iniciar();
		Articulo articulo = baseDatos.buscarArticulo(idArticulo);
		if (Optional.ofNullable(articulo).isPresent()) {
			return calculadorDescuento(articulo.getPrecio(), porcentaje);

		} else {
			System.out.println("No se han encontrado el articulo con ID: " + idArticulo);
		}

		return 0D;
	}

	
	//TALLER FINAL
		// metodo insertar 
		// añada artictulo a la BBDd
		// añadir art a la cesta
		// en el test comprobar que el id del art a la bbd sea uno concreto
		// comprobar que el articulo se ha añadido a la lista
		// commprobar que el nombre y el precio del articulo a la lista tengan unos valores concretos
		// verificar que se llama a la base de datos
	
	@Override
	public Integer InsertarArticulo(Articulo articulo) {
		Integer identificador = baseDatos.insertarArticulo(articulo);
		cesta.add(articulo);
		return identificador;
	}
	
	@Override
	public Articulo getArticulo(Integer identificador) {
		if(identificador <= cesta.size())
			return cesta.get(identificador);
		
		return null;
	}
	
	
	}
	
	
	
	

