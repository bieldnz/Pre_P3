package view;

import javax.swing.JOptionPane;

import controller.ControllerFile;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		ControllerFile controllerFile = new ControllerFile();
		
		controllerFile.gravarArquivo();
	
		String unit = JOptionPane.showInputDialog("Digite o unit que deseja buscar");
		
		JOptionPane.showMessageDialog(null, controllerFile.buscar(unit));
	}
	
}
