package com.example.drwtopapp;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSJiwaTampan extends ListActivity {
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
                String tel = "tel:082348407513";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));
            } else if (pilihan.equals("Message")) {
                String msg = "Desstari Rizky Wahyuni/ P";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:082348407513"));
                a.putExtra("sms_body", msg);
            } else if (pilihan.equals("Direction")) {
                String dir = "https://www.google.com/maps/place/RS+Jiwa+Tampan/@0.464944,101.382591,16z/data=!4m5!3m4!1s0x0:0x843e44bbd84eb38d!8m2!3d0.4649441!4d101.3825906?hl=id";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(dir));
            } else if (pilihan.equals("Website")) {
                String web = "https://rsjiwatampan.riau.go.id/";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
            } else if (pilihan.equals("Google Info")) {
                String inf = "https://www.google.com/search?gs_ssp=eJzj4tFP1zfMyDU2sUg2STZgtFI1qDA2TDFNtDBNSjUzS0oyM02yMqiwMDFONTFJSkqxMElNMrZI8RIpKs5SKEnMLUjMUyhIzU7MS0osKgUAIQgW4Q&q=rsj+tampan+pekanbaru&oq=rsj&aqs=chrome.1.69i57j46i20i175i199i263i512j0i512j46i175i199i512l3j0i512l2j46i175i199i512.2636j0j7&sourceid=chrome&ie=UTF-8";
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
