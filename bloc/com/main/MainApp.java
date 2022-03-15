package bloc.com.main;

import java.time.LocalDateTime;
import java.util.Scanner;

import bloc.com.bloc.Bloc;
import bloc.com.notas.Nota;
import bloc.com.notas.NotaAlarma;
import bloc.com.notas.NotaAlarmaException;

public class MainApp {
	
	private static String MENU_PRINCIPAL="Menu para crear notas (Introduzca 4 para salir) \n"
			+ "1. Crear nota : \n"
			+ "2. Crear nota alarma : \n"
			+ "3. Modificar nota : \n"
			+ "4. Ordenar nota: \n"
			+ "5. Salir. \n"
			+ "Introduzca una opcion: \n";
	
	

	public static void main(String[] args) {
	
		Scanner sc = new Scanner (System.in);
		System.out.println(MENU_PRINCIPAL);
		
		int opcion = Integer.valueOf(sc.nextLine()); 
		
		Bloc bloc = new Bloc("bloc 1");
		
		while (opcion!=5) {
			if (opcion==1) {
				System.out.println("Introduzca el texto a introducir en la nota :");
				String text = sc.nextLine();
				Nota n = new Nota(text);
				bloc.addNota(n);
			}else if (opcion==2) {
				crearFecha(sc);
			}else if (opcion==4) {
				for (Nota n : bloc.ordenaBloc()) {
					System.out.println(n);
				}
			}
			System.out.println("------------------------------------------------------");
			System.out.println(MENU_PRINCIPAL);
			opcion=Integer.valueOf(sc.nextLine());
		}
		
		
		

		
		
		
		
		/*
		Nota[] bloc = new Nota[5];
		for (int i = 0; i < bloc.length; i++) {
			bloc[i]=crearNota();
		}
		*/
		
		
		
		try {
			NotaAlarma notaAlarma = null;
			notaAlarma.activar();
			
		} catch (Exception e) {
			throw new NotaAlarmaException("Se ha producido una excepcion", e);
		}
		
	}



	private static void crearFecha(Scanner sc) {
		System.out.println("Introduzca el dia ");
		int dia =Integer.valueOf(sc.nextLine());
		System.out.println("Introduzca el mes ");
		int mes =Integer.valueOf(sc.nextLine());
		System.out.println("Introduzca el año ");
		int year =Integer.valueOf(sc.nextLine());
		
		System.out.println("Introduzca la hora ");
		int hour =Integer.valueOf(sc.nextLine());
		System.out.println("Introduzca el minutos");
		int min =Integer.valueOf(sc.nextLine());
		System.out.println("Introduzca los segundos");
		int sec =Integer.valueOf(sc.nextLine());
		
		LocalDateTime fecha = LocalDateTime.of(year, mes, dia, hour,min,sec);
	}
	
	
	/*
	public static Nota crearNota() {
		
		System.out.println("Introduce un mensaje para la nota");
		String texto=new Scanner (System.in).nextLine();
		return new Nota(texto);
		
	}
	*/
}
