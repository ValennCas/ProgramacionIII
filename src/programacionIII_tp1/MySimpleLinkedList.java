package programacionIII_tp1;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T> {
	private Node<T> first;
	private int size;
	
	public MySimpleLinkedList() {
		this.first=null;
		size=0;
	}
	public void insertFront(T info) {
		Node<T> next= new Node<T>(info,null);
		next.setNext(first);
		first=next;
		size++;
	}
	
	public T extractFront() {
		if(first==null) {
			return null;
		}
		else{	
			T retorno=first.getInfo();
			first=first.getNext();
			size-=1;
			return retorno;	
			}
		}
		
	public int size(){
		return size;
	}
	public boolean isEmpty() {
		return first==null;
	}
	
	
	public T get(int index) {
		if(index<0 || index>size-1) {
			return null;
		}
		else{
			int contador=0;
			Node<T> aux=this.first;
			while(contador!=index) {
				aux=aux.getNext();
				contador++;
			}
			return aux.getInfo();
		}
	}
	
	
	public void insertLast(T info) {
		Node<T> aux= this.first;
		if(aux== null) {
			insertFront(info);
		}
		else {
			while(aux.getNext() !=null){
				aux=aux.getNext();
			}
			Node<T> tmp= new Node<T>(info, null);
			aux.setNext(tmp);
			size+=1;
		}
	}
	
	public String toString() {
		Node<T> aux= this.first;
		String valores="";
		if(first==null){
			return "La lista no cuenta con algun elemento.";
		}
		else {
			while(aux!=null) {
				T info=aux.getInfo();
				valores+="Su valor es "+info+ "; ";
				aux=aux.getNext();
			}
			return valores;
		}
	}
	
	public int indexOf(T info) {
		int contador=0;
		Node<T> aux=first;
		while(contador<size-1 && aux.getInfo()!= info) {
			aux=aux.getNext();
			contador++;
		}
		if(contador>=size) {
			return -1;
		}
		else {
			return contador;
		}
	}

	public MySimpleLinkedList<Integer> elementosEnComun(MySimpleLinkedList<Integer> lista, MySimpleLinkedList<Integer> lista2){
		MySimpleLinkedList<Integer> listaElementosEnComun= new MySimpleLinkedList<Integer>();
		for(int i=0; i<lista.size();i++) {
			int primerElemento=lista.get(i);
			for(int j=0; j<lista2.size(); j++) {
				if(lista2.get(j)==primerElemento) {
					listaElementosEnComun.insertFront(primerElemento);
					j=lista2.size();
				}
			}
		}
		return listaElementosEnComun;
	}
	public MySimpleLinkedList<Integer> elementosEnComun2(MySimpleLinkedList<Integer> lista, MySimpleLinkedList<Integer> lista2){
		MySimpleLinkedList<Integer> listaElementosEnComun= new MySimpleLinkedList<Integer>();
		
		Iterator<Integer> iterator= lista.iterator();

		while(iterator.hasNext()) {
			int primerElemento= iterator.next();
			Iterator<Integer> iterator2=lista2.iterator();
			while(iterator2.hasNext()) {
				if(iterator2.next().equals(primerElemento)) {
					listaElementosEnComun.insertFront(primerElemento);
				}
			}
		}
		return listaElementosEnComun;
	}
	
	public MySimpleLinkedList<Integer> elementosEnComunListasOrdenadas(MySimpleLinkedList<Integer> lista1, MySimpleLinkedList<Integer> lista2){
		MySimpleLinkedList<Integer> listaOrdenada= new MySimpleLinkedList<Integer>();
		MyIterator<Integer> iterator1=(MyIterator<Integer>) lista1.iterator();
		MyIterator<Integer> iterator2=(MyIterator<Integer>) lista2.iterator();
		while((iterator1.hasNext() && iterator2.hasNext())) {
				if(iterator1.valor()<iterator2.valor()){
					iterator1.avanzar();
				}
				else if(iterator2.valor()<iterator1.valor()) {
					iterator2.avanzar();
				}
				else if(iterator1.valor().equals(iterator2.valor())) {
					listaOrdenada.insertLast(iterator1.valor());
					iterator1.avanzar();
					iterator2.avanzar();
				}
			
		}
		return listaOrdenada;
	}
	public MySimpleLinkedList<Integer> elementosDePrimeraListaQueNoSeRepitenEnLaSegunda(MySimpleLinkedList<Integer> lista1, MySimpleLinkedList<Integer> lista2){
		MySimpleLinkedList<Integer> listaElementosNoRepetidos= new MySimpleLinkedList<Integer>();
		MyIterator<Integer> iterator1= (MyIterator<Integer>) lista1.iterator();
		while(iterator1.hasNext()){
			T info=(T) iterator1.next();
			MyIterator<Integer> iterator2=(MyIterator<Integer>) lista2.iterator();
			int contador=0;
			while(iterator2.hasNext()) {
				T infoIterator2= (T) iterator2.next();
				if(info==infoIterator2) {
					contador++;
				}
			}
			if(contador==0) {
				listaElementosNoRepetidos.insertFront((Integer) info);
			}
		}
		return listaElementosNoRepetidos;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(first);
	}
}
