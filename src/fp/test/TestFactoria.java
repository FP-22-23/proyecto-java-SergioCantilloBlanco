package fp.test;

import fp.estudiante.ContenedorEstudiantes;
import fp.estudiante.FactoriaEstudiantes;

public class TestFactoria {

	public static void main(String[] args) {


			testEstudiantes();
		}

		private static void testEstudiantes() {
				System.out.println("Test de los estudiantes en el registro: ");
				ContenedorEstudiantes estudiante = FactoriaEstudiantes.leeEstudiante("C:\\Users\\34684\\eclipse-workspace\\proyecto-java-SergioCantilloBlanco\\Data\\StudentsPerformance - StudentsPerformance.csv");
				System.out.println("Estudiantes: " + estudiante);
				


			}

		
		}
		



