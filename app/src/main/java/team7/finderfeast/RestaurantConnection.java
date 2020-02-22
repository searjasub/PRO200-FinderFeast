package team7.finderfeast;

import android.app.DownloadManager;
import android.util.Log;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class RestaurantConnection  {
    private static final String BASE_URL = "https://developers.zomato.com/api/v2.1/";
    private static String keyCode = "d3b965d17f5d9cdd0c08e4d1d6ed47e2";
    private static String result;
        private static AsyncHttpClient client = new AsyncHttpClient();

        public static String get(String url, RequestParams params) {
            client.addHeader("user-key", keyCode);
            client.get(getAbsoluteUrl(url), params, new JsonHttpResponseHandler(){
                @Override
                public void onSuccess(int statusCode, Header[] header, JSONObject response) {
                    // If the response is JSONObject instead of expected JSONArray
                    Log.d("asd", "---------------- this is response : " + response);
                    result = response.toString();
                    try {
                        JSONObject serverResp = new JSONObject(response.toString());
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
            return result;
        }
        public static String getNearby(double lat, double lon, double radius) {
            RequestParams rp = new RequestParams();
            if(radius == 0) {
                radius = 10;
            }
            rp.add("lat", Double.toString(lat));
            rp.add("lon", Double.toString(lon));
            rp.add("radius", Double.toString(radius));
            return get("/search", rp);
        }
        public static String getCategories() {
            return get("/categories", new RequestParams());
        }
        private static String getAbsoluteUrl(String relativeUrl) {
            return BASE_URL + relativeUrl;
        }
}
