import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class AdminRunner {

    public static void main(String[] args){


        try {
            FileInputStream serviceAccount =
                    new FileInputStream("src/main/java/secret.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);

            APICalls caller = new APICalls();
            File arduinoData = new File("src/main/java/ArduinoData.txt");
            Scanner sc = new Scanner(arduinoData);
            sc.nextLine();
            while(sc.hasNextLine()){
                Scanner lr  = new Scanner(sc.nextLine());
                lr.useDelimiter(",");
                String pole_name = lr.next();
                double Co2_concentration = Double.parseDouble(lr.next());
                double battery_level = Double.parseDouble(lr.next());
                double tilt = Double.parseDouble(lr.next());
                caller.updatePole(new Pole(Co2_concentration, battery_level, tilt, pole_name));

            }

        }catch(Exception E){
            E.printStackTrace();
        }


    }
}
