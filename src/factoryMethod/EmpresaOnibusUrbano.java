package factoryMethod;

import java.util.Date;

// Classe concreta que herda da classe abstrata Empresa
public class EmpresaOnibusUrbano extends Empresa {

	// Herda o método abstrato da classe abstrata Empresa
	// ele será responsável agora para emitir Passagem do Tipo OnibusUrbano
	// Ou seja, é uma fábrica de PassagemOnibusUrbano
	
	@Override
	public Passagem emitePassagem(String origem, String destino, Date dataHoraPartida) {
		return new PassagemOnibusUrbano(origem, destino, dataHoraPartida);
	}

}
