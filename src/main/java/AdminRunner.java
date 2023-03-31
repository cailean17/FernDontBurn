import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;

public class AdminRunner {

    public static void main(String[] args){


        try {
            FileInputStream serviceAccount =
                    new FileInputStream("D:/Cailean/AP Comp Sci/FernDontBurn/secret.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);

            APICalls caller = new APICalls();
            caller.updatePole(new Pole(Math.random(), 20.0, 200.0, "Kooser Utiliy Pole 1"));
        }catch(Exception E){
            E.printStackTrace();
        }


    }
}
