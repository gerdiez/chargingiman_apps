package com.example.doadoa.View.Fragment;


import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.doadoa.Database.AppDatabase;
import com.example.doadoa.Entity.Doa;
import com.example.doadoa.R;
import com.example.doadoa.View.ListDoa;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBuku extends Fragment {

    private List<Doa> doaList;
    AppDatabase db;
    public FragmentBuku() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_buku, container, false);
        db = Room.databaseBuilder(getContext(), AppDatabase.class,"Doa").allowMainThreadQueries().build();

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ListDoa.class);
                startActivity(intent);
            }
        });

       // doaList = db.doaDao().getAll();
       // Log.d("tambah data",String.valueOf(doaList.size()));

        // Inflate the layout for this fragment
        return view;
    }

}
