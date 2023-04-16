package fp.estudiante;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContenedorEstudiantes {
	//Atributo
	private List<EstudianteImpl> estudiante;
	
	//Constructor
	public ContenedorEstudiantes() {
		this.estudiante = new ArrayList<>();
	}
	public ContenedorEstudiantes(Stream<EstudianteImpl> st) {
		this.estudiante = st.collect(Collectors.toList());
	}
	
	//Basico
	public void añadirEst(EstudianteImpl f) {          
		estudiante.add(f);
    }
	public void eliminarEst(EstudianteImpl f) {        
        if (!estudiante.contains(f)) {
            throw new IllegalArgumentException("El estudiante no existe");
        } else {
        	estudiante.remove(f);
        }
   
    }
	 public void tamañoEst(EstudianteImpl f) {
	    	estudiante.size();
	    }
	 public void addAllEst(EstudianteImpl f) {
	    	estudiante.addAll(estudiante);
	    }
	 
	//MÉTODOS STREAM
    public List<EstudianteImpl> MenorMedia(Double mediaminima) {
    	return this.estudiante.stream()
    			.filter(c -> c.getMedia() >= mediaminima)
    			.collect(Collectors.toList());
    }

	
    public Integer numeroDeEstudiantesPorMes(LocalDate fecha) {
    	Month mes = fecha.getMonth();
    	return (int)this.estudiante.stream()
    			.filter(i -> i.getFecha().getMonth() == mes)
    			.count();
    }
    
    public Boolean estudiantesTardones() {
    	return this.estudiante.stream()
    			.anyMatch(d -> d.getDuracion().compareTo(80) >= 0);  			
    }
    public Map<String, Long> obtenerNumeroDeComprasPorCatergoria(){
		return this.estudiante.stream()
				.collect(Collectors.groupingBy(EstudianteImpl::getGenero,
						Collectors.counting()));
	}
    
    
    
    
	@Override
	public int hashCode() {
		return Objects.hash(estudiante);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContenedorEstudiantes other = (ContenedorEstudiantes) obj;
		return Objects.equals(estudiante, other.estudiante);
	}
	@Override
	public String toString() {
		return "ContenedorEstudiantes [estudiante=" + estudiante + "]";
	}

    
	

}
