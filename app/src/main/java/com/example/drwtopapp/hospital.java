package com.example.drwtopapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class hospital extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] ListHospital = new String[] { "RS Awal Bross","RS Eka Hospital","RS Jiwa Tampan","RS Tabrani"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ListHospital));
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
            if (pilihan.equals("RS Awal Bross")){
                a = new Intent(this,RSAwalBross.class);
            } else if (pilihan.equals("RS Eka Hospital")) {
                a = new Intent(this, RSEkaHospital.class);
            } else if (pilihan.equals("RS Jiwa Tampan")) {
                a = new Intent(this, RSJiwaTampan.class);
            } else if (pilihan.equals("RS Tabrani")) {
                a = new Intent(this, RSArifin.class);
            }
            startActivity(a);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
