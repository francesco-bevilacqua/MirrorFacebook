package comview.example.francesco.mirrorfacebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NotificationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        ListView listView = (ListView) findViewById(R.id.listview);
        final String[] notifications = new String[]{"Notification1", "Notification2", "Notification3", "Notification4", "Notification5", "Notification6"};
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, R.layout.row, R.id.textViewList, notifications);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
                Intent i = new Intent(NotificationsActivity.this, ItemNotify.class);
                i.putExtra("Notify", notifications[pos]);
                startActivity(i);
            }
        });


    }
}
