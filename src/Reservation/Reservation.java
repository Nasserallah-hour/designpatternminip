package Reservation;

import java.time.LocalDateTime;
import Vol.Vol;
import java.util.Observable;
import java.util.Observer;

public class Reservation implements Observer {
    public int num;
    public LocalDateTime date;
    public Vol v;
    private Client client;
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Reservation has been notified");
    }

    public Reservation(int num, LocalDateTime date, Client client,Vol v) {
        this.num = num;
        this.date = date;
        this.client = client;
        this.v=v;
    }
}
