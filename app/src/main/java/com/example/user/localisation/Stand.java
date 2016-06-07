package com.example.user.localisation;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.ImageView;

/**
 * Created by USER on 02/03/2016.
 */
public class Stand {
    private String nom;
    private int x1;
    private int x2;
    private int x3=0;
    private int y1;
    private int y2;
    private int y3=0;
    private Node noeud1;
    private Node noeud2;

    public Stand(String nom, int x1, int y1, int x2, int y2, Node noeud1, Node noeud2){
        this.nom=nom;
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.noeud1=noeud1;
        this.noeud2=noeud2;
    }

    public Stand(String nom, int x1, int y1, int x2, int y2, Node noeud1){

        this.nom=nom;
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.noeud1=noeud1;

    }

    public Stand(String nom, int x1, int y1, int x2, int y2, int x3, int y3, Node noeud){
        this.nom=nom;
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.x3=x3;
        this.y3=y3;
        this.noeud1=noeud;

    }

    public Stand(String nom, Node noeud1){

        this.nom=nom;
        this.noeud1=noeud1;

    }


    public Node getNoeud1() {return this.noeud1; }





}
