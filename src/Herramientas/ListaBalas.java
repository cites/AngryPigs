package Herramientas;
import principal.bala;

public class ListaBalas {
	
	NodoBala primero;
	bala Bala;
	
	public ListaBalas(){
	}
	public String toString(){
		String cadena = "[ ";
		NodoBala n = primero;
		while (n!=null){
			cadena += n.elemento+")(";
			n = n.siguiente;
		}
		cadena += "]";
		return cadena;
	}
	public void agregarAdelante(bala x){
		NodoBala nuevo = new NodoBala();
		nuevo.elemento = x;
		nuevo.siguiente = this.primero;
		this.primero = nuevo;
	}
	
	public void agregarAtras(bala x){
		NodoBala nodo= this.primero;
		NodoBala newNodo = new NodoBala();
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
	public void quitar(bala x){
	NodoBala n=this.primero, anterior=null;
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

	public bala BalaAt(int i){
		NodoBala n=primero;
		bala BalaIndice=null;
		int cont=0;
		while(n!=null){
			if(cont==i){
				BalaIndice= n.elemento;
			}
			cont++;
			n=n.siguiente;
		}
		return BalaIndice;
	}
	
	public boolean pertenece(bala x){
		boolean esta=false;
		NodoBala n=this.primero;
		while(n!=null){
			if(x == n.elemento){
				esta = true;
			}
			n=n.siguiente;
		}
		return esta;
	}
	
	public int largo(){
		NodoBala n = primero;
		int cont = 0;
		while(n !=null){
			cont+=1;
			n = n.siguiente;
		}
		return cont;
	}
		
}

