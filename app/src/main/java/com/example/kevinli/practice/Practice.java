package com.example.kevinli.practice;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.DrawableWrapper;
import android.media.AudioManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;


public class Practice extends AppCompatActivity{
    private DrawerLayout mDrawerLayout;
    private Button setting;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.history:
                Intent intent=new Intent(Practice.this,History.class);
                startActivity(intent);
                break;
            case R.id.settings:
                Intent intt=new Intent(Practice.this,settingsActivity.class);
                startActivity(intt);
                break;
                default:
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        ImageView imageView1=(ImageView) findViewById(R.id.image1);
        ImageView imageView2=(ImageView) findViewById(R.id.image2);
        ImageView imageView3=(ImageView) findViewById(R.id.image3);
        imageView1.setOnClickListener(l);
        imageView2.setOnClickListener(l);
        imageView3.setOnClickListener(l);

//       Toolbar toolbar= (Toolbar)findViewById(R.id.toolbar);
//       setSupportActionBar(toolbar);
//       mDrawerLayout =(DrawerLayout) findViewById(R.id.toolbar);
//        NavigationView navView=(NavigationView) findViewById(R.id.drawer_layout);
//        ActionBar actionBar=getSupportActionBar();
//        if(actionBar!=null){
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
//        }
//        navView.setCheckedItem(R.id.settings);
//        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                mDrawerLayout.closeDrawers();
//                return true;
//            }
//        });
    }

    View.OnClickListener l=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            Fragment f=null;
            switch(v.getId()){
                case R.id.image1:
                    f=new OneFragment();
                    break;
                case R.id.image2:
                    f=new TwoFragment();
                    break;
                case R.id.image3:
                    f=new ThirdFragment();
                    break;
                    default:
                        break;
            }
            ft.replace(R.id.fragment,f);
            ft.commit();
        }
    };

}
