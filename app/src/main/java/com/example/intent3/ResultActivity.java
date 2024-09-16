package com.example.intent3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView txtA, txtB;
    private Button btnReturnSum, btnReturnDifference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        btnReturnSum = findViewById(R.id.btnReturnSum);
        btnReturnDifference = findViewById(R.id.btnReturnDifference);

        // Nhận dữ liệu từ MainActivity
        int a = getIntent().getIntExtra("a", 0);
        int b = getIntent().getIntExtra("b", 0);

        txtA.setText(String.valueOf(a));
        txtB.setText(String.valueOf(b));

        btnReturnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum = a + b;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", sum);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        btnReturnDifference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int difference = a - b;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", difference);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
