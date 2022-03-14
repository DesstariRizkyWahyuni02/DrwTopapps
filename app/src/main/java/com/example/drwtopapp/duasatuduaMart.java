package com.example.drwtopapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class duasatuduaMart extends ListActivity {
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
                String smstext ="Desstari Rizky h/l";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:081268960252"));
                a.putExtra("sms_body",smstext);
            }
            else if (pilihan.equals("Driving Direction"))
            {
                String lokasimart = "https://www.google.com/maps/dir/0.4342532,101.3017898/supermarket+pekanbaru/@0.4475272,101.3068985,13z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x31d5a85c7a897791:0xcdc9949c49146fd9!2m2!1d101.380633!2d0.46407";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasimart));
            }else if (pilihan.equals("Info di Google"))
            {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"212 Mart");
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

