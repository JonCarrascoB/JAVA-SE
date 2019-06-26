package com.ipartek.formacion.uf2216;

import java.io.Serializable;

public class Revista implements Leible, Comparable<Revista>, Serializable {

	String ficheroRevistas = "C:\\1713\\eclipse-workspace\\JonCarrascoBaranda\\resources\\revistas.txt";

	// constantes
	final static int LONGITUD_ISBN = 10;
	final static int LONGITUD_TITULOMIN = 3;
	final static int LONGITUD_TITULOMAX = 150;
	final static int CANTIDAD_PAGINAS = 1;

	// Atributos
	private String titulo;
	private int isbn;
	private int numeroPaginas;
	private String formato;

	// Constructores
	public Revista(String titulo, int isbn, int numeroPaginas, String formato) throws Exception {
		this();
		this.setTitulo(titulo);
		this.setIsbn(isbn);
		this.setNumeroPaginas(numeroPaginas);
		this.setFormato(formato);
	}

	public Revista() {
		super();
	}

	// Getters y Setters
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Controlar la creacion de un titulo
	 * 
	 * @param titulo String titulo
	 * @throws Exception el titulo debe ser >= 3 y <= 150 caracteres para ser valido
	 */
	public void setTitulo(String titulo) throws Exception {
		if (titulo != null && titulo.length() >= LONGITUD_TITULOMIN && titulo.length() <= LONGITUD_TITULOMAX) {
			this.titulo = titulo;
		} else {
			String msg = String.format("Titulo debe ser entre " + LONGITUD_TITULOMIN + " y " + LONGITUD_TITULOMAX);
			throw new Exception(msg);
		}
	}

	public int getIsbn() {
		return isbn;
	}

	/**
	 * Controlar la creacion del ISBN
	 * 
	 * @param isbn int isbn
	 * @throws Exception el ISBN debe ser exactamente de 10 digitos
	 */
	public void setIsbn(int isbn) throws Exception {
		if (Integer.toString(isbn).length() == LONGITUD_ISBN) {
			this.isbn = isbn;
		} else {
			throw new Exception("Longitud del ISBN debe ser " + LONGITUD_ISBN);
		}

	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	/**
	 * Controlar la creacion del numero de paginas
	 * 
	 * @param numeroPaginas int numero de paginas
	 * @throws Exception el numero de paginas debe ser >= 1
	 */
	public void setNumeroPaginas(int numeroPaginas) throws Exception {
		if (numeroPaginas >= CANTIDAD_PAGINAS) {
			this.numeroPaginas = numeroPaginas;
		} else {
			throw new Exception("La revista debe tener mas de " + CANTIDAD_PAGINAS);
		}
	}

	public String getFormato() {
		String resul;
		if(formato == "true") {
			resul = "digital";
		} else {
			resul = "papel";
		}
		return resul;

	}

	public void setFormato(String formato) {
		
		this.formato = formato;
	}

	// metodos

	@Override
	public String toString() {
		return "La revista de titulo " + titulo + ", tiene el ISBN de" + isbn + ", con un numero de paginas de "
				+ numeroPaginas + " y su formato es " + formato + "]";
	}

	@Override
	public int compareTo(Revista r) {
		return r.numeroPaginas - this.numeroPaginas;
	}

}
