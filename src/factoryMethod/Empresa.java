package factoryMethod;

import java.util.Date;

// Classe abstrata, que vai ser a F�brica de Passagem
public abstract class Empresa {

	// M�todo abstrato, logo, quem for filha de Empresa, obrigatoriamente dever�
	// implementar esse m�todo
	public abstract Passagem emitePassagem(String origem, String destino, Date dataHoraPartida);

}
