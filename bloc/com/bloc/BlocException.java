package bloc.com.bloc;

public class BlocException extends RuntimeException {

	public BlocException() {}
	
	public BlocException(String mensaje, Throwable exc, boolean a, boolean b) {
	
	}


	public BlocException(String mensaje, Throwable lanzable) {
		super(mensaje,lanzable);

	}

	public BlocException(String mensaje) {
		super(mensaje);

	}


	public BlocException(Throwable lanzable) {
	super(lanzable);

	}
	
}
