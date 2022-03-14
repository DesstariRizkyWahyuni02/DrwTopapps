package com.example.drwtopapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class supermarkett extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] Listsupermarket = new String[] { "Pesona Swalayan","Raya Swalayan","999 Mart","212 Mart Subrantas"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Listsupermarket));
    }

    protected void onListItemClick (ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }

    private void tampilkanpilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Pesona Swalayan")){
                a = new Intent(this,PesonaSwalayan.class);
            } else if (pilihan.equals("Raya Swalayan")) {
                a = new Intent(this, RayaSwalayan.class);
            } else if (pilihan.equals("999 Mart")) {
                a = new Intent(this, nineMart.class);
            } else if (pilihan.equals("212 Mart Subrantas")) {
                a = new Intent(this, duasatuduaMart.class);
            }
            startActivity(a);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
