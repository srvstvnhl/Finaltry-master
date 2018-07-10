package com.example.nihal.finaltry.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.nihal.finaltry.Adapters.ViewPagerAdapter;
import com.example.nihal.finaltry.Fragments.FragmentChat;
import com.example.nihal.finaltry.Fragments.FragmentConsult;
import com.example.nihal.finaltry.Fragments.FragmentPeoples;
import com.example.nihal.finaltry.Fragments.FragmentProfile;
import com.example.nihal.finaltry.R;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    ImageView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpager_id);
        search=findViewById(R.id.search);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        search.setColorFilter(Color.TRANSPARENT);

        adapter.AddFragment(new FragmentConsult(),"");
        adapter.AddFragment(new FragmentChat(),"");
        adapter.AddFragment(new FragmentPeoples(),"");
        adapter.AddFragment(new FragmentProfile(),"");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_help);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_chat);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_person_add);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_profile);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setElevation(0);
    }
}
