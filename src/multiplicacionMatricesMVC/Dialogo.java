package multiplicacionMatricesMVC;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Dialogo extends JDialog implements ActionListener {

	private static final long serialVersionUID = -7318294886276381948L;
	
	//Variables de instancia
	private JComboBox<String> mAF, mAC, mBF, mBC;
	private JButton comenzar, salir;
	private int filasA, colA, filasB, colB,  filasResultado, colResultado;
	
	 
	public Dialogo() {
		
		this.setModal(true);
		this.setTitle("Demensiones de las matrices");
		this.setLayout(new BorderLayout());
		
		
		//**********
		//ZONA NORTE
		//**********
		JPanel pNorte = zonaNorte();
		
		
		//********
		//ZONA CENTRO
		//********
		
		JPanel pCentro = zonaCentro();
		
		
		
		//*******
		//ZONA SUR
		//********
		
		JPanel pSur = zonaSur();
		
		
		
		
		
		this.add(pNorte, BorderLayout.NORTH);
		this.add(pCentro, BorderLayout.CENTER);
		this.add(pSur, BorderLayout.SOUTH);
		
		
		this.setPreferredSize(new Dimension(450, 220));
		this.setLocation(700, 400);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
		
	}//end Constructor
	
	
	/**
	 * Método que prepara el panel de la zona Norte
	 * @return
	 */
	private JPanel zonaNorte() {
		
		JPanel p = new JPanel();
		
		JLabel texto = new JLabel("Introduce las dimensiones de las matrices");			
		
		p.add(texto);		
		
		return p;
	}
	
	
	/**
	 * Método que prepara el panel de la zona Centro
	 * @return
	 */
	private JPanel zonaCentro() {
		
		String [] array = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		
		this.mAC = new JComboBox<String>(array);
		this.mAF = new JComboBox<String>(array);
		this.mBC = new JComboBox<String>(array);
		this.mBF = new JComboBox<String>(array);
		
		//Paneles
		JPanel principal = new JPanel (new BorderLayout());
		JPanel norte = new JPanel(new GridLayout(1, 2));
		
		JLabel matriz1 = new JLabel("Matriz A", JLabel.CENTER);
		JLabel matriz2 = new JLabel("Matriz B", JLabel.CENTER);
		
		norte.add(matriz1);
		norte.add(matriz2);
		
		JPanel centro = new JPanel(new GridLayout(1, 2));		
		JPanel pM1 = new JPanel();
		JPanel pM2 = new JPanel();
		
		JLabel por1 = new JLabel("X");
		JLabel por2 = new JLabel("X");
		
		pM1.add(mAF);
		pM1.add(por1);		
		pM1.add(mAC);
		
		pM2.add(mBF);
		pM2.add(por2);
		pM2.add(mBC);
		
		
		centro.add(pM1);
		centro.add(pM2);
		
		principal.add(norte, BorderLayout.NORTH);
		principal.add(centro, BorderLayout.CENTER);
		
	//	this.m1F.addActionListener(this);
		this.mAC.addActionListener(this);
		
		this.mBF.addActionListener(this);
	//	this.m2C.addActionListener(this);		
		
		return principal;
	}


	
	
	/**
	 * Método que prepara la zona Sur
	 * @return
	 */
	private JPanel zonaSur() {
		
		this.comenzar = new JButton("Comenzar");
		this.salir = new JButton("Salir");
		
		JPanel p = new JPanel();
		
		comenzar.setPreferredSize(new Dimension(100, 30));
		salir.setPreferredSize(new Dimension(100, 30));
		
		p.add(comenzar);
		p.add(salir);
		
		
		comenzar.addActionListener(this);
		salir.addActionListener(this);		
		
		return p;
	}
	
	
	
	
	
	
	
	
	/**
	 * Método para programar los Clicks
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == this.mAC) {
			
			this.mBF.setSelectedItem(this.mAC.getSelectedItem());
		}
		
		
		if(arg0.getSource() == this.mBF) {
			
			this.mAC.setSelectedItem(this.mBF.getSelectedItem());
		}
		
		
		if(arg0.getSource() == this.salir)
			System.exit(0);
		
		if(arg0.getSource() == this.comenzar) {
			
			comenzar();	
			
		}		
	}

	
	/**
	 * Método que guarda los datos en las variables de instancia
	 */
	private void comenzar() {		
		try {
			
			this.filasA = Integer.parseInt((String)this.mAF.getSelectedItem());
			this.colA = Integer.parseInt((String)this.mAC.getSelectedItem());
			
			this.filasB = Integer.parseInt((String)this.mBF.getSelectedItem());
			this.colB = Integer.parseInt((String)this.mBC.getSelectedItem());
			
			
			this.filasResultado = Integer.parseInt((String)this.mAF.getSelectedItem());			
			this.colResultado = Integer.parseInt((String)this.mBC.getSelectedItem());
			
			this.setVisible(false);
		}
		catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(this, "Debes introducir todos los datos  de las matrices", "ERROR", JOptionPane.ERROR_MESSAGE);
		}		
		
	}
	
	
	
	
	
	
	
	
	
	
	//GETTERS
	public int getmRF() {return filasResultado;}
	public int getmRC() {return colResultado;}	
	public int getFilasA() {return filasA;}
	public int getColA() {return colA;}
	public int getFilasB() {return filasB;}
	public int getColB() {return colB;}
	public int getFilasResultado() {return filasResultado;}
	public int getColResultado() {return colResultado;}
	
	
	
	
	
	
	
	

}//end Dialogo
