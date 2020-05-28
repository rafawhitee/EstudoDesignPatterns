package factoryMethod;

import java.util.Date;

// Classe abstrata, que vai ser a Fábrica de Passagem
public abstract class Empresa {

	// Método abstrato, logo, quem for filha de Empresa, obrigatoriamente deverá
	// implementar esse método
	public abstract Passagem emitePassagem(String origem, String destino, Date dataHoraPartida);

}
