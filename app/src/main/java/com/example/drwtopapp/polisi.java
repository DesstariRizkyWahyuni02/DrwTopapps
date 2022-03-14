package com.example.drwtopapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class polisi extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super.onCreate(icicle);
        String[] listpolis = new String[] {"Polsek Tampan","Polda Riau","Polresta Pekanbaru"};
        this.setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listpolis));
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
            if (pilihan.equals("Polsek Tampan")) {
                a = new Intent(this, polsek.class);
            } else if (pilihan.equals("Polda Riau")) {
                a = new Intent(this, polda.class);
            } else if (pilihan.equals("Polresta Pekanbaru")) {
                a = new Intent(this, polresta.class);
            }
            startActivity(a);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
