package arboles.arboles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Tree {

	private TreeNode root;
	
	public Tree() {
		this.root=null;
	}
	
	public void add(int value) {
		if(root==null) {
			this.root=new TreeNode(value);
		}
		else{
			this.add(this.root,value);
		}
	}
	
	private void add(TreeNode nodo, int value) {
		if(nodo.getValue()>value){
			if (nodo.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				nodo.setLeft(temp);
			} 
			else {
				add(nodo.getLeft(),value);
			}
		}
		else {
			if(nodo.getValue()<value) {
				if (nodo.getRight() == null) { 
					TreeNode temp = new TreeNode(value);
					nodo.setRight(temp);
				} else {
					add(nodo.getRight(),value);
				}
			}
		}
	}
	
	
	public boolean hasElem(Integer value) {
		if(value==root.getValue()) {
			return true;
		}
		else {
			return hasElem(root, value);
		}
	}
	
	public boolean hasElem(TreeNode nodo, Integer value) {
		if(value<nodo.getValue()) {
			if(nodo.getLeft().getValue()==value) {
				return true;
			}
			else{
				hasElem(nodo.getLeft(), value);
			}
		}
		else{
			if(nodo.getRight().getValue()==value) {
				return true;
			}
			else{
				hasElem(nodo.getRight(), value);
			}
		}
		return false;
	}
	
	public int getHeight() {
		int ramaMasLargaIzq= getHeight(root);
		int ramaMasLargaDer=getHeight(root);
		if(ramaMasLargaIzq>ramaMasLargaDer){
			return ramaMasLargaIzq-1;
		}
		else{
			return ramaMasLargaDer-1;
		}
	}
	
	private int getHeight(TreeNode nodo){
		int alturaIzq = 0;
		int alturaDerecha=0;
		if(nodo==null) {
			return 0;
		}
		alturaIzq=getHeight(nodo.getLeft());
		alturaDerecha=getHeight(nodo.getRight());
		
		if(alturaIzq>alturaDerecha) {
			return alturaIzq+1;
		}
		else {
			return alturaDerecha+1;
		}
	}
	
	public void printPreOrder() {
		if(root!=null) {
			printPreOrder(root);
		}
	}
	
	private void printPreOrder(TreeNode nodo) {
		if(nodo!=null){
			System.out.println(nodo.getValue());
			printPreOrder(nodo.getLeft());
			printPreOrder(nodo.getRight());
		}
	}
	
	public void printPosOrder() {
		if(root!=null) {
			printPosOrder(root);
		}
	}
	
	private void printPosOrder(TreeNode nodo) {
		if(nodo!=null) {
			printPosOrder(nodo.getLeft());
			printPosOrder(nodo.getRight());
			System.out.println(nodo.getValue());
		}
	}
	
	public void printInOrder() {
		if(root!=null) {
			printInOrder(root);
		}
	}
	
	private void printInOrder(TreeNode nodo) {
		if(nodo!=null) {
			printInOrder(nodo.getLeft());
			System.out.println(nodo.getValue());
			printInOrder(nodo.getRight());
		}
		
	}
	
	public ArrayList<Integer> getLongestBranch() {
		return getLongestBranch(root);
	}
	
	private ArrayList<Integer> getLongestBranch(TreeNode nodo) {
		if(nodo==null) {
			return new ArrayList<>();
		}
		ArrayList<Integer> listaDerecha=getLongestBranch(nodo.getRight());
		ArrayList<Integer> listaIzq= getLongestBranch(nodo.getLeft());
		
		
		listaIzq.add(0,nodo.getValue());
		listaDerecha.add(0,nodo.getValue());
		
		if(listaIzq.size()>listaDerecha.size()) {
			return listaIzq;
		}
		else {
			return listaDerecha;
		}
	}
	
	public ArrayList<Integer> getFrontera() {
		return getFrontera(root);
	}
	
	private ArrayList<Integer> getFrontera(TreeNode nodo) {
		ArrayList<Integer> hojas= new ArrayList<>();
		if(nodo==null) {
			return new ArrayList<>();
		}
		if(nodo.getLeft()==null && nodo.getRight()==null) {
			hojas.add(nodo.getValue());
		}
		hojas.addAll(getFrontera(nodo.getLeft()));
		hojas.addAll(getFrontera(nodo.getRight()));
		
		return hojas;
	}

	/*	public boolean delete(Integer value) {
		if(value==root.getValue()) {
			TreeNode nmi=nodoMasIzquierdo(root.getRight());
			root=nmi;
			return true;
		}
		else {
			return delete(root, value);
		}
	};
	
	private boolean delete(TreeNode nodo, int value) {
		if(nodo.getValue()==value) {
			if(nodo.getLeft()==null && nodo.getRight()==null) {
				return true;
			}
			else {
				
			}
		}
			else {
				if(nodo.getValue()>value){
					delete(nodo.getLeft(),value);
				}
				else {
					delete(nodo.getRight(), value);
				}
			}
		}
	
	*/
	
	
	
	
	//public int getHeight() {}
	
	public Integer getRoot() {
		return root.getValue();
	}
	
	public boolean isEmpty(){
		return root==null;
	}
	
	public Integer getMaxElem(){
		return getMaxElem(root);
	}
	
	private Integer getMaxElem(TreeNode nodo) {
		int valor = -1;
		if(nodo!=null) {
			if(nodo.getValue()<getMaxElem(nodo.getRight())) {
				valor=getMaxElem(nodo.getRight());
			}else {
				valor=nodo.getValue();
			}
		}
		return valor;
	}
	
	public ArrayList<Integer> getElemAtLevel(int nivel){
		if(root!=null) {
			return getElemAtLevel(nivel, root);
		}
		else {
			return new ArrayList<>();
		}
	}
	private ArrayList<Integer> getElemAtLevel(int nivel, TreeNode nodo){
		ArrayList<Integer> nros= new ArrayList<Integer>();
		if(nodo!=null) {
			if(nivel==0) {
				nros.add(nodo.getValue());
			}
			else {
				nivel=nivel-1;
				nros.addAll(getElemAtLevel(nivel,nodo.getLeft()));
				nros.addAll(getElemAtLevel(nivel,nodo.getRight()));
			}
		}
		return nros;
	}
	
	public int sumaTotal() {
		return sumaTotal(root);
	}
	
	private int sumaTotal(TreeNode nodo) {
		int suma=0;
		if(nodo!=null) {
			suma=nodo.getValue();
			suma+=sumaTotal(nodo.getLeft());
			suma+=sumaTotal(nodo.getRight());
		}
		return suma;
	}
	
	public ArrayList<Integer> nrosSuperiores(int nro){
		return nrosSuperiores(nro, root);
	}

	private ArrayList<Integer> nrosSuperiores(int nro, TreeNode nodo) {
		ArrayList<Integer> nrosSuperiores= new ArrayList<Integer>();
		if(nodo!=null) {
			if(nodo.getValue()>nro) {
				nrosSuperiores.add(nodo.getValue());
			}
			nrosSuperiores.addAll(nrosSuperiores(nro,nodo.getLeft()));
			nrosSuperiores.addAll(nrosSuperiores(nro,nodo.getRight()));
		}
		return nrosSuperiores;
	}
	
	public void asignarValor() {
		AsignarValor(root);
	}
	private int AsignarValor(TreeNode nodo) {
		int suma=0;
		int sumaDerecha=0;
		int sumaIzq=0;
		if(nodo!=null){
			if(nodo.getValue()!=null) {
				return suma=nodo.getValue();
			}
			else {
				sumaDerecha=AsignarValor(nodo.getRight());
				sumaIzq=AsignarValor(nodo.getLeft());
				nodo.setValue(sumaDerecha-sumaIzq); 
				suma=nodo.getValue();
			}
		}
		return suma;
	}
}
