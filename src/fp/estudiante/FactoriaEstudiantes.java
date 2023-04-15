package fp.estudiante;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

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
			String[] trozo = linea.split(";");
			Checkers.check("El formato de la línea no es adecuado", trozo.length == 9);
			String genero =  trozo[0].trim();
			grupo grupo = null;
			    if (String.valueOf(trozo[1].trim()) == "groupA") {
			    	grupo = grupo.A;}
			    else if (String.valueOf(trozo[1].trim()) == "groupB"){
			    	grupo = grupo.B;
			    }else if (String.valueOf(trozo[1].trim()) == "groupC"){
			    	grupo = grupo.C;
			    }
			    else {
			    	grupo = grupo.D;
			    }
			String tituloParental = trozo[2];
			Boolean preparacion = null; 
			if (String.valueOf(trozo[3].trim()) == "none") {
				preparacion = false;}
			else {
				preparacion= true;}
			Double mates = Double.parseDouble(trozo[4].trim());
			Double lectura = Double.parseDouble(trozo[5].trim());
			Double escritura = Double.parseDouble(trozo[6].trim());
			LocalDate fecha = LocalDate.parse(trozo[7].trim(), 
					DateTimeFormatter.ofPattern("dd/MM/yyyy"));	
			Integer duracion = Integer.parseInt(trozo[8].trim());
	        res = new EstudianteImpl(genero, grupo,duracion, tituloParental, preparacion, mates, lectura, escritura, fecha);
			return res;
		}


}
