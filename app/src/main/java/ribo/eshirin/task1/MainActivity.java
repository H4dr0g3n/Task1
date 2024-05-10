package ribo.eshirin.task1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStart;
    private TextView tvTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.btnStartActivity);
        tvTextValue = findViewById(R.id.tvText);
        btnStart.setOnClickListener(this);
        // hui
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnStartActivity) {
            Intent intent = new Intent(this,CalcActivity.class);
            activityResultLauncher.launch(intent);
        }
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                        public void onActivityResult(ActivityResult result) {
                    if (result.getData() != null) {
                        double res = result.getData().getDoubleExtra("data", 0.0);
                        Log.d("INFO", "Result: " + res);
                        tvTextValue.setText("Реультат деления чисел:\n" + res);
                    }
        }
    });
}