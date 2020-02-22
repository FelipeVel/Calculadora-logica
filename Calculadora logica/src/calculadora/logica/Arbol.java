 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.logica;

/**
 *
 * @author estudiantes
 */
public class Arbol {
    private Nodo raiz = null;
    String preOrden="";

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }
    
    public Arbol (String valor){
        this.raiz = new Nodo(valor);
    }
    
    public Arbol(){
        this.raiz=null;
    }
    
    public void agregarNodo(Nodo nodo, Nodo raiz){
        if (raiz==null){
            this.raiz=nodo;
            System.out.println("Nodo "+nodo.getElemento()+" agregado como raiz");
        }
        else{
            if(raiz.getHojaIzquierda()==null){
                raiz.setHojaIzquierda(nodo);
                System.out.println("Nodo "+nodo.getElemento()+" agregado a la izquierda de "+raiz.getElemento());   
            }
            else if(isNumeric(raiz.getHojaIzquierda().getElemento())&&raiz.getHojaIzquierda().getHojaDerecha()==null){
                agregarNodo(nodo,raiz.getHojaIzquierda());
            }
            else{
                raiz.setHojaDerecha(nodo);
                System.out.println("Nodo "+nodo.getElemento()+" agregado a la derecha de "+raiz.getElemento());
            }            
        }
    }
    
    public void agregarNodo(Nodo nodo){
        this.agregarNodo(nodo,this.raiz);
    }
    
    public void inOrder(Nodo nodo){
        if(nodo==null){
            System.out.println("El arbol esta vacio");
        }
        else{
            if(nodo.getHojaIzquierda()!=null)
                inOrder(nodo.getHojaIzquierda());
            preOrden = preOrden + nodo.getElemento();
            if(nodo.getHojaDerecha()!=null){
                inOrder(nodo.getHojaDerecha());                   
            }
            
        }
    }
    
    public void inOrder(){
        inOrder(this.raiz);
        System.out.println("In orden: "+preOrden);
    }
    
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
}
