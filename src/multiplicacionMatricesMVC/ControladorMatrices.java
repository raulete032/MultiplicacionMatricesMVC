package multiplicacionMatricesMVC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControladorMatrices implements ActionListener {
	
	
	
	//Variables de instancia
	private VistaMultiMatrices miVista;
	
	/**
	 * Constructor
	 * @param v
	 */
	public ControladorMatrices(VistaMultiMatrices v) {
		
		this.miVista = v;		
	}


	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == this.miVista.getComprueba()) { //es Comprueba
			
			comprueba();
			
		}
		
		if(arg0.getSource() == this.miVista.getResuelve()) { //es Resuelve
			
			resuelve();
			
		}
		
		
		if(arg0.getSource() == this.miVista.getAleatorio()) { //es Aleatorio
			
			aleatorio();
			
		}
		
		
		if(arg0.getSource() == this.miVista.getLimpia()) { //es Limpia
			
			limpia();
			
		}
						
		
		if(arg0.getSource() == this.miVista.getComenzar()) {//es Comenzar
			boolean sw;
						
			sw= comienza(this.miVista.getMatrizA());
			
			if(sw) {
				sw= comienza(this.miVista.getMatrizB());
			}
			
			
			if(sw)
				habilita();
			
		}		
		
	}//end actionPerformed
	
	
	
	
	
	
	/**
	 * Método que rellena las dos matrices de forma aleatoria
	 */
	private void aleatorio() {
		
		ModeloMultiMatrices.rellena(this.miVista.getMatrizA());
		ModeloMultiMatrices.rellena(this.miVista.getMatrizB());
		
		
	}
	
	
	/**
	 * Método que resuelve la multiplicación de matrices
	 */
	private void resuelve() {		
		
		ModeloMultiMatrices.resuelve(this.miVista.getMatrizA(), this.miVista.getMatrizB(), this.miVista.getMatrizR());		
	}
	
	
	/**
	 * Método que comprueba el resultado de la multiplicación
	 */
	private void comprueba() {		
		
		int fil = this.miVista.getMatrizR().length;
		int col = this.miVista.getMatrizR()[0].length;
		boolean sw = true;
		
		
		JTextField [][] matrizRto = new JTextField [this.miVista.getMatrizR().length][this.miVista.getMatrizR()[0].length]; //matriz auxiliar con las mismas dimensiones que matrizR
		creaMatrizAux(matrizRto);
		ModeloMultiMatrices.resuelve(this.miVista.getMatrizA(), this.miVista.getMatrizB(), matrizRto);
		
		for(int f= 0; f<fil; f++) {
			
			for(int c=0; c<col; c++) {
				
				String aux = matrizRto[f][c].getText();
				String usuario = this.miVista.getMatrizR()[f][c].getText();
				
				if(!aux.equals(usuario)) {					
					if(sw)
						JOptionPane.showMessageDialog(this.miVista, "Resultado INCORRECTO", "ERROR", JOptionPane.ERROR_MESSAGE);
					
					sw= false;
				}				
			}			
		}
		
		if(sw)
			JOptionPane.showMessageDialog(this.miVista, "Resultado CORRECTO", "ENHORABUENA", JOptionPane.INFORMATION_MESSAGE);		
	}
	
	
	
	/**
	 * Método que crea la matriz auxiliar JTextField
	 * @param matrizRto
	 */
	private void creaMatrizAux(JTextField [][] matrizRto) {		
		
		int fil = matrizRto.length;
		int col = matrizRto[0].length;
		
		for(int f=0; f<fil; f++) {
			
			for(int c=0; c<col; c++) {				
				
				matrizRto[f][c] = new JTextField();				
			}			
		}		
		
	}	
		
	
	/**
	 * Método que comprueba si son números lo que se ha introducido
	 * @param matriz
	 */
	private boolean comienza(JTextField [][] matriz) {
		
		int fil = matriz.length;
		int col = matriz[0].length;
		boolean sw= true;
		
		
		
		try {
			
			for(int f=0; f<fil; f++) {
				
				for(int c=0; c<col; c++) {
					
					Integer.parseInt(matriz[f][c].getText());					
				}
				
			}
			
			
		}
		catch(NumberFormatException e) {
			sw=false;
			JOptionPane.showMessageDialog(this.miVista, "Datos erróneos", "ERRROR", JOptionPane.ERROR_MESSAGE); 
		}
		
		
		return sw;		
		
	}
	
	
	private void habilita() {
		
		
		int filA= this.miVista.getMatrizA().length;
		int colA= this.miVista.getMatrizA()[0].length;
		
		int filB= this.miVista.getMatrizB().length;
		int colB= this.miVista.getMatrizB()[0].length;
		
		this.miVista.getComprueba().setEnabled(true);
		this.miVista.getResuelve().setEnabled(true);
		this.miVista.getComenzar().setEnabled(false);
		this.miVista.getAleatorio().setEnabled(false);
		
		
		for(int f=0; f<filA; f++) {
			
			for(int c=0; c<colA; c++) {				
				
				this.miVista.getMatrizA()[f][c].setEditable(false);				
			}			
		}
		
		
		for(int f=0; f<filB; f++) {
			
			for(int c=0; c<colB; c++) {
				
				this.miVista.getMatrizB()[f][c].setEditable(false);
			}
			
		}		
	}
	
	
	
	/**
	 * Método que limpia todas las matrices
	 */
	private void limpia() {
		
		int filA= this.miVista.getMatrizA().length;
		int colA= this.miVista.getMatrizA()[0].length;
		
		int filB= this.miVista.getMatrizB().length;
		int colB= this.miVista.getMatrizB()[0].length;
		
		int filR= this.miVista.getMatrizR().length;
		int colR= this.miVista.getMatrizR()[0].length;
		
		
		for(int f=0; f<filA; f++) {

			for(int c=0; c<colA; c++) {				

				this.miVista.getMatrizA()[f][c].setText("");	
				this.miVista.getMatrizA()[f][c].setEditable(true);
			}			
		}
		
		for(int f=0; f<filB; f++) {

			for(int c=0; c<colB; c++) {				

				this.miVista.getMatrizB()[f][c].setText("");
				this.miVista.getMatrizB()[f][c].setEditable(true);
			}			
		}
		
		
		for(int f=0; f<filR; f++) {

			for(int c=0; c<colR; c++) {				

				this.miVista.getMatrizR()[f][c].setText("");			
			}			
		}
		
		
	}
	
	
	
	

}//end ControladorMatrices
