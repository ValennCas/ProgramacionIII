package grafos;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioDFS {
	
	private Hashtable<Integer, String> colores;
	public void DFS(GrafoDirigido<?> g) {
		
		Iterator<Integer> it=g.obtenerVertices();
		LinkedList<Integer> resultado= new LinkedList<>();
		while(it.hasNext()) {
			Integer adyacente =it.next();
			colores.put(adyacente, "blanco");
		}
		
		it= g.obtenerVertices();
		while(it.hasNext()) {
			Integer adyacente =it.next();
			if(colores.get(adyacente)=="blanco") {
				DFS_VISIT(g, adyacente, resultado);
			}
		}
	}
	
	private void DFS_VISIT(GrafoDirigido<?> g, Integer actual, LinkedList<Integer> resultado) {
		colores.put(actual, "amarillo");
		resultado.add(actual);
		Iterator<Integer> adyacentes=g.obtenerAdyacentes(actual);
		while(adyacentes.hasNext()) {
			Integer adyacente=adyacentes.next();
			if(colores.get(adyacente)=="blanco") {
				DFS_VISIT(g, adyacente, resultado);
			}
		}
		colores.put(actual, "negro");
		resultado.remove(actual);
	}
}
