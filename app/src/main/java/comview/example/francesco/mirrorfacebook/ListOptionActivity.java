package comview.example.francesco.mirrorfacebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListOptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_option);

        ListView listView = (ListView) findViewById(R.id.listview);
        final String[] option = new String[]{"Option1", "Option2", "Option3", "Option4", "Option5", "Option6"};
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, R.layout.row, R.id.textViewList, option);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
                Intent i = new Intent(ListOptionActivity.this, OptionsActivity.class);
                i.putExtra("Item", option[pos]);
                startActivity(i);
            }
        });



    }
}
