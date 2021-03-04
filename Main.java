package src;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Usuario j = new Usuario("Juan", 100);
		Usuario p = new Usuario("Pedro", 150);
		Usuario e = new Usuario("Enrique", 300);
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios.add(j);
		listaUsuarios.add(p);
		listaUsuarios.add(e);
		Subasta s1 = new Subasta(j, "Telefono Movil", true, null);
		if (s1.pujar(p, 100)) {
			Puja PMayor = s1.PMayor();
			System.out.println("La puja fue Aceptada");
			System.out.println("La puja mayor fue de " + PMayor.getPrecioP() + " Realizada por " + PMayor.getUsuario());
		}
		if (!s1.pujar(e, 50)) {
			Puja PMayor = s1.PMayor();
			System.out.println("La puja fue Rechazada");
			System.out.println("La puja mayor fue de " + PMayor.getPrecioP() + " Realizada por " + PMayor.getUsuario());
		}
		if (s1.ejecutar(listaUsuarios)) {
			System.out.println("La subasta fue ejecutada con exito");
		} else
			System.out.println("La subasta no fue ejecutada");
		if (!s1.pujar(e, 200)) {
			System.out.println("La puja fue Rechazada");
		}
		Subasta s2 = new Subasta(p, "Impresora Laser", true, null);
		if (s2.pujar(e)) {
			System.out.println("Puja aceptada");
		}
		s2.ejecutar(listaUsuarios);
		for (Usuario usu : listaUsuarios) {
			System.out.println("Nombre " + usu.getNombre());
			System.out.println("Credito " + usu.getCredito());
		}
		System.out.println("Propietarios de subasta ");
		System.out.println("Primer Propietario " + s1.getPropietario().getNombre());
		System.out.println("Segundo Propietario " + s2.getPropietario().getNombre());
	}
}