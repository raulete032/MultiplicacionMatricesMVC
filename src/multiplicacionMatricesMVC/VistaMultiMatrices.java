package multiplicacionMatricesMVC;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaMultiMatrices extends JPanel {

	private static final long serialVersionUID = 7406697322372308422L;
	
	
	//Variables de instancia
	private JTextField [][] matrizA, matrizB, matrizR;
	private JButton comprueba, limpia, resuelve, aleatorio, comenzar;
	int filasA, colA, filasB, colB, filasR, colR;
	
	/**
	 * Constructor
	 */
	public VistaMultiMatrices() {
		
		Dialogo d = new Dialogo();
		this.filasA = d.getFilasA();
		this.colA = d.getColA();
		this.filasB = d.getFilasB();
		this.colB = d.getColB();
		this.filasR = d.getFilasResultado();
		this.colR = d.getColResultado();
		
		JPanel panelPrincipal = new JPanel (new BorderLayout());
		
		preparaMarices();
		
		//***********
		//ZONA NORTE
		//***********
		JPanel pNorte = zonaNorte();
		
		
		//**********
		//ZONA CENTRO
		//***********		
		JPanel pCentro = zonaCentro();
		
		
		//*********
		//ZONA SUR
		//**********
		JPanel pSur = zonaSur();
		
		
		
		panelPrincipal.add(pNorte, BorderLayout.NORTH);
		panelPrincipal.add(pCentro, BorderLayout.CENTER);
		panelPrincipal.add(pSur, BorderLayout.SOUTH);
		
		
		this.add(panelPrincipal);
		
		
	}//end Constructor
	
	//GETTERS
	public JTextField[][] getMatrizA() {return matrizA;}
	public JTextField[][] getMatrizB() {return matrizB;}
	public JTextField[][] getMatrizR() {return matrizR;}
	public JButton getComprueba() {return comprueba;}
	public JButton getLimpia() {return limpia;}
	public JButton getResuelve() {return resuelve;}
	public JButton getAleatorio() {return aleatorio;}
	public JButton getComenzar() {return comenzar;}

	/**
	 * Método que crea las matrices en función de lo introducido por el usuario
	 */
	private void preparaMarices() {
		
		this.matrizA = new JTextField[filasA][colA];
		this.matrizB = new JTextField[filasB][colB];
		this.matrizR = new JTextField[filasR][colR];		
	}
	
	
	/**
	 * Método que prepara la zona Norte
	 * @return
	 */
	private JPanel zonaNorte() {
		
		JPanel p = new JPanel();
		
		JLabel texto = new JLabel("MULTIPLICACIÓN DE MATRICES", JLabel.CENTER);
		
		p.add(texto);
		
		return p;
		
	}
	
	
	/**
	 * Método que prepara la zona Centro
	 * @return
	 */
	private JPanel zonaCentro() {
		
		JPanel p = new JPanel(new GridLayout(1, 3));	
		
		JPanel pMatrizA = pMatrizA();
		JPanel pMatrizB = pMatrizB();
		JPanel pMatrizR = pMatrizR();
		
		p.add(pMatrizA);
		p.add(pMatrizB);
		p.add(pMatrizR);
		
		return p;
	}
	
	
	/**
	 * Método que rellena la matriz
	 */
	private void rellenaMatriz(JTextField[][] matriz, int filas, int col, JPanel p) {
		
		for(int f=0; f<filas; f++) {

			for(int c=0; c<col; c++) {

				JTextField tf = new JTextField(2);

				matriz[f][c]= tf;

				p.add(tf);
			}
		}				
	}
	
		
	/**
	 * Método que prepara el panel de la matriz A
	 * @return
	 */
	private JPanel pMatrizA() {
		
		JPanel p = new JPanel();
		JPanel pMatriz = new JPanel(new GridLayout(this.filasA, this.colA));		
		
		this.matrizA = new JTextField[this.filasA][this.colA];		
		
		rellenaMatriz(this.matrizA, this.filasA, this.colA, pMatriz);
		
		p.add(pMatriz);
		
		JLabel por = new JLabel("X");
		
		p.add(por);		
		
		return p;
	}
	
	
	/**
	 * Método que prepara el panel de la matriz B
	 * @return
	 */
	private JPanel pMatrizB() {
		
		JPanel p = new JPanel();
		JPanel pMatriz = new JPanel(new GridLayout(this.filasB, this.colB));
		
		this.matrizB = new JTextField[this.filasB][this.colB];
		
		rellenaMatriz(this.matrizB, this.filasB, this.colB, pMatriz);
		
		
		p.add(pMatriz);
		JLabel igual = new JLabel(" = ");
		
		p.add(igual);
		
		return p;		
	}
	
	/**
	 * Método que prepara el panel de la matriz C
	 * @return
	 */
	private JPanel pMatrizR() {
		
		JPanel p = new JPanel();
		JPanel pMatriz = new JPanel(new GridLayout(this.filasR, this.colR));
		
		this.matrizR = new JTextField[this.filasR][this.colR];
		
		rellenaMatriz(this.matrizR, this.filasR, this.colR, pMatriz);
		
		p.add(pMatriz);
		
		return p;
	}
	
	
	/**
	 * Método que prepara el panel de la zona Sur
	 * @return
	 */
	private JPanel zonaSur() {
		
		JPanel p = new JPanel();
		
		this.comprueba = new JButton("Comprueba");
		this.limpia = new JButton("Limpia");
		this.resuelve = new JButton("Resuelve");
		this.aleatorio = new JButton("Aleatorio");
		this.comenzar = new JButton("Comenzar");
		
		comprueba.setEnabled(false);
		resuelve.setEnabled(false);
		
		p.add(comenzar);
		p.add(comprueba);
		p.add(aleatorio);
		p.add(resuelve);
		p.add(limpia);
		
		
		return p;
	}
	
	
	
	/**
	 * Método que añade el control a esos componentes
	 * @param ctr
	 */
	public void añadeControl(ControladorMatrices ctr) {
		
		this.comprueba.addActionListener(ctr);
		this.limpia.addActionListener(ctr);
		this.resuelve.addActionListener(ctr);
		this.aleatorio.addActionListener(ctr);	
		this.comenzar.addActionListener(ctr);
		
	}
	
	
	
	
	
	

}// end VistaMultiMatrices
