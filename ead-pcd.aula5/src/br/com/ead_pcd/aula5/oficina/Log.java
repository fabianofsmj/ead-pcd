package br.com.ead_pcd.aula5.oficina;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.util.Calendar;

public class Log {
	private final String ENDERECO_ARQUIVO_LOG_TEXTO = "F:\\Developer\\projetos\\git\\ead-pcd\\ead-pcd.aula5\\LogAlunos.txt";
	private final String ENDERECO_ARQUIVO_LOG_SERIAL = "F:\\Developer\\projetos\\git\\ead-pcd\\ead-pcd.aula5\\LogAlunos.ser";
	private String mensagem;
	private File arquivo;

	public void registrar(char tipo, String mensagem) throws IOException {
		this.mensagem = getDataHora() + " || " + mensagem;
		
		if (tipo == 'T') {
			gravarArquivoTexto(this.mensagem);
		} else if (tipo == 'S') {
			gravarArquivoSerial(this.mensagem);
		}
	}
	
	private void gravarArquivoSerial(String mensagem) throws IOException {
		arquivo = new File(ENDERECO_ARQUIVO_LOG_SERIAL);

//		if (!arquivo.exists()) {
//			arquivo.createNewFile();
//		}

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo, true));
		oos.writeObject(mensagem + System.getProperty("line.separator"));
		oos.flush();
		oos.close();
		oos = null;
	}

	private void gravarArquivoTexto(String mensagem) throws IOException {
		arquivo = new File(ENDERECO_ARQUIVO_LOG_TEXTO);
		
//		if (!arquivo.exists()) {
//			arquivo.createNewFile();
//		}

		BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));
		bw.write(mensagem + System.getProperty("line.separator"));
		bw.flush();
		bw.close();
		bw = null;
	}

	private String getDataHora(){
		Calendar data = Calendar.getInstance();
		DateFormat formataData = DateFormat.getDateTimeInstance();
		String dataHora = formataData.format(data.getTime());
		return dataHora;
	}
}
