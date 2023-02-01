package Vol;
import Models.AirRoute;
import Reservation.Reservation;
import Reservation.Client;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Vol extends Observable {
    private String reference;
    private AirRoute route;
    private Date heureArrive;
    private Date heureDepart;
    private boolean estOuvert;
    private int nombreDesPlaces;
    private CompagnieAerienne provider;

    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();

    public Vol(AirRoute ar,Date heureArrive, Date heureDepart, boolean estOuvert, int nombreDesPlaces, CompagnieAerienne ca) {
        this.heureArrive = heureArrive;
        this.heureDepart = heureDepart;
        this.estOuvert = estOuvert;
        this.nombreDesPlaces = nombreDesPlaces;
        this.provider = ca;
        this.route = ar;
        this.addObserver(this.provider);
        this.addObserver(ar.departure);
        this.addObserver(ar.arrival);
        this.reference = "F"+this.provider.getNom().toUpperCase().charAt(0)+this.provider.getNumero();
        this.route.departure.getSiege().add(this);

    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
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
        notifyObservers(true);
    }

    public void fermeReservation() {
        estOuvert = false;
        notifyObservers(false);
    }

    public void addReservation(Client c) {
        if (estOuvert) {
            if (nombreDesPlaces > 0) {
                Reservation r = new Reservation(reservations.size(), LocalDateTime.now(), c,this);
                reservations.add(r);
                this.setChanged();
                notifyObservers(r);
                nombreDesPlaces--;
            } else {
                System.out.println("No more places available in this flight");
            }
        } else {
            System.out.println("This flight is not open for reservation yet");
        }
    }

    public AirRoute getRoute() {
        return route;
    }

    protected void openReservations(){
        estOuvert = true;
    }
    protected void closeReservations(){
        estOuvert = false;
    }

    public void setRoute(AirRoute route) {
        this.route = route;
    }

    public Date getHeureArrive() {
        return heureArrive;
    }

    public void setHeureArrive(Date heureArrive) {
        this.heureArrive = heureArrive;
    }

    public Date getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(Date heureDepart) {
        this.heureDepart = heureDepart;
    }

    public boolean isEstOuvert() {
        return estOuvert;
    }

    public void setEstOuvert(boolean estOuvert) {
        this.estOuvert = estOuvert;
    }

    public int getNombreDesPlaces() {
        return nombreDesPlaces;
    }

    public void setNombreDesPlaces(int nombreDesPlaces) {
        this.nombreDesPlaces = nombreDesPlaces;
    }

    public CompagnieAerienne getProvider() {
        return provider;
    }

    public void setProvider(CompagnieAerienne provider) {
        this.provider = provider;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}

