package programacionIII_tp1;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {
	Node<T> cursor;
	
	
	public MyIterator(Node<T> first){
		this.cursor=first;
	}
	
	public boolean hasNext() {
		return (cursor!=null);
	}

	@Override
	public T next() {
		T info= cursor.getInfo();
		cursor= cursor.getNext();
		return info;
	}
	
	public T valor() {
		T info= cursor.getInfo();
		return info;
	}

	public void avanzar() {
		cursor= cursor.getNext();
		
	}

}
