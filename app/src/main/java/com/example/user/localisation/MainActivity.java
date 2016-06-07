package com.example.user.localisation;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

import java.util.Collection;
import java.util.HashMap;



public class MainActivity extends Activity {



    static HashMap<String,Stand> StandMap;
    static HashMap<String, Node> BeaconMap;

    static Node n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12,n13,n14,n15,n16,n17,n18,n19,n20,n21,n22,n23,n24,n25,n26,n27,n28,n29,n30,n31,n32,n33,n34,n35,n36,n37,n38,n39,n40,
    n41,n42,n43,n44,n45,n46,n47,n48,n49,n50,n51,n52,n53,n54,n55,n56,n57,n58,n59,n60,n61,n62;

    Button ok;
    Button btn_info;
    Button btn_reset;
    public static TextView depart;
    public static TextView arrivee;
    static Bundle extras;
    static boolean checked;
    static CheckBox check;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_beacon);
        addListenerOnButton();
        arrivee = (TextView) findViewById(R.id.arrivee);
        depart = (TextView) findViewById(R.id.depart);
        check = ( CheckBox ) findViewById( R.id.checkBox );
        checked = false;
        /*//beaconManager = BeaconManager.getInstanceForApplication(this);

        //beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24"));



        //beaconManager.setBackgroundScanPeriod(1100l);
        //beaconManager.setBackgroundBetweenScanPeriod(10001);
        beaconManager.setForegroundScanPeriod(2100l);
        beaconManager.setForegroundBetweenScanPeriod(10001);
        BeaconManager.setRssiFilterImplClass(RunningAverageRssiFilter.class);
        RunningAverageRssiFilter.setSampleExpirationMilliseconds(3000l);

        try {
            beaconManager.updateScanPeriods();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        //beaconManager.bind(this);*/


        extras = getIntent().getExtras();
        if(extras != null) {
            depart.setText(extras.getString("departitem"));
            arrivee.setText(extras.getString("arriveeitem"));
            checked = extras.getBoolean("checkitem");
            if(checked==false){
                check.setChecked(false);

            }
            else
            {
                depart.setEnabled(false);

                check.setChecked(true);

            }
        }


        if (depart.getText().toString().trim().length() > 0 && arrivee.getText().toString().trim().length() > 0) {
            ok.setBackgroundResource(R.drawable.bienvenu_itin_select);
            ok.setClickable(true);
        } else {
            ok.setBackgroundResource(R.drawable.bienvenu_itineraire);
            ok.setClickable(false);

        }






        depart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Depart.class);

                intent.putExtra("departitem",depart.getText().toString());

                intent.putExtra("arriveeitem", arrivee.getText().toString());

                intent.putExtra("checkitem", checked);
                startActivity(intent);

            }

        });


        arrivee.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Arrivee.class);

                intent.putExtra("departitem",depart.getText().toString());

                intent.putExtra("arriveeitem", arrivee.getText().toString());
                intent.putExtra("checkitem", checked);

                startActivity(intent);


            }

        });


        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    depart.setText("Position Actuelle");
                    depart.setEnabled(false);
                    checked = true;
                    if(arrivee.getText().toString().trim().length() > 0) {
                        ok.setBackgroundResource(R.drawable.bienvenu_itin_select);
                        ok.setClickable(true);
                    }
                } else {
                    depart.setText("");
                    depart.setEnabled(true);
                    checked = false;
                    ok.setBackgroundResource(R.drawable.bienvenu_itineraire);
                    ok.setClickable(false);

                }

            }
        });



        StandMap = new HashMap<>();
        BeaconMap = new HashMap<>();



        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 0);
        }



        Init.Initialiser(StandMap, BeaconMap);



    }

    private void addListenerOnButton() {

        ok = (Button) findViewById(R.id.btn_ok);
        btn_info= (Button)findViewById(R.id.btn_info);
        btn_reset= (Button)findViewById(R.id.reset);



        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                btn_info.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("A propos de nous");
                        alertDialog.setMessage(Html.fromHtml("<b>" + "<i>" + "<u>" + "Adresse: " + "</u>" + "</i>" + "</b>" + "<center>" + "Villa 183, Bois des cars &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3, Dely Ibrahim ALGER &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ALGERIE." + "</center>" + "<br/><br/>" +
                                "<b>" + "<i>" + "<u>" + "Téléphone: " + "</u>" + "</i>" + "</b>" + "+213 21 336 363 " + "<br/>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;" + "+213 21 336 464 " + "<br/><br/>" +
                                "<b>" + "<i>" + "<u>" + "Fax: " + "</u>" + "</i>" + "</b>" + "&nbsp;&nbsp;" + "+213 21 336 349 " + "<br/><br/>" +
                                "<b>" + "<i>" + "<u>" + "Mail: " + "</u>" + "</i>" + "</b>" + "&nbsp;&nbsp;" + "commercial@eurequat-" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;algerie.com" + "<br/>" +
                                "<h6>" + "Eurequat Algerie ©2016" + "</h6>"));
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                });
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this,Itineraire.class);
                intent.putExtra("pointd",depart.getText().toString());
                intent.putExtra("pointa",arrivee.getText().toString());
                startActivity(intent);



            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                depart.setText("");
                arrivee.setText("");
                check.setChecked(false);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Associate searchable configuration with the SearchView

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
