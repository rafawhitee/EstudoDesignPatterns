package factoryMethod;

import java.util.Date;

//Produto Concreto que extende a classe abstrata Passagem
public class PassagemOnibusInterestadual extends Passagem {

	public PassagemOnibusInterestadual(String origem, String destino, Date dataHoraPartida) {
		super(origem, destino, dataHoraPartida);
	}

	public String toString() {
		return "PASSAGEM INTERESTADUAL: " + getOrigem() + " para " + getDestino();
	}

}
