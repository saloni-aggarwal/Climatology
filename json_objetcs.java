package com.example.brij.sunshine;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.HashMap;

/**
 * Created by Brij on 7/2/2017.
 */

public class json_objetcs {
    build_url b=new build_url();
     final int  n=b.numdays;
   static String location;
    String country_name;


        String Date_get[]=new String [n];
         String Decsription[]=new String [n];
        String Day_temp[]=new String [n];
        String humid[]=new  String[n];
         String pressure[]=new  String[n];
         String wind[]=new  String[n];
        String mintemp[]=new  String[n];
        String maxtemp[]=new  String[n];



       // int mages[]=new int[n];
       // static int k=0;



    ArrayList<String[]> list=new ArrayList<String[]>();

    public ArrayList<String[]> jsonobj(String jsondata) throws JSONException {

        StringBuffer finalbuffer1=new StringBuffer();
        StringBuffer finalbuffer2=new StringBuffer();
        JSONObject parentobj=new JSONObject(jsondata);
        JSONObject get_city=parentobj.getJSONObject("city");
         location=get_city.getString("name");
       // MapData.Place = location;
         country_name=get_city.getString("country");
        JSONArray list_array=parentobj.getJSONArray("list");
        JSONObject parentobj2=get_city.getJSONObject("coord");
        MapData.longi=parentobj2.getDouble("lon");
        MapData.lati=parentobj2.getDouble("lat");

        finalbuffer1.append(location+country_name+"\n");
     //   j.getarg1(location,country_name);

            for(int i=0;i<list_array.length();i++) {

                JSONObject final_obj = list_array.getJSONObject(i);
                long date = final_obj.getLong("dt");
                JSONObject tempt = final_obj.getJSONObject("temp");
                double day_temp = tempt.getDouble("day");
                double max_temp = tempt.getDouble("max");
                double min_temp = tempt.getDouble("min");
                String press = final_obj.getString("pressure");
                int humidy = final_obj.getInt("humidity");
                JSONArray weather_day = final_obj.getJSONArray("weather");
                JSONObject weather_obj = weather_day.getJSONObject(0);
                String descp_rain = weather_obj.getString("description");
                String img_icon = weather_obj.getString("icon");
                double Speed = final_obj.getDouble("speed");
                String dateString = new SimpleDateFormat("dd/MM/yyyy").format(new Date(date*1000));

                humid[i]=String.valueOf(humidy);
                pressure[i]=press;
                wind[i]=String.valueOf(Speed);

                maxtemp[i]=String.valueOf((int)max_temp);
                mintemp[i]=String.valueOf((int)min_temp);

                Date_get[i]=dateString;
                Decsription[i]=descp_rain;
                Day_temp[i]=String.valueOf((int)day_temp);


               // finalbuffer2.append(dateString + day_temp + max_temp +min_temp+press+humidy+descp_rain+img_icon+Speed+"\n");
            }
            list.add(Date_get);
            list.add(Decsription);
            list.add(Day_temp);

            list.add(maxtemp);
            list.add(mintemp);

            list.add(humid);
            list.add(pressure);
            list.add(wind);


            return list;



    }
}
