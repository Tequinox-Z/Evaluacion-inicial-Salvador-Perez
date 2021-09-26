
public class ZonaCuadrada extends Zona {

	private Double lado;
	
	public ZonaCuadrada(String nombre, Double lado) {
		super(nombre);
		this.lado = lado;
	}

	@Override
	public Double calcularArea() {
		return lado * lado;
	}

	@Override
	public String toString() {
		return super.toString() + ", cuadrado, con " + this.calcularArea() + " m²";
	}	
}