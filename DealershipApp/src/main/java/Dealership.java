import java.util.ArrayList;

public class Dealership {
    private final String name;
    private final String address;
    private final String phone;
    private final ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory=new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max){
        ArrayList<Vehicle>result=new ArrayList<>();
        for (Vehicle vehicle:inventory){
            if (vehicle.getPrice()>=min&&vehicle.getPrice()<=max){
                result.add(vehicle);

            }
        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make,String model){
        ArrayList<Vehicle> result=new ArrayList<>();
        for (Vehicle vehicle:inventory){
            if (vehicle.getMake().equalsIgnoreCase(make)&&vehicle.getModel().equalsIgnoreCase(model)){
                result.add(vehicle);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByYear(int min,int max){
        ArrayList<Vehicle> result=new ArrayList<>();
        for (Vehicle vehicle:inventory){
            if (vehicle.getYear()>=min&&vehicle.getYear()<=max){
                result.add(vehicle);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> result=new ArrayList<>();
        for (Vehicle vehicle:inventory){
            if (vehicle.getColor().equalsIgnoreCase(color)){
                result.add(vehicle);
            }
        }

        return result;
    }
    public ArrayList<Vehicle> getVehiclesByMileage(double min,double max){
        ArrayList<Vehicle> result=new ArrayList<>();
        for (Vehicle vehicle:inventory){
            if (vehicle.getOdometer()>=min&& vehicle.getOdometer()<=max){
                result.add(vehicle);
            }
        }
            return result;
    }
    public ArrayList<Vehicle> getVehiclesByType(String vehicleType){
        ArrayList<Vehicle> result=new ArrayList<>();
        for (Vehicle vehicle:inventory){
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                result.add(vehicle);
            }
        }
        return result;
    }
    public ArrayList<Vehicle> getAllVehicles(){
        return inventory;
    }
    public void addVehicle(Vehicle vehicle){
       inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);

    }
}
