package Solucion_Reto3.Reto3_Desarrollo.Reportes;

import Solucion_Reto3.Reto3_Desarrollo.Modelo.Client;

/**
 *
 * @author diegoandres
 */



public class ContadorClientes {
    
    private long total;
    private Client client;
    
    public ContadorClientes (Long total, Client client){
        
        this.total = total;
        this.client = client;
        
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    
    
}
