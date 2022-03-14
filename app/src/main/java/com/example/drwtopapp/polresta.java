package com.example.drwtopapp;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class polresta extends ListActivity {
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
                String tel = "tel: 0761-21110 ";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));
            } else if (pilihan.equals("Message")) {
                String msg = "Desstari Rizky Wahyuni/P";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms: 0761-21110 "));
                a.putExtra("sms_body", msg);
            } else if (pilihan.equals("Direction")) {
                String dir = "https://www.google.com/maps/dir/0.4342532,101.3017898/Polresta+Pekanbaru,+Jl.+Jend.+Ahmad+Yani+No.11,+Sago,+Senapelan,+Pekanbaru+City,+Riau+28151/@0.483275,101.3054553,12z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x31d5ac0e5898027d:0xf09dd0c61bcb93e3!2m2!1d101.443234!2d0.5335557";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(dir));
            } else if (pilihan.equals("Website")) {
                String web = "http://www.polrestapekanbaru.com/";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
            } else if (pilihan.equals("Google Info")) {
                String inf = "https://www.google.com/search?q=polresta+pekanbaru&tbm=lcl&sxsrf=APq-WBu1JLzhFxaJBFZfqTnvMMUJjBGn3A%3A1647063375185&ei=TzEsYtLqCrGUseMP07mOIA&oq=polresta+pekanbaru&gs_l=psy-ab.3..35i39k1j0i203k1l6j0i22i30k1l3.4368.14784.0.16998.32.27.1.0.0.0.213.2157.18j6j1.26.0....0...1c.1.64.psy-ab..7.25.2407.10..0i512k1j35i362i39k1j0i273k1j0i433i273k1j0i512i433k1j0i512i433i131k1j0i512i263i20k1j0i512i263i433i20k1j0i10i203k1j0i10k1.402.H4IPwtIjC7A";
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
