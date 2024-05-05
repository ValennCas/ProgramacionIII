package programacionIII_tp1;

public class Main {
	
	public static void main(String[] args) {
		
		
		MySimpleLinkedList<Integer> lista= new MySimpleLinkedList<Integer>();
		
		lista.insertFront(97);
		lista.insertFront(43);
		lista.insertFront(20);
		lista.insertFront(7);
		lista.insertFront(2);
		lista.insertFront(1);
		
		
		MySimpleLinkedList<Integer> lista2= new MySimpleLinkedList<Integer>();
		lista2.insertFront(92);
		lista2.insertFront(87);
		lista2.insertFront(43);
		lista2.insertFront(7);
		lista2.insertFront(6);
		lista2.insertFront(1);
		
		MySimpleLinkedList<Integer> lista3= new MySimpleLinkedList<Integer>();
		
		
		
		//lista3 =lista.elementosEnComun(lista, lista2);
		
		//lista3 =lista3.elementosEnComun2(lista, lista2);
		
		//lista3= lista3.elementosEnComunListasOrdenadas(lista, lista2);
		lista3=lista3.elementosDePrimeraListaQueNoSeRepitenEnLaSegunda(lista, lista2);
		//System.out.println(lista.get(3));
		
		
		System.out.println(lista3.toString());
		
	
		
		//System.out.println(lista.indexOf(2));
		
		
	}
}
