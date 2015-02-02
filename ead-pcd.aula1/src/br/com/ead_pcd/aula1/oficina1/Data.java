package br.com.ead_pcd.aula1.oficina1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


public class Data {
	
	private int dia;
	private int mes;
	private int ano;
	
	public Data(){
		LocalDate dataAtual = LocalDate.now();
		dia = dataAtual.getDayOfMonth();
		mes = dataAtual.getMonthValue();
		ano = dataAtual.getYear();
	}
	
	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public boolean validarData(String data) throws ParseException {
		
		boolean dataValida;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		
		try {
			sdf.parse(data);
			dataValida = true;
		} catch (ParseException e) {
			dataValida = false;
		}

		return dataValida;
	}

	public int getDia(){
		return dia;
	}
	
	public void setDia(int dia){
		this.dia = dia;		
	}


	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}
	
}
