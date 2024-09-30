package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        counter = 10;
        TextView counterTextview=findViewById(R.id.textView_counter);
        counterTextview.setText(""+ counter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
             v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void knock(View view) {
        if (counter > 0) {
            counter--;
            TextView counterTextview = findViewById(R.id.textView_counter);
            counterTextview.setText("" + counter);
        }
        if (counter == 0) {
            ImageView eggImageview = findViewById(R.id.imageView_egg);
            eggImageview.setImageResource(R.drawable.surprise_egg);
        }
    }


    public void reset(View view) {
            counter=10;
            TextView counterTextview=findViewById(R.id.textView_counter);
            counterTextview.setText(""+ counter);
            ImageView eggImageview = findViewById(R.id.imageView_egg);
            eggImageview.setImageResource(R.drawable.green_egg);
        }
    }

