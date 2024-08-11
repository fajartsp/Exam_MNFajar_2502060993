package com.example.fajar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
//import java.util.Locale;
public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DataClass> dataList;
    MyAdapter adapter;
    DataClass androidData;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.search);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();
        androidData = new DataClass("Alabama", R.string.Alabama, "Population: 5028092", R.drawable.alabama);
        dataList.add(androidData);
        androidData = new DataClass("Alaska", R.string.Alaska, "Population: 734821", R.drawable.alaska);
        dataList.add(androidData);
        androidData = new DataClass("Arizona", R.string.Arizona, "Population: 7172282", R.drawable.arizona);
        dataList.add(androidData);
        androidData = new DataClass("Arkansas", R.string.Arkansas, "Population: 3018669", R.drawable.arkansas);
        dataList.add(androidData);
        androidData = new DataClass("California", R.string.California, "Population: 39356104", R.drawable.california);
        dataList.add(androidData);
        androidData = new DataClass("Colorado", R.string.Colorado, "Population: 5770790,", R.drawable.colorado);
        dataList.add(androidData);
        androidData = new DataClass("Delaware", R.string.Delaware, "Population: 993635", R.drawable.delaware);
        dataList.add(androidData);
        androidData = new DataClass("Florida", R.string.Florida, "Population: 21634529", R.drawable.florida);
        dataList.add(androidData);
        androidData = new DataClass("Hawaii", R.string.Hawaii, "Population: 1450589", R.drawable.hawaii);
        dataList.add(androidData);
        androidData = new DataClass("Indiana", R.string.Indiana, "Population: 6784403", R.drawable.indiana);
        dataList.add(androidData);
        androidData = new DataClass("NewYork", R.string.NewYork, "Population: 19994379", R.drawable.newyork);
        dataList.add(androidData);
        androidData = new DataClass("Texas", R.string.Texas, "KPopulation: 29243342", R.drawable.texas);
        dataList.add(androidData);
        androidData = new DataClass("Washington", R.string.Washington, "Population: 7688549", R.drawable.washington);
        dataList.add(androidData);
        androidData = new DataClass("PuertoRico", R.string.PuertoRico, "Population: 3272382", R.drawable.puertorico);
        dataList.add(androidData);
        adapter = new MyAdapter(MainActivity.this, dataList);
        recyclerView.setAdapter(adapter);
    }
    private void searchList(String text){
        List<DataClass> dataSearchList = new ArrayList<>();
        for (DataClass data : dataList){
            if (data.getDataTitle().toLowerCase().contains(text.toLowerCase())) {
                dataSearchList.add(data);
            }
        }
        if (dataSearchList.isEmpty()){
            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setSearchList(dataSearchList);
        }
    }
}