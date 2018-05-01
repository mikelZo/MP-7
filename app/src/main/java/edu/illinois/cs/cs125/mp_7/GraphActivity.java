package edu.illinois.cs.cs125.mp_7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;


public class GraphActivity extends AppCompatActivity {
<<<<<<< HEAD
    /**
     * Default logging tag for messages from the main activity.
     */
=======
    /** Default logging tag for messages from the main activity. */
>>>>>>> 0d28c3f43632a79c014650fa6b4d829998c81581
    private static final String TAG = "Mp7:Graph";
    private static int iterate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Load the main layout for our activity */
        setContentView(R.layout.graph);
<<<<<<< HEAD
        GraphView graph = findViewById(R.id.scatter);
        final TextView x1view = findViewById(R.id.x1);
        final TextView x2view = findViewById(R.id.x2);
        final TextView x3view = findViewById(R.id.x3);
        final TextView x4view = findViewById(R.id.x4);
        final TextView x5view = findViewById(R.id.x5);
        final TextView y1view = findViewById(R.id.y1);
        final TextView y2view = findViewById(R.id.y2);
        final TextView y3view = findViewById(R.id.y3);
        final TextView y4view = findViewById(R.id.y4);
        final TextView y5view = findViewById(R.id.y5);
        /*
        Set up handlers for each button in our UI. These run when the buttons are clicked.
         */
        final Button calculator = findViewById(R.id.calculator);
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
=======

        /*
        Set up handlers for each button in our UI. These run when the buttons are clicked.
         */
        final Button graph = findViewById(R.id.calculator);
        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
>>>>>>> 0d28c3f43632a79c014650fa6b4d829998c81581
                setContentView(R.layout.activity_main);
            }
        });

<<<<<<< HEAD
        final Button plot = findViewById(R.id.plot_data);
        plot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

            }
        });
        final Button one_graph = findViewById(R.id.one_graph);
        one_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "one");
                if (iterate % 2 == 0) {
                    Graphing.addX("1");
                } else {
                    Graphing.addY("1");
                }
            }
        });
        final Button two_graph = findViewById(R.id.two_graph);
        two_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "two");
                if (iterate % 2 == 0) {
                    Graphing.addX("2");
                } else {
                    Graphing.addY("2");
                }
            }
        });
        final Button three_graph = findViewById(R.id.three_graph);
        three_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "three");
                if (iterate % 2 == 0) {
                    Graphing.addX("3");
                } else {
                    Graphing.addY("3");
                }
            }
        });
        final Button four_graph = findViewById(R.id.four_graph);
        four_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "four");
                if (iterate % 2 == 0) {
                    Graphing.addX("4");
                } else {
                    Graphing.addY("4");
                }
            }
        });
        final Button five_graph = findViewById(R.id.five_graph);
        five_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "five");
                if (iterate % 2 == 0) {
                    Graphing.addX("5");
                } else {
                    Graphing.addY("5");
                }
            }
        });
        final Button six_graph = findViewById(R.id.six_graph);
        six_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "six");
                if (iterate % 2 == 0) {
                    Graphing.addX("6");
                } else {
                    Graphing.addY("6");
                }
            }
        });
        final Button seven_graph = findViewById(R.id.seven_graph);
        seven_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "seven");
                if (iterate % 2 == 0) {
                    Graphing.addX('7");
                } else {
                    Graphing.addY("7");
                }
            }
        });
        final Button eight_graph = findViewById(R.id.eight_graph);
        eight_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "eight");
                if (iterate % 2 == 0) {
                    Graphing.addX("8");
                } else {
                    Graphing.addY("8");
                }
            }
        });
        final Button nine_graph = findViewById(R.id.nine_graph);
        nine_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "nine");
                if (iterate % 2 == 0) {
                    Graphing.addX("9");
                } else {
                    Graphing.addY("9");
                }
            }
        });
        final Button zero_graph = findViewById(R.id.zero_graph);
        zero_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "zero");
                if (iterate % 2 == 0) {
                    Graphing.addX("0");
                } else {
                    Graphing.addY("0");
                }
            }
        });
        final Button decimal_graph = findViewById(R.id.decimal_graph);
        decimal_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "decimal");
                if (iterate % 2 == 0) {
                    Graphing.addX(".");
                } else {
                    Graphing.addY(".");
                }
            }
        });


=======
        final Button

    }

    public static int getIterate() {
        return iterate;
>>>>>>> 0d28c3f43632a79c014650fa6b4d829998c81581
    }
}
