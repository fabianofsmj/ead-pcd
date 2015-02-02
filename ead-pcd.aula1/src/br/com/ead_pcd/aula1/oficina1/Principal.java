package br.com.ead_pcd.aula1.oficina1;
import java.text.ParseException;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) throws ParseException {

		Data data1 = new Data(31,02,2014);

		if (data1.validarData(data1.toString()) == true) {
			JOptionPane.showMessageDialog(null, "Data: " + data1.toString());
		} else {
			JOptionPane.showMessageDialog(null,	"Data inválida: " + data1.toString() + "!");
		}
	}
}
