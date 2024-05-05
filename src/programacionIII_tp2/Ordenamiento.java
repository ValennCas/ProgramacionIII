package programacionIII_tp2;

public class Ordenamiento {
	
	public int[] burbujeo(int[] arr){
		int aux;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					aux=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=aux;
				}
			}
		}
		return arr;
		
	}
}
