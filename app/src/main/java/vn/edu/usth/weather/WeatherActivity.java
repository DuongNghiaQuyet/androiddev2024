package vn.edu.usth.weather;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WeatherActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;
    TabLayout tabLayout;
    MediaPlayer mediaPlayer;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("CreateApplication", "onCreate() is being executed!");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager2 = findViewById(R.id.pager);
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);
        tabLayout = findViewById(R.id.tab);
        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setText(viewPagerAdapter.getPageTitle(position));
            tab.setContentDescription(viewPagerAdapter.getPageTitle(position)); // Add content description
        });
        mediator.attach();

        mediaPlayer = MediaPlayer.create(this, R.raw.weather);
        mediaPlayer.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_refresh) {
            Toast.makeText(this, "Refresh clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.action_settings) {
            startActivity(new Intent(this, PrefActivity.class));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
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
        mediaPlayer.release();
        mediaPlayer = null;
    }

    @Override
    protected void onDestroy() {
        Log.i("DestroyApplication", "onDestroy() is being executed!");
        super.onDestroy();
    }
}
