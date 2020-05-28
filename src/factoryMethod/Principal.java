package factoryMethod;

import java.util.Date;
import java.util.Objects;

import javax.swing.JOptionPane;

public class Principal {

	// Factory Method: define uma interface para criar um objeto, mas as subclasses que decidem qual a classe instanciar
	public static void main(String[] args) {

		// Empresa é abstrata e tem 2 filhas, então pode receber quaisquer instâncias das duas filhas aqui
		Empresa empresa = null;
		
		// Passagem é abstrata e tem 2 filhas, então pode receber quaisquer instâncias das duas filhas aqui
		Passagem passagem = null;
		
		// EscolhaS que recebem do Input do OptionPane
		String escolhaEmpresa = null;
		String escolhaOrigem = null;
		String escolhaDestino = null;
		
		// Booleano responsável por controlar o while até ele digitar o 1 ou 2
		boolean escolhaCerta = false;

		// Verifica se escolheu certo, se não, fica no loop até escolher
		while (!escolhaCerta) {
			escolhaEmpresa = JOptionPane.showInputDialog("Escolha a Empresa de Passagem: 1 para Interestadual e 2 para Urbano");
			escolhaCerta = Principal.escolhaValida(escolhaEmpresa);
			Principal.mostrarMensagemInvalido(escolhaCerta);
		}

		// Pega o valor da escolha em formato de Integer
		Integer escolhaInteger = Principal.retornaEscolhaInteira(escolhaEmpresa);

		/*
		 * Essa parte abaixo dos If para instanciar alguma das implementações da classe
		 * Abstrata Empresa, pode ser alterado para um padrão de projeto também. Mas não
		 * será mostrado nessa código
		 */

		// Se for igual a 1, cria um objeto EmpresaOnibusInterestadual
		if (escolhaInteger.intValue() == 1) {
			empresa = new EmpresaOnibusInterestadual();
		}

		// Se for 2, cria Urbano
		else if (escolhaInteger.intValue() == 2) {
			empresa = new EmpresaOnibusUrbano();
		}
		
		// Pede para o usuário digitar Origem e Destino (não irei validar para o código não ficar muito extenso)
		escolhaOrigem = JOptionPane.showInputDialog("Digite sua Origem: ");
		escolhaDestino = JOptionPane.showInputDialog("Digite seu Destino: ");
			
		// Aqui que entra de fato o Factory Method, pois a Empresa é uma fábrica de Passagem
		// A hierarquia principal tem a Empresa (Classe Abstrata) e suas 2 Filhas (EmpresaOnibusInterestadual e EmpresaOnibusUrbano)
		// Na classe pai abstrata (Empresa), existe um método abstrato (sem implementação), que obriga as filhas a implementarem o método abstrato do Pai
		// então toda classe filha de Empresa terá um método emitePassagem com implementação diferente da outra, mas o retorno do método é Igual, é a classe Abstrata PASSAGEM
		// Ou seja, toda classe filha de Empresa irá emitir uma Passagem diferente, uma Fábrica.
		if (empresa != null) {
			// Fábrica de Passagem
			passagem = empresa.emitePassagem(escolhaOrigem, escolhaDestino, new Date());
		}

		// Exibie em uma caixa de diálogo a passagem
		JOptionPane.showMessageDialog(null, passagem.toString());

	}
	
	
	
		
	/* OUTROS MÉTODOS */

	// Se estiver inválido, mostra a mensagem
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

		// Verifica se não está nulo ou se está com caracters vazio
		if (Objects.isNull(str) || (Objects.nonNull(str) && str.isEmpty())) {
			isValidado = false;
		}

		// Verifica se está nas possibilidades
		isValidado = Principal.escolhaValidaNasPossibilidades(str);

		return isValidado;
	}

	// Verifica se é igual a 1 ou 2, se for diferente disso, retorna invalidado
	public static boolean escolhaValidaNasPossibilidades(String str) {
		Integer valor = Principal.retornaEscolhaInteira(str);
		// Valida se é igual a 1 ou 2
		if (valor != null && (valor.equals(new Integer(1)) || valor.equals(new Integer(2)))) {
			return true;
		}
		return false;
	}

}
