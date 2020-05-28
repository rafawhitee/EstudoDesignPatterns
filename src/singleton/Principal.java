package singleton;

public class Principal {

	// Singleton � uma inst�ncia por Execu��o ou Tempo de Vida de algo (exemplo um
	// servidor)

	public static void main(String[] args) {

		// Cria 2 Janelas, mas s�o iguais, pois no primeiro .getInstance() ele n�o
		// existe, entao cria
		// No segundo, ele verifica se est� criado, como j� est�, retorna o mesmo do
		// primeiro
		Janela janela = Janela.getInstance();
		Janela janela2 = Janela.getInstance();

		// Retornar� true, pois s�o os mesmos objetos (ou seja, mesmo endere�o de
		// mem�ria)
		boolean iguais = janela.equals(janela2);
		System.out.println("S�o iguais: " + ((iguais) ? "Sim" : "N�o"));
	}

}
