package Reservation;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Reservation implements Observer {
    public int num;
    public Date date;
    @Override
    public void update(Observable o, Object arg) {

    }
}
