package principal;

import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;

public class arma {
	double angulo;
	double x;
	double y;
	Image imagen;

	arma(Image imagen, double x, double y, double angulo) {
		this.angulo = angulo;
		this.x = x;
		this.y = y;
		this.imagen = Herramientas.cargarImagen("img/Canion-Dorado.png");
	}

	void dibujar(Entorno ent) {
		ent.dibujarImagen(imagen, x, y, angulo, 0.8);
	}

	void avanzarDerecha(Entorno ent) {

		this.x += 3;
		if (this.x < 0)
			x += ent.getWidth();
		if (this.x >= ent.getWidth())
			x -= ent.getWidth();
	}

	void avanzarIzquerda(Entorno ent) {
		this.x -= 3;
		if (this.x < 0)
			x += ent.getWidth();
		if (this.x >= ent.getWidth())
			x -= ent.getWidth();
	}

	void girarDerecha() {

		this.angulo += Herramientas.radianes(1.2);
		if (this.angulo >= 2 * Math.PI) {
			this.angulo = 2 * Math.PI;
		}
	}

	void girarIzquierda() {
		this.angulo -= Herramientas.radianes(1.2);

		if (this.angulo <= Math.PI) {
			this.angulo = Math.PI;
		}

	}

}
