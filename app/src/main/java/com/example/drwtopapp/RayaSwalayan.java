package com.example.drwtopapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RayaSwalayan extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] ListAct = new String[] { "Call Center","SMS Center","Driving Direction","Info di Google","Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ListAct));
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
            if (pilihan.equals("Call Center")){
                String nomortel ="tel:0761-8782364";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomortel));

            }else if (pilihan.equals("SMS Center"))
            {
                String smstext ="Desstari Rizky Wahyuni /P";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:081268960252"));
                a.putExtra("sms_body",smstext);
            }
                else if (pilihan.equals("Driving Direction"))
                {
                    String lokasimart = "https://g.co/kgs/AQqSd6";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasimart));
            }else if (pilihan.equals("Info di Google"))
            {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Raya Swalayan");
            }else if (pilihan.equals("Exit")) {
                finish();
            }

            startActivity(a);

        }   catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
