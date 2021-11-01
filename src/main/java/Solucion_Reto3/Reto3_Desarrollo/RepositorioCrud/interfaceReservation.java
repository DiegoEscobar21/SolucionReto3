package Solucion_Reto3.Reto3_Desarrollo.RepositorioCrud;

import Solucion_Reto3.Reto3_Desarrollo.Modelo.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author diegoandres
 */

public interface interfaceReservation extends CrudRepository < Reservation, Integer > {   
    
    public List <Reservation> findAllByStatus(String status);
    
    public List <Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    @Query ("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)DESC")
    
    public List <Object[]> countTotalReservationsByClient();
    
}
