package com.example.brij.sunshine;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import java.net.URI;

/**
 * Created by Brij on 7/2/2017.
 */

public class build_url {


    String format="json";
    String units="metric";
    int numdays=10;


    String key="d29f8e905cbe35b81bac10ac84b2c0bd";
    String urlbuild(String pin_code,String country_code) {
        final String url = "http://api.openweathermap.org/data/2.5/forecast/daily?";

        final String zip_code = "zip";
        final String unit = "units";
        final String app_id = "appid";
        final String mo_de = "mode";
        final String count_days = "cnt";
        Uri buituri = Uri.parse(url).buildUpon()
                .appendQueryParameter(zip_code, pin_code + "," + country_code)
                .appendQueryParameter(app_id, key)
                .appendQueryParameter(count_days, Integer.toString(numdays))
                .appendQueryParameter(mo_de, format)
                .appendQueryParameter(unit, units)
                .build();

        return buituri.toString();

    }
  /* public String getpin()
    {
        MainActivity m=new MainActivity();
        String s=m.get_pin;
        if (s.length()==0)
        {
            return "281121";
        }
        else
            return s;
    }*/
}
