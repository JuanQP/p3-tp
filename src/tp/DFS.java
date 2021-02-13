package tp;

import java.util.Vector;

import grafos.GrafoDinamic;
import grafos.NodoGrafo;

public class DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GrafoDinamic G = new GrafoDinamic ();
		G.inicializarGrafo(4);
		G.agregarVertice(1);
		G.agregarVertice(2);
		G.agregarVertice(3);
		G.agregarVertice(4);
		G.agregarVertice(6);
		G.agregarVertice(7);
		
		G.agregarArista(1, 2, 4);
		G.agregarArista(1, 4, 1);
		G.agregarArista(2, 3, 2);
		G.agregarArista(3, 4, 1);
		G.agregarArista(6, 7, 2);
		
		
		int origen = 3;
		
		DFS(G,6);
		Marcado (G);
	}
	
	static void DFS (GrafoDinamic x, int o) {
		
		if (x.pertenece(o)) {			// Validar que el numero que se ingresa como origen exista como Nodo del Grafo.
			NodoGrafo origen = x.encontrarNodo(o);
			origen.Visitado = true;
			Vector<NodoGrafo> ady = x.Adyacentes(o);
			for(NodoGrafo nodo: ady ) {
					if (nodo.Visitado == false) {
						o = nodo.valor;
						DFS(x,o);
					}
			}
			origen.marcado = true;
		}
	}
	
	static void Marcado (GrafoDinamic x){
		for (int valorNodo: x.vertices()) {
			NodoGrafo nodo = x.encontrarNodo(valorNodo);
			System.out.println ("El nodo " + nodo.valor + " tiene el estado " + nodo.marcado);
		}
	}

}
