/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GX505DT
 */
public class ColaConPrioridad {
    protected Data[] cola = new Data[10];
    protected int ini = -1;
    protected int fin = -1;
    protected Data valorEliminado;
    
    public ColaConPrioridad(){
        //Ciclo for para construir en cada celdilla un objeto Data
        for(int i=0; i<cola.length; i++){
            cola[i] = new Data();
        }
    }
    
    public boolean insertar(Data dato){
        if(fin == cola.length-1){
            return false;
        }
        fin++;
        cola[fin] = dato;
        if(ini==-1 && fin==0){
            ini++;
        }
        OrdenarPrioridad();
        
        return true;
    }
    
    public boolean eliminar(){
        if(ini==-1 && fin==-1){
            return false;
        }
        valorEliminado = cola[ini];
        if(ini==fin && ini!=-1){
            ini=-1;
            fin=-1;
            return true;
        }
        ini++;
        
        return true;
    }
    
    public boolean insertarINI(Data dato){
        if(ini == 0){
            return false;
        }
        if(ini == -1 && fin == -1){
            ini=fin=0;
            cola[ini] = dato;
            return true;
        } else {
            ini = ini-1;
            cola[ini] = dato;
            return true;
        }
    }
    
    public boolean eliminarFIN(){
        if(ini==-1 && fin==-1){
            return false;
        }
        valorEliminado = cola[fin];
        if(ini==fin && ini!=-1){
            ini=-1;
            fin=-1;
            return true;
        }
        fin--;
        
        return true;
    }
    
    private void OrdenarPrioridad(){
        
        if(fin == 0){
            //hay 1 solo elemento insertado porque cola estaba vacía
            return;
        }
        //el siguiente for evalua cuando hay muchos elementos
        for(int temp = fin;
                temp != ini && cola[temp].prioridad > cola[temp-1].prioridad
                ; temp--){
            Data intercambio = new Data();
            int anterior = temp-1;
            
            //salvando los datos de la celdilla anterior
            intercambio.valor = cola[anterior].valor;
            intercambio.prioridad = cola[anterior].prioridad;
            
            //sobreescribiendo
            cola[anterior].valor = cola[temp].valor;
            cola[anterior].prioridad = cola[temp].prioridad;
            
            //moviendo los valores
            cola[temp].valor = intercambio.valor;
            cola[temp].prioridad = intercambio.prioridad;
        }
        
    }
    
    
    public Data valorEliminado(){
        return valorEliminado;
    }
    
    public int valorINI(){
        return ini;
    }
    
    public int valorFIN(){
        return fin;
    }
    
    public Data[] contenidoCola(){
        return cola;
    }
    
    
}
