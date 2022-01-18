import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Punto 1:
		System.err.println("Punto 1 - Lista de 100 puntos:");

		List<Punto> listPuntos = creaPuntos();
		int cont = 1;
		for (Punto p : listPuntos) {
			System.out.println("Punto" + cont + ":" + p);
			cont++;
		}

		// Punto 2-a:
		System.err.println("\nPunto 2- a) Lista A:");
		Comparator<Punto> comparaX = (Punto p1, Punto p2) -> {
			if (p1.getX() < p2.getX()) {
				return -1;
			} else if (p1.getX() > p2.getX()) {
				return 1;
			} else {
				return 0;
			}
		};

		List<Punto> listaA = listPuntos.stream()
				.sorted(comparaX) // Ordeno los pX de menor a mayor.
				.filter(p -> (p.getY() >= -15 && p.getY() <= 15)) // Filtro los pY:[-15 <= y <= 15])
				.map(p -> new Punto(p.getX(), calcFX(p.getX())))
				.collect(Collectors.toList());
		
		listaA.forEach(x -> System.out.println(x+","));
		
		// Punto 2-b:
		System.err.println("\nPunto 2- b y c) Lista B:");
		List<Punto> listaB = listPuntos.stream() //Tomar la lista de 100 puntos y comparar cada uno...
				.filter(p->((calcFX(p.getX())-(p.getY())>=0)&&(calcFX(p.getX())-(p.getY())<=10))) //Filtrar y obtener una lista donde: [0 <= F(x) – Py <= 10]).
				.collect(Collectors.toList());
		
		//Punto 2-c: Imprimir por consola una lista de puntos del ejercicio b.
		listaB.forEach(x -> System.out.println(x+","));
		
		//Punto 2-d:
		System.err.println("\nPunto 2- d y e) Centroide y Distancia:");
		//Calcular el centroide de la lista de puntos:
		Punto cent=calcCent(listPuntos);
		System.out.println("Centroide: "+cent);
		
		System.err.println("\nPuntos distancia en radio de 5 al centroide: ");
		//d=Sqrt((x_2-x_1)^2+(y_2-y_1)^2)
		List<Punto> listaC=listPuntos.stream()
				.filter(p->((Math.sqrt(Math.pow((cent.getX()-p.getX()), 2)+(Math.pow((cent.getY()-p.getY()), 2)))<=5.0)))
				.collect(Collectors.toList());
		
		//2-e: Imprimir por consola una lista de puntos del ejercicio d.
		listaC.forEach(x -> System.out.println(x+","));
		
		// Punto 2-f:
				System.err.println("\nPunto 2- f) Lista F:");
				List<Punto> listaF = listPuntos.stream()
						.filter(p->((p.getY())-(calcFX(p.getX()))>=0)
								&&((p.getY())-(calcFX(p.getX()))<1)) //[0 <= Py - F(x) < 1]
						.collect(Collectors.toList());
				
				listaF.forEach(x -> System.out.println(x+","));
		
				// Punto 2-g:
				System.err.println("\nPunto 2- g y h) Lista G:");
				List<Punto> listaG = listPuntos.stream()
						.filter(p->(((p.getX())>=0)&&(((p.getY())>=0)&&(p.getY())<=calcFX(p.getX())))) //Filtrar y obtener una lista donde: [0 <= F(x) – Py <= 10]).
						.collect(Collectors.toList());

				//Punto 2-h: Imprimir por consola una lista de puntos del ejercicio g.
				listaG.forEach(x -> System.out.println(x+","));
				
				// Punto 2-i:
				System.err.println("\nPunto 2- i y j) Lista I:");
				List<Punto> listaI = listPuntos.stream()
						.filter(p->(((p.getX())>=-4)&&((p.getX())<=4))&&(p.getY())>=(calcFX(p.getX()))) //Filtrar y obtener una lista donde: [0 <= F(x) – Py <= 10]).
						.collect(Collectors.toList());
				
				//Punto 2-j: Imprimir por consola una lista de puntos del ejercicio i.
				listaI.forEach(x -> System.out.println(x+","));		
	}

	public static double calcFX(double x) {
		return ((Math.pow(x, 3)) + (2 * (Math.pow(x, 2)))-2*x + 2);
	}
	
	public static Punto calcCent(List<Punto> listaPuntos) {
		double sumX=0;
		double sumY=0;
		for(Punto p:listaPuntos) {
			sumX+=p.getX();
			sumY+=p.getY();
		}
		double centX = sumX/100;
		double centY = sumY/100;
		
		Punto cent=new Punto(centX,centY);
		return cent;
	}

	public static List<Punto> creaPuntos() {
		List<Punto> listaPuntos = new ArrayList<Punto>();
		double x;
		double y;
		for (int i = 0; i < 100; i++) {
			x = Math.random() * (20.0) - 10.0;
			y = Math.random() * (40.0) - 20.0;
			listaPuntos.add(new Punto(x, y));
		}
		return listaPuntos;
	}
}
