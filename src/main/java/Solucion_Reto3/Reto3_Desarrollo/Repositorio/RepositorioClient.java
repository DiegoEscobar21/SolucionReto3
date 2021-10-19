package Solucion_Reto3.Reto3_Desarrollo.Repositorio;

import Solucion_Reto3.Reto3_Desarrollo.Modelo.Client;
import Solucion_Reto3.Reto3_Desarrollo.RepositorioCrud.interfaceClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author diegoandres
 */

@Repository

public class RepositorioClient {
   
    @Autowired
    
    private interfaceClient crud2;
    
    public List<Client> getAll(){
        return (List<Client>) crud2.findAll();               
    }
    
    public Optional<Client> getClient(int id){
        return crud2.findById(id);       
    }
    
    public Client save(Client client){
        return crud2.save(client);
    }
    
    public void delete(Client client){
        crud2.delete(client);
    }
    
}
