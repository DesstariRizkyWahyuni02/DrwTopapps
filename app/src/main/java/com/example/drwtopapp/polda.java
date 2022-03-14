package com.example.drwtopapp;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class polda extends ListActivity {
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
                String tel = "tel: (0761) 31307";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));
            } else if (pilihan.equals("Message")) {
                String msg = "Desstari Rizky Wahyuni/P";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms: (0761) 31307 "));
                a.putExtra("sms_body", msg);
            } else if (pilihan.equals("Direction")) {
                String dir = "https://www.google.com/maps/dir/0.4342532,101.3017898/polda+terdekat/@0.4705671,101.3097548,12z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x31d5aec14333e6f1:0xbcbc6a819ea27901!2m2!1d101.4578011!2d0.5105346";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(dir));
            } else if (pilihan.equals("Website")) {
                String web = "https://www.polri.go.id/";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
            } else if (pilihan.equals("Google Info")) {
                String inf = "https://www.google.com/search?sxsrf=APq-WBubFKPz1WECCkDJ-tX3ltFQIOgniw:1647063212875&q=polda+riau&sxsrf=APq-WBubFKPz1WECCkDJ-tX3ltFQIOgniw:1647063212875&sa=X&ved=2ahUKEwjJiOfN7L_2AhXTUGwGHYDpAFoQuzF6BAgBEAI&biw=1536&bih=735&dpr=1.25";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(inf));
            } else if (pilihan.equals("Exit")) {
                finish();
            }
            startActivity(a);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}