package com.example.a15017381.p02_sgholidays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.category;

/**
 * Created by 15017381 on 28/4/2017.
 */

public class SecondActivity extends AppCompatActivity {
    ListView lv;
    TextView tvName;
    ArrayAdapter aa;
    ArrayList<SGHolidays> holidays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) this.findViewById(R.id.lvSGHolidays);
        tvName = (TextView) findViewById(R.id.tvName);

        holidays = new ArrayList<SGHolidays>();

        aa = new SGHolidaysAdapter(this, R.layout.row, holidays);
        lv.setAdapter(aa);

        Intent i = getIntent();
        String category = i.getStringExtra("category");
        tvName.setText(category);
//
        if(category.equals("Secular")){
            holidays.add(new SGHolidays("New Year's Day","1 Jan 2017","helmet"));
            holidays.add(new SGHolidays("Labour Day","1 May 2017","icecream"));
            holidays.add(new SGHolidays("National Day","9 Aug 2017","flag"));

        }else{
            holidays.add(new SGHolidays("Chinese New Year","28-29 Jan 2017","hongpao"));
            holidays.add(new SGHolidays("Good Friday","14 April 2017","friday"));
            holidays.add(new SGHolidays("Vesak Day","10 May 2017","flower"));
            holidays.add(new SGHolidays("Hari Raya Puasa","25 June 2017","harirayapuasa"));
            holidays.add(new SGHolidays("Hari Raya Haji","1 Sept 2017","harirayahaji"));
            holidays.add(new SGHolidays("Deepavali","18 Oct 2017","deepavali"));
            holidays.add(new SGHolidays("Christmas Day" ,"25 Dec 2017","christmas"));
        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SGHolidays selectedHol = holidays.get(position);

                Toast.makeText(SecondActivity.this, selectedHol.getName()
                                + " Date: " + selectedHol.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
