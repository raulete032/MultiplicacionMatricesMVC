package multiplicacionMatricesMVC;

import java.util.Random;

import javax.swing.JTextField;

public class ModeloMultiMatrices {
	
	
	
	/**
	 * M�todo que rellena de forma aleatoria una matriz
	 */
	public static void rellena (JTextField [][] matriz){
		
		Random rndm= new Random ();
			
			for(int f=0; f<matriz.length; f++) {
				
				for(int c=0; c<matriz[f].length; c++) {
					
					matriz[f][c].setText(String.valueOf(rndm.nextInt(20)+1));
				}
			}			
			
			
		}//fin m�todo rellenaAleatorio
		
		
	
	/**
	 * M�todo que rellena la matriz Resultado con 0
	 * As� puedo sumar sobre s� misma
	 * @param matrizR
	 */
	private static void rellenaCeros(JTextField [][] matrizR) {
		
		
		for(int f=0; f<matrizR.length; f++) {			
			
			for(int c=0; c<matrizR[f].length; c++) {
				
				matrizR[f][c].setText("0");				
			}			
		}		
	}
	
	
	
	
	/**
	 * M�todo para rosolver la multiplicaci�n de matrices	
	 */
	public static JTextField[][] resuelve(JTextField [][] matrizA, JTextField [][] matrizB, JTextField [][] matrizR){
		
					
		int filA = matrizA.length;
//		int colA = matrizA[0].length;
		
		int filB = matrizB.length;
		int colB = matrizB[0].length;
		
		rellenaCeros(matrizR);
				
		//c=2;
		//f= 1;
		//r= 1
		//La matriz resultante ser� filasA x colsB
		
		for(int r=0; r<filA; r++) {
			
			for(int f=0; f< colB; f++ ) {
				
				for(int c=0; c< filB; c++) {
					
				//	matrizR[r][f] = matrizR[r][f] + (matrizA[r][c] * matrizB[c][f]);
					matrizR[r][f].setText(String.valueOf(Integer.parseInt(matrizR[r][f].getText())+ Integer.parseInt(matrizA[r][c].getText()) * Integer.parseInt(matrizB[c][f].getText())));
									
				}
			}
			
		}
		
		return matrizR;	
		
	}//end Resuelve
		
	
	
	
	
	
	
	

}
