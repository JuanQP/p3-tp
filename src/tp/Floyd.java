package tp;

import grafos.GrafoDinamic;
import grafos.GrafosTDA;

public class Floyd {
	
	public static void Test() throws Exception {
		Floyd floyd= new Floyd();
		GrafoDinamic grafo1 = new GrafoDinamic();
		grafo1.agregarVertice(1);
		grafo1.agregarVertice(2);
		grafo1.agregarVertice(3);
		grafo1.agregarVertice(4);
		grafo1.agregarArista(1, 4, 5);
		grafo1.agregarArista(1, 2, 3);
		grafo1.agregarArista(2, 1, 2);
		grafo1.agregarArista(2, 4, 4);
		grafo1.agregarArista(3, 2, 1);
		grafo1.agregarArista(4, 3, 2);
		
		System.out.println("Se va a usar el grafo: ");
		grafo1.mostrarMatriz();

		int[][] A = floyd.recorrer(grafo1);

		System.out.println("Matriz resultado con distancias minimas: ");
		mostrarMatriz(A);
	}
	
	public int[][] recorrer(GrafosTDA grafo) throws Exception {
		int n = grafo.vertices().length;
		int[][] A = new int[n][n];
		
		// Inicialización
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				try {
					A[i][j] = grafo.pesoArista(i+1, j+1);
				} catch (Exception e) {
					A[i][j] = 9999;
				}
			}
		}
		// Diagonal en 0s
		for (int i = 0; i < n; i++) {
			A[i][i] = 0;
		}
		System.out.println("Matriz inicializada:");
		mostrarMatriz(A);
		System.out.println();
		// Resolución
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(A[i][k] + A[k][j] < A[i][j])
						A[i][j] = A[i][k] + A[k][j];
				}
			}
		}
		
		return A;
	}
	
	public static void mostrarMatriz(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if(A[i][j] == 9999)
					System.out.print(Utils.padString("INF", 4, ' '));
				else
					System.out.print(Utils.padString(A[i][j] + "", 4, ' '));
			}
			System.out.println();
		}
	}
}
