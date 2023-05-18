package fp.estudiante;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
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
    public Map<Integer, List<EstudianteImpl>> ObtenerEstudiantePorDebajoMediaMinima(Integer MediaMinima){
		return estudiante.stream().filter(estudiante -> estudiante.getMedia()<= MediaMinima)
				.collect(Collectors.groupingBy(EstudianteImpl::getMedia));

	}
    public Map<String, Long> ObtenerNumeroEstudiantesPorGeneroQueEstudio(){
    	return estudiante.stream().filter(estudiante -> estudiante.getPreparacion() == true).collect(Collectors.groupingBy(EstudianteImpl::getGenero, Collectors.counting()));
    }
    
    
    //METODOS TERCERA ENTREGA
    
    public EstudianteImpl estudianteMaximaMedia() {
    	return estudiante.stream().max(Comparator.comparing(EstudianteImpl::getMedia)).get();
    	}
    	
    public List<EstudianteImpl> notasMujeresMatesordenadasMayorAMenor() {
    	return estudiante.stream().filter(f->f.getGenero().equals("female")).sorted(Comparator.comparing(EstudianteImpl::getMates).reversed()).toList();
    	}
    
    public List<Double> getlistaDeNotasLectura() {
    	return estudiante.stream().collect(Collectors.mapping(EstudianteImpl::getLectura, Collectors.toList()));
    	
    }
    
    public Map<String, Double> mujerHombreConMayorMedia() {
    	return this.estudiante.stream()
    			.collect(Collectors.toMap(EstudianteImpl::getGenero, EstudianteImpl::getMates, Double::max));
    }
    
    public SortedMap<String, List<Double>>tresPeoresNotasPorGenero(Integer n){
    	return   estudiante.stream()
    			.collect(Collectors.groupingBy(EstudianteImpl::getGenero,TreeMap::new,
    					Collectors.collectingAndThen(Collectors.toList(), lv->seleccionaest(lv, n))));
    	
    }
    
    //FUNCION AUX
    public List<Double> seleccionaest(List<EstudianteImpl> l, Integer n){
    	return l.stream().sorted(Comparator.comparing(EstudianteImpl::getMates))
    			.map(EstudianteImpl::getMates)
    			.limit(n)
    			.collect(Collectors.toList());
    }
    
    public String MayorMediaEntreHombreMujer() {
    	return this.mujerHombreConMayorMedia().entrySet().stream().max(Comparator.comparing(Entry::getValue)).get().getKey();
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
