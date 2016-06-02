/*package com.company;*/

import java.util.Scanner;
import java.util.Random;
/**
 * Classe Main
 * 
 * @author ies
 * 
 */
public class Main { /// Nom del programa cambiar per Main

    static protected String paraules[] = {"hola","programacio","casa"};
    static protected int index;
    static protected String paraula;
    
    /**
     * Constructor de la classe principal de l'aplicació
     * 
     * 
     * @param paraules Per determinar la bateria de paraules del joc
     * @param index Es el valor per escollir la paraula
     * @param p es el sustitut de les lletres per "_"
     *
     */
    
    public static void main(String[] args) {
        System.out.println("Comença el joc!");

        Random rand = new Random();
        index = rand.nextInt(3);
        paraula = "_";///Aixi ya no entra un null davant de la paraula que no permet jugar be.
        for (int i=1; i<paraules[index].length(); i++) {
            paraula += "_";
        }

        System.out.println(paraula);

        Scanner reader = new Scanner(System.in);

        int num_errors = 0;
        
        while (!paraula.equals(paraules[index]) && num_errors < 5) {
            if (!nova_lletra(reader.next().charAt(0))) {
                num_errors++;
                System.out.println("Numero d'errors restants " + (5-num_errors));///Contador d'errors visible
           
            }
            System.out.println(paraula);
        }
        reader.close();
        if(num_errors==5)
            	System.out.println("Has perdut.");///Missatge de perdre partida
        else
        	System.out.println("Has guanyat.");///Missatge de guanyar partida
   }
    /**
     * Constructor que identifica una lletra dins de la parula
     * 
     * @param nova la lletra que vols comprobar
     * @return retorna si la lletra esta o no.
     */
    static public boolean nova_lletra(char nova) {
        boolean trobada = false;
        String paraula_old = paraula;
        paraula = "";
        for (int i=0; i<paraules[index].length(); i++) {
            if (paraules[index].charAt(i) == nova) {
            	paraula += paraules[index].charAt(i);
                trobada = true;
            }
            else {
            	paraula += paraula_old.charAt(i);
            }
        }
        if (trobada == true)
                	System.out.println("Lletra trobada");///Troba la lletra
        else
        	System.out.println("Lletra no trobada");/// No troba la lletra
        return trobada;
    }

}

