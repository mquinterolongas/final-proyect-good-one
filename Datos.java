
import java.util.ArrayList;
public class Datos {
    public String station;
    public String name;
    public String date;
    public String prcp;
    public String tavg;
    public String tmax;
    public String tmin;
    public Datos(ArrayList<String> a) {
        this.station = a.get(0);
        this.name = a.get(1);
        this.date = a.get(2);
        this.prcp = a.get(3);
        this.tavg = a.get(4);
        this.tmax = a.get(5);
        this.tmin = a.get(6);
    }
    public String getName(){
        return this.name;
    }
    public String getStation(){
        return this.station;
    }
    public String getDate(){
        return this.date;
    }
    public String getPrcp(){
        return this.prcp;
    }
    public String getTavg(){
        return this.tavg;
    }
    public String getTmax(){
        return this.tmax;
    }
    public String getTmin(){
        return this.tmin;
    }
    
}

