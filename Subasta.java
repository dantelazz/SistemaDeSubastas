package src;

import java.util.ArrayList;

public class Subasta {
	private Usuario propietario;
	private String nombreDProducto;
	private boolean estado;
	private ArrayList<Puja> listaPujas;

	public Subasta(Usuario propietario, String nombreDProducto, boolean estado, ArrayList<Puja> listaPujas) {
		super();
		this.propietario = propietario;
		this.nombreDProducto = nombreDProducto;
		this.estado = estado;
		this.listaPujas = new ArrayList<Puja>();
	}

	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}

	public Usuario getPropietario() {
		return this.propietario;
	}

	public String getNombreDProducto() {
		return nombreDProducto;
	}

	public void setNombreDProducto(String nombreDProducto) {
		this.nombreDProducto = nombreDProducto;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public ArrayList<Puja> getListaPujas() {
		return listaPujas;
	}

	public void setListaPujas(ArrayList<Puja> listaPujas) {
		this.listaPujas = listaPujas;
	}

	public boolean pujar(Usuario usuario, float oferta) {
		boolean rta = false;
		Puja nP = new Puja(usuario.getNombre(), oferta);
		if (this.estado == true) {
			if (usuario.getCredito() >= oferta) {
				if (!usuario.getNombre().equals(this.propietario.getNombre())) {
					if (this.listaPujas.size() > 0 && this.listaPujas != null) {
						if (oferta > this.listaPujas.get(listaPujas.size() - 1).getPrecioP()) {
							listaPujas.add(nP);
							rta = true;
						} else
							rta = false;
					} else {
						this.listaPujas.add(nP);
						rta = true;
					}
				} else {
					rta = false;
					System.out.println("El propietario no puede pujar");
				}
			} else {
				rta = false;
				System.out.println("El credito del usuario no es suficiente");
			}
		} else {
			rta = false;
			System.out.println("Subasta cerrada");
		}
		return rta;
	}

	public boolean pujar(Usuario usuario) {
		boolean rta = false;
		if (this.estado == true) {
			if (!usuario.getNombre().equals(this.propietario.getNombre())) {
				if (this.listaPujas.size() > 0 && this.listaPujas != null) {
					float ofertaNueva = this.listaPujas.get(this.listaPujas.size() - 1).getPrecioP() + 1;
					Puja nP = new Puja(usuario.getNombre(), ofertaNueva);
					listaPujas.add(nP);
					rta = true;
				} else {
					Puja nP = new Puja(usuario.getNombre(), 1);
					this.listaPujas.add(nP);
					rta = true;
				}
			} else {
				rta = false;
				System.out.println("El usuario es propietario no puede pujar");
			}
		} else {
			rta = false;
			System.out.println("Subasta fue cerrada");
		}
		return rta;
	}

	public boolean ejecutar(ArrayList<Usuario> listaUsuarios) {
		boolean rta = false;
		if (this.estado == true) {
			if (this.listaPujas.size() > 0) {
				String NombreWin = this.listaPujas.get(this.listaPujas.size() - 1).getUsuario();
				float ofertaGanadora = this.listaPujas.get(this.listaPujas.size() - 1).getPrecioP();
				for (Usuario usuario : listaUsuarios) {
					if (usuario.getNombre().toLowerCase().equals(this.propietario.getNombre().toLowerCase())) {
						usuario.setCredito(usuario.getCredito() + ofertaGanadora);
					}
				}
				for (Usuario usuario : listaUsuarios) {
					if (usuario.getNombre().toLowerCase().equals(NombreWin.toLowerCase())) {
						usuario.setCredito(usuario.getCredito() - ofertaGanadora);
						this.propietario = usuario;
					}
				}
				this.estado = false;
				rta = true;
			}
		} else
			rta = false;
		return rta;
	}

	public Puja PMayor() {
		return this.listaPujas.get(this.listaPujas.size() - 1);
	}
}
