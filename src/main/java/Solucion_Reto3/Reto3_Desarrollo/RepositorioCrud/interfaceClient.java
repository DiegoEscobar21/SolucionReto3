package Solucion_Reto3.Reto3_Desarrollo.RepositorioCrud;

import Solucion_Reto3.Reto3_Desarrollo.Modelo.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author diegoandres
 */

public interface interfaceClient extends CrudRepository < Client, Integer > {   
    
}
