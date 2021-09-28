package com.example.brij.sunshine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class No_connection extends AppCompatActivity {
    TextView text_net;
    ImageView img_net;
    boolean ic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_connection);
        text_net=(TextView)findViewById(R.id.net_text);
        img_net=(ImageView)findViewById(R.id.net_img);

            Toast.makeText(this, "No connection", Toast.LENGTH_SHORT).show();
            img_net.setVisibility(View.VISIBLE);
            text_net.setVisibility(View.VISIBLE);

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.connection_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.refresh1) {

            mybroadcast connection=new mybroadcast();
            ic=connection.check_error(this);

            if(ic==true)
            {
                Toast.makeText(this, "Active connection", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(No_connection.this,MainActivity.class);
                startActivity(i);
                finish();
            }
            else
            {
                Toast.makeText(this, "No connection", Toast.LENGTH_SHORT).show();

            }


        }
        return super.onOptionsItemSelected(item);
    }


}

