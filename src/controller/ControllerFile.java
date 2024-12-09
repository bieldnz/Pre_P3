package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import util.Lista;

public class ControllerFile {
	
	Lista<String> lista;
	
	public void gravarArquivo() {
		try {
			String path = System.getProperty("java.io.tmpdir");
			BufferedReader reader = new BufferedReader(new FileReader("exchange.json"));
			BufferedWriter writer = new BufferedWriter(new FileWriter(path + "exchange.json", true));
			lista = new Lista<String>();
			String linha = reader.readLine();
			while (linha != null) {
				lista.addLast(linha);
				writer.write(linha);
				writer.newLine();
				linha = reader.readLine();
			}
			reader.close();
			writer.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String buscar(String unit) throws Exception {
		int tamanho = lista.size();
		String resultado = "";
		String[] vetorLinhas = new String[tamanho];
		for (int x = 0; x < tamanho; x++) {
			vetorLinhas[x] = lista.removeFirst();
			if (vetorLinhas[x].contains("\"" + unit + "\"") && vetorLinhas[x].contains("unit")) {
				vetorLinhas[x+1] = lista.removeFirst();
				vetorLinhas[x+2] = lista.removeFirst();
				resultado = "NOME:  " + pegaValorLinha(vetorLinhas[x - 1]) + "\nUNIT:  "
						+ pegaValorLinha(vetorLinhas[x]) + "\nVALOR: " + pegaValorLinha(vetorLinhas[x + 1])
						+ "\nTIPO:  " + pegaValorLinha(vetorLinhas[x + 2]);
				return resultado;
			}
		}

		return "";
	}

	private String pegaValorLinha(String linha) {
		if(linha != null) {
			String[] linhaSplit = linha.split(":");
			linhaSplit[1] = linhaSplit[1].replace("\"", "").trim().replace(",", "");
			return linhaSplit[1];
		}
		return "";
	}

}
