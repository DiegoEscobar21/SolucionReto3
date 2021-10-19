package Solucion_Reto3.Reto3_Desarrollo.Servicios;

/*
Importaciones
*/
import Solucion_Reto3.Reto3_Desarrollo.Modelo.Reservation;
import Solucion_Reto3.Reto3_Desarrollo.Repositorio.RepositorioReservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diegoandres
 */

/*
service
*/

@Service

/*
Clase servicio Reservaciones
*/
public class serviciosReservation {
    /*
    Autowired
    */
    @Autowired
    /*
    metodos Crud
    */
    private RepositorioReservation metodosCrud;
    /*
    list reservation
    */
    public List<Reservation> getAll() {
        return metodosCrud.getAll();
    }
    /*
    optional reservation
    */
    public Optional<Reservation> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }
    /*
    reservation save 
    */
    public Reservation save(Reservation reservation) {
        /*
        codicion if
        */
        if (reservation.getIdReservation() == null) {
            return metodosCrud.save(reservation);
            /*
            condicion sino
            */
        } else {
            /*
            conidicion anidada
            */
            Optional<Reservation> evento5 = metodosCrud.getReservation(reservation.getIdReservation());
            /*
            condicion if
            */
            if (evento5.isEmpty()) {
                return metodosCrud.save(reservation);
            /*
            codicion else    
            */    
            } else {
                return reservation;
            }
            /*
            return reservation
            */
            
        }
        /*
        fin condicion
        */
        
    }
    /*
    Fin reservation save
    */
    
    /*
    inicion actualizar
    */
    public Reservation update(Reservation reservation) {
        
        /*
        condicion
        */
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> evento5 = metodosCrud.getReservation(reservation.getIdReservation());
            if (!evento5.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    evento5.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    evento5.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    evento5.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(evento5.get());
                return evento5.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
        /*
        fin condicion
        */
        
    }
    /*
    Fin Actualizar
    */
    
    
    /*
    Eliminar
    */ 
    public boolean deleteReservation(int reservationId) {
        Boolean eBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return eBoolean;
    }
    /*
    Fin Eliminar
    */
    
}

/*
Fin clase Reservaciones
*/