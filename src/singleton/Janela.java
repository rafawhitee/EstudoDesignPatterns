package singleton;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;

	// "Auto-Relacionamento"
	// "Static" diz que todas as inst�ncias da Classe Janela ter�o os atributos declarados com static iguais para todos
	private static Janela janela;

	// Construtor Privado, ent�o s� pode ser instanciado aqui dentro da Classe
	private Janela() {
		// Seta a dimens�o do JFrame
		setSize(new Dimension(800, 600));
	}

	// M�todo "Static", pois como o construtor � private, ele n�o pode instanciar de qualquer lugar com a palavra reservada "New"
	// Ent�o esse m�todo pode ser chamado simplesmente por "Janela.getInstance()" diretamente
	// Ele verifica se o atributo static janela est� null, se tiver, faz o "new" e retorna a janela
	// Ou seja, ele sempre retornar� a mesma inst�ncia
	// Exemplo: se ele chamar 4 Janela.getInstance(), na primeira vez ele n�o existe, ent�o ir� de fato criar um novo (new) e retornar
	// Nas outras vezes, ele n�o ir� cair dentro do If, ou seja, ir� retornar o objeto criado pela primeira vez
	
	public static Janela getInstance() {
		if (janela == null) {
			janela = new Janela();
		}
		return janela;
	}

}