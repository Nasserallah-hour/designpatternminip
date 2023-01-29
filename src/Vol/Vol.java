package Vol;

import Reservation.Reservation;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Vol extends Observable {
    private Date heureArrive;
    private Date heureDepart;
    private boolean estOuvert;

    private int nombreDesPlaces;

    @Override
    public synchronized void addObserver(Observer o) {
        if (o instanceof Reservation) {
            if (nombreDesPlaces > 0) {
                nombreDesPlaces--;
            } else {
                System.out.println("No more places available in this flight");
            }
        }
        super.addObserver((Observer) o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        if (o instanceof Reservation) {
            nombreDesPlaces++;
        }
        super.deleteObserver(o);
    }

    public void ouvrirReservation() {
        estOuvert = true;
        notifyObservers();
    }

    public void fermeReservation() {
        estOuvert = false;
        notifyObservers();
    }

}
