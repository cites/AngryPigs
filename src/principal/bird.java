package principal;

import java.awt.Image;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;

public class bird {
	
	Image imagen;
	double x;
	double y;
	double angulo;
	int idPajaro; //1=Pajarito Azul, 2= Pajarito Amarillo, 3=Pajarito Blanco, 4=Pajarito Rojo 5=Pajarito Verde
	int valorPuntos;//Esta variable es utilizada para sumar los puntos correspondientes asignados por cada pajaro;
	
	public bird(Image TipoDePajaro,double x,double y,double angulo,int idPajaro,int valorPuntos){ //le paso un Id para diferenciar los distintos pajartos.
		this.imagen = TipoDePajaro;
		this.x = x;
		this.y = y;
		this.angulo = angulo;
		this.idPajaro=idPajaro;
		this.valorPuntos=valorPuntos;
	} 
	
	void dibujar(Entorno ent){
			ent.dibujarImagen(imagen, x, y, angulo);
			}
	
	void avanzarPajaros(Entorno ent) {
		Random gen = new Random();
		if(this.idPajaro==1){//Si es Pajarito Azul;
			this.x+=1;
			this.y+=Math.cos(x/15);
		}
		else if(this.idPajaro==2){// Si es Pajarito Amarillo;
			this.x += Math.cos(angulo) * 5;
			this.y += Math.sin(angulo) * 5;
			int saltoEnVuelo=gen.nextInt(800);
			if(this.y!=saltoEnVuelo)
				this.y+=0.5;
			else{
				this.angulo=-Herramientas.radianes(35);
				}
			}
		
		else if(this.idPajaro==3){// Si es Pajarito Blanco;
			this.y +=0.5;
			this.x -= Math.cbrt(x);
			}
		
		else if(this.idPajaro==4){// Si es Pajarito Rojo;
			this.x -=Math.pow(1,x+2);
			}
		else if(this.idPajaro==5){// Si es Pajarito Verde;
			this.x -= Math.cos(angulo) * 6;
			this.y -= Math.sin(angulo) * 6;
			int vueltaAtras=gen.nextInt(800);
			if(this.y!=vueltaAtras)
				this.y+=0.5;
			else
				this.angulo-=Herramientas.radianes(180);}
		}
	
}