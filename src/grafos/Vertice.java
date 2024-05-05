package grafos;

import java.util.List;
import java.util.ArrayList;

public class Vertice<T> {
	private Integer valor;
	private List<Arco<T>> arcos;
	private String color;
	private int tiempoComienzo;
	private int tiempoFinaliza;
	private String visitado;
	
	public Vertice(Integer valor, String color) {
		this.arcos=new ArrayList<Arco<T>>();
		this.valor=valor;
		this.color=color;
	}
	
	public Integer getValor() {
		return valor;
	}
	public void setColor(String color) {
		this.color=color;
	}
	public Integer getiempoComienzo() {
		return tiempoComienzo;
	}
	public void setiempoComienzo(int tiempo) {
		this.tiempoComienzo=tiempo;
	}
	public Integer getiempoFinaliza() {
		return this.tiempoFinaliza;
	}
	public void setiempoFinaliza(int tiempo) {
		this.tiempoFinaliza=tiempo;
	}
	public String getColor() {
		return this.color;
	}
	public List<Arco> getArcos(){
		List<Arco> clonArcos = null;
		clonArcos.addAll(arcos);
		return clonArcos;
	}
	
	public void agregarArco(Arco<T> arcoNuevo) {
		if(!arcos.contains(arcoNuevo)) {
			arcos.add(arcoNuevo);
		}
	}
	public boolean contieneArco(Integer valorDestino) {
		for(int i=0; i<arcos.size();i++) {
			Integer valorDestinoDelArco=arcos.get(i).getVerticeDestino();
			if(valorDestino==valorDestinoDelArco) {
				return true;
			}
		}
		return false;
	}
	
	public Arco<T> obtenerArco(Integer valorDestino){
		for(int i=0; i<arcos.size();i++) {
			Integer valorDestinoDelArco=arcos.get(i).getVerticeDestino();
			if(valorDestino==valorDestinoDelArco) {
				return arcos.get(i);
			}
		}
		return null;
	}
	
	public Integer cantidadDeArcos() {
		return arcos.size();
	}
	
	public void borrarArco(int valorDestino) {
		for(int i=0; i<arcos.size();i++) {
			Integer valorDestinoDelArco=arcos.get(i).getVerticeDestino();
			if(valorDestino==valorDestinoDelArco) {
				arcos.remove(arcos.get(i));
			}
		}
	}
	public List<Integer> devolverAdyacentes(){
		List<Integer> adyacentes= new ArrayList<>();
		for(int i=0;i<arcos.size();i++) {
			adyacentes.add(arcos.get(i).getVerticeDestino());
		}
		return adyacentes;
	}
	public void setVisitado(String visitado) {
		this.visitado=visitado;
		
	}

	public String getVisitado() {
		return this.visitado;
	}
}
