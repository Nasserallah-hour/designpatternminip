package Models;

import Vol.Aeroport;

public class AirRoute {
    public Aeroport departure;
    public Aeroport arrival;
    public AirRoute(Aeroport departure, Aeroport arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }
}
