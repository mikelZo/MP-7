package edu.illinois.cs.cs125.mp_7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;


public class MainActivity extends AppCompatActivity {
    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "Mp7:Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Load the main layout for our activity */
        setContentView(R.layout.activity_main);

        final TextView txtView = findViewById(R.id.screen);

        /*
        Set up handlers for each button in our UI. These run when the buttons are clicked.
         */
        final Button second = findViewById(R.id.second);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "second button clicked");
                /* Insert swap tab code here */
            }
        });
        final Button zero = findViewById(R.id.zero);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "zero");
                Calculate.addNumberToString("0");
                txtView.setText(Calculate.getString());
            }
        });
        final Button one = findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "one");
                Calculate.addNumberToString("1");
                txtView.setText(Calculate.getString());
            }
        });
        final Button two = findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "two");
                Calculate.addNumberToString("2");
                txtView.setText(Calculate.getString());
            }
        });
        final Button three = findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "three");
                Calculate.addNumberToString("3");
                txtView.setText(Calculate.getString());
            }
        });
        final Button four = findViewById(R.id.four);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "four");
                Calculate.addNumberToString("4");
                txtView.setText(Calculate.getString());
            }
        });
        final Button five = findViewById(R.id.five);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "five");
                Calculate.addNumberToString("5");
                txtView.setText(Calculate.getString());
            }
        });
        final Button six = findViewById(R.id.six);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "six");
                Calculate.addNumberToString("6");
                txtView.setText(Calculate.getString());
            }
        });
        final Button seven = findViewById(R.id.seven);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "seven");
                Calculate.addNumberToString("7");
                txtView.setText(Calculate.getString());
            }
        });
        final Button eight = findViewById(R.id.eight);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "eight");
                Calculate.addNumberToString("8");
                txtView.setText(Calculate.getString());
            }
        });
        final Button nine = findViewById(R.id.nine);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "nine");
                Calculate.addNumberToString("9");
                txtView.setText(Calculate.getString());
            }
        });
        final Button add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "add");
                Calculate.addOperationToString("+");
                txtView.setText(Calculate.getString());
            }
        });
        final Button subtract = findViewById(R.id.subtract);
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "subtract");
                Calculate.addOperationToString("-");
                txtView.setText(Calculate.getString());
            }
        });
        final Button multiply = findViewById(R.id.multiply);
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "multiply");
                Calculate.addOperationToString("*");
                txtView.setText(Calculate.getString());
            }
        });
        final Button divide = findViewById(R.id.division);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "divide");
                Calculate.addOperationToString("/");
                txtView.setText(Calculate.getString());
            }
        });
        final Button leftParentheses = findViewById(R.id.left_parentheses);
        leftParentheses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "(");
                Calculate.addOperationToString("(");
                txtView.setText(Calculate.getString());
            }
        });
        final Button rightParentheses = findViewById(R.id.right_parentheses);
        rightParentheses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, ")");
                Calculate.addOperationToString(")");
                txtView.setText(Calculate.getString());
            }
        });
        final Button calculate = findViewById(R.id.enter);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "calculated value");
                Calculate.calculate();
                txtView.setText(Calculate.getString());
            }
        });
        final Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "cleared screen");
                Calculate.clear();
                txtView.setText(Calculate.getString());
            }
        });
        final Button decimal = findViewById(R.id.decimal);
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "decimal");
                Calculate.addNumberToString(".");
                txtView.setText(Calculate.getString());
            }
        });

        final Button power = findViewById(R.id.power);
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "power");
                Calculate.addOperationToString("^");
                txtView.setText(Calculate.getString());
            }
        });

        final Button test = findViewById(R.id.power);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (final View v) {
                Log.d(TAG, "power");
                Calculate.addOperationToString("^");
                txtView.setText(Calculate.getString());
            }
        });

    }
}
