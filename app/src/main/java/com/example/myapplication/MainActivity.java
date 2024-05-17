package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbarMain;
    EditText inputFirstMin;
    EditText inputFirstSec;
    EditText inputSecondMin;
    EditText inputSecondSec;
    Button buttonSum;
    Button buttonSubtraction;
    EditText resultCalculate;
    String title = "Calculator";
    String subTitle = "version 2.0";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toolbarMain = findViewById(R.id.toolbarMain);
        inputFirstMin = findViewById(R.id.firstMinText);
        inputFirstSec = findViewById(R.id.firstSecText);
        inputSecondMin = findViewById(R.id.secondMinText);
        inputSecondSec = findViewById(R.id.secondSecText);
        buttonSum = findViewById(R.id.sumOperation);
        buttonSubtraction = findViewById(R.id.subtractionOperation);
        resultCalculate = findViewById(R.id.resultOperation);

        setSupportActionBar(toolbarMain);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setSubtitle(subTitle);
        getSupportActionBar().setLogo(R.drawable.ic_calculate_foreground);


        buttonSum.setOnClickListener(this);
        buttonSubtraction.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_reset) {
            inputFirstMin.getText().clear();
            inputFirstSec.getText().clear();
            inputSecondMin.getText().clear();
            inputSecondSec.getText().clear();
            resultCalculate.setText("Результат");
            Toast.makeText(this, "Данные очищены!", Toast.LENGTH_LONG).show();

        }
        if (item.getItemId() == R.id.menu_exit) {
            finish();
            Toast.makeText(this, "Приложение закрыто", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        String result = null;
        int a = Integer.parseInt(inputFirstMin.getText().toString());
        int b = Integer.parseInt(inputFirstSec.getText().toString());
        int c = Integer.parseInt(inputSecondMin.getText().toString());
        int d = Integer.parseInt(inputSecondSec.getText().toString());

        Opiration opiration = new Opiration(a, b, c, d);

        if (v.getId() == R.id.subtractionOperation) {
            result = opiration.differenceOpearation();
            resultCalculate.setText(result);
            Toast.makeText(this, resultCalculate.getText(), Toast.LENGTH_SHORT).show();

        }

        if (v.getId() == R.id.sumOperation) {
            result = opiration.sumResult();
            resultCalculate.setText(result);
            Toast.makeText(this, resultCalculate.getText(), Toast.LENGTH_SHORT).show();

        }

    }
}