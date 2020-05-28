package singleton;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;

	// "Auto-Relacionamento"
	// "Static" diz que todas as instâncias da Classe Janela teria os atributos declarados com static iguais para todos
	private static Janela janela;

	// O único construtor é privado, então só pode ser instanciado aqui dentro da Classe
	private Janela() {
		setSize(new Dimension(640, 480));
	}

	// Método "Static", pois como o construtor é private, ele não pode instanciar de qualquer lugar com a palavra reservada "New"
	// Então esse método pode ser chamado simplesmente por "Janela.getInstance()" diretamente
	// Ele verifica se o atributo static janela está null, se tiver, faz o "new" e retorna a janela
	// Ou seja, ele sempre retornará a mesma instância
	// Exemplo: se ele chamar 4 Janela.getInstance(), na primeira vez ele não existe, então irá de fato criar um novo (new) e retornar
	// Nas outras vezes, ele não irá cair dentro do If, ou seja, irá retornar o objeto criado pela primeira vez
	public static Janela getInstance() {
		if (janela == null) {
			janela = new Janela();
		}
		return janela;
	}

}