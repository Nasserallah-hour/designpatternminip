package Vol;

import Models.AirRoute;
import Reservation.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class CompagnieAerienne implements Observer {
    private String nom;
    private int numero;
    private ArrayList<Vol> listOfFlights;

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Reservation){
            System.out.println("Compagnie Aierienne "+ this.nom +" has got a new reservation number "+((Reservation) arg).num);
        }

    }

    public CompagnieAerienne(String nom, int numero, ArrayList<Vol> listOfFlights) {
        this.nom = nom;
        this.numero = numero;
        this.listOfFlights = listOfFlights;
    }

    public Vol creeVol(AirRoute ar, Date heureAller, Date heureArrive, boolean estOuvert, int nombredeplaces){
        Vol v =new Vol(ar,heureArrive,heureAller,estOuvert,nombredeplaces,this);
        this.listOfFlights.add(v);
        v.addObserver(this);
        return v;
    }

    public void openReservationsForVol(Vol v){
        if(listOfFlights.contains(v)){
            System.out.println(this.nom + " is opening the reservations for flight "+v.getRoute().departure.getNom()+ " to "+v.getRoute().arrival.getNom());
            v.openReservations();
        }
    }
    public void closeReservationsForVol(Vol v){
        if(listOfFlights.contains(v)){
            System.out.println(this.nom + " is closing the reservations for flight "+v.getRoute().departure.getNom()+ " to "+v.getRoute().arrival.getNom());
            v.closeReservations();
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Vol> getListOfFlights() {
        return listOfFlights;
    }

    public void setListOfFlights(ArrayList<Vol> listOfFlights) {
        this.listOfFlights = listOfFlights;
    }
}
