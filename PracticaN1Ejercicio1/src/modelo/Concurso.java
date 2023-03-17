package modelo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import excepciones.FueraTerminoException;

public class Concurso {

	private int idConcurso;
	private Set<Participante> participantes;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;

	public Concurso(int idConcurso, LocalDate InicioIncripcion, LocalDate FinInscripcion) {
		this.idConcurso = idConcurso;
		this.participantes = new HashSet();
		this.fechaInicio = InicioIncripcion;
		this.fechaFin = FinInscripcion;
	}

	public boolean inscribirParticipante(Participante nuevo) throws FueraTerminoException {

		if ((!participantes.contains(nuevo)) && (this.puedeIncribirse())) {

			if (fechaInicio.isEqual(LocalDate.now())) {
				nuevo.sumarPuntos(10);
			}
			this.participantes.add(nuevo);
			return true;

		} else {
			new FueraTerminoException("Preguntar incripciones fuera de termino");
			return false;
		}
	}

	private boolean puedeIncribirse() {
		LocalDate hoy = LocalDate.now();
		return (hoy.isBefore(fechaFin) && hoy.isAfter(fechaInicio.minusDays(1)));

	}

}
