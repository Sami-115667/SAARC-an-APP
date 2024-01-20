package com.example.saarc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] Countrynames;
    private SearchView searchView;
    private ListView listView;
    private int[] flags={R.drawable.afg,R.drawable.ban1,R.drawable.bhut, R.drawable.ind,
            R.drawable.mal, R.drawable.nep,R.drawable.pak, R.drawable.sri};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Countrynames =getResources().getStringArray(R.array.Country);
        listView=findViewById(R.id.listviewid);
        searchView=findViewById(R.id.searchviewid);
        CustomAdapter adapter=new CustomAdapter(this,Countrynames,flags);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(MainActivity.this,Details.class);
                TextView textView = view.findViewById(R.id.countryname);
                String name = textView.getText().toString();
               // int x=position;
               // String numberAsString = Integer.toString(x);
                intent.putExtra("Number",name);
                //Toast.makeText(MainActivity.this,numberAsString,Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });






    }
}