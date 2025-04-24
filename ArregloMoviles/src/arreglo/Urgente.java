package arreglo;

import java.time.LocalDate;

public class Urgente extends Arreglo {
	LocalDate fecha_entrega;

	public Urgente(LocalDate fecha_entrega) {
		super();
		this.fecha_entrega = fecha_entrega;
	}

}
