package programacionIII_tp1;

public class Node<T> {
	private T info;
	private Node<T> next;
	
	public Node(T info, Node<T> node){
	this.info=info;
	this.next=node;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> siguiente) {
		this.next = siguiente;
	}
	
	
}
