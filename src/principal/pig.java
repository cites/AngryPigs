package principal;

import java.awt.Image;

import entorno.Entorno;

public class pig {
	Image imagen;
	Image arma;
	double x;
	double y;
	double angulo;
	int puntos=0000;

	pig(Image jugadorX, double x, double y, double angulo, int puntos) {
		this.imagen = jugadorX;
		this.x = x;
		this.y = y;
		this.angulo = angulo;
		this.puntos = puntos;
		

	}

	void dibujar(Entorno ent) {
		ent.dibujarImagen(imagen, x, y, angulo);
	}

	void moverDerecha(Entorno ent) {
		this.x+=3;
		if (this.x <0)
			x += ent.getWidth();
		if (this.x >= ent.getWidth())
			x -= ent.getWidth();
		
		
		
	}
	void moverIzquierda(Entorno ent) {
		this.x-=3;
		if (this.x <0)
			x += ent.getWidth();
		if (this.x >= ent.getWidth())
			x -= ent.getWidth();
	}
}



