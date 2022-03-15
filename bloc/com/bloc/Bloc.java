package bloc.com.bloc;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

import bloc.com.notas.Activable;
import bloc.com.notas.Nota;
import bloc.com.notas.NotaAlarma;
import bloc.com.notas.NotaAlarmaException;

public class Bloc  {

	private static final Integer NUMERO_NOTAS_MAXIMA=100;
	private Integer numNotas=0;
	private String nombre;
	private Nota[] listaNota = new Nota[NUMERO_NOTAS_MAXIMA];
	
	
	
	public Bloc (String nombre) {
		this.nombre=nombre;
		
	}
	
	public String getNota(Integer numNotas) {
		
		String resultado="";
		
		if (numNotas!=null) {
			resultado=listaNota[numNotas-1].getTexto();
					
		}else {
			throw new BlocException("No se ha encontrado una nota ");
		}
		
		return resultado;
	}
	
	
	public void addNota (Nota nota) {
		if (numNotas<NUMERO_NOTAS_MAXIMA) {			
			this.listaNota[numNotas++]=nota;
		}
	}
	
	           
	
	public void addNota (int posicion,Nota nota) {
		if (posicion<NUMERO_NOTAS_MAXIMA) {			
			this.listaNota[posicion++]=nota;
		}
	}
	
	
	
	
	public void updateNota(String textoNota,Integer pos) {
			if (listaNota[pos-1]==null) {
				
				throw new BlocException("No se ha encontrado ninguna nota en esa posicion");
			}else {
				listaNota[pos-1].setTexto(textoNota);
				
			}
	}
	
	public void activa(Integer pos) {
		
		if (pos<NUMERO_NOTAS_MAXIMA) {
			if (this.listaNota[pos-1] instanceof Activable && this.listaNota[pos-1]!=null) {
				Nota notaAactivar= (NotaAlarma)this.listaNota[pos-1];
				((NotaAlarma) notaAactivar).activar();
			}				
		}else {
			throw new BlocException("No se ha podido activar la alarma");
		}
		
		
	}
	
	
	public void desactivar(Integer pos) {
		if (pos<NUMERO_NOTAS_MAXIMA) {
			if (this.listaNota[pos-1] instanceof Activable && this.listaNota[pos-1]!=null) {
				Nota notaAactivar= (NotaAlarma)this.listaNota[pos-1];
				((NotaAlarma) notaAactivar).desactivar();
			}				
		}else {
			throw new BlocException("No se ha podido activar la alarma");
		}
		
	}
	
	
	public Nota[] ordenaBloc() {
		int contadorNotas = contarNotasNoNulas();
		
		Nota[] notasOrdenadas = new Nota [contadorNotas];
		int contadorNotasOrdenadas=0;
		
		for (int i = 0; i < notasOrdenadas.length; i++) {
			if (this.listaNota[i]!=null) {
				notasOrdenadas[contadorNotasOrdenadas++]=this.listaNota[i];
				
			}
		}
		
		Arrays.sort(notasOrdenadas);
		return notasOrdenadas;
	}

	private int contarNotasNoNulas() {
		int contadorNotas=0;
		for (int i = 0; i < listaNota.length; i++) {
			if (this.listaNota[i]!=null) {
				contadorNotas++;
			}
		}
		return contadorNotas;
	}
	

	public static Integer getNumeroNotasMaxima() {
		return NUMERO_NOTAS_MAXIMA;
	}

	public String getNombre() {
		return nombre;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bloc otroBloc = (Bloc) obj;
		return Objects.equals(nombre, otroBloc.nombre);
	}

	@Override
	public String toString() {
		return "Bloc con nombre " + nombre;
	}

	
	
	
	
	
	
	

}
