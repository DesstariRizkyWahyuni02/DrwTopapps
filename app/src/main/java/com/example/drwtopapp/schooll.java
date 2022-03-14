package com.example.drwtopapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class schooll extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super.onCreate(icicle);
        String[] listschooll = new String[] {"SMK Taruna", "SMAN Plus Prop Riau",
                "SMAN 1 Pekanbaru", "SMA Muhammadiyah 01"};
        this.setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listschooll));
    }

    protected void onListItemClick (ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkan(pilihan);
    }

    private void tampilkan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("SMK Taruna")) {
                a = new Intent(this, SMKTaruna.class);

            } else if (pilihan.equals("SMAN Plus Prop Riau"))
            {
                a = new Intent(this, SmanPlusPropRiau.class);

            } else if (pilihan.equals("SMAN 1 Pekanbaru"))
            {
                a = new Intent(this, Sman1Pekanbaru.class);

            }else if (pilihan.equals("SMA Muhammadiyah 01"))
                a = new Intent(this, SMAMuhammadiyahsatu.class);
            {

            }
            startActivity(a);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}