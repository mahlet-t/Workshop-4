import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;

public class DealershipFileManager {
    public static void getDealership(){
        try {
            Dealership
        BufferedReader reader=new BufferedReader(new FileReader("inventory.csv"));
        reader.readLine();
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



        }
        }catch (Exception e){
            System.out.println("Invalid");
        }
    }

}
