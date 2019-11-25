package dad.javafx.ahorcado.model;



public class Puntuacion implements Comparable<Puntuacion>{
	
	private String nombre;
	private Integer numero;
	
	

	public Puntuacion(String nombre, Integer numero) {
		this.nombre=nombre;
		this.numero=numero;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String toString() {
		
		return nombre+"____"+numero+" Puntos";
	}
	
	
	public int compareTo(Puntuacion o) {
		return numero-o.getNumero();
	}

}