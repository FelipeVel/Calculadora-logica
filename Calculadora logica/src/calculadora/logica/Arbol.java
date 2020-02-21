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

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }
    
    public Arbol (String valor){
        this.raiz = new Nodo(valor);
    }
    
    public void agregarNodo(Nodo nodo, Nodo raiz){
        if (raiz==null){
            this.setRaiz(nodo);
        }
        if(raiz.getHojaIzquierda()==null){
            raiz.setHojaIzquierda(nodo);
        }
        else if(isNumeric(raiz.getHojaIzquierda().getElemento())){
            agregarNodo(nodo,raiz.getHojaIzquierda());
        }
        else{
            agregarNodo(nodo,raiz.getHojaDerecha());
        }
    }
    
    public void agregarNodo(Nodo nodo){
        this.agregarNodo(nodo,this.raiz);
    }
    
    public void inOrder(Nodo nodo){
        Nodo p=this.raiz;
        
        if(p==null){
            System.out.println("El arbol esta vacio");
        }
        else{
            if(p.getHojaIzquierda()!=null){
                inOrder(p.getHojaIzquierda());
            }
            else{
                System.out.println(p.getElemento());
                inOrder(p.getHojaDerecha());
            }
        }
    }
    
    public void inOrder(){
        inOrder(this.raiz);
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
