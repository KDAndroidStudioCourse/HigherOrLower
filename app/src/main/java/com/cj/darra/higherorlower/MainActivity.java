package com.cj.darra.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int number;

    public void generateRandomNumber() {
        Random rand = new Random();

        number = rand.nextInt(20) + 1;
    }

    public void guessNumber(View view) {
        Log.i("Info", "Button pressed!");
        Log.i("Random number", Integer.toString(number));

        EditText guess = (EditText) findViewById(R.id.numberEditText);

        int numberGuessed = Integer.parseInt(guess.getText().toString());

        if(number == numberGuessed) {
            Toast.makeText(this, "The number is exactly " + number, Toast.LENGTH_SHORT).show();

            generateRandomNumber();
        } else if (number > numberGuessed) {
            Toast.makeText(this, "Higher", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Lower", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Higher or Lower");

        generateRandomNumber();
    }
}
