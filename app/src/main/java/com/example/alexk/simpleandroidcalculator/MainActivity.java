package com.example.alexk.simpleandroidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String SQUARE = "Square";
    final String CIRCLE = "Circle";
    final String TRIANGLE = "Triangle";

    String selected_shape = "";

    boolean shapeIsSelected = false;

    ImageButton imageButton_square;
    ImageButton imageButton_circle;
    ImageButton imageButton_triangle;

    Button button_calculate;

    TextView textView_selection;

    EditText editText_value1;
    EditText editText_value2;
    EditText editText_result;

    double lengthValue1;
    double lengthValue2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing of Variables
        imageButton_square = findViewById(R.id.imageButton_square);
        imageButton_circle = findViewById(R.id.imageButton_circle);
        imageButton_triangle = findViewById(R.id.imageButton_triangle);

        textView_selection = findViewById(R.id.textView_selectionTitle);

        editText_value1 = findViewById(R.id.editText_value1);
        editText_value2 = findViewById(R.id.editText_value2);
        editText_result = findViewById(R.id.editText_result);

        button_calculate = findViewById(R.id.button_calculate);

        //Setting Listeners for each button
        imageButton_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set Shape-Selection textView
                if (textView_selection.getText() != SQUARE) {
                    textView_selection.setText(SQUARE);
                }

                //Setting the EditTexts/PlainTexts
                editText_value1.setHint(R.string.square_length);
                editText_value2.setVisibility(View.INVISIBLE);

                if (!shapeIsSelected) {
                    shapeIsSelected = true;
                }
            }
        });

        imageButton_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set Shape-Selection textView
                if (textView_selection.getText() != CIRCLE) {
                    textView_selection.setText(CIRCLE);
                }

                //Setting the EditTexts/PlainTexts
                editText_value1.setHint(R.string.circle_radius);
                editText_value2.setVisibility(View.INVISIBLE);

                if (!shapeIsSelected) {
                    shapeIsSelected = true;
                }
            }
        });

        imageButton_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set Shape-Selection textView
                if (textView_selection.getText() != TRIANGLE) {
                    textView_selection.setText(TRIANGLE);
                }

                //Setting the EditTexts/PlainTexts
                editText_value1.setHint(R.string.tri_base);
                editText_value2.setVisibility(View.VISIBLE);
                editText_value2.setHint(R.string.tri_height);


            }
        });

        //Calculation of result using a switch statement
        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selected_shape = textView_selection.getText().toString();
                switch (selected_shape) {

                    case CIRCLE:
                        try {
                            lengthValue1 = Double.parseDouble(editText_value1.getText().toString());
                            String answer = String.valueOf((3.14 * (Math.pow(lengthValue1, 2))));
                            editText_result.setText(answer);
                        } catch (NumberFormatException e) {
                            Toast.makeText(getApplicationContext(), R.string.please_enter
                                    , Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case SQUARE:
                        try {
                            lengthValue1 = Double.parseDouble(editText_value1.getText().toString());
                            String answer = String.valueOf((Math.pow(lengthValue1, 2)));
                            editText_result.setText(answer);
                        } catch (NumberFormatException e) {
                            Toast.makeText(getApplicationContext(), R.string.please_enter
                                    , Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case TRIANGLE:
                        try {
                            lengthValue1 = Double.parseDouble(editText_value1.getText().toString());
                            lengthValue2 = Double.parseDouble(editText_value2.getText().toString());
                            String answer = String.valueOf((.5 * lengthValue1) * lengthValue2);
                            editText_result.setText(answer);
                        } catch (NumberFormatException e) {
                            Toast.makeText(getApplicationContext(), R.string.please_enter
                                    , Toast.LENGTH_SHORT).show();
                        }
                        break;

                        //In case no shape is chosen
                    default:
                        Toast.makeText(getApplicationContext(), R.string.please_make
                                , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
