package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.content.Intent;
import android.widget.EditText;

import com.example.capstoneproject.Dungeons.CatacombStats.DungeonCatacombsStatsFragment;

public class MainActivity extends AppCompatActivity {

    private Button SubmitButton;
    private EditText inputUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SubmitButton = findViewById(R.id.SubmitButton);
        inputUsername = findViewById(R.id.InputUsername);


        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, SecondMainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Username",inputUsername.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}