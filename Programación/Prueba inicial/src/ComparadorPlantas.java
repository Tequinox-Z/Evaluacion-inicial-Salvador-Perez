import java.util.Comparator;

public class ComparadorPlantas implements Comparator<Planta> {

	@Override
	public int compare(Planta p1, Planta p2) {
		int resultado;
		
		if (p1.getNumeroPlanta() == p2.getNumeroPlanta()) {
			resultado = 0;
		}
		else if (p1.getNumeroPlanta() > p2.getNumeroPlanta()) {
			resultado = -1;
		}
		else {
			resultado = 1;
		}
		
		return resultado;
	}

}
