package src;

public class Puja {
	private String usuario;
	private float precioP;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public float getPrecioP() {
		return precioP;
	}

	public void setPrecioP(float precioP) {
		this.precioP = precioP;
	}

	public Puja(String usuario, float precioP) {
		super();
		this.usuario = usuario;
		this.precioP = precioP;
	}
}
