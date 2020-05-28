package factoryMethod;

import java.util.Date;
import java.util.Objects;

import javax.swing.JOptionPane;

public class Principal {

	// Factory Method: define uma interface para criar um objeto, mas as subclasses que decidem qual a classe instanciar
	public static void main(String[] args) {

		// Empresa � abstrata e tem 2 filhas, ent�o pode receber quaisquer inst�ncias das duas filhas aqui
		Empresa empresa = null;
		
		// Passagem � abstrata e tem 2 filhas, ent�o pode receber quaisquer inst�ncias das duas filhas aqui
		Passagem passagem = null;
		
		// EscolhaS que recebem do Input do OptionPane
		String escolhaEmpresa = null;
		String escolhaOrigem = null;
		String escolhaDestino = null;
		
		// Booleano respons�vel por controlar o while at� ele digitar o 1 ou 2
		boolean escolhaCerta = false;

		// Verifica se escolheu certo, se n�o, fica no loop at� escolher
		while (!escolhaCerta) {
			escolhaEmpresa = JOptionPane.showInputDialog("Escolha a Empresa de Passagem: 1 para Interestadual e 2 para Urbano");
			escolhaCerta = Principal.escolhaValida(escolhaEmpresa);
			Principal.mostrarMensagemInvalido(escolhaCerta);
		}

		// Pega o valor da escolha em formato de Integer
		Integer escolhaInteger = Principal.retornaEscolhaInteira(escolhaEmpresa);

		/*
		 * Essa parte abaixo dos If para instanciar alguma das implementa��es da classe
		 * Abstrata Empresa, pode ser alterado para um padr�o de projeto tamb�m. Mas n�o
		 * ser� mostrado nessa c�digo
		 */

		// Se for igual a 1, cria um objeto EmpresaOnibusInterestadual
		if (escolhaInteger.intValue() == 1) {
			empresa = new EmpresaOnibusInterestadual();
		}

		// Se for 2, cria Urbano
		else if (escolhaInteger.intValue() == 2) {
			empresa = new EmpresaOnibusUrbano();
		}
		
		// Pede para o usu�rio digitar Origem e Destino (n�o irei validar para o c�digo n�o ficar muito extenso)
		escolhaOrigem = JOptionPane.showInputDialog("Digite sua Origem: ");
		escolhaDestino = JOptionPane.showInputDialog("Digite seu Destino: ");
			
		// Aqui que entra de fato o Factory Method, pois a Empresa � uma f�brica de Passagem
		// A hierarquia principal tem a Empresa (Classe Abstrata) e suas 2 Filhas (EmpresaOnibusInterestadual e EmpresaOnibusUrbano)
		// Na classe pai abstrata (Empresa), existe um m�todo abstrato (sem implementa��o), que obriga as filhas a implementarem o m�todo abstrato do Pai
		// ent�o toda classe filha de Empresa ter� um m�todo emitePassagem com implementa��o diferente da outra, mas o retorno do m�todo � Igual, � a classe Abstrata PASSAGEM
		// Ou seja, toda classe filha de Empresa ir� emitir uma Passagem diferente, uma F�brica.
		if (empresa != null) {
			// F�brica de Passagem
			passagem = empresa.emitePassagem(escolhaOrigem, escolhaDestino, new Date());
		}

		// Exibie em uma caixa de di�logo a passagem
		JOptionPane.showMessageDialog(null, passagem.toString());

	}
	
	
	
		
	/* OUTROS M�TODOS */

	// Se estiver inv�lido, mostra a mensagem
	public static void mostrarMensagemInvalido(boolean isValido) {
		if (!isValido) {
			JOptionPane.showMessageDialog(null, "Escolha errada, tente novamente!");
		}
	}

	// Tenta passar a escolha de String para Integer
	public static Integer retornaEscolhaInteira(String str) {
		try {
			return Integer.valueOf(str);
		} catch (Exception e) {
			return null;
		}
	}

	// Valida o Input do showInputDialog
	public static boolean escolhaValida(String str) {
		// Inicia como true
		boolean isValidado = true;

		// Verifica se n�o est� nulo ou se est� com caracters vazio
		if (Objects.isNull(str) || (Objects.nonNull(str) && str.isEmpty())) {
			isValidado = false;
		}

		// Verifica se est� nas possibilidades
		isValidado = Principal.escolhaValidaNasPossibilidades(str);

		return isValidado;
	}

	// Verifica se � igual a 1 ou 2, se for diferente disso, retorna invalidado
	public static boolean escolhaValidaNasPossibilidades(String str) {
		Integer valor = Principal.retornaEscolhaInteira(str);
		// Valida se � igual a 1 ou 2
		if (valor != null && (valor.equals(new Integer(1)) || valor.equals(new Integer(2)))) {
			return true;
		}
		return false;
	}

}
