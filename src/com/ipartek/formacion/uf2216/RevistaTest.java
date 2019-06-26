package com.ipartek.formacion.uf2216;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


public class RevistaTest {
	Revista revista;
	static final String TITULO = "Biogune";
	static final int ISBN = 1234567894;
	static final int NUMERO_PAGINAS = 45;
	static final String FORMATO = "digital";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		revista = new Revista(TITULO, ISBN, NUMERO_PAGINAS, FORMATO);
	}

	@After
	public void tearDown() throws Exception {
		revista = null;
	}

	@Ignore
	public void testRevistaStringIntIntString() {
		fail("Not yet implemented");
	}

	@Test
	public void testRevista() {

		assertEquals(TITULO, revista.getTitulo());
		assertEquals(ISBN, revista.getIsbn());
		assertEquals(NUMERO_PAGINAS, revista.getNumeroPaginas());
		assertEquals(FORMATO, revista.getFormato());

		// excepcion isbn exactamente 10
		try {
			Revista revista = new Revista(TITULO, 10, NUMERO_PAGINAS, FORMATO);
			fail("El ISBN no tiene exactamente 10 caracteres");
		} catch (Exception e) {
			assertTrue(true);
		}
		
		// excepcion al minimo del titulo
		
		try {
			Revista revista = new Revista("", ISBN, NUMERO_PAGINAS, FORMATO);
			fail("El titulo no tiene mas de 3 caracteres");
		} catch (Exception e) {
			assertTrue(true);
		}
		
		//excepcion al maximo del titulo
		try {
			Revista revista = new Revista("qwertyuiopasdfghjklñzxcvbnmqwertyuiopasdfghjklñzxcvbnm1234567890qwertyuiopasdfghjklñzxcvbnm1234567890qwertyuiopasdfghjklñzxcvbnmqwertyuiopasdfghjklñ1234567890zxcvbnm", ISBN, NUMERO_PAGINAS, FORMATO);
			fail("El titulo no tiene menos de 150 caracteres");
		} catch (Exception e) {
			assertTrue(true);
		}
		
		//excepcion al minimo del numero de paginas
		try {
			Revista revista = new Revista(TITULO, ISBN, 0, FORMATO);
			fail("El numero de paginas no tiene mas de 1 pagina");
		} catch (Exception e) {
			assertTrue(true);
		}

	}

	@Test
	public void testGetTitulo() {
		assertEquals(TITULO,revista.getTitulo());
	}

	@Test
	public void testSetTitulo() throws Exception {
		
		try {
			revista.setTitulo("Biogune");
		} catch (Exception e) {
			throw new Exception (" El titulo debe tener caracteres entre " + Revista.LONGITUD_TITULOMIN + " y "+ Revista.LONGITUD_TITULOMAX);
		}
		assertEquals("Biogune", revista.getTitulo());
	}

	@Test
	public void testGetIsbn() {
		assertEquals(ISBN,revista.getIsbn());
	}

	@Test
	public void testSetIsbn() throws Exception {
		try {
			revista.setIsbn(1234567899);
		} catch (Exception e) {
			throw new Exception (" El titulo debe tener exactamente " + Revista.LONGITUD_ISBN);
		}
		assertEquals(1234567899, revista.getIsbn());
	}

	@Test
	public void testGetNumeroPaginas() {
		assertEquals(NUMERO_PAGINAS,revista.getNumeroPaginas());
	}

	@Test
	public void testSetNumeroPaginas() throws Exception {
		try {
			revista.setNumeroPaginas(25);
		} catch (Exception e) {
			throw new Exception ("Se deben tener más del siguiente numero de paginas " + Revista.CANTIDAD_PAGINAS);
		}
		assertEquals(25, revista.getNumeroPaginas());
	}

	@Test
	public void testGetFormato() {
		assertEquals(FORMATO,revista.getFormato());
	}

	@Test
	public void testSetFormato() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareTo() {
		fail("Not yet implemented");
	}

}
