package Reservation;

import java.util.ArrayList;

public class Client {
    private String nom;
    private String prenom;
    private String numTel;
    private String numFax;

    private ArrayList<Reservation> listOfReservations= new ArrayList<Reservation>();

    public Client(String nom, String prenom, String numTel, String numFax) {
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.numFax = numFax;
    }

    void addReservationToClient(Reservation r){
        listOfReservations.add(r);
        System.out.println("RESERVATION " + r.num+ " HAS BEEN ADDED TO CLIENT "+this.nom +" "+this.prenom);
    }

    public ArrayList<Reservation> getListOfReservations() {
        return listOfReservations;
    }

    public void setListOfReservations(ArrayList<Reservation> listOfReservations) {
        this.listOfReservations = listOfReservations;
    }
}
