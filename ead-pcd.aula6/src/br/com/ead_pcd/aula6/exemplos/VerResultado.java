package br.com.ead_pcd.aula6.exemplos;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class VerResultado extends javax.swing.JFrame {

	public VerResultado() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		lbTitulo = new javax.swing.JLabel();
		jsTitulo = new javax.swing.JSeparator();
		jlResultado = new javax.swing.JLabel();
		jbVer = new javax.swing.JButton();
		jlData = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		lbTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lbTitulo.setText("Resultado da Mega Sena");
		lbTitulo.setToolTipText("");
		getContentPane().add(lbTitulo);
		lbTitulo.setBounds(0, 10, 420, 50);
		getContentPane().add(jsTitulo);
		jsTitulo.setBounds(20, 60, 390, 10);

		jlResultado.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
		jlResultado.setForeground(new java.awt.Color(0, 108, 208));
		jlResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		getContentPane().add(jlResultado);
		jlResultado.setBounds(20, 70, 390, 60);

		jbVer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jbVer.setText("Ver agora!");
		jbVer.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbVerActionPerformed(evt);
			}
		});
		getContentPane().add(jbVer);
		jbVer.setBounds(60, 180, 300, 50);

		jlData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jlData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		getContentPane().add(jlData);
		jlData.setBounds(30, 130, 370, 30);

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
		setBounds((screenSize.width - 439) / 2, (screenSize.height - 283) / 2,
				439, 283);
	}

	private void jbVerActionPerformed(java.awt.event.ActionEvent evt) {
		requisitarResultado();
	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new VerResultado().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jbVer;
	private javax.swing.JLabel jlData;
	private javax.swing.JLabel jlResultado;
	private javax.swing.JSeparator jsTitulo;
	private javax.swing.JLabel lbTitulo;

	private void requisitarResultado() {

		try {
			Socket servidor = new Socket("127.0.0.1", 2012);
			DataInputStream dis = new DataInputStream(servidor.getInputStream());

			String resposta = dis.readUTF();
			String[] dados = resposta.split(",");

			exibirResultado(dados[0], dados[1]);

		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

	}

	private void exibirResultado(String resultado, String data) {
		jlResultado.setText(resultado);
		jlData.setText("Sorteio: " + data);
	}
}
