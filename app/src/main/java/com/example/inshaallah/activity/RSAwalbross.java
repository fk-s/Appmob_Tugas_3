package com.example.inshaallah.activity;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSAwalbross extends ListActivity {
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] ListAct = new String[]{"Call Center", "Driving Direction", "SMS center", "Website", "Info di Google", "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListAct));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }

    private void tampilkanpilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Call Center")) {
                String nomortel = "tel: 0822-7420-3119";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomortel));

            } else if (pilihan.equals("SMS center")) {
                String smstext = "Dea Ropija Sari";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms : 082274203119"));
                a.putExtra("sms_body" , smstext);
            } else if (pilihan.equals("Driving Direction"))
            {
                String lokasirs = "google.navigation:q=0.463823,101.390353";
                a= new Intent(Intent.ACTION_VIEW,Uri.parse(lokasirs));


            }  else if (pilihan.equals("Website"))
            {
                String website ="http://ww.awal-bross.net";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));

            } else if (pilihan.equals("Info di Google"))
            {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Rumah Sakit Awal Bross");
            }
            startActivity(a);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
