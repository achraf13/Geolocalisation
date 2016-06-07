package com.example.user.localisation;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Arrivee extends Activity {

    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;

    Button btn_retour;
    Button btn_info;
    String depart,arrivee;
    boolean checked;
    String products[] = {"IMA SPA", "JOKTAL", "COMINOX SARL", "IXAPACK 6 AUCOUTURIER-SELVEX","POLYMA INDUSTRY SARL","GROUPEMENT STAF INTER GIE","GUNTER GMBH & CO.KG",
            "FLCOWA","ATMC HYGIENE", "ACEMIA/ACINOX", "ESCALIER", "MISTOUN HYGIENE CHIMIE INDUSTRIELLE","AXFLOW","UROLA S.COOP","EUREQUAT ALGERIE","EL DJAZAIR ISTITHMAR",
            "MEDPACK SOLUTIONS","BRAMBATI SPA","ICE SAS","OMS MAGHREB","COLD ENERGY","PRINCONFLEX SARL","ASIBEX OPTION","MAXFLOW","TECAIRE","FLEXOMED","SIAPI AFRICA",
            "OPEM SPA","LODIGE","TAVIL","ROBERT BOSCH MIDDLE EAST","SIPA EMBALLAGE","ENTREE","SORTIE"};

    int[] colors = new int[] { 0xF1F1F1F1, 0xE7E7E7E7 };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arrivee_activity);
        addListenerOnButton();

        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 0);
        }
        // Listview Data


        lv = (ListView) findViewById(R.id.listView1);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {

            depart = extras.getString("departitem");
            arrivee = extras.getString("arriveeitem");
            checked = extras.getBoolean("checkitem");
        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String item = (String) lv.getItemAtPosition(position);


                if(item.equals(depart)){
                    AlertDialog alertDialog = new AlertDialog.Builder(Arrivee.this).create();
                    alertDialog.setTitle("Erreur");
                    alertDialog.setMessage("Le point de depart ne peut pas être le même que le point d'arrivée");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else {
                    Intent intent = new Intent(Arrivee.this, MainActivity.class);
                    intent.putExtra("arriveeitem",item);
                    intent.putExtra("departitem", depart);
                    intent.putExtra("checkitem", checked);
                    //based on item add info to intent
                    startActivity(intent);

                }



            }
        });
        inputSearch = (EditText) findViewById(R.id.editText1);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, products){

            @Override
            public View getView(int position, View convertView,ViewGroup parent) {
                View view= super.getView(position, convertView, parent);
                if (position % 2 == 1) {
                    view.setBackgroundColor(Color.WHITE);
                } else {
                    view.setBackgroundColor(Color.GRAY);
                }
                return view;

            }
        };
        lv.setAdapter(adapter);
        sortAscending();
        adapter.notifyDataSetChanged();
        /**
         * Enabling Search Filter
         * */
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                Arrivee.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void addListenerOnButton() {
        btn_retour = (Button) findViewById(R.id.btn_retour);
        btn_info= (Button)findViewById(R.id.btn_info);

        btn_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Arrivee.this, MainActivity.class);
                intent.putExtra("departitem", depart);
                intent.putExtra("arriveeitem", arrivee);
                intent.putExtra("checkitem", checked);
                startActivity(intent);
            }
        });

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                btn_info.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        AlertDialog alertDialog = new AlertDialog.Builder(Arrivee.this).create();
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
    }

    private void sortAscending () {
        List<String> sortedMonthsList = Arrays.asList(products);
        Collections.sort(sortedMonthsList);

        products = (String[]) sortedMonthsList.toArray();
    }
}

























