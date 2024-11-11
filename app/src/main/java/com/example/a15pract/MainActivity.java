package com.example.a15pract;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        setFragment(new FirstFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                int id = item.getItemId();
                    if (id == R.id.first_item) {
                        setFragment(new FirstFragment());
                        return true;
                    }
                    else if (id == R.id.second_item)
                    {
                        setFragment(new SecondFragment());
                        return true;
                    }
                    else if (id == R.id.third_item)
                    {
                        setFragment(new ThirdFragment());
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_settings){
            Toast.makeText(this, "Настройки выбраны", Toast.LENGTH_SHORT).show();;
        }
        else if (id == R.id.firstFrag){
            setFragment(new FirstFragment());
            return true;
        }
        else if (id == R.id.twoFrag){
            setFragment(new SecondFragment());
            return true;
        }
        else if (id == R.id.thirdFrag){
            setFragment(new ThirdFragment());
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
    public void setFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.selected, fragment, null).commit();
    }
}