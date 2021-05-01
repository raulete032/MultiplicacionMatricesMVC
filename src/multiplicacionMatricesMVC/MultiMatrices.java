package multiplicacionMatricesMVC;


import java.util.Random;
import java.util.Scanner;

public class MultiMatrices {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		
		int filasA, filasB, colsA, colsB;
		
		System.out.println("Introduce el orden de la matriz A");
		System.out.println("Filas de la matriz A");
		filasA= sc.nextInt();
		System.out.println("Columnas de la matriz A");
		colsA= sc.nextInt();
		
		System.out.println("Introduce el orden de la matriz B");
		System.out.println("Filas de la matriz B");
		filasB= sc.nextInt();
		System.out.println("Columnas de la matriz B");
		colsB= sc.nextInt();
		
		
		//Para que se puedan multiplicar colsA == filasB
		//La matriz resultante será filasA x colsB
		
		if(colsA!=filasB) {
			System.out.println("NO se pueden multiplicar estas dos matrices");
		}
		else {
		
			int [][] matrizA = new int[filasA][colsA];
			int [][] matrizB = new int[filasB][colsB];
			int [][] matrizR = new int[filasA][colsB];
			
			
			System.out.println("Vamos a cargar automáticamente las matrices");
			
			//Muestro y cargo la matriz A
			System.out.println("Esta es la matriz A");
			for(int f=0; f<matrizA.length; f++) {
				
				for( int c=0; c<matrizA[f].length; c++) {
					
					matrizA[f][c]= rnd.nextInt(10)+1; //números aleatorios entre 1 y 10
					System.out.print("\t" + matrizA[f][c]);						
				}
				System.out.println(" ");
			}
			
			
			
			System.out.println("\n");
			System.out.println("Esta es la matriz B");
			//Muestro la matriz B
			for(int f=0; f<matrizB.length; f++) {
				
				for( int c=0; c<matrizB[f].length; c++) {
					
					matrizB[f][c]= rnd.nextInt(10)+1; //números aleatorios entre 1 y 10
					System.out.print("\t" + matrizB[f][c]);						
				}
				System.out.println(" ");
			}
			
			
					
			
			//Relleno la matriz de 0 para poder sumar sobre si misma
			System.out.println("\n");
			
			for(int f=0; f<matrizR.length; f++) {
				
				for( int c=0; c<matrizR[f].length; c++) {
					
					matrizR[f][c]=0;
											
				}
				System.out.println(" ");
			}
			
			
			
			int f2=0;//variable auxiliar
			//CÁLCULO DE LA MULTIPLICACION
			for(int r=0; r<matrizR.length; r++) {//matrizR es la matriz resultado
			
				for(int f=0; f<matrizA.length; f++) {//Este marca las filas de la matriz de la "derecha"
					
					for(int c=0; c<=matrizB[f].length; c++) {//Este marca las columnas de la matriz de la "derecha" y las de la "izquierda", pues son las mismas
						
						matrizR[r][f]= matrizR[r][f] + (matrizA[f2][c]*matrizB[c][f]);
							
					}//fin for columnas					
				}//fin for filas
				f2++;		//esta es la variable que mueve la fila de la matriz de la "izquierda"
			}//fin for matrizR
			
			
			
			
			System.out.println("RESULTADO");
			//Muestro la matrizR resultado		
			for(int f=0; f<matrizR.length; f++) {
				
				for( int c=0; c<matrizR[f].length; c++) {
					
					System.out.print("\t" + matrizR[f][c]);						
				}
				System.out.println(" ");
			}	
			
			
					
			
			
		}//fin else
			
			
				
	sc.close();	
	}

}
