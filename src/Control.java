import java.util.Queue;
import java.util.Scanner;

public class Control {

    private int welcomeScreen() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter option \n 0: Exit \n 1: Add new vehicle \n 2: Examine ");
        int userSelection = scan.nextInt();
        scan.nextLine();
        return userSelection;
    }

    private void addVehicle(Queue vehicleQueue) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter vehicle type: ");
        String type = scan.nextLine();
        System.out.println("Enter brand: ");
        String brand = scan.nextLine();
        System.out.println("Enter model: ");
        String model = scan.nextLine();
        System.out.println("Enter production year: ");
        int year = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter distance: ");
        int distance = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter VIN: ");
        String vin = scan.nextLine();

        vehicleQueue.offer(new Vehicle(type, brand, model, year, distance, vin));

    }

    private void takeToDiagnostic(Queue vehicleQueue) {
        System.out.println("Vehicle is taken to diagnostic: " + vehicleQueue.poll());
    }

    void userIntercom(Queue vehicleQueue){
        int userSelection = welcomeScreen();
        switch (userSelection){
            case 0:
                System.out.println("Goodbye!");
                break;
            case 1:
                addVehicle(vehicleQueue);
                break;
            case 2:
                takeToDiagnostic(vehicleQueue);
        }

    }

}
