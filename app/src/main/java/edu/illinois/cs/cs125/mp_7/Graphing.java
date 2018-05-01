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

    public static void addX(final String value) {
        int i = GraphActivity.getIterate() / 2;
        xString[i] += value;
    }

    public static void addY(final String value) {
        int i = (GraphActivity.getIterate() - 1) / 2;
        yString[i] += value;
    }

    public static void nextX() {
        for (int i = 0; i < xString.length; i++) {
            if (xString[i] != null) {
                x[i] = Double.parseDouble(xString[i]);
            }
        }
    }

    public static void nextY() {
        for (int i = 0; i < yString.length; i++) {
            if (yString[i] != null) {
                y[i] = Double.parseDouble(yString[i]);
            }
        }
    }

    public static LineGraphSeries getGraph() {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(x[0], y[0]),
                new DataPoint(x[1], y[1]),
                new DataPoint(x[2], y[2]),
                new DataPoint(x[3], y[3]),
                new DataPoint(x[4], y[4]),
                new DataPoint(x[5], y[5])
        });
        return series;
    }


}
