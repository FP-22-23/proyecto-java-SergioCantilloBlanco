package fp.test;

import java.time.LocalDate;

import fp.estudiante.ContenedorEstudiantes;
import fp.estudiante.EstudianteImpl;
import fp.estudiante.FactoriaEstudiantes;
import fp.estudiante.grupo;

public class ContenedorTest {
	private static EstudianteImpl est1 = new EstudianteImpl ("Female", grupo.B, 34, "included", "Primary",true, (double) 90, (double) 97, (double) 90, LocalDate.of(2000, 6, 30));
	private static EstudianteImpl est2 = new EstudianteImpl ("Male", grupo.A, 81, "Not included","Primary", false, (double) 15, (double) 29, (double) 19, LocalDate.of(2000, 4, 3));
	private static EstudianteImpl est3 = new EstudianteImpl ("Female", grupo.C, 11, "included", "Primary",true, (double) 41, (double) 37, (double) 95, LocalDate.of(2000, 1, 2));
	
	private static ContenedorEstudiantes estu = new ContenedorEstudiantes();
	private static ContenedorEstudiantes estudiante = FactoriaEstudiantes.leeEstudiante("C:\\Users\\34684\\eclipse-workspace\\proyecto-java-SergioCantilloBlanco\\Data\\StudentsPerformance - StudentsPerformance.csv");

	public static void main(String[] args) {


		//testConstructor();
		//añadirEstTest();
		//testEliminarEst();
		//testMenorMedia();
		//testCalcularEpisodiosPorAño();
		//testestudiantesTardones();
		//TestObtenerEstudiantePorDebajoMediaMinima();
		//TestObtenerNumeroEstudiantesPorGeneroQueEstudio();
		//TestestudianteMaximaMedia();
		//TestnotasMujeresMatesordenadasMayorAMenor();
		//TestgetlistaDeNotasLectura();
		//TestmujerHombreConMayorMedia();
		//TesttresPeoresNotasPorGenero();
		TestMayorMediaEntreHombreMujer();

	}
		
		

		
		
		
		private static void testConstructor() {
			EstudianteImpl est7 = new EstudianteImpl ("Female", grupo.B, 34, "included","Primary",true, (double) 45, (double) 67, (double) 90, LocalDate.of(2000, 6, 30));
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

		
		
		//MÉTODOS STREAM: Tratamientos secuenciales(I) (Apartado 4 del proyecto).	
		private static void testMenorMedia() {
			System.out.println("Testeo de MenorMedia");
			System.out.println("Las medias mas pequeñas son: ");
			System.out.println(estudiante.MenorMedia(78.9));
		}
		
		private static void testCalcularEpisodiosPorAño() {
			System.out.println("Testeo de numeroDeEstudiantesPorMes");
			Integer numero = estudiante.numeroDeEstudiantesPorMes(LocalDate.of(2000, 8, 30));  
			System.out.println("Hay " + numero + " estudiantes que realizaron el examen en el mes 8.");
		}

		private static void testestudiantesTardones() {
			System.out.println("Testeo de estudiantesTardones");
			System.out.println("¿hubo algun estudiante que tardo mas de 80 min en terminar el examen?");
			System.out.println(estudiante.estudiantesTardones());
		}
		private static void TestObtenerEstudiantePorDebajoMediaMinima() {
			System.out.println("Testeo de ObtenerEstudiantePorDebajoMediaMinima");
			System.out.println(estudiante.ObtenerEstudiantePorDebajoMediaMinima(35));
		}
		private static void TestObtenerNumeroEstudiantesPorGeneroQueEstudio() {
			System.out.println("Testeo de ObtenerNumeroEstudiantesPorGeneroQueEstudio");
			System.out.println(estudiante.ObtenerNumeroEstudiantesPorGeneroQueEstudio());
		}
		
		private static void TestestudianteMaximaMedia() {
			System.out.println("Testeo de estudianteMaximaMedia");
			System.out.println(estudiante.estudianteMaximaMedia());
		}
		
		private static void TestnotasMujeresMatesordenadasMayorAMenor() {
			System.out.println("Testeo de notasMujeresMatesordenadasMayorAMenor");
			System.out.println( estudiante.notasMujeresMatesordenadasMayorAMenor());
		}
		
		private static void TestgetlistaDeNotasLectura() {
			System.out.println("Testeo de getlistaDeNotasLectura");
			System.out.print(estudiante.getlistaDeNotasLectura());
		}
		
		private static void TestmujerHombreConMayorMedia() {
			System.out.println("Testeo de mujerHombreConMayorMedia");
			System.out.println(estudiante.mujerHombreConMayorMedia());
		}
		
		private static void TesttresPeoresNotasPorGenero() {
			System.out.println("Testeo de tresPeoresNotasPorGenero");
			System.out.print(estudiante.tresPeoresNotasPorGenero(3));
		}
		
		private static void TestMayorMediaEntreHombreMujer() {
			System.out.println("Testeo de MayorMediaEntreHombreMujer");
			System.out.print(estudiante.MayorMediaEntreHombreMujer());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
