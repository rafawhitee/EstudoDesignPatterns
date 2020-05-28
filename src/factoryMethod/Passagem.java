package factoryMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

// Classe Abstrata para não poder instanciar
public abstract class Passagem {
	
	private String origem;
	private String destino;
	private Date dataHoraPartida;
	
	protected SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	public Passagem(String origem, String destino, Date dataHoraPartida) {
		this.origem = origem;
		this.destino = destino;
		this.dataHoraPartida = dataHoraPartida;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Date getDataHoraPartida() {
		return dataHoraPartida;
	}

	public void setDataHoraPartida(Date dataHoraPartida) {
		this.dataHoraPartida = dataHoraPartida;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}
	
	

}
