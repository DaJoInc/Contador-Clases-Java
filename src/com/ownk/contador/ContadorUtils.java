package com.ownk.contador;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
public class ContadorUtils {
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
		GetContador getContador= new GetContador();
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File file : files) 
        {
            if (file.isFile())
            {
            	if (file.getName().trim().endsWith(".java")) {
              		rutaArchivo.add(String.valueOf(file.getAbsolutePath()));
				}
            }
            else if (file.isDirectory())
            {
            	archivosDeProyecto(file.getAbsolutePath(),rutaArchivo);
            }
        }
        return rutaArchivo;
    }
/**
 * ---------------------
 * contenidoCliente
 * ---------------------
 * Metodo encargado de imprimir el contenido final, el cual toma las lineas de todos los archivos, compara cada una con ciertos parametros, estos parametros indican la salida esperada y cada uno de ellos se guarda en las listas de la clase GetContador que actua como un DTO, luego se devuelven y se imprimen en el orden deseado.
 * @param lineasArchivos {@code}
 * @return
 */
	public boolean contenidoCliente(List<String> lineasArchivos){
		GetContador getContador= new GetContador();
		List<String> numerodeMetodos=new ArrayList<>();
		List<GetContador> numerosDeNombre= new ArrayList<GetContador>();
		int contadorA=1;
		int lineaSupuesta=0;
		String nombreClase="";
		int imprimirTitulo = 0;
       	int imprimirMetodo = 0;
       	int lineaFinal = 0;
   		int lineasNormalizadas=0;
   		int lineasDeClases=0;
   		int lineaClaseUbicada=0;
		for (String lineaClases : lineasArchivos) {
			if (lineaClases.trim().startsWith("p")&& !lineaClases.endsWith(";")) {
				if (lineaClases.trim().contains("class")) {
					nombreClase ="";
					nombreClase = lineaClases;
					lineaClaseUbicada=contadorA;
				}
				else {
					getContador=new GetContador();
					//System.out.println(lineaClases);
					getContador.setNombreClase(nombreClase);
					getContador.setNombreMetodo(lineaClases);
					getContador.setMetodoLineaInicial(contadorA);
					numerodeMetodos.add(String.valueOf(lineasArchivos.size()));
					getContador.setNumeroMetodos(numerodeMetodos.size());
					getContador.setLineaDeclase(lineaClaseUbicada);
					numerosDeNombre.add(getContador);
				}
			}
			contadorA++;
	}
   		for (GetContador contadorChiquito : numerosDeNombre) {
   		if (imprimirTitulo==0) {
   			System.out.println("¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶");
   			System.out.println("Nombre de Clase: "+contadorChiquito.getNombreClase());
   			imprimirTitulo=imprimirTitulo+1;
   			System.out.println("Número de metodos de la clase: "+numerosDeNombre.size());
   			imprimirMetodo=imprimirMetodo+1;
   			lineasDeClases=lineasFueraDelosMetodos(lineasArchivos, contadorChiquito.getMetodoLineaInicial(), contadorChiquito.getLineaDeclase());
   			contadorChiquito.setLineasFueraDeMetodo(lineasDeClases);
   			System.out.println("Numero de lineas de codigo de la clase: "+contadorChiquito.getLineasFueraDeMetodo());
   		}
   		if (lineaSupuesta+1<numerosDeNombre.size()) {
				lineaFinal =corchetesEnMetodos(lineasArchivos, contadorChiquito.getMetodoLineaInicial(), numerosDeNombre.get(lineaSupuesta+1).getMetodoLineaInicial());
			
   		}
   		else {
				lineaFinal = corchetesEnMetodos(lineasArchivos, contadorChiquito.getMetodoLineaInicial(), lineasArchivos.size());
			}
   		lineasNormalizadas=lineasValidasDeMetodos(lineasArchivos, contadorChiquito.getMetodoLineaInicial(), lineaFinal);
		contadorChiquito.setLineasNormalizadas(lineasNormalizadas);
   		System.out.println("Nombre Metodo: "+contadorChiquito.getNombreMetodo());
//   		System.out.println("Linea inicial: "+contadorChiquito.getMetodoLineaInicial());
   		contadorChiquito.setLineaFinalDeMetodo(lineaFinal);
//   		System.out.println("Linea Final: "+contadorChiquito.getLineaFinalDeMetodo());
   		int resultadoMetodos= lineaFinal-contadorChiquito.getMetodoLineaInicial();
//   	System.out.println("Lineas del metodo sin normalizar: "+resultadoMetodos);
   		getContador.setLineasNormalizadas(lineasNormalizadas);
   		//System.out.println("LineasInvalidas: "+ contadorChiquito.getLineasNormalizadas());
   		lineasNormalizadas=contadorChiquito.getLineasNormalizadas();
   		System.out.println("Numero de lineas del metodo: "+lineasNormalizadas);
   		System.out.println("©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©©");
   		lineaSupuesta++;
   	}
		return false;	
	}
	public int corchetesEnMetodos(List<String> lineasArchivos,int lineaInicialMetodo, int suposicionLineaFinal){
		int contador=0;
		int contadorA=1;
		int lineaFinal=0;
		boolean encuentraCorchete=false;
		
		for (String lineaClases : lineasArchivos) {
			if (contadorA>=lineaInicialMetodo&&contadorA<=suposicionLineaFinal) {
				if(lineaClases.trim().contains("{")){
					contador=contador+1;
					encuentraCorchete=true;
					}
				if (lineaClases.trim().contains("}")&&!lineaClases.trim().endsWith(";")) {
					contador=contador-1;
					encuentraCorchete=true;
				}
			if (contador==0&&encuentraCorchete) {
				lineaFinal=contadorA;
				contador= contador +contadorA;
				}
			}
		contadorA++;
		}
		return lineaFinal;
	}
	public int lineasValidasDeMetodos(List<String> lineasArchivos,int lineaInicialMetodo, int suposicionLineaFinal){
		int contador=0;
		int contadorA=1;
		for (String lineaClases : lineasArchivos) {
			if (contadorA>=lineaInicialMetodo&&contadorA<=suposicionLineaFinal) {
				if (lineaClases.trim().contains("try")||lineaClases.trim().contains("catch")) {
					contador=contador+1;
				}
				if (lineaClases.trim().contains("for")||lineaClases.trim().contains("if")||lineaClases.trim().contains("while")||lineaClases.trim().contains("else")||lineaClases.trim().contains("switch")) {
					contador=contador+1;
				}
				if (!lineaClases.trim().contains("//")&&lineaClases.trim().endsWith(";")) {
					contador=contador+1;
				}
			}
			contadorA++;
		}
		return contador;
	}
	public int lineasFueraDelosMetodos(List<String> lineasArchivos,int lineaInicialMetodo, int lineaDeclase){
		int contadorB=1;
		int lineasValidas=0;
		for (String lineaClases : lineasArchivos) {
		
			if (contadorB<lineaInicialMetodo&&contadorB>lineaDeclase) {
				if(lineaClases.trim().endsWith(";")){
					lineasValidas=lineasValidas+1;
				}
			}
			contadorB++;
		}
		return lineasValidas;
	}
}
