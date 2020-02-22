/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.logica;

import java.util.Scanner;

/**
 *
 * @author estudiantes
 */

//((p1q)2p)1(p1(p2q))
public class CalculadoraLogica {
    static Scanner sc = new Scanner(System.in);
    public static Arbol arbol = new Arbol();
    public static void main(String[] args) {
        System.out.println("Conectores:\n"
                + "\t1:Y\n"
                + "\t2:O\n"
                + "\t3:Entonces\n"
                + "\t4:Si y solo si\n"
                + "\t5:Negacion");
        System.out.print("Digite la proposicion (Ejemplo: p1q): ");
        String proposicion = sc.nextLine();
        cortar(proposicion);
        arbol.inOrder();
    }
    
    public static void cortar(String str, Nodo nodo){
        int cont =0;
        int i =0;
        int aux=0;
        do{
            if(str.charAt(i)=='('){
                cont++;
                aux=1;
            }
            else if (str.charAt(i)==')'){
                cont--;         
            }
            i++;
        }while(cont!=0 && i<str.length());
        Nodo a;
        if(str.length()==3){
            a = new Nodo(""+str.charAt(1));
        }
        else if(str.length()==1){
            a = new Nodo(""+str.charAt(0));
        }
        else{
            a = new Nodo(""+str.charAt(i));
        }
        arbol.agregarNodo(a, nodo);
        
        
        if(str.length()>1){
            if(i-1!=aux){
                cortar(str.substring(aux,i-1),a);               
            }
            else{
                arbol.agregarNodo(new Nodo(""+str.charAt(0)),a);
            }
            if(str.length()-i>3)
                cortar(str.substring(i+2,str.length()-1));
            else
                cortar(str.substring(i+1),a);            
            
            
        }
    }
    
    public static void cortar (String str){
        cortar(str,arbol.getRaiz());
    }
}
