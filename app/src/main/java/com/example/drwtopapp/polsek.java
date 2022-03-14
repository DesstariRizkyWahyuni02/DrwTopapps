package com.example.drwtopapp;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class polsek extends ListActivity {
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
                String tel = "tel:(0761) 64110 ";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));
            } else if (pilihan.equals("Message")) {
                String msg = "Desstari Rizky Wahyuni/P";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms: (0761) 64110 "));
                a.putExtra("sms_body", msg);
            } else if (pilihan.equals("Direction")) {
                String dir = "https://www.google.com/maps/dir/0.4342532,101.3017898/Tampan+Sectoral+Police,+Gg.+Keluarga,+Simpang+Baru,+Tampan,+Pekanbaru+City,+Riau+28293/@0.4479255,101.3099703,13z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x31d5a858af8f27d3:0x4ce4c9be814dedc4!2m2!1d101.3879482!2d0.465117";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(dir));
            } else if (pilihan.equals("Website")) {
                String web = "https://www.google.com/search?q=polsek+tampan+pekanbaru&sxsrf=APq-WBvztaTYoBFmBvEbPtvBbAbXvUh6vw%3A1647058020206&ei=ZBwsYqCfDKiLseMP0sGc8A0&oq=&gs_lcp=Cgdnd3Mtd2l6EAEYATIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCC4Q6gIQJzINCC4QxwEQowIQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJ0oECEEYAEoECEYYAFAAWABg1BFoAnABeACAAQCIAQCSAQCYAQCgAQGwAQrAAQE&sclient=gws-wiz";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
            } else if (pilihan.equals("Google Info")) {
                String inf = "https://www.google.com/search?q=polsek+tampan+pekanbaru&sxsrf=APq-WBvztaTYoBFmBvEbPtvBbAbXvUh6vw%3A1647058020206&ei=ZBwsYqCfDKiLseMP0sGc8A0&oq=&gs_lcp=Cgdnd3Mtd2l6EAEYATIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCC4Q6gIQJzINCC4QxwEQowIQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJzIHCCMQ6gIQJ0oECEEYAEoECEYYAFAAWABg1BFoAnABeACAAQCIAQCSAQCYAQCgAQGwAQrAAQE&sclient=gws-wiz";
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
