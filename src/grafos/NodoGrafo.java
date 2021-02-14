package grafos;

public class NodoGrafo {
	public int valor;
	public NodoArista lista;
	public NodoGrafo sig;
	public boolean Visitado;
	public boolean marcado;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "NodoGrafo(" + this.valor + ")";
	}
}
