package programacionIII_tp2;

public class Main {
	public static void main(String[] ar) {
		 Recursividad re=new Recursividad();
		 int nro1=10;
		 int nro2=8;
		 int nro3=1;
		 int nro4=14;
		 int nro5=17;
		 int nro6=24;
		 
		 int[] nros=new int[6];
		 nros[0]=nro3;
		 nros[1]=nro2;
		 nros[2]=nro1;
		 nros[3]=nro4;
		 nros[4]=nro5;
		 nros[5]=nro6;
		 
		 int[]nross= {-3, -1, 0, 2, 4, 6, 10};
		 
		 int[]nross2= {-3, -1, 0, 3, 4, 5,7,9,10,11};
		 int[]nross3= {-7,-5,-2,-1,4,5,6,7,8};
		 
		 
		 //re.verSiSeEncuentraOrdenado(nros, 4);
		 
		 //int pos=re.recursividadBinaria(nros,1,0,5);
		 //System.out.println("el numero esta en la poscion:"+pos);
		 
		 //re.convertirEnNotacionBinaria(230);
		 
		// re.primerosTerminosDeLaSecuenciaFibonacci(15, 0, 0);
		 
		 //re.numeroDePosicionMismoQueElNumeroInsertado(nross3, nross3.length-1);
		 
		 
		 
		 int[]nrosOrdenar= {7, -1,87, 0, 14, 4, 9,6,13,5};
		 /*Ordenamiento ord=new Ordenamiento();
		 int[] ordenado=ord.burbujeo(nrosOrdenar);
		 for(int i=0; i<ordenado.length;i++) {
			 System.out.println(ordenado[i]);
		 }*/
		 //MergeSort merge=new MergeSort();
		 //merge.sort(nrosOrdenar);
		 Seleccion seleccion=new Seleccion();
		 QuickSort quick=new QuickSort();
		 //seleccion.seleccion(nrosOrdenar);
		 quick.quickSort(nrosOrdenar, 0, nrosOrdenar.length-1);
		 for(int i=0; i<nrosOrdenar.length;i++) {
			 System.out.println(nrosOrdenar[i]);
		 }
	}
	
}
