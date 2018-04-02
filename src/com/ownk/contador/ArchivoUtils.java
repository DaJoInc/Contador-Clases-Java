package com.ownk.contador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUtils {
	int hola =0;
	/**
	 * ----------------------------------------------------------------------
	 * listarUnaRutaIsFile
	 * -----------------------------------------------------------------------
	 * 	Metodo encargado de listar unicamente archivos de una ruta, es decir, que exceputara absolutamentte cualquier otro archivo que no sea .txt
	 * @param ruta: Ubicación tipo String que brinda la ruta que se recorrera
	 * @return
	 */
	public List<String> listarUnaRutaIsFile(String ruta){
		List<String> archivosEnUnaCarpeta = new ArrayList<String>();
		File archivos = new File(ruta);
		File[] ficheros = archivos.listFiles();
		for (File file : ficheros) {
			if(file.isFile()) {
//			System.out.println("Archivos: "+file.getName());
				archivosEnUnaCarpeta.add(file.getName());
			}
		}
		return archivosEnUnaCarpeta;
	}
	/**
	 * ------------------------
	 * leerLineaDeArchivoB
	 * --------------------------
	 * Lectura de un archivo que trae su ruta como ubicador exacto, se suele usar para lista de rutas
	 * @param rutaArchivo=String que contiene ubicación exacta del archivo que se quiere leer
	 * @return
	 */
	public List<String>leerLineaDeArchivoB(String rutaArchivo){
		List<String>obtenerLineaArchivo = new ArrayList<>();
		List<String>listadoDeLineas = new ArrayList<>();
		File archivo = new File(rutaArchivo);
		FileReader fr;
		BufferedReader br;
		String siguientelinea="";
		 try{
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);			
	        while((siguientelinea=br.readLine())!=null){
	        	obtenerLineaArchivo.add(siguientelinea);
	        }
	        for (String lineasArchivo : obtenerLineaArchivo){
	        	listadoDeLineas.add(lineasArchivo);
//      	System.out.println("LineaOWNK: "+lineasArchivo);
	        	}
		 	}
		 catch (Exception e){
			// TODO: handle exception
		 	}
		 return listadoDeLineas;
		}
}