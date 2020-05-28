package factoryMethod;

import java.util.Date;

// Classe concreta que herda da classe abstrata Empresa
public class EmpresaOnibusUrbano extends Empresa {

	// Herda o m�todo abstrato da classe abstrata Empresa
	// ele ser� respons�vel agora para emitir Passagem do Tipo OnibusUrbano
	// Ou seja, � uma f�brica de PassagemOnibusUrbano
	
	@Override
	public Passagem emitePassagem(String origem, String destino, Date dataHoraPartida) {
		return new PassagemOnibusUrbano(origem, destino, dataHoraPartida);
	}

}
