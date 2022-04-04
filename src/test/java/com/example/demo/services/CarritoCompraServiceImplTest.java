package com.example.demo.services;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.exameple.demo.model.Articulo;

@RunWith(MockitoJUnitRunner.class)
public class CarritoCompraServiceImplTest {

//hay que crear cada uno de los test

	@InjectMocks
	private CarritoCompraServiceImpl carritoService = new CarritoCompraServiceImpl();

	@Mock
	private BaseDatosI baseDatos;

	@Test
	public void testLimpiarCesta() { // comprobar que limpia la cesta, se añade un objeto y luego ver que se limpia y
										// queda vacía
		carritoService.addArticulo(new Articulo("Camiseta", 15.99D));
		assertFalse(carritoService.getArticulos().isEmpty()); // comprobamos que no esta vacía
		carritoService.limpiarCesta();
		assertTrue(carritoService.getArticulos().isEmpty()); // compramos que esta vacía y es verdadero

	}

	@Test
	public void testAddArticulo() { // Añade un artículo a la cesta
		carritoService.addArticulo(new Articulo("Pantalon", 20.75D));
		carritoService.addArticulo(new Articulo("Jersey", 15.99D));
		assertFalse(carritoService.getArticulos().isEmpty());
	}

	@Test
	public void testGetNumArticulos() { // Devuelve el número de artículos de la cesta​

		carritoService.addArticulo(new Articulo("Pantalon", 20.75D));
		carritoService.addArticulo(new Articulo("Jersey", 15.99D));
		assertEquals(Integer.valueOf(2), carritoService.getNumArticulos());

	}

	@Test
	public void testGetArticulos() { // Devuelve la lista de todos los artículos añadidos​
		carritoService.addArticulo(new Articulo("Pantalon", 20.75D));
		carritoService.addArticulo(new Articulo("Jersey", 15.99D));
		carritoService.addArticulo(new Articulo("Bañador", 15.99D));
		List<Articulo> res = carritoService.getArticulos();
		assertEquals("Pantalon", res.get(0).getNombre());
		assertEquals(2, res.size());

	}

	@Test
	public void testTotalPrice() { // Devuelve el precio total de la compra​
		carritoService.addArticulo(new Articulo("Pantalon", 20D));
		carritoService.addArticulo(new Articulo("Jersey", 10D));
		Double res = carritoService.totalPrice();
		assertEquals(Double.valueOf(30D), res);
	}

	@Test
	public void testCalculadoraDescuento() { // aplica un descuento a un producto dado su precio​
		assertEquals(Double.valueOf(90D), carritoService.calculadorDescuento(100D, 10D));
	}

/*	@Test
	public void testAplicarDescuento() {
		Articulo articulo = new Articulo("Camiseta", 20.00);
		when(baseDatos.buscarArticulo(1)).thenReturn(articulo); // tiene que ser 1 porque esta simulando que funciona la lógica del código, no que haya algo en la bbdd
		Double res = carritoService.aplicarDescuento(1, 10D);
		assertEquals(Double.valueOf(18D), res);
	}
*/	
	
	   //Con Any sería:
	  
	   @Test 
	   public void testAplicarDescuento() { 
	   Articulo articulo = new Articulo("Camiseta", 20.00);
	   when(baseDatos.buscarArticulo(any(Integer.class))).thenReturn(articulo);   //Así siempre devolvería "Camiseta" 
	   Double res = carritoService.aplicarDescuento(1, 10D); 
	   assertEquals(Double.valueOf(18D), res);
	   }
	   //verify(baseDatos).buscarArtculos(any(Integer.class)); }   //verifica las interacciones Mock
	 
	 
	
//TALLER FINAL 

	@Test
	public void testInsertar() {
		Articulo articulo = new Articulo("Camiseta", 20.00); // insertar articulo
		Integer identificador = carritoService.InsertarArticulo(articulo);
		
		assertEquals(Integer.valueOf(0),identificador); // para comprobar el ID
		
		Articulo tallerFinal = carritoService.getArticulo(identificador); // para comprobar que es el mismo articulo
		assertSame(articulo, tallerFinal);
		
		verify(baseDatos, times(1)).insertarArticulo(articulo); // Verificar que se llama a baseDatos
		
		

	}
}
