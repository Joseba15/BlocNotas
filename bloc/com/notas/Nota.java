package bloc.com.notas;

import java.time.LocalDateTime;
import java.util.Objects;

public class Nota implements Comparable<Nota> {

	private static int codigoSiguiente;
	private int codigo=0;
	private String texto;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaUltimaModificacion;
	
	public Nota (String texto) {
		this.texto=texto;
		this.codigo=codigoSiguiente++;
		this.fechaCreacion=LocalDateTime.now();
		
	}

	
	public boolean isModificadoAnterior(Nota otraNota){
		boolean esAnterior=false;
	 
		if (this.getFechaUltimaModificacion()==null && otraNota.getFechaUltimaModificacion()==null) {
			esAnterior=false;
	   }else if (this.isModificado() && otraNota.isModificado()) {
			esAnterior=this.getFechaUltimaModificacion().isBefore(otraNota.getFechaUltimaModificacion());
	   }else if (this.isModificado()) {
		   	esAnterior=true;
	}
		
		return esAnterior;
	}
	
	public boolean isCreadoAnterior (Nota otraNota) {
		boolean esAnterior=false;
		
		if (this.getFechaCreacion().isBefore(otraNota.getFechaCreacion())) {
			esAnterior=true;
			
		}
		
		return esAnterior;
	}
	
	public boolean isEmpty() {
		boolean estaVacio=false;
		if (texto==null || texto.trim().isEmpty()) {
			estaVacio=true;
		}
		return estaVacio;
	}


	public boolean isModificado() {
		boolean estaModfechaCreacion=true;
		if (fechaUltimaModificacion==null) {
			estaModfechaCreacion=false;
		}
		return estaModfechaCreacion;
	}


	public Integer getCodigo() {
		return codigo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
		this.fechaUltimaModificacion=LocalDateTime.now();
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDateTime getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}




	@Override
	public int hashCode() {
		return Objects.hash(fechaCreacion, texto);
	}


	@Override
	public boolean equals(Object obj) {
		boolean sonIguales=true;
		
		if (obj!=null) {
			if (this==obj) {
				sonIguales=true;
				
			}else{
				Nota laOtra = (Nota)obj;
				sonIguales=this.texto.equals(laOtra.getTexto())
						&& this.getFechaCreacion().equals(laOtra.getFechaCreacion());
			}
		}
		
			return sonIguales;
	}


	@Override
	public String toString() {
		return "Nota con codigo " + codigo + " y texto " + texto;
	}

	
	@Override
	public int compareTo(Nota other) {
		
		
		int resultado=0;
		if (other!=null) {
			if (this.fechaCreacion.isBefore(other.fechaCreacion)) {
				resultado=-1;
			}else if (this.fechaCreacion.isAfter(other.fechaCreacion)) {
				resultado=1;
			}			
		}
		
		return -resultado;	
		
		//return this.getCodigo-other.getCodigo;
	}

	
	
	
	
	
	
	
}
