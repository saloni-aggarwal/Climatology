package com.example.brij.sunshine;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class get_location extends AppCompatActivity {

    EditText get_loc,get_code;
    TextView setloc;
    Button ok,cancel;
   // LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location);
        setloc=(TextView)findViewById(R.id.set_loc) ;



    }

   /* public void location(View view)
    {


        final AlertDialog.Builder dialog_box=new AlertDialog.Builder(get_location.this);
        View mview=getLayoutInflater().inflate(R.layout.pin_code,null);
        get_loc=(EditText)mview.findViewById(R.id.get_loc);
        ok=(Button)mview.findViewById(R.id.ok_button);
        cancel=(Button)mview.findViewById(R.id.cencel_button);
        get_code=(EditText)mview.findViewById(R.id.get_country);


        dialog_box.setView(mview);
        final AlertDialog dialog=dialog_box.create();
        dialog.show();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sf = getSharedPreferences("pincode", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sf.edit();
                editor.putString("get_pin", get_loc.getText().toString());
                editor.putString("get_countrycode", get_code.getText().toString());
               *//* editor.putString("set_loc",json_objetcs.location);
                editor.putString("set_country",json_objetcs.country_name);*//*
                editor.apply();
                String pin = sf.getString("get_pin", "");
                String country_code = sf.getString("get_countrycode", "");
               *//* String getloc=sf.getString("set_loc","");
                String getcountry=sf.getString("set_country","");*//*
                MainActivity.pin = pin;
                MainActivity.country_code=country_code;
               // setloc.setText(getloc+","+getcountry);
                Toast.makeText(get_location.this, pin+","+country_code, Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });





    }*/
}
