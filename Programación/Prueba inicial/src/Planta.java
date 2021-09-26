import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

public class Planta implements Medible{

	private int numeroPlanta;
	private HashSet<Zona> zonas;
	
	public Planta(int numeroPlanta) {
		super();
		this.numeroPlanta = numeroPlanta;
		this.zonas = new HashSet<Zona>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroPlanta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planta other = (Planta) obj;
		return numeroPlanta == other.numeroPlanta;
	}

	@Override
	public String toString() {
		return "Planta " + numeroPlanta + ", área: " + calcularArea() + " m²";
	}

	public String mostrarZonas() {
		StringBuilder resultado = new StringBuilder();
		
		for (Zona zonaActual: zonas) {
			resultado.append("    " + zonaActual.toString() + "\n");
		}
		
		return resultado.toString();
	}

	public int getNumeroPlanta() {
		return numeroPlanta;
	}
	
	public Double calcularArea() {
		Double metrosTotales = 0.0;
		
		for (Zona zonaActual: zonas) {
			metrosTotales += zonaActual.calcularArea();
		}
		
		return metrosTotales;
	}
	
	public boolean annadirZona(Zona nuevaZona) {
		return zonas.add(nuevaZona);
	}

	public HashSet<Zona> getZonas() {
		return (HashSet<Zona>) zonas.clone();
	}
	
}
