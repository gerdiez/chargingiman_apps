package com.gerdi.doadoa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ItemDetails extends AppCompatActivity {

    TextView nama, baca, latin, arti, carabaca, keutamaan, sumber, jenis;
    String coba, coba2, coba3, coba4, coba5,coba6,coba7,coba8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);

                setContentView(R.layout.item_details);

                final Intent intent = getIntent();

                coba = intent.getStringExtra("NAMA_DOA");
                coba2 = intent.getStringExtra("BACA_DOA");
                coba3 = intent.getStringExtra("LATIN_DOA");
                coba4 = intent.getStringExtra("artiDoa");
                coba5= intent.getStringExtra("carabacaDoa");
                coba6 = intent.getStringExtra("keutamaanDoa");
                coba7 = intent.getStringExtra("sumberDoa");
                coba8 = intent.getStringExtra("jenisDoa");

                nama = findViewById(R.id.doa);
                baca =findViewById(R.id.doa2);
        latin =findViewById(R.id.bacadoa2);
        arti =findViewById(R.id.bacadoa3);
        carabaca =findViewById(R.id.bacadoa4);
        keutamaan =findViewById(R.id.bacadoa);
        sumber =findViewById(R.id.bacadoa5);
//        jenis =findViewById(R.id.bacadoa);

        //Toast.makeText(ItemDetails.this, coba2, Toast.LENGTH_LONG).show();

                nama.setText(coba);
                baca.setText(coba2);
        latin.setText(coba3);
        arti.setText(coba4);
        carabaca.setText(coba5);
        keutamaan.setText(coba6);
        sumber.setText(coba7);
//        jenis.setText(coba8);

    }
        }


