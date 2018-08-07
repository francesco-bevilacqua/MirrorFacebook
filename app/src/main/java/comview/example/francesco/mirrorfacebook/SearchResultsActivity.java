package comview.example.francesco.mirrorfacebook;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import comview.example.francesco.mirrorfacebook.Network.OkHttpProvider;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SearchResultsActivity extends AppCompatActivity {

    private Handler handler;
    private Button butPhoto,butVideo,butInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Intent i= getIntent();
        String value = i.getStringExtra("Name");
        TextView title = findViewById(R.id.textView4);
        String finaValue= value + "'s Profile";
        title.setText(finaValue);


        handler = new Handler(getMainLooper());
        getUrl();




    }

    private void getUrl() {

        Intent i =getIntent();
        String value = i.getStringExtra("Name");


        OkHttpClient client = OkHttpProvider.getInstance().getOkHttpClient();
        Request request = new Request.Builder().url("https://it.wikipedia.org/wiki/"+value).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                handler.post(() -> {
                    TextView tv = (TextView) findViewById(R.id.textView);
                    try {
                        tv.setText(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        });

    }




}
