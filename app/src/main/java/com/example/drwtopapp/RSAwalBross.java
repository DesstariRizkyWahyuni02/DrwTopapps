package com.example.drwtopapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSAwalBross extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] ListAct = new String[] { "Call Center","SMS Center","Driving Direction","Website","Info di Google","Exit"};
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
                String nomortel ="tel:0761-73646347";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomortel));

            }else if (pilihan.equals("SMS Center"))
            {
                String smstext ="Desstari Rizky Wahyuni/P";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:081268960252"));
                a.putExtra("sms_body",smstext);
            }
            else if (pilihan.equals("Driving Direction"))
            {
                String lokasirs = " https://g.co/kgs/NhFxbP";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasirs));
            } else if (pilihan.equals("Website")) {
                String web = "http://awalbros.com/branch/panam/";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
            } else if (pilihan.equals("Info di Google")) {
                String inf = "https://www.google.com/search?q=awal%20bros&sxsrf=APq-WBtMyGcfpE6JhgWtspE6_iGDfMfrgA:1646971859604&ei=ycsqYqHLD8ya4t4P89q28Aw&ved=2ahUKEwic7JWlmL32AhXV8XMBHS7XBRoQvS56BAgDEEo&uact=5&oq=awal+bros&gs_lcp=Cgdnd3Mtd2l6EAMyBAgjECcyCwguEIAEEMcBEK8BMgsILhDHARCvARDLATILCC4QgAQQxwEQrwEyBQgAEMsBMgUIABCABDIFCAAQgAQyBQgAEJECMgUIABCRAjIFCAAQywE6BwgAEEcQsAM6BggAEBYQHkoECEEYAEoECEYYAFCbC1jLEmD3FmgBcAF4AIABeogBkQWSAQMxLjWYAQCgAQHIAQjAAQE&sclient=gws-wiz&tbs=lrf:!1m4!1u3!2m2!3m1!1e1!1m4!1u2!2m2!2m1!1e1!2m1!1e2!2m1!1e3!3sIAE,lf:1,lf_ui:2&tbm=lcl&rflfq=1&num=10&rldimm=10325654477956984196&lqi=Cglhd2FsIGJyb3NIleGN4pmqgIAIWhcQABABGAAYASIJYXdhbCBicm9zMgJpZJIBEGdlbmVyYWxfaG9zcGl0YWw&rlst=f#rlfi=hd:;si:10325654477956984196,l,Cglhd2FsIGJyb3NIleGN4pmqgIAIWhcQABABGAAYASIJYXdhbCBicm9zMgJpZJIBEGdlbmVyYWxfaG9zcGl0YWw;mv:[[0.5423089,101.48708409999999],[0.4558857999999999,101.3848531]]";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(inf));
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