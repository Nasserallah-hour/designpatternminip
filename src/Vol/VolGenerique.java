package Vol;

import java.sql.Time;
import java.time.Period;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class VolGenerique implements Observer {

    private String nom;
    private Time heureArrive;
    private Time heureDepart;

    protected Period duree;

    private Date jour;

    @Override
    public void update(Observable o, Object arg) {

    }
}
