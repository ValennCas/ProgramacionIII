package arboles.arboles;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String [] args){
		
		Tree arbol=new Tree();
		
		arbol.add(8);
		arbol.add(6);
		arbol.add(13);
		arbol.add(15);
		arbol.add(14);
		arbol.add(4);
		arbol.add(7);
		arbol.add(9);
		
		
		//System.out.println(arbol.getHeight());
		
		//arbol.printPreOrder();
		//arbol.printPosOrder();
		//arbol.printInOrder();
		
		//ArrayList HOJAS=arbol.getFrontera();
		//ramaMasLarga.addAll(arbol.getLongestBranch());
		//System.out.println(arbol.getMaxElem());
		/*ArrayList elems=arbol.getElemAtLevel(2);
		*/
		ArrayList nrosSuperiores=arbol.nrosSuperiores(4);
		for(int i=0; i<nrosSuperiores.size();i++) {
			System.out.println(nrosSuperiores.get(i));
		}
		//System.out.println(arbol.sumaTotal());
	}
}
