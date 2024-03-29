package fp.estudiante;

import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;


//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


import fp.utiles.Checkers;

public class FactoriaEstudiantes {
	
	//LECTURA FICHERO
		public static ContenedorEstudiantes leeEstudiante(String rutaFichero) {
			ContenedorEstudiantes res = null;
			try {
				Stream<EstudianteImpl> st = Files.lines(Paths.get(rutaFichero)).skip(1).map(FactoriaEstudiantes::parsearEstudiante);
				res = new ContenedorEstudiantes(st);
			} catch(IOException e) {
				e.printStackTrace();
			}
			return res;
		}

		//MÉTODO PARSING
		private static EstudianteImpl parsearEstudiante(String linea) {
			EstudianteImpl res;
			Checkers.checkNoNull(linea);
			String[] trozo = linea.split(",");
			Checkers.check("El formato de la línea no es adecuado", trozo.length == 10);
			String genero =  trozo[0].trim();
			grupo grupo = null;
			    if (String.valueOf(trozo[1]).equals("group A")) {
			    	grupo = grupo.A;}
			    else if (String.valueOf(trozo[1]).equals("group B")){
			    	grupo = grupo.B;
			    }else if (String.valueOf(trozo[1]).equals("group C")){
			    	grupo = grupo.C;
			    }
			    else if (String.valueOf(trozo[1]).equals("group D")){
			    	grupo = grupo.D;
			    }
			    else {
			    	grupo = grupo.E;
			    }
			String tituloParental = trozo[2];
			String comida = trozo[3];
			Boolean preparacion = null; 
			     if (String.valueOf(trozo[4].trim()).equals("completed")) {
				     preparacion = true;}
			     else {
				     preparacion= false;}
			Double mates = Double.parseDouble(trozo[5].trim());
			Double lectura = Double.parseDouble(trozo[6].trim());
			Double escritura = Double.parseDouble(trozo[7].trim());
			LocalDate fecha = LocalDate.parse(trozo[8].trim(), 
					DateTimeFormatter.ofPattern("d/MM/yyyy"));	
			Integer duracion = Integer.parseInt(trozo[9].trim());
	        res = new EstudianteImpl(genero, grupo,duracion,comida, tituloParental, preparacion, mates, lectura, escritura, fecha);
			return res;
		}


}
