package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class WeatherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("CreateApplication", "onCreate() is being executed!");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);
        // fragment(s)
        // check if a fragment is already loaded
        if (savedInstanceState == null) {
            // add fragment
            ForecastFragment forecast = new ForecastFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.main, forecast).commit();
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onStart() {
        Log.i("StartApplication", "onStart() is being executed!");
        super.onStart();
    }
    @Override
    protected void onResume() {
        Log.i("ResumeApplication", "onResume() is being executed!");
        super.onResume();
    }
    @Override
    protected void onPause() {
        Log.i("PauseApplication", "onPause() is being executed!");
        super.onPause();
    }
    @Override
    protected void onStop() {
        Log.i("StopApplication", "onStop() is being executed!");
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        Log.i("DestroyApplication", "onDestroy() is being executed!");
        super.onDestroy();
    }
}