package com.example.user.localisation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 09/03/2016.
 */
public class Node {
    public List<Node> neighbors = new ArrayList<Node>();
    public Node parent;
    public double f;
    public double g;
    public double h;
    public int x;
    public int y;
    public double cost;

    public Node(int x, int y, double cost){
        this.x=x;
        this.y=y;
        this.cost=cost;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }




}
