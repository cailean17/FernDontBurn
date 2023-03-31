import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

public class APICalls {

    private Firestore db;

    public APICalls(){
         this.db = FirestoreClient.getFirestore();
    }

    public void updatePole(Pole current_pole){
        try {
            ApiFuture<WriteResult> future = db.collection("San Jose Utility Poles").document(current_pole.get_Pole_Name()).set(current_pole.formatForAPi());
            future.get();
        } catch (Exception E){
            E.printStackTrace();
        }
    }
}
