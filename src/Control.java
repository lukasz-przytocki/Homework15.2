import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Control {

    private int welcomeScreen(String fileName) throws FileNotFoundException {
        checkSavedData(fileName);
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

    void userIntercom(String fileName) throws IOException {
        Queue<Vehicle> vehicleQueue=checkSavedData(fileName);
        int userSelection = welcomeScreen(fileName);
        switch (userSelection) {
            case 0:
                checkIfEmptyQueue(vehicleQueue);
                break;
            case 1:
                addVehicle(vehicleQueue);
                break;
            case 2:
                takeToDiagnostic(vehicleQueue);
        }

    }

    void saveData(Queue<Vehicle> vehicleQueue) throws IOException {
        FileWriter fileWriter = new FileWriter("file.csv");
        BufferedWriter bfw = new BufferedWriter(fileWriter);
        while (!vehicleQueue.isEmpty()) {
            bfw.write(vehicleQueue.poll().getVehicle());
            bfw.newLine();

        }
        bfw.close();

    }

    Queue<Vehicle> readData(String fileName) throws FileNotFoundException {
        Queue<Vehicle> vehicleQueue = new LinkedList<>();
         Scanner scan = new Scanner(new File(fileName));
        String[] tmp=null;
        while (scan.hasNextLine()){
            tmp = scan.nextLine().split(";");
            Vehicle  vehicle = new Vehicle(tmp[0], tmp[1], tmp[2], Integer.valueOf(tmp[3]), Integer.valueOf(tmp[4]), tmp[5]);
            vehicleQueue.offer(vehicle);
        }
        return vehicleQueue;
    }

    void checkIfEmptyQueue(Queue<Vehicle> vehicleQueue) throws IOException {
        if(!vehicleQueue.isEmpty()){
            saveData(vehicleQueue);
            System.out.println("Data saved. Goodbye!");
        }else{
            System.out.println("Empty queue. Goodbye!");
        }
    }

    Queue<Vehicle> checkSavedData(String fileName) throws FileNotFoundException {
        Queue<Vehicle> vehicle = new LinkedList<>();
        if(readData(fileName).size()!=0){
            vehicle=readData(fileName);
        }
        return vehicle;
    }



}
