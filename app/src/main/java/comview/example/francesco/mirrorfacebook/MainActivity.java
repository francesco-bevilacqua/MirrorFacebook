package comview.example.francesco.mirrorfacebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Button butSearch;
    private Button butShow,butFriends,butMarket,butNot;
    private EditText et;
    private String Value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butShow = findViewById(R.id.button2);
        butFriends = findViewById(R.id.button3);
        butMarket = findViewById(R.id.button4);
        butNot = findViewById(R.id.button5);

        butSearch = findViewById(R.id.button1);
        EditText et = (EditText) findViewById(R.id.editText);

        butSearch.setEnabled(false); // set button disable initially

        et.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // TODO Auto-generated method stub

                if (s.toString().equals("")) {
                    butSearch.setEnabled(false);
                } else {
                    butSearch.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });



        View.OnClickListener gestore = new View.OnClickListener() {
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.button1:
                        Intent i0=new Intent(MainActivity.this, SearchResultsActivity.class);
                        Value=et.getText().toString();
                        i0.putExtra("Name",Value);
                        startActivity(i0);
                        break;
                    case R.id.button2:
                        Intent i1=new Intent(MainActivity.this, ListOptionActivity.class);
                        i1.putExtra("Id", "id123456789Show");
                        startActivity(i1);
                        break;
                    case R.id.button3:
                        Intent i2=new Intent(MainActivity.this, FriendsActivity.class);
                        i2.putExtra("Id", "id123456789Friends");
                        startActivity(i2);
                        break;
                    case R.id.button4:
                        Intent i3=new Intent(MainActivity.this, MarketActivity.class);
                        startActivity(i3);
                        break;
                    case R.id.button5:
                        Intent i4=new Intent(MainActivity.this, NotificationsActivity.class);
                        i4.putExtra("Id", "id123456789Market");
                        startActivity(i4);
                        break;
                }
            }
        };

        butShow.setOnClickListener(gestore);
        butFriends.setOnClickListener(gestore);
        butMarket.setOnClickListener(gestore);
        butNot.setOnClickListener(gestore);
        butSearch.setOnClickListener(gestore);


        ListView listView = (ListView) findViewById(R.id.listview);
        final String[] stuff = new String[]{"ItemShowcase1", "ItemShowcase2", "ItemShowcase3", "ItemShowcase4", "ItemShowcase5", "ItemShowcase6"};
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, R.layout.row, R.id.textViewList, stuff);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
                Intent i = new Intent(MainActivity.this, StuffActivity.class);
                i.putExtra("Item", stuff[pos]);
                startActivity(i);
            }
        });



    }



}

