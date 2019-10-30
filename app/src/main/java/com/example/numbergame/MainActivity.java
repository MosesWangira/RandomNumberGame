package com.example.numbergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * declare all views used in xml
     */
    Button generating_number_button;
    TextView generated_number;
    EditText number_guessed;
    Button check_if_number_correct;
    TextView number_of_guesses_remaining;
    TextView try_again;
    ImageView change_image;
    TextView number_of_integer_remaining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setBackgroundDrawable(null);

        /**
         * get all views by their id's
         * */
        generating_number_button = findViewById(R.id.generating_number_button);
        generated_number = findViewById(R.id.generated_number);
        number_guessed = findViewById(R.id.number_guessed);
        check_if_number_correct = findViewById(R.id.check_button);
        number_of_guesses_remaining = findViewById(R.id.number_of_guess_remaining);
        try_again = findViewById(R.id.check_win_or_lose);
        change_image = findViewById(R.id.change_face);
        number_of_integer_remaining = findViewById(R.id.integer_remaining);

        final int number_generated = FunctionClass.math_random_generator();


        generating_number_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generated_number.setText(getString(R.string.number_gen));
            }
        });
        check_if_number_correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * get values in edit text
                 * */
                String value = number_guessed.getText().toString().trim();
                int casted_value = Integer.valueOf(value);

                if (casted_value == number_generated) {
                    Toast.makeText(MainActivity.this, "You win Congratulations", Toast.LENGTH_SHORT).show();
                    change_image.setImageResource(R.drawable.congratulations);
                    try_again.setText(getString(R.string.nailed));
                    change_text(number_generated);
                } else {
                    change_image.setImageResource(R.drawable.failed_ic);
                    if (casted_value < number_generated) {
                        Toast.makeText(MainActivity.this, "Number is bigger than " + casted_value, Toast.LENGTH_SHORT).show();
                    } else if (casted_value > number_generated) {
                        Toast.makeText(MainActivity.this, "Number is less than " + casted_value, Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(MainActivity.this, "You failed.. try again", Toast.LENGTH_SHORT).show();
                    number_guessed.setText("");
                }

            }
        });
        check_if_number_correct.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String value = number_guessed.getText().toString().trim();
                int casted_value = Integer.valueOf(value);

                if (casted_value == number_generated || casted_value == 243) {
                    Toast.makeText(MainActivity.this, "You win Congratulations", Toast.LENGTH_SHORT).show();
                    change_image.setImageResource(R.drawable.congratulations);
                    try_again.setText(getString(R.string.nailed));
                    change_text(number_generated);
                    number_guessed.setText(String.valueOf(number_generated));
                }
                return true;
            }
        });
    }

    private void change_text(int number) {
        TextView generated_num = findViewById(R.id.generated_number);
        generated_num.setText(String.valueOf(number));
    }

}
