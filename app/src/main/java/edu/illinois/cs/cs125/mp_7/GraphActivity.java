package edu.illinois.cs.cs125.mp_7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class GraphActivity extends AppCompatActivity {
    /**
     * Default logging tag for messages from the main activity.
     */
    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "Mp7:Graph";
    private static int iterate = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Load the main layout for our activity */
        setContentView(R.layout.graph);
        final GraphView graph = findViewById(R.id.scatter);
        final TextView x5View = findViewById(R.id.x5);
        final TextView x1View = findViewById(R.id.x1);
        final TextView x2View = findViewById(R.id.x2);
        final TextView x3View = findViewById(R.id.x3);
        final TextView x4View = findViewById(R.id.x4);
        final TextView y5View = findViewById(R.id.y5);
        final TextView y1View = findViewById(R.id.y1);
        final TextView y2View = findViewById(R.id.y2);
        final TextView y3View = findViewById(R.id.y3);
        final TextView y4View = findViewById(R.id.y4);



        /*
        Set up handlers for each button in our UI. These run when the buttons are clicked.
         */
        final Button calculator = findViewById(R.id.calculator);
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        final Button plot = findViewById(R.id.plot_data_graph);
        plot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                LineGraphSeries<DataPoint> series = Graphing.getGraph();
                graph.addSeries(series);
            }
        });
        final Button next = findViewById(R.id.next_graph);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (iterate % 2 == 0) {
                    Graphing.nextX();
                } else {
                    Graphing.nextY();
                }
                iterate++;
                if (iterate == 10) {
                    iterate = 0;
                }
            }
        });
        final Button one_graph = findViewById(R.id.one_graph);
        one_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                if (iterate % 2 == 0) {
                    Graphing.addX("1");
                    if (iterate == 0) {
                        x1View.setText(Graphing.getX());
                    } else if (iterate == 2) {
                        x2View.setText(Graphing.getX());
                    } else if (iterate == 4) {
                        x3View.setText(Graphing.getX());
                    } else if (iterate == 6) {
                        x4View.setText(Graphing.getX());
                    } else if (iterate == 8) {
                        x5View.setText(Graphing.getX());
                    }
                } else {
                    Graphing.addY("1");
                    if (iterate == 1) {
                        y1View.setText(Graphing.getY());
                    } else if (iterate == 3) {
                        y2View.setText(Graphing.getY());
                    } else if (iterate == 5) {
                        y3View.setText(Graphing.getY());
                    } else if (iterate == 7) {
                        y4View.setText(Graphing.getY());
                    } else if (iterate == 9) {
                        y5View.setText(Graphing.getY());
                    }
                }
            }
        });
        final Button two_graph = findViewById(R.id.two_graph);
        two_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                if (iterate % 2 == 0) {
                    Graphing.addX("2");
                    if (iterate == 0) {
                        x1View.setText(Graphing.getX());
                    } else if (iterate == 2) {
                        x2View.setText(Graphing.getX());
                    } else if (iterate == 4) {
                        x3View.setText(Graphing.getX());
                    } else if (iterate == 6) {
                        x4View.setText(Graphing.getX());
                    } else if (iterate == 8) {
                        x5View.setText(Graphing.getX());
                    }
                } else {
                    Graphing.addY("2");
                    if (iterate == 1) {
                        y1View.setText(Graphing.getY());
                    } else if (iterate == 3) {
                        y2View.setText(Graphing.getY());
                    } else if (iterate == 5) {
                        y3View.setText(Graphing.getY());
                    } else if (iterate == 7) {
                        y4View.setText(Graphing.getY());
                    } else if (iterate == 9) {
                        y5View.setText(Graphing.getY());
                    }
                }
            }
        });
        final Button three_graph = findViewById(R.id.three_graph);
        three_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                if (iterate % 2 == 0) {
                    Graphing.addX("3");
                    if (iterate == 0) {
                        x1View.setText(Graphing.getX());
                    } else if (iterate == 2) {
                        x2View.setText(Graphing.getX());
                    } else if (iterate == 4) {
                        x3View.setText(Graphing.getX());
                    } else if (iterate == 6) {
                        x4View.setText(Graphing.getX());
                    } else if (iterate == 8) {
                        x5View.setText(Graphing.getX());
                    }
                } else {
                    Graphing.addY("3");
                    if (iterate == 1) {
                        y1View.setText(Graphing.getY());
                    } else if (iterate == 3) {
                        y2View.setText(Graphing.getY());
                    } else if (iterate == 5) {
                        y3View.setText(Graphing.getY());
                    } else if (iterate == 7) {
                        y4View.setText(Graphing.getY());
                    } else if (iterate == 9) {
                        y5View.setText(Graphing.getY());
                    }
                }
            }
        });
        final Button four_graph = findViewById(R.id.four_graph);
        four_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                if (iterate % 2 == 0) {
                    Graphing.addX("4");
                    if (iterate == 0) {
                        x1View.setText(Graphing.getX());
                    } else if (iterate == 2) {
                        x2View.setText(Graphing.getX());
                    } else if (iterate == 4) {
                        x3View.setText(Graphing.getX());
                    } else if (iterate == 6) {
                        x4View.setText(Graphing.getX());
                    } else if (iterate == 8) {
                        x5View.setText(Graphing.getX());
                    }
                } else {
                    Graphing.addY("4");
                    if (iterate == 1) {
                        y1View.setText(Graphing.getY());
                    } else if (iterate == 3) {
                        y2View.setText(Graphing.getY());
                    } else if (iterate == 5) {
                        y3View.setText(Graphing.getY());
                    } else if (iterate == 7) {
                        y4View.setText(Graphing.getY());
                    } else if (iterate == 9) {
                        y5View.setText(Graphing.getY());
                    }
                }
            }
        });
        final Button five_graph = findViewById(R.id.five_graph);
        five_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                if (iterate % 2 == 0) {
                    Graphing.addX("5");
                    if (iterate == 0) {
                        x1View.setText(Graphing.getX());
                    } else if (iterate == 2) {
                        x2View.setText(Graphing.getX());
                    } else if (iterate == 4) {
                        x3View.setText(Graphing.getX());
                    } else if (iterate == 6) {
                        x4View.setText(Graphing.getX());
                    } else if (iterate == 8) {
                        x5View.setText(Graphing.getX());
                    }
                } else {
                    Graphing.addY("5");
                    if (iterate == 1) {
                        y1View.setText(Graphing.getY());
                    } else if (iterate == 3) {
                        y2View.setText(Graphing.getY());
                    } else if (iterate == 5) {
                        y3View.setText(Graphing.getY());
                    } else if (iterate == 7) {
                        y4View.setText(Graphing.getY());
                    } else if (iterate == 9) {
                        y5View.setText(Graphing.getY());
                    }
                }
            }
        });
        final Button six_graph = findViewById(R.id.six_graph);
        six_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                if (iterate % 2 == 0) {
                    Graphing.addX("6");
                    if (iterate == 0) {
                        x1View.setText(Graphing.getX());
                    } else if (iterate == 2) {
                        x2View.setText(Graphing.getX());
                    } else if (iterate == 4) {
                        x3View.setText(Graphing.getX());
                    } else if (iterate == 6) {
                        x4View.setText(Graphing.getX());
                    } else if (iterate == 8) {
                        x5View.setText(Graphing.getX());
                    }
                } else {
                    Graphing.addY("6");
                    if (iterate == 1) {
                        y1View.setText(Graphing.getY());
                    } else if (iterate == 3) {
                        y2View.setText(Graphing.getY());
                    } else if (iterate == 5) {
                        y3View.setText(Graphing.getY());
                    } else if (iterate == 7) {
                        y4View.setText(Graphing.getY());
                    } else if (iterate == 9) {
                        y5View.setText(Graphing.getY());
                    }
                }
            }
        });
        final Button seven_graph = findViewById(R.id.seven_graph);
        seven_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                if (iterate % 2 == 0) {
                    Graphing.addX("7");
                    if (iterate == 0) {
                        x1View.setText(Graphing.getX());
                    } else if (iterate == 2) {
                        x2View.setText(Graphing.getX());
                    } else if (iterate == 4) {
                        x3View.setText(Graphing.getX());
                    } else if (iterate == 6) {
                        x4View.setText(Graphing.getX());
                    } else if (iterate == 8) {
                        x5View.setText(Graphing.getX());
                    }
                } else {
                    Graphing.addY("7");
                    if (iterate == 1) {
                        y1View.setText(Graphing.getY());
                    } else if (iterate == 3) {
                        y2View.setText(Graphing.getY());
                    } else if (iterate == 5) {
                        y3View.setText(Graphing.getY());
                    } else if (iterate == 7) {
                        y4View.setText(Graphing.getY());
                    } else if (iterate == 9) {
                        y5View.setText(Graphing.getY());
                    }
                }
            }
        });
        final Button eight_graph = findViewById(R.id.eight_graph);
        eight_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                if (iterate % 2 == 0) {
                    Graphing.addX("8");
                    if (iterate == 0) {
                        x1View.setText(Graphing.getX());
                    } else if (iterate == 2) {
                        x2View.setText(Graphing.getX());
                    } else if (iterate == 4) {
                        x3View.setText(Graphing.getX());
                    } else if (iterate == 6) {
                        x4View.setText(Graphing.getX());
                    } else if (iterate == 8) {
                        x5View.setText(Graphing.getX());
                    }
                } else {
                    Graphing.addY("8");
                    if (iterate == 1) {
                        y1View.setText(Graphing.getY());
                    } else if (iterate == 3) {
                        y2View.setText(Graphing.getY());
                    } else if (iterate == 5) {
                        y3View.setText(Graphing.getY());
                    } else if (iterate == 7) {
                        y4View.setText(Graphing.getY());
                    } else if (iterate == 9) {
                        y5View.setText(Graphing.getY());
                    }
                }
            }
        });
        final Button nine_graph = findViewById(R.id.nine_graph);
        nine_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                if (iterate % 2 == 0) {
                    Graphing.addX("9");
                    if (iterate == 0) {
                        x1View.setText(Graphing.getX());
                    } else if (iterate == 2) {
                        x2View.setText(Graphing.getX());
                    } else if (iterate == 4) {
                        x3View.setText(Graphing.getX());
                    } else if (iterate == 6) {
                        x4View.setText(Graphing.getX());
                    } else if (iterate == 8) {
                        x5View.setText(Graphing.getX());
                    }
                } else {
                    Graphing.addY("9");
                    if (iterate == 1) {
                        y1View.setText(Graphing.getY());
                    } else if (iterate == 3) {
                        y2View.setText(Graphing.getY());
                    } else if (iterate == 5) {
                        y3View.setText(Graphing.getY());
                    } else if (iterate == 7) {
                        y4View.setText(Graphing.getY());
                    } else if (iterate == 9) {
                        y5View.setText(Graphing.getY());
                    }
                }
            }
        });
        final Button zero_graph = findViewById(R.id.zero_graph);
        zero_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                if (iterate % 2 == 0) {
                    Graphing.addX("0");
                    if (iterate == 0) {
                        x1View.setText(Graphing.getX());
                    } else if (iterate == 2) {
                        x2View.setText(Graphing.getX());
                    } else if (iterate == 4) {
                        x3View.setText(Graphing.getX());
                    } else if (iterate == 6) {
                        x4View.setText(Graphing.getX());
                    } else if (iterate == 8) {
                        x5View.setText(Graphing.getX());
                    }
                } else {
                    Graphing.addY("0");
                    if (iterate == 1) {
                        y1View.setText(Graphing.getY());
                    } else if (iterate == 3) {
                        y2View.setText(Graphing.getY());
                    } else if (iterate == 5) {
                        y3View.setText(Graphing.getY());
                    } else if (iterate == 7) {
                        y4View.setText(Graphing.getY());
                    } else if (iterate == 9) {
                        y5View.setText(Graphing.getY());
                    }
                }
            }
        });
        final Button decimal_graph = findViewById(R.id.decimal_graph);
        decimal_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                if (iterate % 2 == 0) {
                    Graphing.addX(".");
                    if (iterate == 0) {
                        x1View.setText(Graphing.getX());
                    } else if (iterate == 2) {
                        x2View.setText(Graphing.getX());
                    } else if (iterate == 4) {
                        x3View.setText(Graphing.getX());
                    } else if (iterate == 6) {
                        x4View.setText(Graphing.getX());
                    } else if (iterate == 8) {
                        x5View.setText(Graphing.getX());
                    }
                } else {
                    Graphing.addY(".");
                    if (iterate == 1) {
                        y1View.setText(Graphing.getY());
                    } else if (iterate == 3) {
                        y2View.setText(Graphing.getY());
                    } else if (iterate == 5) {
                        y3View.setText(Graphing.getY());
                    } else if (iterate == 7) {
                        y4View.setText(Graphing.getY());
                    } else if (iterate == 9) {
                        y5View.setText(Graphing.getY());
                    }
                }
            }
        });
    }
    public static int getIterate() {
        return iterate;
    }


}
