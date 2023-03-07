package fp.estudiante;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import fp.utiles.Checkers;


public class EstudianteImpl implements Estudiante{
	
	private String genero;
	private grupo grupo;
	private String educacionParental;
	private Boolean almuerzo;
	private Boolean preparacion;
	private Double mates;
	private Double lectura;
	private Double escrito;
	private LocalDate fecha;
	private Integer duracion;
	private List<String> lista = new LinkedList<String>();
	public tipoAuxiliar tipo;
	
	public double nota_Media (double mates, double lectura, double escrito) {
		double media = (mates+lectura+escrito)/3;
		return media;
	}
	
	
	public EstudianteImpl(String genero, grupo grupo, Integer duracion,Boolean almuerzo,Boolean preparacion,Double mates,Double lectura,Double escrito,LocalDate fecha) {
		Checkers.check("El genero no puede estar vacío",!genero.equals(""));
		Checkers.check("La duracion no puede ser superior a 90 minutos.",duracion<=90);
		this.genero= genero;
		this.grupo = grupo;
		this.duracion = duracion;
		this.almuerzo= almuerzo;
		this.preparacion = preparacion;
		this.mates = mates;
		this.lectura= lectura;
		this.escrito = escrito;
		this.fecha = fecha;
	}
	public EstudianteImpl(double mates, double lectura, double escrito) {
		Checkers.check("Fuera de limite",mates <= 100 && mates >= 0);
		Checkers.check("Fuera de limite",lectura <= 100 && lectura >= 0);
		Checkers.check("Fuera de limite",escrito <= 100 && escrito >= 0);
		this.mates=mates;
		this.lectura=lectura;
		this.escrito=escrito;
		
	}
	

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(grupo grupo) {
		this.grupo = grupo;
	}


	public String getEducacionParental() {
		return educacionParental;
	}

	public void setEducacionParental(String educacionParental) {
		this.educacionParental = educacionParental;
	}

	public Boolean getAlmuerzo() {
		return almuerzo;
	}

	public void setAlmuerzo(Boolean almuerzo) {
		this.almuerzo = almuerzo;
	}

	public Boolean getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(Boolean preparacion) {
		this.preparacion = preparacion;
	}

	public Double getMates() {
		return mates;
	}

	public void setMates(Double mates) {
		Checkers.check("Fuera de limite",mates <= 100 && mates >= 0);
		this.mates = mates;
	}

	public Double getLectura() {
		return lectura;
	}

	public void setLectura(Double lectura) {
		Checkers.check("Fuera de limite",lectura <= 100 && lectura >= 0);
		this.lectura = lectura;
	}

	public Double getEscrito() {
		return escrito;
	}

	public void setEscrito(Double escrito) {
		Checkers.check("Fuera de limite",escrito <= 100 && escrito >= 0);
		this.escrito = escrito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	
	
	public String toString() {
		return "Estudiante [genero=" + genero + 
				", grupo=" + grupo + 
				", educacion parental=" + educacionParental
				+ "almuerzo=" + almuerzo + 
				"preparacion=" + preparacion + 
				"Nota mates=" + mates +
				"Nota lectura=" + lectura +
				"Nota escrito=" + escrito +
				"fecha de realizacion de examen=" + fecha +
				"duracion=" + duracion +"]";
	}
	
	public int compareTo(Estudiante p) {
		int r;
		if (p == null) {
			throw new NullPointerException();
		}
		r = getMates().compareTo(p.getMates());	
		if (r == 0) {
			r = getLectura().compareTo(p.getLectura());
			if (r == 0) {
				r = getEscrito().compareTo(p.getEscrito());
			}
			
		}
		return r;
	}
	
	public boolean equals(Object o) {
		boolean r = false;
		if (o instanceof EstudianteImpl) {
			EstudianteImpl p = (EstudianteImpl) o;
		r = this.getGrupo().equals(p.getGrupo()) &&
		this.getGenero().equals(p.getGenero());
		}
		return r;
		}





}



