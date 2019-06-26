package com.ipartek.formacion.uf2216;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CMSRevistas {

	static final String FICHERO_REVISTAS = "C:\\1713\\eclipse-workspace\\JonCarrascoBaranda\\resources\\revistas.txt";

	static final int OPCION_CREAR = 1;
	static final int OPCION_RESUMEN = 2;
	static final int OPCION_GUARDAR = 3;
	static final int OPCION_SALIR = 4;
	private static final int LONGITUD_TITULOMAX = 150;
	private static final int LONGITUD_TITULOMIN = 3;
	private static final int LONGITUD_ISBN = 10;
	private static final int CANTIDAD_PAGINAS = 1;

	static ArrayList<Revista> revistas = new ArrayList<Revista>();
	static Scanner sc;
	static int opcion;
	static FileWriter fw;
	static BufferedWriter bw;

	//elemento de prueba
	//String prueba = "qwertyuiopasdfghjklñzxcvbnmqwertyuiopasdfghjklñzxcvbnm1234567890qwertyuiopasdfghjklñzxcvbnm1234567890qwertyuiopasdfghjklñzxcvbnmqwertyuiopasdfghjklñ1234567890zxcvbnm";

	public static void main(String[] args) throws IOException {

		sc = new Scanner(System.in);
		do {
			pintarMenuYPedirOpcion();
		} while (opcion != OPCION_SALIR);
		sc.close();

	}

	/**
	 * Metodo para pintar el menu inicial de la APP y pedir una opcion
	 * 
	 * @throws IOException
	 * 
	 * @throws Exception
	 */
	private static void pintarMenuYPedirOpcion() throws IOException {
		System.out.println("");
		System.out.println("*******************************");
		System.out.println("**   CMS de Revistas         **");
		System.out.println("**                           **");
		System.out.println("**  Eliga una opcion:        **");
		System.out.println("**  1. Crear una revista     **");
		System.out.println("**  2. Listar revistas       **");
		System.out.println("**  3. Guardar revistas      **");
		System.out.println("**  4. Salir                 **");
		System.out.println("*******************************");
		System.out.println("");

		try {
			opcion = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("Inserte una de las opciones validas del menu, por favor");
			pintarMenuYPedirOpcion();
		}
		activarOpcion(opcion);

	}

	/**
	 * Metodo para enlazar el menu inicial con las diversas funcionalidades de la
	 * App
	 * 
	 * @param opcion2 int opcion pasada de metodo anterior
	 * @throws IOException
	 * @throws Exception
	 * @see pintarMenuYPedirOpcion();
	 */
	private static void activarOpcion(int opcion2) throws IOException {
		switch (opcion) {
		case OPCION_CREAR:
			crearRevista();
			break;
		case OPCION_RESUMEN:
			listarRevistas();
			break;
		case OPCION_GUARDAR:
			guardarRevistas();
			break;
		case OPCION_SALIR:
			System.out.println("Gracias por crear sus revistas con nosotros, ADIOS");
			break;
		}

	}

	/**
	 * Metodo para preguntar si se quiere guardar o no el listado de las revistas
	 * 
	 * @throws IOException
	 */
	private static void guardarRevistas() throws IOException {
		String respuesta = "";
		do {
			System.out.println("Quiere usted que se guarde el listado de revistas, responda SI o NO");
			try {
				respuesta = sc.nextLine().toUpperCase();
			} catch (Exception e) {
				System.out.println("** ERROR ** Introduzca un valor valido por favor");
			}
		} while (!respuesta.equals("SI") && !respuesta.equals("NO"));
		if (respuesta.equals("SI")) {
			grabarDatos();
		}
	}

	/**
	 * Metodo para guardar el listado de revistas en un txt
	 * 
	 * @throws IOException
	 * @see revistas.txt
	 */
	private static void grabarDatos() throws IOException {

		fw = new FileWriter(FICHERO_REVISTAS);
		bw = new BufferedWriter(fw);
		for (int i = 0; i < revistas.size(); i++) {
			String linea = "La revista de titulo " + revistas.get(i).getTitulo() + ", con ISBN de "
					+ revistas.get(i).getIsbn() + ", con un numero de paginas de " + revistas.get(i).getNumeroPaginas()
					+ " y formato " + revistas.get(i).getFormato();
			bw.write(linea);
			bw.newLine();

		}
		bw.close();
		fw.close();

	}

	/**
	 * Metodo para listar graficamente en la consola de la App la lista de revistas
	 * creadas
	 */
	private static void listarRevistas() {
		System.out.println("*************************************************************");
		System.out.println("**         Lista de revistas registradas                   **");
		System.out.println("*************************************************************");
		System.out.println("** Titulo      ISBN     Numero de Paginas    Formato       **");

		Collections.sort(revistas);

		for (Revista revista : revistas) {
			System.out.printf(" %9s %9s %12s %5s \n", revista.getTitulo(), revista.getIsbn(),
					revista.getNumeroPaginas(), revista.getFormato());
		}

	}

	/**
	 * Metodo para crear e insertar una nueva revista por consola
	 * 
	 * @throws Exception las introducidas desde la clase
	 */
	private static void crearRevista() {
		String titulo, formato = "";
		int isbn = 0, numeroPaginas = 0;
		String formatoReal = "false";

		do {
			System.out.println("Inserte el titulo de la revista, recuerde debe tener entre 3 y 150 caracteres: ");
			titulo = sc.nextLine();
		} while (titulo.length() <= LONGITUD_TITULOMIN || titulo.length() >= LONGITUD_TITULOMAX);

		do {
			System.out.println("Inserte el ISBN de la revista, recuerde tiene 10 digitos unicamente: ");
			try {
				isbn = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("** ERROR ** Introduzca un valor valido por favor");
			}
		} while (isbn == 0 || Integer.toString(isbn).length() != LONGITUD_ISBN);

		do {
			System.out
					.println("Inserte el numero de paginas de la revista, recuerde que tiene un minimo de 1 pagina: ");
			try {
				numeroPaginas = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("** ERROR ** Introduzca un valor valido por favor");
			}
		} while (numeroPaginas <= CANTIDAD_PAGINAS);

		do {
			System.out.println("Inserte el formato de la revista, recuerde digital o papel");
			try {
			formato = sc.nextLine().toLowerCase();
			} catch (Exception e) {
				System.out.println("** ERROR ** Introduzca un valor valido por favor");
			}
			if (formato.equals("digital")) {
				formatoReal = "true";
			} else if (formato.equals("papel")) {
				formatoReal = "false";
			}
		} while (!formato.equals("digital") && !formato.equals("papel"));

		Revista revista;

		try {
			revista = new Revista(titulo, isbn, numeroPaginas, formatoReal);
			revistas.add(revista);
		} catch (Exception e) {
			System.out.println("** ERROR al insertar la revista **");

		}

	}

}
