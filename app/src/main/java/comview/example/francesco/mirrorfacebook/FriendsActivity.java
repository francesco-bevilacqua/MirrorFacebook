package comview.example.francesco.mirrorfacebook;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

import comview.example.francesco.mirrorfacebook.Network.OkHttpProvider;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FriendsActivity extends AppCompatActivity {

    private String temp;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        ListView listView = (ListView) findViewById(R.id.listview);
        final String[] friends = new String[]{"Friend1", "Friend2", "Friend3", "Friend4", "Friend5", "Friend6"};
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, R.layout.row, R.id.textViewList, friends);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
                temp=friends[pos];

                handler = new Handler(getMainLooper());
                getUrl();
            }
        });



    }
    private void getUrl() {

        OkHttpClient client = OkHttpProvider.getInstance().getOkHttpClient();
        Request request = new Request.Builder().url("https://it.wikipedia.org/wiki/"+temp).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                handler.post(() -> {
                    TextView tv = (TextView) findViewById(R.id.textView);
                    TextView tv3= findViewById(R.id.textView3);
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
