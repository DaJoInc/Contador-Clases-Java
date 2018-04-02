package com.ownk.contador;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * --------------
 * OrquestadorContador
 * ----------------
 * Encargado de organizar de manera coherente y simple los metodos de la clase ContadorUtils para brindar la salida esperada de impresion.
 * @author user
 *
 */
public class OrquestadorContador {
private static Scanner rutaProyecto;

public static void main(String[] args) {
	List<String>archivosJavaConRuta = new ArrayList<String>();
	//rutaProyecto = new Scanner(System.in);
	String ruta = "C:\\Users\\The Young Knight\\Desktop\\ContadorClases";
	ContadorUtils contadorUtils= new ContadorUtils();
	ArchivoUtils archivoUtils= new ArchivoUtils();
	List<String>lineasArchivo = new ArrayList<String>();
	archivosJavaConRuta=contadorUtils.archivosDeProyecto(ruta,archivosJavaConRuta);
	//System.out.println(archivosJavaConRuta);
	for (String archivoConRuta : archivosJavaConRuta) {
//		System.out.println("Archivo java: "+archivoConRuta);
		lineasArchivo=archivoUtils.leerLineaDeArchivoB(archivoConRuta);
		contadorUtils.contenidoCliente(lineasArchivo);
//		contadorUtils.corchetesEnMetodos(lineasArchivo);
		}
	}
}