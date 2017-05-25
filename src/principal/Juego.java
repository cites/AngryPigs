package principal;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import Herramientas.ListaBalas;
import Herramientas.ListaBirds;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	private Entorno entorno;
	private String estadoDeJuego;
	private Image fondo;
	private ListaBirds pajaritos; 
	private pig jugadorNum1;
	private pig jugadorNum2;
	private arma arma1;
	private arma arma2;
	private int municionPig_1;
	private int municionPig_2;
	private ListaBalas balasDispPig_1;
	private ListaBalas balasDispPig_2;
	private pig chanchoDePuntos1;
	private pig chanchoDePuntos2;

	Juego() {
		estadoDeJuego = "PantallaDeInicio";
		balasDispPig_1 = new ListaBalas();
		balasDispPig_2 = new ListaBalas();
		municionPig_1 = 15;
		municionPig_2 = 15;
		pajaritos = new ListaBirds();
		jugadorNum1 = new pig(Herramientas.cargarImagen("img/Pig1.png"), 700, 500,
				0, 0);
		jugadorNum2 = new pig(Herramientas.cargarImagen("img/Pig2.png"), 100, 500,
				0, 0);
		arma1 = new arma(Herramientas.cargarImagen("img/Canion-Dorado.png"),
				jugadorNum1.x, jugadorNum1.y - 25, Herramientas.radianes(245));
		arma2 = new arma(Herramientas.cargarImagen("img/Canion-Dorado.png"),
				jugadorNum2.x, jugadorNum2.y - 25, Herramientas.radianes(290));
		this.fondo = Herramientas.cargarImagen("img/Fondo.jpg");
		entorno = new Entorno(this, "Angry Pigs, �la venganza! - Versi�n 0.01",
				800, 600);
		
		chanchoDePuntos1 = new pig(Herramientas.cargarImagen("img/Pig1.png"), 100, 200,
				0, 0);
		chanchoDePuntos2 = new pig(Herramientas.cargarImagen("img/Pig2.png"), 100, 400,
				0, 0);
	}

	public void tick() {
		if (entorno.estaPresionada(entorno.TECLA_ENTER)){
			estadoDeJuego = "IniciarJuego";
		}
		else if(entorno.estaPresionada(entorno.TECLA_FIN)){
			System.exit(0);
		}
		else if (entorno.estaPresionada('P'))
			estadoDeJuego = "Pausa";
		
		
//Comienzo a ver el estado del juego para ver si comienza el juego
		if(estadoDeJuego=="PantallaDeInicio"){
				entorno.cambiarFont("Chiller", 40, Color.GREEN);
				entorno.escribirTexto("Angry Pigs La Vengaza",entorno.alto()/2-75, entorno.ancho()/3);
				entorno.cambiarFont("Chiller", 20, Color.lightGray);
				entorno.escribirTexto("Iniciar Juego(Enter)", this.entorno.alto()/3, this.entorno.ancho()/2);
				entorno.escribirTexto("Salir del Juego(Fin)", 600-this.entorno.alto()/3, this.entorno.ancho()/2);
		}
		
		else if(estadoDeJuego=="Pausa"){
			entorno.cambiarFont("Chiller", 40, Color.GREEN);
			entorno.escribirTexto("Pausa", entorno.ancho()/2-80,entorno.alto()/2);
			entorno.cambiarFont("Chiller", 15, Color.GRAY);
			entorno.escribirTexto("Reanudar Juego(Enter)", this.entorno.ancho()-250, this.entorno.alto()-50);
		}
		
//Cuando finaliza el juego muestro los puntos de ambos;
		else if(estadoDeJuego=="TerminarJuego") {
			entorno.cambiarFont("Chiller", 70, Color.ORANGE);
			entorno.escribirTexto("Juego Finalizado",entorno.getWidth() / 2 - 175, 100);
			entorno.cambiarFont("Chiller", 35, Color.WHITE);
			this.chanchoDePuntos1.dibujar(entorno);
			entorno.escribirTexto("Puntos : "+Integer.toString(this.jugadorNum1.puntos),this.chanchoDePuntos1.x+75, this.chanchoDePuntos1.y);
			this.chanchoDePuntos2.dibujar(entorno);
			entorno.escribirTexto("Puntos : "+Integer.toString(this.jugadorNum2.puntos),this.chanchoDePuntos2.x+75, this.chanchoDePuntos2.y);
			//ver ganador del juego
			entorno.cambiarFont("Chiller", 40, Color.GREEN);
			if(this.jugadorNum1.puntos>this.jugadorNum2.puntos){
				entorno.escribirTexto("<------  Ganador", this.chanchoDePuntos1.x+350, this.chanchoDePuntos1.y);
			}else if(this.jugadorNum2.puntos>this.jugadorNum1.puntos){
				entorno.escribirTexto("<------  Ganador", this.chanchoDePuntos2.x+350, this.chanchoDePuntos2.y);
			}else if(this.jugadorNum1.puntos==this.jugadorNum2.puntos){
				entorno.escribirTexto("Empate", entorno.ancho()/2+50, entorno.alto()/2);
			}
			
		}

//Apartado donde incio el juego
		if (estadoDeJuego=="IniciarJuego") {
			/* Dibujo Todo */
			
			this.entorno.dibujarImagen(this.fondo, entorno.getWidth() / 2,
					entorno.getHeight() / 2, 0, 0.7);
			this.jugadorNum1.dibujar(entorno);
			this.jugadorNum2.dibujar(entorno);
			this.arma1.dibujar(entorno);
			this.arma2.dibujar(entorno);
			entorno.cambiarFont("Chiller", 20, Color.LIGHT_GRAY);
			this.entorno.escribirTexto("Balas:"+Integer.toString(municionPig_1),
					this.entorno.ancho() - 230, this.entorno.alto() - 7);
			this.entorno.escribirTexto("Balas:"+Integer.toString(municionPig_2), 15,
					this.entorno.alto() - 7);
			entorno.cambiarFont("Chiller", 30, Color.orange);
			this.entorno.escribirTexto("Puntos:"+Integer.toString(this.jugadorNum1.puntos),
					this.entorno.ancho() - 230, this.entorno.alto() - 30);
			this.entorno.escribirTexto("Puntos:"+Integer.toString(this.jugadorNum2.puntos), 15,
					this.entorno.alto() - 30);

			// Agrego los pajaritos a la lista.
			Random gen = new Random();
			if (pajaritos.largo() < 17) {
				int aleatorio = gen.nextInt(1000);

				if (aleatorio < 10) {
					if (aleatorio < 3) {
						pajaritos.agregarAtras(new bird(Herramientas
								.cargarImagen("img/Azul-Der.png"), 1, gen
								.nextInt(250), 0, 1, 10));
					}
				}
				if (aleatorio > 50) {
					if (aleatorio < 60) {
						pajaritos.agregarAtras(new bird(Herramientas
								.cargarImagen("img/Amarillo-Der.gif"), 1, gen
								.nextInt(250), 0, 2, 100));
					}
				}
				if (aleatorio < 5) {
					if (aleatorio < 2) {
						pajaritos.agregarAtras(new bird(Herramientas
								.cargarImagen("img/Blanco-Izq.png"), 799, gen
								.nextInt(250), 0, 3, 50));
					}
				}
				if (aleatorio < 5) {
					if (aleatorio < 2) {
						pajaritos.agregarAtras(new bird(Herramientas
								.cargarImagen("img/RojoGordo-Izq.png"), 799,
								gen.nextInt(300), 0, 4, 75));
					}
				}
				if (aleatorio < 5) {
					if (aleatorio < 2) {
						pajaritos.agregarAtras(new bird(Herramientas
								.cargarImagen("img/Verde-Izq.png"), 799, gen
								.nextInt(300), 0, 5, 150));
					}
				}
			}

			int b1 = 0;
			while (b1 < balasDispPig_1.largo()) {// Dibujo y Avanzo las balas del chancho 1
				if (balasDispPig_1.BalaAt(b1) != null) {
					balasDispPig_1.BalaAt(b1).avanzar();
					if(balasDispPig_1.BalaAt(b1).distancia(arma1)>48){
						balasDispPig_1.BalaAt(b1).dibujar(entorno);
					}
				}
				b1++;
			}
			int b2 = 0;
			while (b2 < balasDispPig_2.largo()) {// Dibujo y Avanzo las balas del chancho 2
				if (balasDispPig_2.BalaAt(b2) != null) {
					balasDispPig_2.BalaAt(b2).avanzar();
					if(balasDispPig_2.BalaAt(b2).distancia(arma2)>48){
						balasDispPig_2.BalaAt(b2).dibujar(entorno);
					}
				}
				b2++;
			}

			int i = 0;
			while (i < pajaritos.largo()) {
				int t1 = 0;
				while (t1 < balasDispPig_1.largo()) {
					if (pajaritos.birdAt(i)!=null && (balasDispPig_1.BalaAt(t1).distancia(
							pajaritos.birdAt(i)) <= 45.0)) {
						if(municionPig_1<=15){
							municionPig_1 += 1;
						}
						this.jugadorNum1.puntos += this.pajaritos.birdAt(i).valorPuntos;
						pajaritos.quitar(pajaritos.birdAt(i));
						balasDispPig_1.quitar(balasDispPig_1.BalaAt(t1));
					}
					if (balasDispPig_1.BalaAt(t1) != null
							&& (balasDispPig_1.BalaAt(t1).y < -3
									|| balasDispPig_1.BalaAt(t1).x < -3 || balasDispPig_1
									.BalaAt(t1).x > entorno.ancho() + 3)) {
						balasDispPig_1.quitar(balasDispPig_1.BalaAt(t1));
					}
					t1++;
				}
				int t2 = 0;
				while (t2 < balasDispPig_2.largo()) {
					if (pajaritos.birdAt(i)!=null && (balasDispPig_2.BalaAt(t2).distancia(
							pajaritos.birdAt(i)) <= 45.0)) {
						if(municionPig_2<=15){
							municionPig_2 += 1;
						}
						this.jugadorNum2.puntos += this.pajaritos.birdAt(i).valorPuntos;
						pajaritos.quitar(pajaritos.birdAt(i));
						balasDispPig_2.quitar(balasDispPig_2.BalaAt(t2));
					}
					if (balasDispPig_2.BalaAt(t2) != null
							&& (balasDispPig_2.BalaAt(t2).y < -3
									|| balasDispPig_2.BalaAt(t2).x < -3 || balasDispPig_2
									.BalaAt(t2).x > entorno.ancho() + 3)) {
						balasDispPig_2.quitar(balasDispPig_2.BalaAt(t2));
					}
					t2++;
				}

				if (pajaritos.birdAt(i) != null) {
					pajaritos.birdAt(i).avanzarPajaros(entorno);
					pajaritos.birdAt(i).dibujar(entorno);
				}
				if (pajaritos.birdAt(i) != null
						&& (pajaritos.birdAt(i).x > entorno.ancho() || pajaritos
								.birdAt(i).x < 0)) {
					pajaritos.quitar(pajaritos.birdAt(i));
				}
				i++;
			}

			// mover el chanchito1 con su arma
			if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)) {
				jugadorNum1.moverDerecha(entorno);
				arma1.avanzarDerecha(entorno);
			}
			if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)) {
				jugadorNum1.moverIzquierda(entorno);
				arma1.avanzarIzquerda(entorno);
			}
			if (this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA)) {
				arma1.girarDerecha();
			}
			if (this.entorno.estaPresionada(this.entorno.TECLA_ABAJO)) {
				arma1.girarIzquierda();
			}

			// mover el chanchito2 con su arma
			if (this.entorno.estaPresionada('D')) {
				jugadorNum2.moverDerecha(entorno);
				arma2.avanzarDerecha(entorno);
			}
			if (this.entorno.estaPresionada('A')) {
				jugadorNum2.moverIzquierda(entorno);
				arma2.avanzarIzquerda(entorno);
			}
			if (this.entorno.estaPresionada('W')) {
				arma2.girarDerecha();
			}
			if (this.entorno.estaPresionada('S')) {
				arma2.girarIzquierda();
			}

			// Disparo con chancho 1
			if (this.entorno.estaPresionada(entorno.TECLA_CTRL)
					&& balasDispPig_1.largo() == 0 && municionPig_1 > 0) {
				balasDispPig_1.agregarAdelante(new bala(Herramientas
						.cargarImagen("img/Bala-Plateada.png"), this.arma1.x,
						this.arma1.y, this.arma1.angulo));
				municionPig_1 -= 1;
			} else if (this.entorno.estaPresionada(this.entorno.TECLA_CTRL)
					&& municionPig_1 > 0
					&& balasDispPig_1.BalaAt(0).distancia(arma1) > 200) {
				balasDispPig_1.agregarAdelante(new bala(Herramientas
						.cargarImagen("img/Bala-Plateada.png"), this.arma1.x,
						this.arma1.y, this.arma1.angulo));
				municionPig_1 -= 1;
			}
			// Disparo con chancho 2
			if (this.entorno.estaPresionada('E') && balasDispPig_2.largo() == 0
					&& municionPig_2 > 0) {
				balasDispPig_2.agregarAdelante(new bala(Herramientas
						.cargarImagen("img/Bala-Plateada.png"), this.arma2.x,
						this.arma2.y, this.arma2.angulo));
				municionPig_2 -= 1;
			} else if (this.entorno.estaPresionada('E') && municionPig_2 > 0
					&& balasDispPig_2.BalaAt(0).distancia(arma2) > 200) {
				balasDispPig_2.agregarAdelante(new bala(Herramientas
						.cargarImagen("img/Bala-Plateada.png"), this.arma2.x,
						this.arma2.y, this.arma2.angulo));
				municionPig_2 -= 1;
			}
			
		}
//Si a alguno de los dos chanchitos se le terminaron las balas doy por finalizado el juego
		if(this.municionPig_1==0 && balasDispPig_1.largo()==0 ||  this.municionPig_2==0 && balasDispPig_2.largo()==0){
			estadoDeJuego = "TerminarJuego";
		}	
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
