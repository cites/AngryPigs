package principal;
import java.awt.*;
import entorno.Entorno;
import entorno.Herramientas;

public class bala {
	Image imagen;
	double x;
	double y;
	double angulo;
	
	
	
	bala(Image imagen,double x,double y, double angulo){
		this.imagen= Herramientas.cargarImagen("img/Bala-Plateada.png");
		this.x=x;
		this.y=y;
		this.angulo=angulo;
		
	}
	
	void dibujar(Entorno ent) {
		ent.dibujarImagen(this.imagen, this.x, this.y, this.angulo);
	}


	void avanzar() {
		this.x += Math.cos(angulo) * 8;
		this.y += Math.sin(angulo) * 8;
	
	}
	
	void moverDerecha(Entorno ent) {
		;
		this.x += 1.5;
		if (this.x < 0)
			x += ent.getWidth();
		if (this.x >= ent.getWidth())
			x -= ent.getWidth();
	}
	
	void girarDerecha() {
		this.angulo+=Herramientas.radianes(1.2);
		if(this.angulo>=2 *Math.PI){
			this.angulo=2 *Math.PI;
		}
	}
	
	void moverIzquerda(Entorno ent) {
		this.x -= 1.5;
		if (this.x < 0)
			x += ent.getWidth();
		if (this.x >= ent.getWidth())
			x -= ent.getWidth();
	}
	
	void girarIzquierda() {
		this.angulo-=Herramientas.radianes(1.2);
		
		if(this.angulo<=Math.PI){
			this.angulo=Math.PI;
		}
		
	}
	
	double distancia(bird b){
		return Math.sqrt(Math.pow(this.x-b.x, 2)+(Math.pow(this.y-b.y, 2)));
	}
	double distancia(arma b){
		return Math.sqrt(Math.pow(this.x-b.x, 2)+(Math.pow(this.y-b.y, 2)));
	}
	
}
