package com.ownk.libary;

import java.awt.LinearGradientPaint;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Car {
	/**
	 * -------------
	 * archivosDeProyecto
	 * --------------
	 * Metodo Encargado de buscar todos los archivos que finalizen con .java de un proyecto y listar su respectiva ruta
	 * @param path= Ruta del proyecto que actua como inicializador del metodo.
	 * @param rutaArchivo=Lista que de manera recursiva se vuelve a llamar para usar el mismo espacio de memoria y llene de manera continua su contenido con rutas de archivos .java 
	 * @return
	 */
	public List<String> archivosDeProyecto(String path,List<String> rutaArchivo){
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File file : files) 
        {
            if (file.isFile())
            {
            	if (file.getName().trim().endsWith(".txt")) {
              		rutaArchivo.add(String.valueOf(file.getName()));
              		System.out.println(file.getName());
				}
            }
            else if (file.isDirectory())
            {
            	archivosDeProyecto(file.getAbsolutePath(),rutaArchivo);
            }
        }
        return rutaArchivo;
    }
}
