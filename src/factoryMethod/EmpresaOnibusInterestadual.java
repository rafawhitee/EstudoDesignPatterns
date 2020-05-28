package factoryMethod;

import java.util.Date;

//Classe concreta que herda da classe abstrata Empresa
public class EmpresaOnibusInterestadual extends Empresa {
	
	// Herda o m�todo abstrato da classe abstrata Empresa
	// ele ser� respons�vel agora para emitir Passagem do Tipo Interestadual
	// Ou seja, � uma f�brica de PassagemInterestadual

	@Override
	public Passagem emitePassagem(String origem, String destino, Date dataHoraPartida) {	
		return new PassagemOnibusInterestadual(origem, destino, dataHoraPartida);
	}

}
