package factoryMethod;

import java.util.Date;

// Produto Concreto que extende a classe abstrata Passagem
public class PassagemOnibusUrbano extends Passagem {

	public PassagemOnibusUrbano(String origem, String destino, Date dataHoraPartida) {
		super(origem, destino, dataHoraPartida);
	}
	
	public String toString() {
		return "PASSAGEM URBANA: " + getOrigem() + " para " + getDestino();
	}
	
}
