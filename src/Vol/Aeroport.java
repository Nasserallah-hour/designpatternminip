package Vol;

import Models.Ville;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Aeroport implements Observer {
    private String nom;
    private Ville location;
    private ArrayList<Vol> siege;


    public Aeroport(String nom, Ville location, ArrayList<Vol> siege) {
        this.nom = nom;
        this.location = location;
        this.siege = siege;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Ville getLocation() {
        return location;
    }

    public void setLocation(Ville location) {
        this.location = location;
    }

    public ArrayList<Vol> getSiege() {
        return siege;
    }

    public void setSiege(ArrayList<Vol> siege) {
        this.siege = siege;
    }

    @Override
    public void update(Observable o, Object arg) {
    }
}
