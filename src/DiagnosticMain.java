import java.util.LinkedList;
import java.util.Queue;

public class DiagnosticMain {
    public static void main(String[] args) {
        Queue<Vehicle> vehicle = new LinkedList<>();
//        vehicle.offer(new Vehicle("osobowy","Fiat", "500", 2017, 30000, "ABC2010010"));
//        vehicle.offer(new Vehicle("ciężarowy", "MAN", "T100", 2014, 20000,"ABB2010010"));
//        vehicle.offer(new Vehicle("motocykl", "BMW", "K3000", 2015, 10000,"AAB2010010"));

        Control control = new Control();
        control.userIntercom(vehicle);
//        System.out.println(vehicle);



    }
}
