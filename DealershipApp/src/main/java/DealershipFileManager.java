import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

public class DealershipFileManager {
    public static Dealership getDealership(){
        Dealership dealership=null;
        try {
            BufferedReader reader=new BufferedReader(new FileReader("../inventory.csv"));
       String headerLine= reader.readLine();
       String[] headerParts=headerLine.split("\\|");
       String name=headerParts[0];
       String address=headerParts[1];
       String phone=headerParts[2];
       dealership=new Dealership(name,address,phone);
        String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType =(parts[4]);
                String color=(parts[5]);
                int odometer=Integer.parseInt(parts[6]);
                double price=Double.parseDouble(parts[7]);
                Vehicle vehicle=new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
                dealership.addVehicle(vehicle);
        }
            reader.close();
        }catch (Exception e){
            System.out.println("Invalid File:" + e.getMessage());
        }
        return dealership;

    }
    public static void saveDealership(Dealership dealership){
        try {
            FileWriter writer=new FileWriter("../inventory.csv",true);
            writer.write(dealership.getName()+"|"+dealership.getAddress()+"|"+dealership.getPhone());
            for (Vehicle v: dealership.getAllVehicles()){
                writer.write(v.getVin()+"|"+ v.getYear()+"|"+v.getMake()+"|"+v.getModel()+"|"+v.getVehicleType()+"|"+v.getColor()+"|"+v.getOdometer()+"|"+v.getPrice());
            }
            writer.close();



        }catch (Exception e){
            System.out.println("Invalid:"+e.getMessage());
        }

    }


}
