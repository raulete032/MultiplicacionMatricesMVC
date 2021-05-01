package multiplicacionMatricesMVC;

import javax.swing.JFrame;

public class MainMultiMatrices {

	public static void main(String[] args) {

		
		JFrame ventana = new JFrame("Multiplicación matrices");
		
		VistaMultiMatrices miVista = new VistaMultiMatrices();
		ControladorMatrices ctr = new ControladorMatrices(miVista);
		miVista.añadeControl(ctr);
		
		ventana.setContentPane(miVista);
		
		ventana.setVisible(true);
		
		ventana.setLocationRelativeTo(null);
		ventana.pack();
	//	ventana.setPreferredSize(new Dimension(500, 500));
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
