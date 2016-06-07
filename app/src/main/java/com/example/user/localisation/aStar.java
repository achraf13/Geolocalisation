package com.example.user.localisation;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by USER on 09/03/2016.
 */

public class aStar {



    public static ArrayList<Node> calculerItineraire(Node start, Node goal) {
        Set<Node> open = new HashSet<>();
        Set<Node> closed = new HashSet<>();

        start.g = 0;
        start.h = estimateDistance(start, goal);
        start.f = start.h;

        open.add(start);

        while (true) {
            Node current = null;

            if (open.size() == 0) {
                throw new RuntimeException("no route");
            }

            for (Node node : open) {
                if (current == null || node.f < current.f) {
                    current = node;
                }
            }

            if (current == goal) {
                break;
            }

            open.remove(current);
            closed.add(current);

            for (Node neighbor : current.neighbors) {
                if (neighbor == null) {
                    continue;
                }

                double nextG = current.g + estimateDistance(neighbor, current);

                if (!open.contains(neighbor) && !closed.contains(neighbor)) {
                    neighbor.g = nextG;
                    neighbor.h = estimateDistance(neighbor, goal);
                    neighbor.f = neighbor.g + neighbor.h;
                    neighbor.parent = current;
                    open.add(neighbor);
                }

                if (nextG < neighbor.g) {
                    open.remove(neighbor);
                    closed.remove(neighbor);
                }
            }
        }


        Node current = goal;
        ArrayList<Node> nodes = new ArrayList<>();


            while (current.parent != null) {
                nodes.add(current);
                current = current.parent;

            }
            nodes.add(start);


            return nodes;

    }

    public static double estimateDistance(Node node1, Node node2) {
        return Math.sqrt(Math.pow((node2.x - node1.x), 2) + Math.pow((node2.y - node1.y), 2));
    }

    public static Bitmap colorPath(ArrayList<Node> liste/*, ImageView img*/, Bitmap bmp) {
        Bitmap operation = bmp.copy(bmp.getConfig(), true);
    for(int i=0;i<liste.size()-1;i++) {
        if(liste.get(i).getX()==liste.get(i+1).getX()){
        for (int j = Math.min(liste.get(i).getX(), liste.get(i+1).getX()+10); j <= Math.max(liste.get(i).getX(), liste.get(i+1).getX()+10); j++) {
            for (int k = Math.min(liste.get(i).getY(), liste.get(i+1).getY()); k <= Math.max(liste.get(i).getY(), liste.get(i+1).getY())+10; k++) {
            int p = bmp.getPixel(j, k);
            int r = Color.red(p);
            int g = Color.green(p);
            int b = Color.blue(p);
            int alpha = Color.alpha(p);

                r =  43;
                g =  174;
                b =  145;
                alpha = 0;
            operation.setPixel(j, k, Color.argb(Color.alpha(p), r, g, b));
             }
         }
    }
        else{
            for (int j = Math.min(liste.get(i).getX(), liste.get(i+1).getX()); j <= Math.max(liste.get(i).getX(), liste.get(i+1).getX()); j++) {
            for (int k = Math.min(liste.get(i).getY(), liste.get(i+1).getY()+10); k <= Math.max(liste.get(i).getY(), liste.get(i+1).getY()+10); k++) {
                int p = bmp.getPixel(j, k);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);
                int alpha = Color.alpha(p);

                r =  43;
                g =  174;
                b =  145;
                alpha = 0;
                operation.setPixel(j, k, Color.argb(Color.alpha(p), r, g, b));
            }
        }

        }
    }
        //img.setImageBitmap(operation);
        return operation;
    }

    /*public static void calculerItineraire(Node start, Node goal) {
        Set<Node> open = new HashSet<>();
        Set<Node> closed = new HashSet<>();

        start.g = 0;
        start.h = estimateDistance(start, goal);
        start.f = start.h;

        open.add(start);

        while (true) {
            Node current = null;

            if (open.size() == 0) {
                throw new RuntimeException("no route");
            }

            for (Node node : open) {
                if (current == null || node.f < current.f) {
                    current = node;
                }
            }

            if (current == goal) {
                break;
            }

            open.remove(current);
            closed.add(current);

            for (Node neighbor : current.neighbors) {
                if (neighbor == null) {
                    continue;
                }

                double nextG = current.g + estimateDistance(neighbor, current);

                if (!open.contains(neighbor) && !closed.contains(neighbor)) {
                    neighbor.g = nextG;
                    neighbor.h = estimateDistance(neighbor, goal);
                    neighbor.f = neighbor.g + neighbor.h;
                    neighbor.parent = current;
                    open.add(neighbor);
                }

                if (nextG < neighbor.g) {
                    open.remove(neighbor);
                    closed.remove(neighbor);
                }
            }
        }


        Node current = goal;

        int i=0;
        Itineraire.tab1 = new int[100];
        Itineraire.tab2 = new int[100];


            while (current.parent != null)
                 {
                     Itineraire.tab1[i] = current.getX();
                     Itineraire.tab2[i] = current.getY();
                     current = current.parent;
                     i++;
            }
        Itineraire.tab1[i]=start.getX();
        Itineraire.tab2[i]=start.getY();




    }

    public static Bitmap colorPath(Bitmap bmp) {
        Bitmap operation = bmp.copy(bmp.getConfig(), true);
        for(int i=0;i<Itineraire.tab1.length-1;i++) {
            if(Itineraire.tab1[i]==Itineraire.tab1[i+1]){
                for (int j = Math.min(Itineraire.tab1[i], Itineraire.tab1[i+1]+10); j <= Math.max(Itineraire.tab1[i], Itineraire.tab1[i+1]+10); j++) {
                    for (int k = Math.min(Itineraire.tab2[i], Itineraire.tab2[i+1]); k <= Math.max(Itineraire.tab2[i], Itineraire.tab2[i+1])+10; k++) {
                        int p = bmp.getPixel(j, k);
                        int r = Color.red(p);
                        int g = Color.green(p);
                        int b = Color.blue(p);
                        int alpha = Color.alpha(p);

                        r =  43;
                        g =  174;
                        b =  145;
                        alpha = 0;
                        operation.setPixel(j, k, Color.argb(Color.alpha(p), r, g, b));
                    }
                }
            }
            else{
                for (int j = Math.min(Itineraire.tab1[i], Itineraire.tab1[i+1]); j <= Math.max(Itineraire.tab1[i], Itineraire.tab1[i+1]); j++) {
                    for (int k = Math.min(Itineraire.tab2[i], Itineraire.tab2[i+1]+10); k <= Math.max(Itineraire.tab2[i], Itineraire.tab2[i+1]+10); k++) {
                        int p = bmp.getPixel(j, k);
                        int r = Color.red(p);
                        int g = Color.green(p);
                        int b = Color.blue(p);
                        int alpha = Color.alpha(p);

                        r =  43;
                        g =  174;
                        b =  145;
                        alpha = 0;
                        operation.setPixel(j, k, Color.argb(Color.alpha(p), r, g, b));
                    }
                }

            }
        }
        //img.setImageBitmap(operation);
        return operation;
    }*/

}
