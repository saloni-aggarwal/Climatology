package com.example.brij.sunshine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends AppCompatActivity {

    TextView setloc,setdesp,setdate,settemp,setmin,setmax,sethumid,setpress,setwind;
    ImageView img;
    json_objetcs j=new json_objetcs();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        setloc=(TextView)findViewById(R.id.loc);
        setdate=(TextView)findViewById(R.id.dat);
        settemp=(TextView)findViewById(R.id.temp);
        setdesp=(TextView)findViewById(R.id.des) ;

        setmax=(TextView)findViewById(R.id.max);
        setmin=(TextView)findViewById(R.id.min);

        sethumid=(TextView)findViewById(R.id.humi);
        setpress=(TextView)findViewById(R.id.press);
        setwind=(TextView)findViewById(R.id.wind);
        img=(ImageView)findViewById(R.id.img1);

        String loc1=j.location;
        setloc.setText(loc1);

        Intent intent = getIntent();

        String getd1= intent.getStringExtra("setdate1");
        setdate.setText(getd1);
        String getd2= intent.getStringExtra("setdes1");
        setdesp.setText(getd2);
        String getd3= intent.getStringExtra("settemp1");
        settemp.setText(getd3+"\u2103");

        String getd4= intent.getStringExtra("setmax1");
        setmax.setText("Max-"+getd4 +"\u2103");
        String getd5= intent.getStringExtra("setmin1");
        setmin.setText("Min-"+getd5 +"\u2103");

        String getd6= intent.getStringExtra("sethumid1");
        sethumid.setText("Humidity : "+getd6+" %");
        String getd7= intent.getStringExtra("setpress1");
        setpress.setText("Pressure : "+getd7+" Hpa");
        String getd8= intent.getStringExtra("setwind1");
        setwind.setText("Wind     :"+getd8+" m/s");



        if (getd2.equals("clear sky"))
            img.setImageResource(R.drawable.clear_sky);

        else if(getd2.equals("few clouds"))
            img.setImageResource(R.drawable.few_clouds);

        else if(getd2.equals("scattered clouds"))
            img.setImageResource(R.drawable.scatered_clouds);

        else if(getd2.equals("broken clouds"))
            img.setImageResource(R.drawable.broken_cloud);

        else if(getd2.equals("shower rain"))
            img.setImageResource(R.drawable.shower_rain);

        else if(getd2.equals("rain"))
            img.setImageResource(R.drawable.weather_rain);

        else if(getd2.equals("thunderstorm"))
            img.setImageResource(R.drawable.thunderstorm);

        else if(getd2.equals("snow"))
            img.setImageResource(R.drawable.snow);

        else if(getd2.equals("light rain"))
            img.setImageResource(R.drawable.light_rain);

        else if(getd2.equals("mist"))
            img.setImageResource(R.drawable.mist);

        else if(getd2.equals("moderate rain"))
            img.setImageResource(R.drawable.moderate_rain);

        else if(getd2.equals("heavy intensity rain"))
            img.setImageResource(R.drawable.heavy_intensity_rain);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.deatil_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.detail_setting) {
            Toast.makeText(this, "Settings Details", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(Details.this,get_location.class);
            startActivity(i);

        }

        return super.onOptionsItemSelected(item);
    }





}

