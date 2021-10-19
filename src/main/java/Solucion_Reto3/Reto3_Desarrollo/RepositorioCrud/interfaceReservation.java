package Solucion_Reto3.Reto3_Desarrollo.RepositorioCrud;

import Solucion_Reto3.Reto3_Desarrollo.Modelo.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author diegoandres
 */

public interface interfaceReservation extends CrudRepository < Reservation, Integer > {   
    
}
