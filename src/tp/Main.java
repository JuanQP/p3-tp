package tp;

public class Main {

	public static void main(String[] args) throws Exception {
		// Acá va el código para ejecutar el proyecto
		System.out.println("+Se va a ejecutar el Algoritmo DFS");
		DFS.main(null);

		System.out.println();
		System.out.println("+Se va a ejecutar el Algoritmo de Dijkstra");
		Dijkstra.Test();

		System.out.println();
		System.out.println("+Se va a ejecutar el Algoritmo de Floyd");
		Floyd.Test();
	}

}
