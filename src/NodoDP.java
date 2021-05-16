/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rip.Torres! ^-^
 */
public class NodoDP {
    private char dato;
    private NodoDP sig;
    private NodoDP ant;
    private int lvl;
    
    public NodoDP(){
    }
    
    public NodoDP(char dato, int lvl){
        this.dato = dato;
        this.lvl = lvl;
        sig = ant = null;  
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public NodoDP getSig() {
        return sig;
    }

    public void setSig(NodoDP sig) {
        this.sig = sig;
    }

    public NodoDP getAnt() {
        return ant;
    }

    public void setAnt(NodoDP ant) {
        this.ant = ant;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
    
}
