package grafos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
		GrafoDirigido<Float> grafito = new GrafoDirigido<>();
		
		// Agrego los vertices 1 y 2
		grafito.agregarVertice(1);
		grafito.agregarVertice(2);
		grafito.agregarVertice(3);
		grafito.agregarVertice(7);
		grafito.agregarVertice(5);
		grafito.agregarVertice(13);
		grafito.agregarVertice(4);
		grafito.agregarVertice(6);

		// Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
		grafito.agregarArco(1, 2, 3F);
		grafito.agregarArco(2, 5, 5F);
		grafito.agregarArco(2, 3, 4F);
		grafito.agregarArco(3, 7, null);
		grafito.agregarArco(7, 5, null);
		grafito.agregarArco(2, 13, null);
		grafito.agregarArco(13, 4, null);
		grafito.agregarArco(2, 13, null);
		grafito.agregarArco(3, 6, null);
		grafito.agregarArco(6, 13, null);
		
		// Obtengo el arco entre 1 y 2, y le pido la etiqueta
		Float etiqueta = grafito.obtenerArco(1, 2).getEtiqueta();
		
		System.out.println(etiqueta); // Deber�a imprimir 3
		
		/*Iterator<Integer> adyacentes=grafito.obtenerAdyacentes(2);
		while(adyacentes.hasNext()) {
			System.out.println(adyacentes.next());
		}*/
		/*List<Integer> caminoMasLargo=new ArrayList<>();
		caminoMasLargo.addAll(grafito.caminoMasLargo(grafito, 1, 5));
		System.out.println("[");
		for(int i=0;i<caminoMasLargo.size();i++) {
			System.out.println(caminoMasLargo.get(i)+", ");
		}
		System.out.println("]");*/
		
   		List<Integer> obtenerVerticesConCamino= new ArrayList<>();
		obtenerVerticesConCamino.addAll(grafito.obtenerTodosLosVerticesQueLLevanAOtro(grafito, 13));
		System.out.println("[");
		for(int i=0;i<obtenerVerticesConCamino.size();i++) {
			System.out.println(obtenerVerticesConCamino.get(i)+", ");
		}
		System.out.println("]");
	}
	

}
