package com.prasath.webtech2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    ListView l,l2;
    String departments[]
    = { "IT","ECE","EEE","RPT","CSE" };
    String activities[]=
            {"Unveiling the statue of Bharat Ratna Dr.A.P.J.Abdul Kalam(Former President of India)New",
                    "Foundation For Excellence India Trust Scholarship(FFE, AFE) for the year 2022-2023New",
                    "AMITA Scholarship UG and PG First Year 2022-2023New",
                    "SC/ST Scholarship - New FormNew",
                    "SC/ST Scholarship - Renewal FormNew",
                    "BC, MBS & DNC - New FormNew",
                    "BC, MBS & DNC - Renewal FormNew"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = (ListView)findViewById(R.id.list);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this, R.layout.simple_list_item_1,R.id.listView, departments);
        l.setAdapter(arr);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                String item= (String) adapterView.getItemAtPosition(i);
                intent.putExtra("dept",item);
                MainActivity.this.startActivity(intent);
            }
        });
        l2=findViewById(R.id.avt);
        ArrayAdapter<String> avtAdp=new ArrayAdapter<String>(this,R.layout.simple_list_item_1,R.id.listView,activities);
        l2.setAdapter(avtAdp);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    // Get a handle to the GoogleMap object and display marker.
    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(0, 0))
                .title("Marker"));
    }



//        l2=(ListView)findViewById(R.id.infrastructure);
//        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
//        for (int i = 0; i < infras.length; i++) {
//            Map<String, Object> datum = new HashMap<String, Object>(2);
//            datum.put("thumbnail", "@drawable/"+infras[i]);
//            datum.put("name", departments[i]);
//            data.add(datum);
//        }
//        l2.setAdapter(new SimpleAdapter(this, data, R.layout.infrastructure,
//                new String[] {"thumbnail","name"}, new int[] {R.id.img, R.id.imgCap}));

//        dept=(TextView)findViewById(R.id.it);
//        dept.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("hello world");
//                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
//                intent.putExtra("dept",dept.getText());
//                MainActivity.this.startActivity(intent);
//            }
//        });
}