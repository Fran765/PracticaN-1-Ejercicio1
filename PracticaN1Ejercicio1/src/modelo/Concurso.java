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

	public void inscribirParticipante(Participante nuevo) throws FueraTerminoException {

		if ((!participantes.contains(nuevo)) && (this.puedeIncribirse())) {

			if (fechaInicio.isEqual(LocalDate.now())) {
				nuevo.sumarPuntos(10);
			}
			this.participantes.add(nuevo);

		} else {
			throw new FueraTerminoException("La inscripcion a finalizado.");
		}		
	}

	private boolean puedeIncribirse() {
		LocalDate hoy = LocalDate.now();
		return (hoy.isBefore(fechaFin) && hoy.isAfter(fechaInicio.minusDays(1)));

	}

	public int cantidadInscriptos() {
		return (participantes.size());
	}

}
