package grafos;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class ServicioBFS {
	
	private Hashtable<Integer, String> visitado;
	
public void DFS(GrafoDirigido<?> g) {
		
		Iterator<Integer> it=g.obtenerVertices();
		LinkedList<Integer> resultado= new LinkedList<>();
		while(it.hasNext()) {
			Integer adyacente =it.next();
			visitado.put(adyacente, "blanco");
		}
		
		it= g.obtenerVertices();
		while(it.hasNext()) {
			Integer adyacente =it.next();
			if(visitado.get(adyacente)=="NO_VISITADO") {
				BFS_VISIT(g, adyacente, resultado);
			}
		}
	}
	
	private void BFS_VISIT(GrafoDirigido<?> g, Integer actual, LinkedList<Integer> resultado) {
		visitado.put(actual, "amarillo");
		resultado.add(actual);
		Iterator<Integer> adyacentes=g.obtenerAdyacentes(actual);
		while(adyacentes.hasNext()) {
			Integer adyacente=adyacentes.next();
			if(visitado.get(adyacente)=="blanco") {
				BFS_VISIT(g, adyacente, resultado);
			}
		}
		visitado.put(actual, "negro");
		resultado.remove(actual);
	}
}
