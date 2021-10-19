package Solucion_Reto3.Reto3_Desarrollo.RepositorioCrud;

import Solucion_Reto3.Reto3_Desarrollo.Modelo.Doctor;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author diegoandres
 */

public interface interfaceDoctor extends CrudRepository < Doctor, Integer > {
      
}
