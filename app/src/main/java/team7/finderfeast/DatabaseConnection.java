//package team7.finderfeast;
import androidx.appcompat.app.AppCompatActivity;

//import com.mongodb.ConnectionString;
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.MongoException;
//import com.mongodb.ServerAddress;
//
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.MongoCollection;
//
//import org.bson.Document;
//import java.util.Arrays;
//import com.mongodb.Block;
//
//import com.mongodb.client.MongoCursor;
//import static com.mongodb.client.model.Filters.*;
//import com.mongodb.client.result.DeleteResult;
//import static com.mongodb.client.model.Updates.*;
//import com.mongodb.client.result.UpdateResult;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DatabaseConnection  extends AppCompatActivity {
//    private String url = "https://developers.zomato.com/api/v2.1/";
//    private String keyCode = "d3b965d17f5d9cdd0c08e4d1d6ed47e2";
//    MongoClientURI connString = new MongoClientURI("mongodb+srv://pro200:pro200password@cluster0-jaeea.mongodb.net/test?retryWrites=true&w=majority");
//    MongoClient mongoClient = new MongoClient(connString);
//    MongoDatabase database = mongoClient.getDatabase("FinderFeastDB");
//    MongoCollection<Document> collection = database.getCollection("Users");
////    Document doc = new Document("name", "MongoDB")
////            .append("type", "database")
////            .append("count", 1)         /*THIS IS HOW YOU ADD DOCUMENTS TO THE DATABASE*/
////            .append("info", new Document("x", 203).append("y", 102));
////    collection.insertOne(doc);
//
//    public boolean AddUser(String firstName, String lastName, String username, String password, String email) {
//        try {
//            Document doc = new Document("username", username)
//                    .append("password", password)
//                    .append("firstName", firstName)
//                    .append("lastName", lastName)
//                    .append("email", email);
//            collection.insertOne(doc);
//        } catch (MongoException e) {
//            System.out.println("There has been a Mongo Exception in NewUser");
//            return false;
//        }
//        return true;
//    }
//}
