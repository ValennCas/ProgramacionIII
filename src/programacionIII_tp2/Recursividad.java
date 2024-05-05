package programacionIII_tp2;

public class Recursividad {
	
	public void verSiSeEncuentraOrdenado(int[] nros, int tamanio) {
		int nro=nros[tamanio];
		if((tamanio>0) && nros[tamanio-1]<nro) {
			tamanio=tamanio-1;
			verSiSeEncuentraOrdenado(nros,tamanio);
			System.out.println(nro);
			
		}
		else if((tamanio-1)>=0 && nros[tamanio-1]>nro) {
				System.out.println("No se encuentra ordenado");
			}
	}
	
	public int recursividadBinaria(int[] Arr,int x, int inicio, int fin) {
		int medio;
		if(fin<inicio) {
			return -1;
		}
		else {
			medio=(inicio+fin)/2;
			if(x>Arr[medio]) {
				System.out.println(recursividadBinaria(Arr, x, medio+1, fin));
				return this.recursividadBinaria(Arr, x, medio+1, fin);
				
			}
			else{
				if(x<Arr[medio]) {
					return this.recursividadBinaria(Arr, x, inicio, medio-1);
				}
				else {
					return medio;
				}
			}
		}
	}
	public void convertirEnNotacionBinaria(int x) {
		if(x>=1) {
			convertirEnNotacionBinaria(x/2);
			System.out.println(x%2);
		}
	}
/*	public void primerosTerminosDeLaSecuenciaFibonacci(int cantTerminos,int primerNumero, int antNumero) {
		if(cantTerminos>0) {
			int numero=primerNumero+antNumero;
			antNumero=primerNumero;
			primerNumero=numero;
			System.out.println(numero);
			
			if(primerNumero==0) {
				primerosTerminosDeLaSecuenciaFibonacci(cantTerminos-1,primerNumero+1,0);
			}
			else if(primerNumero==1) {
				System.out.println(numero);
				primerosTerminosDeLaSecuenciaFibonacci(cantTerminos-2,primerNumero,antNumero);
			}
			else {
				primerosTerminosDeLaSecuenciaFibonacci(cantTerminos-1,primerNumero,antNumero);
			}
		}
	}*/
	
	public int fibonacci(int n) {
		if(n<=0) {
			return 0;
		}
		else if(n==1) {
			return 1;
		}
		else {
			return fibonacci(n-1) +fibonacci(n-2);
		}
	}
	//no tiene sentido hacerlo recursivo ya que se facilita hacerlo y entenderlo de forma iterativa.
	public void secuenciaFibonacci(int n) {
		for(int i=0;i<=n;i++) {
			System.out.print(fibonacci(i)+"");
		}
	}
	
	
	
	
	public void numeroDePosicionMismoQueElNumeroInsertado(int[] nros, int tamanio) {
		if(tamanio>=0){
			numeroDePosicionMismoQueElNumeroInsertado(nros,tamanio-1);
			if(nros[tamanio]==tamanio) {
				System.out.println(tamanio);
			}
		}
	}
}