package fp.test;

import java.time.LocalDate;

import fp.estudiante.EstudianteImpl;
import fp.estudiante.grupo;

public class Estudiante_Test {

	private static final grupo B = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EstudianteImpl f1 = new EstudianteImpl("Female", B, 34, false, true, (double) 45, (double) 67, (double) 90, LocalDate.of(2000, 6, 30));

		EstudianteImpl f2 = new EstudianteImpl(4,78,67);
		
		//EstudianteImpl f3 = new EstudianteImpl("College",tipoAuxiliar("male", "primaria"));
		
		
		
		//System.out.print(f1.toString());
		
		
		// Gets
		System.out.println(f1.getGenero());
		System.out.println(f1.getGrupo());
		System.out.println(f1.getAlmuerzo());
		System.out.println(f1.getPreparacion());
		System.out.println(f1.getMates());
		System.out.println(f1.getLectura());
		System.out.println(f1.getEscrito());
		System.out.println(f1.getFecha());
		System.out.println(f1.getDuracion());
		System.out.println(f2.getMedia());
		// me falta el del list y el del tipo
		
		//Sets
		f1.setGenero("Male");
		f1.setGrupo(grupo.A);
		f1.setEducacionParental("College");
		f1.setAlmuerzo(true);
		f1.setPreparacion(false);
		f2.setMates(45.0);
		f2.setLectura(67.0);
		f2.setEscrito(22.0);
		f1.setFecha(LocalDate.of(2022, 5, 9));
		f1.setDuracion(49);
		// me falta el del list y el del tipo
		
		if (f1.equals(f2)){ 
			System.out.println("Mismo estudiante");
		} else {
			System.out.println("Diferentes estudiantes");
		}
		
		//me falta el compareto
		
		
	}

}
