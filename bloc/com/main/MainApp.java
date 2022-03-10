package bloc.com.main;

import java.util.Scanner;

import bloc.com.notas.Nota;
import bloc.com.notas.NotaAlarma;
import bloc.com.notas.NotaAlarmaException;

public class MainApp {

	public static void main(String[] args) {
	
		Nota[] bloc = new Nota[5];
		for (int i = 0; i < bloc.length; i++) {
			bloc[i]=crearNota();
		}
		
		
		
		
		try {
			NotaAlarma notaAlarma = null;
			notaAlarma.activar();
			
		} catch (Exception e) {
			throw new NotaAlarmaException("Se ha producido una excepcion", e);
		}
		
	}
	
	
	
	public static Nota crearNota() {
		
		System.out.println("Introduce un mensaje para la nota");
		String texto=new Scanner (System.in).nextLine();
		return new Nota(texto);
		
	}
	
}
