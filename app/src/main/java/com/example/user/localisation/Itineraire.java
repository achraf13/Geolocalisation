package com.example.user.localisation;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.service.RangedBeacon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Timer;

/**
 * Created by USER on 29/03/2016.
 */

public class Itineraire extends Activity implements BeaconConsumer {
    Button btn_info;
    Button btn_retour;

    static String uuid;
    static Canvas canvas;
    static Bitmap bmp,bmp2,bmpdepart,bmparrive;
    static boolean change;
    static boolean okpos;

    private BeaconManager beaconManager;
    static Node position,oldposition;


    static ImageView im;
    BitmapDrawable abmp;
    static Bitmap map1,map2,map3;
    static String dep, arr;
    static ArrayList<Node> liste = new ArrayList<>();
    static boolean done;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itineraire_activity);
        addListenerOnButton();
        okpos = false;

        im = (ImageView) findViewById(R.id.mapView);
        abmp = (BitmapDrawable) im.getDrawable();
        bmp = abmp.getBitmap();

        map1 = Bitmap.createScaledBitmap(bmp, 1108, 616, true);
        im.setOnTouchListener(new Touch());
        im.setImageBitmap(map1);

        beaconManager = BeaconManager.getInstanceForApplication(this);

        beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24"));



        //beaconManager.setBackgroundScanPeriod(5000);
        beaconManager.setBackgroundBetweenScanPeriod(2000);
        /*beaconManager.setForegroundScanPeriod(2000l);
        beaconManager.setForegroundBetweenScanPeriod(00001);*/


        try {
            beaconManager.updateScanPeriods();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        beaconManager.bind(this);

        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 0);
        }


        bmp2 = BitmapFactory.decodeResource(getResources(),
                R.drawable.loc);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            dep = extras.getString("pointd");
            arr = extras.getString("pointa");
        }
        map2 = map1;
        map3 = map1;
        canvas = new Canvas(map2);
        if(dep.equals("Position Actuelle")){

        }
        else{

            liste = aStar.calculerItineraire(MainActivity.StandMap.get(dep).getNoeud1(), MainActivity.StandMap.get(arr).getNoeud1());
            map2 = aStar.colorPath(liste, map1);
            //aStar.calculerItineraire(MainActivity.StandMap.get(dep).getNoeud1(), MainActivity.StandMap.get(arr).getNoeud1());
            //map2= aStar.colorPath(map1);
            canvas.drawBitmap(map2,0,0,null);


        }



        bmpdepart = BitmapFactory.decodeResource(getResources(),
                R.drawable.departicon);
        bmpdepart = Bitmap.createScaledBitmap(bmpdepart, 45, 45, true);
        bmparrive = BitmapFactory.decodeResource(getResources(),
                R.drawable.arriveeicon);
        bmparrive = Bitmap.createScaledBitmap(bmparrive, 45, 45, true);
        done=false;
    }

    private void addListenerOnButton() {


        btn_info= (Button)findViewById(R.id.btn_info);

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                btn_info.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        AlertDialog alertDialog = new AlertDialog.Builder(Itineraire.this).create();
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

        btn_retour= (Button)findViewById(R.id.btn_retour);

        btn_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Itineraire.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        beaconManager.unbind(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();


    }





    @Override
    public void onBeaconServiceConnect() {


        beaconManager.setRangeNotifier(new RangeNotifier() {
            @Override
            public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {
                double distance = 0;
                if (beacons.size() > 0) {

                    for (Beacon b : beacons) {
                        RangedBeacon bea = new RangedBeacon(b);
                        bea.setSampleExpirationMilliseconds(5000);
                        if (distance == 0) distance = b.getDistance();
                        else if (distance > b.getDistance()) {
                            distance = b.getDistance();
                            uuid = b.getId1().toString();
                        }
                    }
                    System.out.println(uuid + " " + distance);

                    if(distance<5) {

                        if (uuid != null) {
                            if (oldposition == null) {
                                position = MainActivity.BeaconMap.get(uuid);
                                oldposition = MainActivity.BeaconMap.get(uuid);
                                change = false;
                            } else {
                                oldposition = position;
                                position = MainActivity.BeaconMap.get(uuid);
                                change = true;
                            }

                            if (oldposition != position || change == false) {

                                if (done == false) {
                                    if (dep.equals("Position Actuelle")) {

                                        if (!okpos) {

                                            liste = aStar.calculerItineraire(position, MainActivity.StandMap.get(arr).getNoeud1());
                                            map2 = Bitmap.createScaledBitmap(bmp, 1108, 616, true);
                                            map2 = aStar.colorPath(liste, map2);
                                            okpos = true;
                                        }


                                        //aStar.calculerItineraire(position, MainActivity.StandMap.get(arr).getNoeud1());


                                        //map2 = aStar.colorPath(map2);
                                        map2 = Bitmap.createScaledBitmap(map2, 1108, 616, true);
                                        canvas.drawBitmap(map2, 0, 0, null);
                                        canvas.drawBitmap(bmp2, position.getX() - 20, position.getY() - 40, null);
                                        canvas.drawBitmap(bmparrive, liste.get(0).getX() - 22, liste.get(0).getY() - 38, null);
                                        canvas.drawBitmap(bmpdepart, liste.get(liste.size() - 1).getX() - 22, liste.get(liste.size() - 1).getY() - 38, null);
                                        //canvas.drawBitmap(bmparrive, tab1[0] - 22, tab2[0] - 38, null);


                                    } else {
                                        map2 = Bitmap.createScaledBitmap(map2, 1108, 616, true);
                                        canvas.drawBitmap(map2, 0, 0, null);
                                        canvas.drawBitmap(bmp2, position.getX() - 20, position.getY() - 40, null);
                                        canvas.drawBitmap(bmpdepart, liste.get(0).getX() - 22, liste.get(0).getY() - 38, null);
                                        canvas.drawBitmap(bmparrive, liste.get(liste.size() - 1).getX() - 22, liste.get(liste.size() - 1).getY() - 38, null);
                                        //canvas.drawBitmap(bmpdepart, tab1[0] - 22, tab2[0] - 38, null);
                                        //canvas.drawBitmap(bmparrive, tab1[tab1.length-1] - 22, tab2[tab2.length-1] - 38, null);
                                    }

                                } else {
                                    map1 = Bitmap.createScaledBitmap(bmp, 1108, 616, true);
                                    canvas.drawBitmap(map1, 0, 0, null);
                                    canvas.drawBitmap(bmp2, position.getX() - 20, position.getY() - 40, null);

                                }

                                positionner();
                            }

                            if (position.getX() == liste.get(0).getX() && position.getY() == liste.get(0).getY()){
                                done = true;
                                map1 = Bitmap.createScaledBitmap(bmp, 1108, 616, true);
                                canvas.drawBitmap(map1, 0, 0, null);
                                canvas.drawBitmap(bmp2, position.getX() - 20, position.getY() - 40, null);
                            }


                            //if(position.getX()==tab1[0] && position.getY()==tab2[0]) done=true;


                        /*if(position.getX()==liste.get(0).getX() && position.getY()==liste.get(0).getY()){
                            AlertDialog alertDialog = new AlertDialog.Builder(Itineraire.this).create();
                            alertDialog.setTitle("C'est bon !");
                            alertDialog.setMessage("Vous êtes arrivé à destination.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            done = true;
                                            dialog.dismiss();
                                        }
                                    });

                            while(done==false){alertDialog.show();}
                        }*/
                        }
                    }

                }


            }


        });
        try {
            beaconManager.startRangingBeaconsInRegion(new Region("Region1", null,null,null));


        } catch (RemoteException e) {   }


    }


    public void positionner(){

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                im.invalidate();

            }
        });

    }
    public double calculateAccuracy(int txPower, double rssi) {
        if (rssi == 0) {
            return -1.0; // if we cannot determine accuracy, return -1.
        }

        double ratio = rssi*1.0/txPower;
        if (ratio < 1.0) {
            return Math.pow(ratio,10);
        }
        else {
            double accuracy =  (0.89976)*Math.pow(ratio,7.7095) + 0.111;
            return accuracy;
        }
    }
}
