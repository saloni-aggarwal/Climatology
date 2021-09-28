package com.example.brij.sunshine;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    build_url uri=new build_url();
    final int  n=uri.numdays;
    GPSTracker gps;
    double lat,longt;
    String pin="281121";
     String country_code="in";
    mybroadcast connection=new mybroadcast();
    boolean check=connection.check_error(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);


        if(check==true)
        {
            gps=new GPSTracker(this);
            lat=gps.getLatitude();
            longt=gps.getLongitude();
            String address=gps.getAddressLine(this);
            String picode=gps.getPostalCode(this);
            String country_name=gps.getCountryName(this);
            Toast.makeText(this, "Fetching Weather", Toast.LENGTH_SHORT).show();
            String urldata=uri.urlbuild(pin,country_code);
            new JsonTask().execute(urldata);
        }
        else {
            Toast.makeText(this, "N0 connection", Toast.LENGTH_SHORT).show();

        }


    }

   /* @Override
    protected void onStart() {
        super.onStart();

        if(check==true)
        {
            Toast.makeText(this, "Fetching Weather", Toast.LENGTH_SHORT).show();
            String urldata=uri.urlbuild(pin,country_code);
            new JsonTask().execute(urldata);
        }
        else {
            Toast.makeText(this, "N0 connection", Toast.LENGTH_SHORT).show();

        }

    }

*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.main_setting) {
         /*  Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(MainActivity.this,get_location.class);
            startActivity(i);*/
        }
        if (id == R.id.map_loc) {


           /* Toast.makeText(this, "Map Location", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(MainActivity.this,map_location.class);
            startActivity(i);*/



        }
        return super.onOptionsItemSelected(item);
    }



    public class JsonTask extends AsyncTask<String, Void, String>  {
        ArrayList<String[]> getlist = null;

        ProgressDialog progress;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
             progress =new ProgressDialog(MainActivity.this);
           // progress.setTitle("Please Wait.....");
            progress.setIndeterminate(false);
            progress.setMessage("Loading . . .");
            progress.setCancelable(true);
            progress.show();
        }

        @Override
        protected String doInBackground(String... params) {

            HttpURLConnection connection = null;
            BufferedReader reader = null;

            //url connection to fetch data

            try {
              URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                 connection.setRequestMethod("GET");
                connection.setConnectTimeout(3000);
                connection.setReadTimeout(4000);
                    connection.connect();
                  InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
              //  String jsonstr= null;t

                   return   buffer.toString();



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (connection != null)
                 //   Toast.makeText(MainActivity.this, "disconnect", Toast.LENGTH_SHORT).show();
                connection.disconnect();
                try {
                    if (reader != null)
                        reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            return null;
        }

        @Override
        protected void onPostExecute(String Result) {
            super.onPostExecute(Result);
            progress.dismiss();

            if(Result.length() > 0 && Result != null){
                try {
                    getlist = new json_objetcs().jsonobj(Result);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String[] Date = getlist.get(0);
                String[] Description = getlist.get(1);
                String[] Temp = getlist.get(2);
                custom_adpter adapter=new custom_adpter(MainActivity.this,Date,Description,Temp);
                listView.setAdapter(adapter);
            }
            else {
                Toast.makeText(MainActivity.this ,"Slow Connection", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(MainActivity.this,No_connection.class);

                startActivity(i);
            }



            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String a1=getlist.get(0)[position];
                        String a2=getlist.get(1)[position];
                        String a3=getlist.get(2)[position];

                        String a4=getlist.get(3)[position];
                        String a5=getlist.get(4)[position];

                        String a6=getlist.get(5)[position];
                        String a7=getlist.get(6)[position];
                        String a8=getlist.get(7)[position];

                        Intent i = new Intent(MainActivity.this, Details.class);
                        i.putExtra("setdate1", a1);
                        i.putExtra("setdes1",a2);
                        i.putExtra("settemp1",a3);

                        i.putExtra("setmax1", a4);
                        i.putExtra("setmin1",a5);

                        i.putExtra("sethumid1",a6);
                        i.putExtra("setpress1", a7);
                        i.putExtra("setwind1",a8);

                    startActivity(i);

                       // d.setdate.setText(d1);
                }

            });




        }



        }
    }

