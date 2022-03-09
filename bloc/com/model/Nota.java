package bloc.com.model;

import java.time.LocalDateTime;

public class Nota implements Comparable<Nota> {

	private static Integer codigoSiguiente;
	private Integer codigo;
	private String texto;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaUltimaModificacion;
	
	public Nota (String texto) {
		this.texto=texto;
		
	}
	
	
	public boolean isCreadoAnterior (Nota nota) {
		boolean esAnterior=false;
		
		if (this.getFechaCreacion().compareTo(nota.getFechaCreacion())<0) {
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
		boolean estaModfechaCreacionifacado=true;
		if (fechaUltimaModificacion==null) {
			estaModifacado=false;
		}
		return estaModifacado;
	}


	public Integer getCodigo() {
		return codigo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDateTime getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Nota)) {
			return false;
		}
		Nota other = (Nota) obj;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null) {
				return false;
			}
		} else if (!fechaCreacion.equals(other.fechaCreacion)) {
			return false;
		}
		if (texto == null) {
			if (other.texto != null) {
				return false;
			}
		} else if (!texto.equals(other.texto)) {
			return false;
		}
		return true;
	}




	@Override
	public String toString() {
		return "Nota con codigo " + codigo + " y texto " + texto;
	}

	
	@Override
	public int compareTo(Nota other) {
		int resultado=0;
		if (this.fechaCreacion.isBefore(other.fechaCreacion)) {
			resultado=-1;
		}else if (this.fechaCreacion.isAfter(other.fechaCreacion)) {
			resultado=1;
		}
		
		return resultado;	
	}

	
	
	
	
	
	
	
}
