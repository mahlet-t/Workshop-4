
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private final Scanner input=new Scanner(System.in);
    public void init(){
         dealership=DealershipFileManager.getDealership();
    }

   public void display(){
        init();
       while (true) {
       displayMenu();
       int choice=input.nextInt();
       input.nextLine();

           switch (choice) {
               case 1:processGetByPriceRequest();break;
               case 2:processGetByMakeModelRequest();break;
               case 3:processGetByYearRequest();break;
               case 4:processGetByColorRequest();break;
               case 5:processGetByMileageRequest();break;
               case 6:processGetByVehicleType();break;
               case 7:processGetAllVehiclesRequest();break;
               case 8:processAddVehicleRequest();break;
               case 9:processRemoveVehicleRequest();break;
               case 10:
                   System.out.println("Good Bye!");return;
               default:
                   System.out.println("Invalid input try again");
           }
       }
   }
   private void displayMenu(){
       System.out.println("choose from the following option");
       System.out.println("1, Find vehicle within a price range");
       System.out.println("2, Find vehicle by make/model ");
       System.out.println("3, Find vehicle by year range ");
       System.out.println("4, Find vehicle by color");
       System.out.println("5, Find vehicle by mileage range ");
       System.out.println("6, Find vehicle by type ");
       System.out.println("7, List all vehicle");
       System.out.println("8, Add a vehicle");
       System.out.println("9, Remove a vehicle");
       System.out.println("10, Quit");
   }
   public void processGetByPriceRequest(){
       System.out.println("enter min price");
       double min=input.nextDouble();
       input.nextLine();
       System.out.println("enter max price");
       double max=input.nextDouble();
       input.nextLine();
       ArrayList<Vehicle> result=dealership.getVehiclesByPrice(min,max);
for (Vehicle vehicle:result){
    System.out.println(vehicle);
}

   }
   public void processGetByMakeModelRequest(){
       System.out.println("Enter make");
       String make=input.nextLine();
       System.out.println("enter model");
       String model=input.nextLine();
       ArrayList<Vehicle> result=dealership.getVehiclesByMakeModel(make,model);
       for (Vehicle vehicle:result){
           System.out.println(vehicle);
       }
   }
   public void processGetByYearRequest(){
       System.out.println("Enter min year");
       int min=input.nextInt();
       input.nextLine();
       System.out.println("Enter max year");
       int max=input.nextInt();
       input.nextLine();
       ArrayList<Vehicle> result=dealership.getVehiclesByYear(min,max);
       for (Vehicle vehicle:result){
           System.out.println(vehicle);
       }
   }
   public void processGetByColorRequest(){
       System.out.println("Enter the color");
       String color=input.nextLine();
       ArrayList<Vehicle> result=dealership.getVehiclesByColor(color);
       for (Vehicle vehicle:result){
           System.out.println(vehicle);
       }
   }
   public void processGetByMileageRequest(){
       System.out.println("Enter min mileage");
       int min= input.nextInt();
       input.nextLine();
       System.out.println("Enter max mileage");
       int max = input.nextInt();
       input.nextLine();
       ArrayList<Vehicle>result=dealership.getVehiclesByMileage(min,max);
       for (Vehicle vehicle:result){
           System.out.println(vehicle);
       }

   }
   public void processGetByVehicleType(){
       System.out.println("Enter vehicle type");
       String vehicleType=input.nextLine();
       ArrayList<Vehicle> result=dealership.getVehiclesByType(vehicleType);
       for (Vehicle vehicle:result){
           System.out.println(vehicle);
       }
   }
   public void processGetAllVehiclesRequest(){
        ArrayList<Vehicle> result=dealership.getAllVehicles();
        for (Vehicle vehicle:result){
            System.out.println(vehicle);
        }
   }
public void processAddVehicleRequest(){
    System.out.println("Enter VIN");
    int vin= input.nextInt();
    input.nextLine();
    System.out.print("Enter year: ");
    int year = input.nextInt();
    input.nextLine();

    System.out.print("Enter make: ");
    String make = input.nextLine();

    System.out.print("Enter model: ");
    String model = input.nextLine();

    System.out.print("Enter vehicle type: ");
    String type = input.nextLine();

    System.out.print("Enter color: ");
    String color = input.nextLine();

    System.out.print("Enter odometer: ");
    int odometer = input.nextInt();

    System.out.print("Enter price: ");
    double price = input.nextDouble();
    input.nextLine();

    Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
    dealership.addVehicle(vehicle);
    DealershipFileManager.saveDealership(dealership);
    System.out.println("Vehicle added successfully!");
}
public void processRemoveVehicleRequest(){
        System.out.print("Enter VIN of the vehicle to remove: ");
        int vinToRemove = input.nextInt();
        input.nextLine();
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();

        for (Vehicle v : inventory) {
            if (v.getVin() == vinToRemove) {
                dealership.removeVehicle(v);
                DealershipFileManager.saveDealership(dealership);
                System.out.println("Vehicle removed successfully.");
                return;
            }
        }

        System.out.println("Vehicle with that VIN not found.");
}



}
