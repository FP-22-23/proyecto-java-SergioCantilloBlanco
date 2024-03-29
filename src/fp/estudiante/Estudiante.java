package fp.estudiante;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fp.common.tipoAuxiliar;



public interface Estudiante extends Comparable<Estudiante> {
		
		public String getGenero();
		public void setGenero(String s);
		
		public grupo getGrupo();
		public void setGrupo(grupo g);

		public String getEducacionParental();
		public void setEducacionParental(String i);
		
		public String getAlmuerzo();
		public void setAlmuerzo(String j);
		
		public Boolean getPreparacion();
		public void setPreparacion(Boolean p);
		
		public Double getMates();
		public void setMates(Double m);
		
		public Double getLectura();
		public void setLectura(Double l);
		
		public Double getEscrito();
		public void setEscrito(Double e);
		
		public LocalDate getFecha();
		public void setFecha(LocalDate f);
		
		public Integer getDuracion();
		public void setDuracion(Integer f);
		
		public tipoAuxiliar getTipo();
		
		public Integer getMedia();
		public void setMedia(Integer M);
		
		public ArrayList getListaNotas();
		public void setListaNotas(ArrayList  M);
	
	

		;


}
