public class Vehicle {
    private String vehicleType;
    private String brand;
    private String model;
    private int year;
    private int distance;
    private String VIN;

    public Vehicle(String vehicleType, String brand, String model, int year, int distance, String VIN) {
        this.vehicleType = vehicleType;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.distance = distance;
        this.VIN = VIN;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getVehicle(){
       return vehicleType +';'+brand+';'+model+';'+year+';'+distance+';'+VIN;
    }

    @Override
    public String toString() {
        return "Type='" + vehicleType + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", distance=" + distance +
                ", VIN='" + VIN + "'\n";
    }
}