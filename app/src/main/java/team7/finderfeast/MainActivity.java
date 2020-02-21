package team7.finderfeast;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission();
        client = LocationServices.getFusedLocationProviderClient(this);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(ActivityCompat.checkSelfPermission(MainActivity.this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                RequestParams rp = new RequestParams();
                RestaurantConnection.get("categories", rp, new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(int statusCode, Header[] header, JSONObject response) {
                        // If the response is JSONObject instead of expected JSONArray
                        Log.d("asd", "---------------- this is response : " + response);
                        TextView textView = findViewById(R.id.categories);
                        textView.setText(response.toString());
                        try {
                            JSONObject serverResp = new JSONObject(response.toString());
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
//        RC.NewUser("Dan","Baydak","Tikalaka","password","baydadan001@gmail.com");
        Button button = findViewById(R.id.getLocation);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ActivityCompat.checkSelfPermission(MainActivity.this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }

                client.getLastLocation().addOnSuccessListener(MainActivity.this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if(location!= null) {
                            TextView textView = findViewById(R.id.location);
                            textView.setText("Latitude: " + location.getLatitude() + " \nLongitude:" + location.getLongitude());
                        }
                    }
                });
            }
        });
    }
    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, 1);
    }
}
