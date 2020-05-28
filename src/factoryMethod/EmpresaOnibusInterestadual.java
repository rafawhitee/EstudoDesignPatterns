package factoryMethod;

import java.util.Date;

//Classe concreta que herda da classe abstrata Empresa
public class EmpresaOnibusInterestadual extends Empresa {
	
	// Herda o método abstrato da classe abstrata Empresa
	// ele será responsável agora para emitir Passagem do Tipo Interestadual
	// Ou seja, é uma fábrica de PassagemInterestadual

	@Override
	public Passagem emitePassagem(String origem, String destino, Date dataHoraPartida) {	
		return new PassagemOnibusInterestadual(origem, destino, dataHoraPartida);
	}

}
