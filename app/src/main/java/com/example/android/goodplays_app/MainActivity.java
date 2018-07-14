package com.example.android.goodplays_app;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import com.example.android.goodplays_app.Fragments.ArtistsFragment;
import com.example.android.goodplays_app.Fragments.FavouriteFragment;
import com.example.android.goodplays_app.Fragments.SongFragment;
import com.example.android.goodplays_app.ModelClasses.ArtistModelClasses.Artist;
import com.example.android.goodplays_app.ModelClasses.SongModelClasses.Track;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Track> list;
    ArrayList<Artist> ArtistList;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    Bundle bSong,bArtist;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            list=(ArrayList<Track>)getIntent().getExtras().getSerializable("listtracks");
        }
        catch (Exception e){
            Log.e("error",e.toString());
        }
        try{
            ArtistList = (ArrayList<Artist>)getIntent().getExtras().getSerializable("listartist");
        }
        catch(Exception e)
        {
            Toast.makeText(this, "IN MainActivity"+e.toString(), Toast.LENGTH_LONG).show();
        }
        bSong = new Bundle();
        bSong.putSerializable("listtracks",list);
        bArtist = new Bundle();
        bArtist.putSerializable("listartist",ArtistList);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout =  findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(in);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);
            //return mFragmentList.get(position)
            switch (position)
            {
                case 0:
                    SongFragment sf = new SongFragment();
                    sf.setArguments(bSong);
                    return sf;
                case 1:
                    ArtistsFragment af = new ArtistsFragment();
                    af.setArguments(bArtist);
                    return af;
                case 2:
                    return new FavouriteFragment();
                default:
                    return new SongFragment();
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }
}
