package com.example.doadoa.View;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.doadoa.Adapter.DoaAdapter;
import com.example.doadoa.Database.AppDatabase;
import com.example.doadoa.Entity.Doa;
import com.example.doadoa.ItemDetails;
import com.example.doadoa.R;

import java.util.HashMap;
import java.util.List;

public class ListDoa extends AppCompatActivity{

    public static AppDatabase db;
    private List<Doa> doaList;
    private RecyclerView recyclerView;
    private DoaAdapter doaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_doa);

        db = Room.databaseBuilder(this, AppDatabase.class,"Doa").allowMainThreadQueries().build();
        doaList = db.doaDao().getAll();

        recyclerView = findViewById(R.id.rvlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        doaAdapter=new DoaAdapter(doaList);
        recyclerView.setAdapter(doaAdapter);

        doaAdapter.setOnCallbackListener(new DoaAdapter.OnCallbackListener() {
            @Override
            public void onClick(Doa doa) {



                Intent intent = new Intent(ListDoa.this, ItemDetails.class);
                String id = String.valueOf(doa.getDoaid());

                intent.putExtra("id", id);
                intent.putExtra("NAMA_DOA", doa.getNamaDoa());
                intent.putExtra("BACA_DOA", doa.getBacaDoa());
                intent.putExtra("LATIN_DOA", doa.getLatinDoa());
                intent.putExtra("artiDoa", doa.getArtiDoa());
                intent.putExtra("carabacaDoa", doa.getCarabacaDoa());
                intent.putExtra("keutamaanDoa", doa.getKeutamaanDoa());
                intent.putExtra("sumberDoa", doa.getSumberDoa());
                intent.putExtra("jenisDoa", doa.getJenisDoa());

                //Toast.makeText(ListDoa.this, doa.getNamaDoa(),Toast.LENGTH_LONG).show();

                startActivity(intent);
            }
        });


    }
}
