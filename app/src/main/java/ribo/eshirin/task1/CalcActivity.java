package ribo.eshirin.task1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        EditText editTextFirst = findViewById(R.id.etFirst);
        EditText editTextSecond = findViewById(R.id.etSecond);
        Button btnCalc = findViewById(R.id.btnStart);
        btnCalc.setOnClickListener(v -> {
            String firstTermStr = editTextFirst.getText().toString();
            String secondTerStr = editTextSecond.getText().toString();
            if(!firstTermStr.isEmpty() && !secondTerStr.isEmpty() && !secondTerStr.equals("0")) {
                double firstNumber = Double.parseDouble(firstTermStr);
                Log.d("DEBUG", "First number: " + firstNumber);
                double secondNumber = Double.parseDouble(secondTerStr);
                Log.d("DEBUG", "Second number: " + secondNumber);
                double result = firstNumber / secondNumber;
                Log.d("DEBUG", "Result: " + result);
                Intent intent = new Intent();
                intent.putExtra("data", result);
                setResult(RESULT_OK, intent);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Invalid terms", Toast.LENGTH_SHORT).show();
                Log.d("DEBUG", "Invalid terms");
            }
        });
    }
}