package Solucion_Reto3.Reto3_Desarrollo.RepositorioCrud;

import Solucion_Reto3.Reto3_Desarrollo.Modelo.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author diegoandres
 */

public interface interfaceMessage extends CrudRepository < Message, Integer > {
      
}
