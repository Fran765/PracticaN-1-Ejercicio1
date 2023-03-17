package modelo;

public class Participante {

	private int dni;
	private int puntos;

	public Participante(int dni) {
		this.dni = dni;
		this.puntos = 0;
	}

	public void sumarPuntos(int puntos) {
		this.puntos = this.puntos + puntos;
	}

	public int devolverCantidadDePuntos() {
		return puntos;
	}

}
