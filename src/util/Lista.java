package util;

public class Lista<Type>{
	
	No<Type> primeiro;
	
	public boolean listaVazia() {
		if(primeiro == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public int size() {
		int cont = 0;
		if(listaVazia() == false){
			No<Type> auxiliar = primeiro;
			while(auxiliar != null) {
				cont = cont + 1;
				auxiliar = auxiliar.proximo;
			}
		}
		return cont;
	}
	
	No<Type> getNo(int pos) throws Exception {
		if(listaVazia() == true) {
			throw new Exception("Lista vazia");
		}
		
		int tamanho = size();
		
		if(pos < 0 || pos > tamanho) {
			throw new Exception("Valor inválido");
		}
		
		No<Type> auxiliar = primeiro;
		int cont = 0;
		
		while(cont < pos) {
			auxiliar = auxiliar.proximo;
			cont = cont + 1;
		}
		
		return auxiliar;
		
	}
	
	public void addFirst(Type valor) {
		No<Type> elemento = new No<Type>();
		elemento.dado = valor;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}
	
	public void addLast(Type valor)throws Exception{
		if(listaVazia() == true) {
			addFirst(valor);
		}else {
			int tamanho = size();
			No<Type> elemento = new No<Type>();
			elemento.dado = valor;
			elemento.proximo = null;
			No<Type> ultimo = getNo(tamanho - 1);
			ultimo.proximo = elemento;
		}
	}
	
	public void add(Type valor, int pos) throws Exception{
		int tamanho = size();
		if(pos < 0 || pos > tamanho) {
			throw new Exception("Posição inválida");
		}
		
		if(pos == 0) {
			addFirst(valor);
		}else if(pos == tamanho) {
			addLast(valor);
		}else {
			No<Type> elemento = new No<Type>();
			elemento.dado = valor;
			No<Type> anterior = getNo(pos - 1);
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}
		
	}
	
	public Type removeFirst() throws Exception{
		if(listaVazia() == true) {
			throw new Exception("Lista Vazia");
		}
		Type elemento = primeiro.dado;
		primeiro = primeiro.proximo;
		return elemento;
	}
	
	public void removeLast()throws Exception{
		if(listaVazia() == true) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if(tamanho == 1) {
			removeFirst();
		}else {
			No<Type> penultimo = getNo(tamanho - 2);
			penultimo.proximo = null;
		}
		
	}
	
	public void remove(int pos)throws Exception{
		if(listaVazia() == true) {
			throw new Exception("Lista Vazia");
		}
		
		int tamanho = size();
		
		if(pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição Inválida");
		}
		
		if(pos == 0) {
			removeFirst();
		}else if(pos == tamanho - 1) {
			removeLast();
		}else {
			No<Type> anterior = getNo(pos - 1);
			No<Type> atual = getNo(pos);
			anterior.proximo = atual.proximo;
		}
	}
	
	public Type get(int pos) throws Exception{
		if(listaVazia() == true) {
			throw new Exception("");
		}
		
		int tamanho = size();
		
		if(pos < 0 || pos > tamanho - 1) {
			throw new Exception("Valor Inválido");
		}
		int cont = 0;
		No<Type> auxiliar = primeiro;
		while(cont < pos) {
			auxiliar = auxiliar.proximo;
			cont++;
		}
		return auxiliar.dado;
	}

	public void clean()throws Exception{
		if(listaVazia()){
			throw new Exception("Lista Vazia");
		}
		primeiro.proximo = null;
		primeiro = null;
	}
	
}