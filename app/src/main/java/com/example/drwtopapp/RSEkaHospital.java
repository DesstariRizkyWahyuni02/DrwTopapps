package com.example.drwtopapp;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSEkaHospital extends ListActivity {
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
                String dir = "https://www.google.com/maps/dir//Eka+Hospital+Pekanbaru,+Jl.+Ir+Soekarno-Hatta,+Tengkerang+Barat,+Pekanbaru+City,+Riau/@0.4823281,101.2805236,11z/data=!4m8!4m7!1m0!1m5!1m1!1s0x31d5a958ff468d7d:0x958ef365745c3ff7!2m2!1d101.4202668!2d0.4823295";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(dir));
            } else if (pilihan.equals("Website")) {
                String web = "https://www.ekahospital.com/id";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
            } else if (pilihan.equals("Google Info")) {
                String inf = "https://www.google.com/search?q=eka+hospital+pekanbaru&tbm=lcl&sxsrf=APq-WBvUhybdJoPPYvskfqFW1WredF08vQ%3A1646972034887&ei=gswqYvzZNZGgseMPpe2KuAU&oq=eka&gs_l=psy-ab.1.2.0i433i273k1l2j0i512i433k1l2j0i512k1j0i512i433k1j0i512k1j0i512i433i131k1j0i512i10k1j0i512i433k1.38823.40592.0.42798.3.3.0.0.0.0.85.223.3.3.0....0...1c.1.64.psy-ab..0.3.222...35i39k1j0i273k1j0i433i131k1j0i67k1j0i433k1.0.FDsYc8oLSY4";
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
