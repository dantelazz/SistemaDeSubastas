package src;

public class Usuario {
	private String nombre;
	private float credito;

	public Usuario(String nombre, float cantidad) {
		this.nombre = nombre;
		this.credito = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) {
		this.credito = credito;
	}

	public void incrementarC(float cantidad) {
		credito = credito + cantidad;
	}

	public void decrementarC(float cantidad) {
		credito = credito - cantidad;
	}
}