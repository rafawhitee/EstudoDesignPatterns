package singleton;

public class Principal {

	// Singleton é uma instância por Execução ou Tempo de Vida de algo (exemplo um
	// servidor)

	public static void main(String[] args) {

		// Cria 2 Janelas, mas são iguais, pois no primeiro .getInstance() ele não
		// existe, entao cria
		// No segundo, ele verifica se está criado, como já está, retorna o mesmo do
		// primeiro
		Janela janela = Janela.getInstance();
		Janela janela2 = Janela.getInstance();

		// Retornará true, pois são os mesmos objetos (ou seja, mesmo endereço de
		// memória)
		boolean iguais = janela.equals(janela2);
		System.out.println("São iguais: " + ((iguais) ? "Sim" : "Não"));
	}

}
