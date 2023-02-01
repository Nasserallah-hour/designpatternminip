import Models.AirRoute;
import Models.Ville;
import Reservation.Client;
import Reservation.Reservation;
import Vol.CompagnieAerienne;
import Vol.Vol;
import Vol.Aeroport;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        CompagnieAerienne ryanAir = new CompagnieAerienne("RyanAir", 1, new ArrayList<>());
        CompagnieAerienne tunisAir = new CompagnieAerienne("TunisAir", 2, new ArrayList<>());

        Client c1 = new Client("Ahmed", "Mohamed", "+2165325142", "+2163521542");
        Client c2 = new Client("Sami", "Karim", "+216532547855", "+2163425142");

        Ville tunis =new Ville("Tunis", "Tunisia");
        Ville marrakech = new Ville("Marrakech", "Morocco");
        Ville algier =new Ville("Algier", "Algeria");
        Ville tripoli = new Ville("Triploli", "Libya");
        Ville nouakchot = new Ville("Nouakchot", "Mauritania");

        ArrayList<Aeroport> aeroports = new ArrayList<Aeroport>();

        Aeroport mohamedV = new Aeroport("Aeroport Mohamed V",marrakech,new ArrayList<Vol>());
        aeroports.add(mohamedV);
        Aeroport tunisCarthage = new Aeroport("Aeroport Tunis Carthage",tunis,new ArrayList<Vol>());
        aeroports.add(tunisCarthage);
        Aeroport algierInternational = new Aeroport("Aeroport Algier International",algier,new ArrayList<Vol>());
        aeroports.add(tunisCarthage);

        Vol v1 = ryanAir.creeVol(new AirRoute(tunisCarthage, mohamedV), new Date(2022, 12, 11, 14, 20),
                new Date(2022, 12, 11, 16, 30),
                false, 50);
        Vol v2 = tunisAir.creeVol(new AirRoute(mohamedV, tunisCarthage), new Date(2022, 10, 13, 21, 30),
                new Date(2022, 10, 13, 23, 20),
                false, 110);

        v1.addReservation(c1);
        ryanAir.openReservationsForVol(v1);
        v1.addReservation(c1);
        tunisAir.openReservationsForVol(v2);
        v1.addReservation(c2);
        v2.addReservation(c2);


boolean proceed = false;

        while(true && !proceed) {
            System.out.print("\n Please enter the departure : ");
            Scanner s = new Scanner(System.in);
            String destination = s.next();
            System.out.print("\n Please enter the destination : ");
            String departure = s.next();
            System.out.println("Available flights to destination are :");
            List<Vol> foundVolsToDestination = aeroports.stream().flatMap(
                    element -> element.getSiege().stream().filter(
                            vol -> vol.getRoute().arrival.getLocation().name.toUpperCase().contains(destination.toUpperCase()) && vol.getRoute().departure.getLocation().name.toUpperCase().contains(departure.toUpperCase()) && vol.isEstOuvert()
                    )
            ).collect(Collectors.toList());
            foundVolsToDestination.stream().flatMap(elm ->
                            Stream.of(elm)).
                    forEach(v -> System.out.println("Flight REF "+v.getReference() + " Date " + v.getHeureDepart()+" Company "+v.getProvider().getNom()));
        }
    }


}