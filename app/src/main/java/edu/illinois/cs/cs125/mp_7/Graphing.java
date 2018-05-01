package edu.illinois.cs.cs125.mp_7;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.PointsGraphSeries;

public class Graphing {
    private static double[] x = new double[5];
    private static double[] y = new double[5];

    public static void addX(final double value) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 0) {
                x[i] = value;
            }
        }
    }

    public static void addY(final double value) {
        for (int i = 0; i < y.length; i++) {
            if (y[i] == 0) {
                y[i] = value;
            }
        }
    }
}