package Herramientas;

import principal.bird;

public class ListaBirds {
	
	NodoBird primero;
	bird pajarito;
	
	public ListaBirds(){
	}
	public String toString(){
		String cadena = "[ ";
		NodoBird n = primero;
		while (n!=null){
			cadena += n.elemento+")(";
			n = n.siguiente;
		}
		cadena += "]";
		return cadena;
	}
	public void agregarAdelante(bird x){
		NodoBird nuevo = new NodoBird();
		nuevo.elemento = x;
		nuevo.siguiente = this.primero;
		this.primero = nuevo;
	}
	
	public void agregarAtras(bird x){
		NodoBird nodo= this.primero;
		NodoBird newNodo = new NodoBird();
		if(nodo==null){
			agregarAdelante(x);
		}
		else{
			while(nodo.siguiente!=null){
					nodo=nodo.siguiente;
			}	
			nodo.siguiente=newNodo;
			newNodo.elemento=x;
			newNodo.siguiente=null;
		}
	}
	public void quitar(bird x){
	NodoBird n=this.primero, anterior=null;
	while(n!=null && n.elemento!=x){
			anterior=n;
			n=n.siguiente;
	}
	if ( n!= null ) {
		if (anterior == null)
			this.primero = n.siguiente;
	else
		anterior.siguiente = n.siguiente;
		}
	}

	public bird birdAt(int i){
		NodoBird n=primero;
		bird PajaroIndice=null;
		int cont=0;
		while(n!=null){
			if(cont==i){
				PajaroIndice= n.elemento;
			}
			cont++;
			n=n.siguiente;
		}
		return PajaroIndice;
	}
	
	public boolean pertenece(bird x){
		boolean esta=false;
		NodoBird n=this.primero;
		while(n!=null){
			if(x == n.elemento){
				esta = true;
			}
			n=n.siguiente;
		}
		return esta;
	}
	
	public int largo(){
		NodoBird n = primero;
		int cont = 0;
		while(n !=null){
			cont+=1;
			n = n.siguiente;
		}
		return cont;
	}
}

