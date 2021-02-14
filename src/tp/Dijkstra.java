package tp;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import grafos.GrafoDinamic;
import grafos.NodoGrafo;

public class Dijkstra {
	/**
	 * Es el ejemplo de la diapositiva 11 de la ppt 10
	 * @throws Exception 
	 */
	public static void Test() throws Exception {
		Dijkstra dijkstra = new Dijkstra();
		GrafoDinamic grafo1 = new GrafoDinamic();
		grafo1.agregarVertice(1);
		grafo1.agregarVertice(2);
		grafo1.agregarVertice(3);
		grafo1.agregarVertice(4);
		grafo1.agregarVertice(5);
		grafo1.agregarVertice(6);
		grafo1.agregarArista(1, 6, 5);
		grafo1.agregarArista(1, 5, 10);
		grafo1.agregarArista(1, 3, 40);
		grafo1.agregarArista(2, 4, 5);
		grafo1.agregarArista(3, 2, 10);
		grafo1.agregarArista(3, 5, 5);
		grafo1.agregarArista(4, 3, 5);
		grafo1.agregarArista(5, 4, 20);
		grafo1.agregarArista(6, 2, 20);
		grafo1.agregarArista(6, 5, 10);
		NodoGrafo inicio1 = grafo1.encontrarNodo(1);
		
		Map<NodoGrafo, Integer> D1 = dijkstra.recorrer(grafo1, inicio1);
		
		System.out.println(D1.toString());
	}
	
	public Map<NodoGrafo, Integer> recorrer(GrafoDinamic grafo, NodoGrafo inicio) throws Exception {
		// Distancias
		Map<NodoGrafo, Integer> D = new HashMap<>();
		// Cola de pendientes por visitar
		Queue<NodoGrafo> Q = new LinkedList<NodoGrafo>();
		// Conjunto de nodos visitados
		Set<NodoGrafo> S = new HashSet<NodoGrafo>();
		
		// Inicializamos las distancias de todos los nodos respectivo del inicio a infinito
		for (int valorNodo : grafo.vertices()) {
			NodoGrafo nodo = grafo.encontrarNodo(valorNodo);
			D.put(nodo, Integer.MAX_VALUE);
			Q.add(nodo); // Q = V
		}
		// El inicio queda con distancia 0.
		D.put(inicio, 0);
		
		// Recorremos Q mientras no sea vacío.		
		while(!Q.isEmpty()) {
			NodoGrafo u = this.distanciaMinima(D, Q);
			Q.remove(u);
			S.add(u); // Visitado
			// Iteramos entre los vecinos del nodo actual
			for (NodoGrafo v : grafo.Adyacentes(u.valor)) {
				// Si la distancia hasta el vecino es mayor que la distancia
				// del nodo actual + (la arista nodoActual->vecino), significa que encontramos un camino
				// más corto!
				if(D.get(v) > D.get(u) + grafo.pesoArista(u.valor, v.valor)) {
					D.put(v, D.get(u) + grafo.pesoArista(u.valor, v.valor));
				}
			}
		}
		return D;
	}
	
	/**
	 * Primero filtra D, y se queda con solo aquellos que también están en Q.
	 * Luego, busca el que tiene la distancia mínima.
	 * Devuelve el NodoGrafo con distancia mínima.
	 * @param D
	 * @return El NodoGrafo con menor distancia
	 */
	public NodoGrafo distanciaMinima(Map<NodoGrafo, Integer> D, Queue<NodoGrafo> Q) {
		return D.entrySet()
			.stream()
			.filter(x -> Q.contains(x.getKey()))
			.min(Comparator.comparingInt(Map.Entry::getValue))
			.get()
			.getKey();
	}
}
