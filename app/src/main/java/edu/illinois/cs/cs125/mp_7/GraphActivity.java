package edu.illinois.cs.cs125.mp_7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;


public class GraphActivity extends AppCompatActivity {
    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "Mp7:Graph";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Load the main layout for our activity */
        setContentView(R.layout.graph);

        /*
        Set up handlers for each button in our UI. These run when the buttons are clicked.
         */
        final Button graph = findViewById(R.id.graphing);
        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "second button clicked");
                /* Insert swap tab code here */
            }
        });

    }
}
