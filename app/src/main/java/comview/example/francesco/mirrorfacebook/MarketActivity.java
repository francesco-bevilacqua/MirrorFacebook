package comview.example.francesco.mirrorfacebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MarketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        GridView Gridview = (GridView) findViewById(R.id.gridview);
        final String[] market=new String[]{"ItemMarket1","ItemMarket2","ItemMarket3","ItemMarket4","ItemMarket5", "ItemMarket6"};
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, R.layout.row, R.id.textViewList, market);
        Gridview.setAdapter(arrayAdapter);
        Gridview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos, long id)
            {
                Intent i = new Intent(MarketActivity.this, ItemMarketActivity.class);
                i.putExtra("itemarket", market[pos]);
                startActivity(i);
            }
        });


    }
}
