package com.example.drwtopapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SmanPlusPropRiau extends ListActivity {
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] listAct = new String[]{"Call Center", "Message", "Direction", "Website", "Google Info", "Exit"};
        this.setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listAct));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkan(pilihan);
    }

    private void tampilkan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Call Center")) {
                String tel = "tel:07616989999";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));
            } else if (pilihan.equals("Message")) {
                String msg = "Desstari Rizky Wahyuni/P";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:07616989999"));
                a.putExtra("sms_body", msg);
            } else if (pilihan.equals("Direction")) {
                String dir = "https://www.google.com/maps/dir/0.4691852,101.3544531/sman+8+pekanbaru/@0.4872202,101.3363694,12z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x31d5ae98ea15dfed:0xff85d7228db92685!2m2!1d101.4585275!2d0.5090783";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(dir));
            } else if (pilihan.equals("Website")) {
                String web = "http://www.sman8pku.sch.id/";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
            }else if (pilihan.equals("Google Info"))
            {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"SMAN Plus Prop Riau");
            } else if (pilihan.equals("Exit")) {
                finish();
            }
            startActivity(a);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
