package tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import excepciones.FueraTerminoException;
import modelo.Concurso;
import modelo.Participante;

class ConcursoTest {

	@Test
	void testInscribirParticipante() {

		// primer caso cuando el participante se inscribe a un curso pero no en el
		// primer dia
		Concurso primerConcurso = new Concurso(1, LocalDate.now().minusDays(2), LocalDate.now().plusDays(8));
		Participante miParticipante = new Participante(42699344);

		try {

			primerConcurso.inscribirParticipante(miParticipante);
			int valorEsparado = 1;

			assertEquals(valorEsparado, primerConcurso.cantidadInscriptos());

		} catch (FueraTerminoException e) {

			System.err.println("Excepcion inscripcion: " + e.getMessage());
		}

		// segundo caso cuando el participante se inscribe a un curso en el primer dia
		Concurso segundoConcurso = new Concurso(2, LocalDate.now(), LocalDate.now().plusDays(8));

		try {

			segundoConcurso.inscribirParticipante(miParticipante);

			int resultado2 = miParticipante.devolverCantidadDePuntos();
			int puntosEsperados = 10;

			assertEquals(puntosEsperados, resultado2);

		} catch (FueraTerminoException e) {

			System.err.println("Excepcion inscripcion: " + e.getMessage());
		}

		// tercer caso cuando el aprticipante se intenta inscribir en un curso ya
		// finalizado
		Concurso tercerConcurso = new Concurso(3, LocalDate.now().minusDays(16), LocalDate.now().minusDays(2));
		try {

			tercerConcurso.inscribirParticipante(miParticipante);
			int cantidadEsperada = 0;

			assertEquals(cantidadEsperada, tercerConcurso.cantidadInscriptos());

		} catch (FueraTerminoException e) {

			System.err.println("Excepcion inscripcion: " + e.getMessage());
		}
	}

}
