package grafos;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
public class GrafoDirigido<T> implements Grafo<T> {
	
	private List<Vertice> vertices;
	
	public GrafoDirigido() {
		this.vertices= new ArrayList<>();
	}
	@Override
	public void agregarVertice(int verticeId) {
		if(devolverVertice(verticeId)==null) {
			Vertice vertice=new Vertice(verticeId, "blanco");
			vertices.add(vertice);
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		Vertice v=this.devolverVertice(verticeId);
		if(v!=null) {
			for(int i=0;i<vertices.size();i++) {
				if(vertices.get(i).contieneArco(verticeId)) {
					v.borrarArco(verticeId);
				}
			}
			vertices.remove(v);
		}
	}
	
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Vertice vertice=this.devolverVertice(verticeId1);
		if(vertice!=null) {
			Arco<T> arcoNuevo= new Arco<T>(verticeId1, verticeId2, etiqueta);
			vertice.agregarArco(arcoNuevo);
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		Vertice vertice=this.devolverVertice(verticeId1);
		if(vertice!=null) {
			vertice.borrarArco(verticeId2);
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		if(this.devolverVertice(verticeId)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		Vertice vertice= this.devolverVertice(verticeId1);
		if(vertice!=null) {
			return vertice.contieneArco(verticeId2);
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		Vertice vertice= this.devolverVertice(verticeId1);
		if(vertice!=null) {
			return vertice.obtenerArco(verticeId2);
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}
	public List<Vertice> obtenerCopiaVertices(){
		List<Vertice> clonVertice=null;
		clonVertice.addAll(vertices);
		return clonVertice;
	}
	@Override
	public int cantidadArcos() {
		int cantidadDeArcos=0;
		for(int i=0;i<vertices.size();i++) {
			Vertice v=vertices.get(i);
			cantidadDeArcos+=v.cantidadDeArcos();
		}
		return cantidadDeArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		List<Integer> verticesValores=new ArrayList<>();
		for(int i=0; i<vertices.size();i++) {
			Vertice v=vertices.get(i);
			verticesValores.add(v.getValor());
		}
		return verticesValores.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		List<Integer> adyacentes= new ArrayList<>();
		Vertice v= this.devolverVertice(verticeId);
		if(v!=null) {
			adyacentes.addAll(v.devolverAdyacentes());
			return adyacentes.iterator();
		}
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		List<Arco<T>> arcos=new ArrayList<>();
		for(int i=0;i<vertices.size();i++) {
			Vertice v=vertices.get(i);
			arcos.addAll(v.getArcos());
		}
		return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		Vertice v= this.devolverVertice(verticeId);
		if(v!=null) {
			List<Arco<T>> arcosDelVertice= null;
			arcosDelVertice.addAll(v.getArcos());
			return arcosDelVertice.iterator();
		}
		return null;
	}
	
	public Vertice devolverVertice(int verticeId) {
		if(vertices!=null) {
			for(int i=0;i<vertices.size();i++) {
				Vertice v=vertices.get(i);
				if(v.getValor().equals(verticeId)) {
					return v;
				}
			}
		}
		return null;
	}
	
	public static boolean comprobarSiHayCiclo(GrafoDirigido<Float> g) {
		List<Vertice> vertices=g.obtenerCopiaVertices();
		for(int i=0;i<vertices.size();i++) {
			vertices.get(i).setColor("blanco");
		}
		for(int i=0;i<vertices.size();i++) {
			Vertice v=vertices.get(i);
			if(v.getColor()=="blanco") {
				return comprobarSiHayCiclo(g, v);
			}
		}
		return false;
	}
	
	private static boolean comprobarSiHayCiclo(GrafoDirigido<Float> g, Vertice actual) {
		actual.setColor("amarillo");
		List<Arco> adyacentes=actual.getArcos();
		for(int i=0;i<adyacentes.size();i++) {
			Integer siguiente=adyacentes.get(i).getVerticeDestino();
			Vertice siguienteVertice=g.devolverVertice(siguiente);
			if(siguienteVertice.getColor()=="amarillo") {
				return true;
			}
			if(siguienteVertice.getColor()=="blanco") {
				comprobarSiHayCiclo(g, siguienteVertice);
			}
		}
		actual.setColor("negro");
		return false;
	}
	
	
	public static void BFS(GrafoDirigido<Float> g) {
		List<Vertice> fila=new ArrayList<>();
		List<Vertice> vertices=g.obtenerCopiaVertices();
		
		for(int i=0;i<vertices.size();i++) {
			vertices.get(i).setVisitado("NO_VISITADO");
		}
		for(int i=0;i<vertices.size();i++) {
			Vertice v=vertices.get(i);
			if(v.getVisitado()=="NO_VISITADO") {
				BFS_VISIT(g, v, fila);
			}
		}
	}
	
	private static void BFS_VISIT(GrafoDirigido<Float> g, Vertice actual, List<Vertice> fila) {
		actual.setVisitado("VISITADO");
		fila.add(actual);
		while(fila.size()>0) {
			Vertice v=fila.get(0);
			List<Arco> adyacentes=v.getArcos();
			for(int i=0;i<adyacentes.size();i++) {
				Integer siguiente=adyacentes.get(i).getVerticeDestino();
				Vertice siguienteVertice=g.devolverVertice(siguiente);
				if(siguienteVertice.getVisitado()=="NO_VISITADO") {
					siguienteVertice.setVisitado("VISITADO");
					fila.add(siguienteVertice);
				}
			}
		}
	}
	public static List<Integer> caminoMasLargo(GrafoDirigido<?> g, int verticeOrigen, int verticeFinal) {
		List<Integer> caminoMasLargo=new ArrayList<>();
		List<Integer> auxRecorrido=new ArrayList<>();
		ObtenerCaminoMasLargo(g, verticeOrigen, verticeFinal, auxRecorrido, caminoMasLargo);
		return caminoMasLargo;
	}
	
	private static void ObtenerCaminoMasLargo(GrafoDirigido<?> g,  int verticeOrigen, int verticeFinal, List<Integer> auxRecorrido,List<Integer> caminoMasLargo){
		auxRecorrido.add(verticeOrigen);
		Iterator<Integer> adyacentes= g.obtenerAdyacentes(verticeOrigen);
		if(adyacentes!=null) {
			while(adyacentes.hasNext()) {
				Integer siguiente=adyacentes.next();
				if(siguiente==verticeFinal) {
					auxRecorrido.add(siguiente);
					if(auxRecorrido.size()>caminoMasLargo.size()) {
						caminoMasLargo.clear();
						caminoMasLargo.addAll(auxRecorrido);
						auxRecorrido.remove(auxRecorrido.size()-1);
					}
				}
				else {
					ObtenerCaminoMasLargo(g, siguiente, verticeFinal,auxRecorrido, caminoMasLargo);
				}
			}
		}
	}
	
	public static List<Integer> obtenerTodosLosVerticesQueLLevanAOtro(GrafoDirigido<?> g, int verticeDestino){
		List<Integer> todosLosVertices= new ArrayList<>();
		List<Integer> auxVertices=new ArrayList<>();
		Integer primerVertice= g.obtenerVertices().next();
		obtenerCaminos(g, verticeDestino,primerVertice, todosLosVertices, auxVertices);
		return todosLosVertices;
	}
	
	private static void obtenerCaminos(GrafoDirigido<?> g, int verticeDestino,Integer vertice, List<Integer> todosLosVertices, List<Integer> auxVertices) {
			auxVertices.add(vertice);
			Iterator<Integer> adyacentes= g.obtenerAdyacentes(vertice);
			Integer siguiente = null;
				while(adyacentes.hasNext()) {
					siguiente=adyacentes.next();
					if(siguiente.equals(verticeDestino)) {
						for(int i=0; i<auxVertices.size();i++) {
							if(!todosLosVertices.contains(auxVertices.get(i))) {
								todosLosVertices.add(auxVertices.get(i));
							}
						}
					}
					else {
						if(siguiente!=null) {
							obtenerCaminos(g, verticeDestino,siguiente, todosLosVertices, auxVertices);
						}
					}
				}
				auxVertices.remove(auxVertices.size()-1);
		}
	
	public static List<Integer> caminoMasCortoVecindario(GrafoDirigido<?> g, Integer verticeInicio, Integer verticeDestino) {
		List<Vertice> fila=new ArrayList<>();
		Iterator<Integer> vertices=g.obtenerAdyacentes(verticeInicio);
		List<Integer> camino=new ArrayList<>();
		
		while(vertices.hasNext()) {
			Integer verticeActual=vertices.next();
			Vertice v=g.devolverVertice(verticeActual);
			if(v.getVisitado()=="NO_VISITADO") {
				caminoMasCorto(g, v , verticeDestino, fila, camino);
			}
		}
		return camino;
	}
	private static void caminoMasCorto(GrafoDirigido<?> g, Vertice actual, Integer verticeDestino,List<Vertice> fila, List<Integer> camino) {
		actual.setVisitado("VISITADO");
		fila.add(actual);
		List<Integer> caminoRecorrido=new ArrayList<>();
		while(fila.size()>0) {
			Vertice v=fila.get(0);
			Iterator<Integer> adyacentes=g.obtenerAdyacentes(actual.getValor());
			while(adyacentes.hasNext()) {
				Integer siguiente=adyacentes.next();
				Vertice siguienteVertice=g.devolverVertice(siguiente);
				if(siguienteVertice.getVisitado()=="NO_VISITADO") {
					siguienteVertice.setVisitado("VISITADO");
					fila.add(siguienteVertice);
					if(siguienteVertice.getValor().equals(verticeDestino)) {
						camino.add(siguienteVertice.getValor());
					}
				}
			}
	}
	}
}
