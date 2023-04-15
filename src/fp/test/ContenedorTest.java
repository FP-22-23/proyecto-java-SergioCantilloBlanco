package fp.test;

import java.time.LocalDate;

import fp.estudiante.ContenedorEstudiantes;
import fp.estudiante.EstudianteImpl;
import fp.estudiante.FactoriaEstudiantes;
import fp.estudiante.grupo;

public class ContenedorTest {
	private static EstudianteImpl est1 = new EstudianteImpl ("Female", grupo.B, 34, "included", true, (double) 90, (double) 97, (double) 90, LocalDate.of(2000, 6, 30));
	private static EstudianteImpl est2 = new EstudianteImpl ("Male", grupo.A, 81, "Not included", false, (double) 15, (double) 29, (double) 19, LocalDate.of(2000, 8, 3));
	private static EstudianteImpl est3 = new EstudianteImpl ("Female", grupo.C, 11, "included", true, (double) 41, (double) 37, (double) 95, LocalDate.of(2000, 1, 2));
	
	private static ContenedorEstudiantes estu = new ContenedorEstudiantes();
	private static ContenedorEstudiantes estudiante = FactoriaEstudiantes.leeEstudiante("./data/StudentsPerformance-StudentsPerformance.csv");

	public static void main(String[] args) {


		//testConstructor();
		añadirEstTest();
		//testEliminarEst();
		testMenorMedia();
		testCalcularEpisodiosPorAño();
		testestudiantesTardones();
	}
		//Test
		

		
		
		
		private static void testConstructor() {
			EstudianteImpl est7 = new EstudianteImpl ("Female", grupo.B, 34, "included", true, (double) 45, (double) 67, (double) 90, LocalDate.of(2000, 6, 30));
			System.out.println(est7);
		}
		
		private static void añadirEstTest() {
			System.out.println("Test del constructor del tipo contenedor");
			try {
				estudiante = new ContenedorEstudiantes();
				estudiante.añadirEst(est1);
				estudiante.añadirEst(est2);
				estudiante.añadirEst(est3);
				System.out.println("Estudiantes: "+ estudiante + "\n");
			} catch(Exception e) {
				System.out.println("Excepción capturada: \n " + e);	
			}
		}
		private static void testEliminarEst() {
			System.out.println("Testeo de eliminarCap");
			estudiante.eliminarEst(est1);
			estudiante.eliminarEst(est2);
			estudiante.eliminarEst(est3);
			System.out.println("Después de borrar a un estudiante quedaría así: " + estudiante);
			System.out.println(estudiante);
		}
	// me falta el de size y addall

		
		
		//MÉTODOS STREAM: Tratamientos secuenciales(I) (Apartado 4 del proyecto).
	    //"filter", "allMatch", "anyMatch" (Predicate) (mínimo 2 métodos).		
		private static void testMenorMedia() {
			System.out.println("Testeo de MenorMedia");
			System.out.println("Las medias mas pequeñas son: ");
			System.out.println(estudiante.MenorMedia(78.9));
		}
		
		private static void testCalcularEpisodiosPorAño() {
			System.out.println("Testeo de numeroDeEstudiantesPorMes");
			Integer numero = estudiante.numeroDeEstudiantesPorMes(LocalDate.of(2000, 8, 30));  
			System.out.println("Hay " + numero + " estdudiantes que realizaron el examen en el mes 8.");
		}

		private static void testestudiantesTardones() {
			System.out.println("Testeo de estudiantesTardones");
			System.out.println("hubo algun estudiante que tardo mas de 80 min en terminar el examen.");
			System.out.println(estudiante.estudiantesTardones());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
