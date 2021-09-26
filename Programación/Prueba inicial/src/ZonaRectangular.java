
public class ZonaRectangular extends Zona {

	private Double largo;
	private Double ancho;
	
	public ZonaRectangular(String nombre, Double largo, Double ancho) {
		super(nombre);
		this.largo = largo;
		this.ancho = ancho;
	}

	@Override
	public Double calcularArea() {
		return largo * ancho;
	}

	@Override
	public String toString() {
		return super.toString() + ", rectangular con " + this.calcularArea() + " m²";
	}
}
