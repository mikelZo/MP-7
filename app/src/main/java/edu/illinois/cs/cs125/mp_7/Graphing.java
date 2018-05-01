package edu.illinois.cs.cs125.mp_7;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Graphing {
    private static String[] xString = new String[5];
    private static String[] yString = new String[5];
    private static double[] x = new double[5];
    private static double[] y = new double[5];

    public static void sort() {
        for (int i = 0; i < x.length; i++) {
            for (int j = 1; j < x.length - i; j++) {
                if (x[j] < x[j - 1]) {
                    double tempX = x[j];
                    double tempY = y[j];
                    x[j] = x[j - 1];
                    x[j - 1] = tempX;
                    y[j] = y[j - 1];
                    y[j - 1] = tempY;
                }
            }
        }
    }

    public static void clear() {
        for (int i = 0; i < xString.length; i++) {
            xString[i] = "";
            yString[i] = "";
            x[i] = 0;
            y[i] = 0;
        }
    }

    public static void deleteX() {
        int i = GraphActivity.getIterate() / 2;
        if (xString[i].length() > 1) {
            xString[i] = xString[i].substring(0, xString[i].length() - 1);
        } else {
            xString[i] = "";
        }
    }

    public static void deleteY() {
        int i = (GraphActivity.getIterate() - 1) / 2;
        if (yString[i].length() > 1) {
            yString[i] = yString[i].substring(0, yString[i].length() - 1);
        } else {
            yString[i] = "";
        }
    }

    public static void addX(final String value) {
        int i = GraphActivity.getIterate() / 2;
        if (xString[i] == null) {
            xString[i] = value;
        } else {
            xString[i] += value;
        }
    }

    public static void addY(final String value) {
        int i = (GraphActivity.getIterate() - 1) / 2;
        if (yString[i] == null) {
            yString[i] = value;
        } else {
            yString[i] += value;
        }
    }

    public static String getX() {
        int i = GraphActivity.getIterate() / 2;
        return xString[i];
    }

    public static String getY() {
        int i = (GraphActivity.getIterate() - 1) / 2;
        return yString[i];
    }

    public static void nextX() {
        for (int i = 0; i < xString.length; i++) {
            if (xString[i] != null) {
                if (!xString[i].equals("")) {
                    x[i] = Double.parseDouble(xString[i]);
                }
            }
        }
    }

    public static void nextY() {
        for (int i = 0; i < yString.length; i++) {
            if (yString[i] != null) {
                if (!yString[i].equals("")){
                    y[i] = Double.parseDouble(yString[i]);
                }
            }
        }
    }

    public static LineGraphSeries<DataPoint> getGraph() {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(x[0], y[0]),
                new DataPoint(x[1], y[1]),
                new DataPoint(x[2], y[2]),
                new DataPoint(x[3], y[3]),
                new DataPoint(x[4], y[4])
        });
        return series;
    }


}
