package Solucion_Reto3.Reto3_Desarrollo.Servicios;

/**
Importaciones
*/
import Solucion_Reto3.Reto3_Desarrollo.Modelo.Reservation;
import Solucion_Reto3.Reto3_Desarrollo.Reportes.ContadorClientes;
import Solucion_Reto3.Reto3_Desarrollo.Reportes.StatusReservas;
import Solucion_Reto3.Reto3_Desarrollo.Repositorio.RepositorioReservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
Fin importaciiones
*/



/**
 *
 * @author diegoandres
 */

/**
service
*/

@Service

/**
Clase servicio Reservaciones
*/
public class serviciosReservation {
    /**
    Autowired
    */
    @Autowired
    /**
    metodos Crud
    */
    private RepositorioReservation metodosCrud;
    /**
    list reservation
    */
    public List<Reservation> getAll() {
        return metodosCrud.getAll();
    }
    /**
    optional reservation
    */
    public Optional<Reservation> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }
    /**
    reservation save 
    */
    public Reservation save(Reservation reservation) {
        /**
        codicion if
        */
        if (reservation.getIdReservation() == null) {
            return metodosCrud.save(reservation);
            /**
            condicion sino
            */
        } else {
            /**
            conidicion anidada
            */
            Optional<Reservation> evento5 = metodosCrud.getReservation(reservation.getIdReservation());
            /**
            condicion if
            */
            if (evento5.isEmpty()) {
                return metodosCrud.save(reservation);
            /**
            codicion else    
            */    
            } else {
                return reservation;
            }
            /**
            return reservation
            */
            
        }
        /**
        fin condicion
        */
        
    }
    /**
    Fin reservation save
    */
    
    /**
    inicion actualizar
    */
    public Reservation update(Reservation reservation) {
        
        /**
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
        /**
        fin condicion
        */
        
    }
    /**
    Fin Actualizar
    */
    
    
    /**
    Eliminar
    */ 
    public boolean deleteReservation(int reservationId) {
        Boolean eBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return eBoolean;
    }
    /**
    Fin Eliminar
    */
    
    
    /**
    Status Reservas
    */
    public StatusReservas getReporteStatusReservaciones(){
        
        List <Reservation> completed = metodosCrud.ReservacionStatus("completed");
        List <Reservation> cancelled = metodosCrud.ReservacionStatus("cancelled");
        return new StatusReservas(completed.size(), cancelled.size());
        
    }
    /**
    Fin Status Reservas
    */
    
    /**
    Reporte de fechas Reservaciones
    */
    public List <Reservation> getReportesTiempoReservaciones(String datoA, String datoB){
        
        /**
        Formato de fecha
        */
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        /**
        Fecha uno
        */
        Date datoUno = new Date();
        /**
        fecha dos
        */
        Date datoDos = new Date();
        
        try{
            
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
            
        } catch (ParseException evt){
            
            evt.printStackTrace();
                        
        } if (datoUno.before(datoDos)){
            
            return metodosCrud.ReservacionTiempo(datoUno, datoDos);
            
        } else {
            
            return new ArrayList <>();
            
        }
        /**
        Fin 
        */   
    }
    /**
    Fin reporte de fechas Reservaciones
    */
    
    /**
    Contador Clientes
    */
    public List <ContadorClientes> servicioTopClientes(){
        
        return metodosCrud.getTopClientes();
        
    }
    /**
    Fin contadorclientes
    */
    
}
/**
Fin clase Reservaciones
*/