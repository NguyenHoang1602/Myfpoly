package com.example.asm_nguyenhnpk02250;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asm_nguyenhnpk02250.Model.Product;
import com.example.asm_nguyenhnpk02250.Model.User;
import com.example.asm_nguyenhnpk02250.services.APIService;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_SCHEDULE = 1;
    private static final int FRAGMENT_SCORE = 2;
    private static final int FRAGMENT_UTILITIES = 3;

    private int mCurrentFragment = FRAGMENT_HOME;
    private NavigationView navigationView;
    private DrawerLayout mDrawerLayout;
    private BottomNavigationView mbottomNavigationView;

    private MyViewPagerAdapter mViewPagerAdapter;
    private ViewPager2 mViewpager2;
    private TextView tv_name, tv_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        mViewPagerAdapter = new MyViewPagerAdapter(this);
        mViewpager2.setAdapter(mViewPagerAdapter);



        MaterialToolbar toolbar = findViewById(R.id.Appbar_layout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
                mDrawerLayout.addDrawerListener(toggle);
                toggle.syncState();
            }
        });
        //getdata();
        bottomclick();
        Bundle bundleReceive = getIntent().getExtras();
        if(bundleReceive != null ){
            User user = (User) bundleReceive.get("Object_User");
            if(user != null){
                tv_name.setText(user.getName());
                tv_email.setText(user.getMSSV());
            }
        }


    }

    private void bottomclick() {

        mbottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.button_Home){
                    openHomeFragment();
                    getSupportActionBar().setTitle("Home");
                    //navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
                }else if(id == R.id.button_Schedule){
                    openScheduleFragment();
                    getSupportActionBar().setTitle("Schedule");
                    //navigationView.getMenu().findItem(R.id.nav_favorite).setChecked(true);
                }else if(id == R.id.button_Score){
                    openScoreFragment();
                    getSupportActionBar().setTitle("Score");
                    //navigationView.getMenu().findItem(R.id.nav_favorite).setChecked(true);
                }else if(id == R.id.button_Utilities){
                    openUtilitiesFragment();
                    getSupportActionBar().setTitle("Utilities");
                    //navigationView.getMenu().findItem(R.id.nav_favorite).setChecked(true);
                }
                return true;
            }
        });
        mViewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        mCurrentFragment = FRAGMENT_HOME;
                        //navigationView.getMenu().findItem(R.id.nav_table).setChecked(true);
                        mbottomNavigationView.getMenu().findItem(R.id.button_Home).setChecked(true);
                        getSupportActionBar().setTitle("Home");
                        break;
                    case 1:
                        mCurrentFragment = FRAGMENT_HOME;
                        //navigationView.getMenu().findItem(R.id.nav_menu).setChecked(true);
                        mbottomNavigationView.getMenu().findItem(R.id.button_Schedule).setChecked(true);
                        getSupportActionBar().setTitle("Schedule");
                        break;
                    case 2:
                        mCurrentFragment = FRAGMENT_HOME;
                        //navigationView.getMenu().findItem(R.id.nav_pay).setChecked(true);
                        mbottomNavigationView.getMenu().findItem(R.id.button_Score).setChecked(true);
                        getSupportActionBar().setTitle("Score");
                        break;
                    case 3:
                        mCurrentFragment = FRAGMENT_HOME;
                        //navigationView.getMenu().findItem(R.id.nav_user).setChecked(true);
                        mbottomNavigationView.getMenu().findItem(R.id.button_Utilities).setChecked(true);
                        getSupportActionBar().setTitle("Utilities");
                        break;
                }

            }
        });
    }

//    private void getdata() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(APIService.base_link)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        APIService service = retrofit.create(APIService.class);
//        Call<ArrayList<Product>> response = service.getProduct();
//        response.enqueue(new Callback<ArrayList<Product>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
//                ArrayList<Product> list = response.body();
//                Toast.makeText(MainActivity.this, "" + list.size(),Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Fail",Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }

    public void init(){
        mbottomNavigationView = findViewById(R.id.button_navigation);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        mViewpager2 = findViewById(R.id.view_pager_2);
        tv_name = navigationView.getHeaderView(0).findViewById(R.id.tv_name);
        tv_email = navigationView.getHeaderView(0).findViewById(R.id.tv_email);

    }
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    private void openHomeFragment(){
        if(mCurrentFragment != FRAGMENT_HOME){
            //replaceFragment(new HomeFragment());
            mViewpager2.setCurrentItem(0);
            mCurrentFragment = FRAGMENT_HOME;
        }
    }
    private void openScheduleFragment(){
        if(mCurrentFragment != FRAGMENT_SCHEDULE){
            //replaceFragment(new HomeFragment());
            mViewpager2.setCurrentItem(1);
            mCurrentFragment = FRAGMENT_SCHEDULE;
        }
    }
    private void openScoreFragment(){
        if(mCurrentFragment != FRAGMENT_SCORE){
            //replaceFragment(new HomeFragment());
            mViewpager2.setCurrentItem(2);
            mCurrentFragment = FRAGMENT_SCORE;
        }
    }
    private void openUtilitiesFragment(){
        if(mCurrentFragment != FRAGMENT_UTILITIES){
            //replaceFragment(new HomeFragment());
            mViewpager2.setCurrentItem(3);
            mCurrentFragment = FRAGMENT_UTILITIES;
        }
    }
}