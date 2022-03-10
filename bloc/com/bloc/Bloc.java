package bloc.com.bloc;

import bloc.com.notas.Nota;

public class Bloc {

	private static final Integer NUMERO_NOTAS_MAXIMA=100;
	private Integer numNotas;
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

}
