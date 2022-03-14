package com.example.drwtopapp;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSArifin extends ListActivity {
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
                String tel = "tel: (0761) 21618";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));
            } else if (pilihan.equals("Message")) {
                String msg = "Desstari Rizky Wahyuni/P";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms: (0761) 21618"));
                a.putExtra("sms_body", msg);
            } else if (pilihan.equals("Direction")) {
                String dir = "https://g.co/kgs/6wCrmu";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(dir));
            } else if (pilihan.equals("Website")) {
                String web = "http://rsudarifinachmad.riau.go.id/";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
            } else if (pilihan.equals("Google Info")) {
                String inf = "https://www.google.com/search?gs_ssp=eJwFwUsKgCAUBVCa1iYkaNx7_VCX0CbilloiRZiCy--cuunPntMrSxg2qnRHZWQz4-BdLWYwoFlTwbQ4BjnFLCXYrm3MNy7xIfgkEL3zj8B1w4jXBjw7Yv4BhMYb5g&q=rumah+sakit+arifin+ahmad+pekanbaru&oq=rumah+sakit+arifin+ahmad+&aqs=chrome.1.69i57j46i175i199i512j0i22i30l7.11854j0j7&sourceid=chrome&ie=UTF-8";
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
