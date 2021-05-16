/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rip.Torres! ^-^
 */
public class ListaDP {
    private NodoDP ini;
    private NodoDP fin;
    
    public ListaDP(){
        ini = fin = null;
    }
    
    public boolean insertar(char d, int l){
        NodoDP nuevo = new NodoDP(d, l);
        if(nuevo == null) return false;
        if(hayListaDobleVacia()){
            ini = fin = nuevo;
            return true;
        }
        //COMPARACIONES EXPLICADAS EN EL VIDEO, 
        //PARA EL ORDENAMIENTO POR PRIORIDAD.
        if(nuevo.getLvl()>ini.getLvl()){
            ini.setAnt(nuevo);
            nuevo.setSig(ini);
            ini=nuevo;
            return true;
        }
        if(nuevo.getLvl()<=fin.getLvl()){
            fin.setSig(nuevo);
            nuevo.setAnt(fin);
            fin=nuevo;
            return true;
        }
        
        NodoDP T2 = fin.getAnt();
        
        T2.getSig().setAnt(nuevo);
        nuevo.setSig(T2.getSig());
        T2.setSig(nuevo);
        nuevo.setAnt(T2);
        return true;
    }
    
    public boolean hayListaDobleVacia(){
        return ini == null && fin == null;
    }
    
    public boolean eliminar(char d, int l){
        NodoDP temporal = null;
        if(hayListaDobleVacia()) return false;
        if(hayUnSoloNodo()){
            ini = fin = null;
            return true;
        }
        //POR SI QUEREMOS ELIMINAR EL PRIMERO
        if(ini.getDato()==d && ini.getLvl()==l){
            ini.setSig(temporal);
            temporal.setAnt(null);
            ini.setSig(null);
            ini=temporal;
            return true;
        }
        //POR SI QUEREMOS ELIMINAR EL ULTIMO
        if(fin.getDato()==d && fin.getLvl()==l){
            fin.setAnt(temporal);
            temporal.setSig(null);
            fin.setAnt(null);
            fin=temporal;
            return true;
        }
        
        //BUSCAR ALGUN VALOR A LO LARGO DE LA LISTA
        
        for(NodoDP temp = ini.getSig(); temp!=fin; temp = temp.getSig()){
            if(temp.getDato()==d && temp.getLvl()==l){
                temp.getAnt().setSig(temp.getSig());
                temp.getSig().setAnt(temp.getAnt());
                temp.setAnt(null);
                temp.setSig(null);
                return true;
            }
        }
        return false;
    }
    
    public boolean hayUnSoloNodo(){
        return ini==fin;
    }

    public NodoDP getIni() {
        return ini;
    }

    public NodoDP getFin() {
        return fin;
    }    
    
}
