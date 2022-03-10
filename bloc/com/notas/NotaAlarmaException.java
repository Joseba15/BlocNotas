package bloc.com.notas;


public class NotaAlarmaException extends RuntimeException {

	public NotaAlarmaException(String mensaje, Throwable exc, boolean a, boolean b) {
		
	}
	
	
	public NotaAlarmaException(String mensaje, Throwable lanzable) {
		super(mensaje,lanzable);
	
	}
	
	public NotaAlarmaException(String mensaje) {
		super(mensaje);
	
	}
	
	
	public NotaAlarmaException(Throwable lanzable) {
		super(lanzable);
	
	}
	
	
	
}
