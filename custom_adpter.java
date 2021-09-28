package com.example.brij.sunshine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Brij on 7/4/2017.
 */

public class custom_adpter extends ArrayAdapter<String> {

    json_objetcs j=new json_objetcs();
    String loc=j.location;


    Context context;
    String[] date1;
    String[] descipt1;
    String[] day_temp1;
    ImageView img;


    custom_adpter(Context c,String[] date,String[] descipt,String[] day_temp)
    {
        super(c,R.layout.custom_layout,R.id.text_view1,date);
        this.context=c;
        this.date1=date;
        this.day_temp1=day_temp;
        this.descipt1=descipt;


    }
    public View getView(int position, View ConvertView , ViewGroup parent)
    {
            View row=ConvertView;

        if(row==null)
        {


                LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.custom_layout, parent, false);


        }




        TextView mydate=(TextView)row.findViewById(R.id.text_view1);
        TextView mydescript=(TextView) row.findViewById(R.id.text_view2);
        TextView mytemp=(TextView)row.findViewById(R.id.text_view3);
        img=(ImageView)row.findViewById(R.id.img) ;



        mydate.setText(date1[position]+" , "+loc);
        mydescript.setText(descipt1[position]);


        if (descipt1[position].equals("clear sky"))
            img.setImageResource(R.drawable.clear_sky);

        else if(descipt1[position].equals("few clouds"))
            img.setImageResource(R.drawable.few_clouds);

        else if(descipt1[position].equals("scattered clouds"))
            img.setImageResource(R.drawable.scatered_clouds);

        else if(descipt1[position].equals("broken clouds"))
            img.setImageResource(R.drawable.broken_cloud);

        else if(descipt1[position].equals("shower rain"))
            img.setImageResource(R.drawable.shower_rain);

        else if(descipt1[position].equals("rain"))
            img.setImageResource(R.drawable.weather_rain);

        else if(descipt1[position].equals("thunderstorm"))
            img.setImageResource(R.drawable.thunderstorm);

        else if(descipt1[position].equals("snow"))
            img.setImageResource(R.drawable.snow);

        else if(descipt1[position].equals("light rain"))
            img.setImageResource(R.drawable.light_rain);

        else if(descipt1[position].equals("mist"))
            img.setImageResource(R.drawable.mist);

        else if(descipt1[position].equals("moderate rain"))
            img.setImageResource(R.drawable.moderate_rain);

        else if(descipt1[position].equals("heavy intensity rain"))
            img.setImageResource(R.drawable.heavy_intensity_rain);




        mytemp.setText(day_temp1[position]+"\u2103");

        return row;


    }


}
