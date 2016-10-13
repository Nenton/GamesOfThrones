package com.nenton.gamesofthrones.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.nenton.gamesofthrones.R;
import com.nenton.gamesofthrones.data.manager.DataManager;
import com.nenton.gamesofthrones.data.storage.NamesParc;
import com.nenton.gamesofthrones.data.storage.Persons;
import com.nenton.gamesofthrones.ui.adapters.CustomClickListener;
import com.nenton.gamesofthrones.ui.adapters.LannisterAdapter;
import com.nenton.gamesofthrones.ui.adapters.StarkAdapter;
import com.nenton.gamesofthrones.ui.adapters.TargarienAdapter;

import java.util.List;

public class CharacterListScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String PARCELABLER_KEY = "PARCELABLER_KEY";
    private TabHost mTabHost;
    private RecyclerView mRecyclerViewStark;
    private RecyclerView mRecyclerViewLannister;
    private RecyclerView mRecyclerViewTargarien;
    private List<Persons> personsesStark;
    private List<Persons> personsesLannister;
    private List<Persons> personsesTargarien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        mTabHost = (TabHost) findViewById(R.id.tabs);
        mRecyclerViewStark = (RecyclerView) findViewById(R.id.starks_list);
        mRecyclerViewLannister = (RecyclerView) findViewById(R.id.lannister_list);
        mRecyclerViewTargarien = (RecyclerView) findViewById(R.id.targarien_list);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this);
        mRecyclerViewStark.setLayoutManager(linearLayoutManager1);
        mRecyclerViewLannister.setLayoutManager(linearLayoutManager2);
        mRecyclerViewTargarien.setLayoutManager(linearLayoutManager3);

        personsesStark = DataManager.getInstanse().getStarkHouse();
        personsesLannister = DataManager.getInstanse().getLannisterHouse();
        personsesTargarien = DataManager.getInstanse().getTargaryenHouse();

        mTabHost.setup();

        TabHost.TabSpec tabSpec = mTabHost.newTabSpec("tag1");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Starks");
        mTabHost.addTab(tabSpec);
        mRecyclerViewStark.setAdapter(new StarkAdapter(personsesStark, new CustomClickListener() {
            @Override
            public void onUserItemClickListener(int position) {
                NamesParc userProfile = new NamesParc(personsesStark.get(position),
                        personsesStark.get(position).getAliases(),
                        personsesStark.get(position).getTitles(),
                        "Winter is Coming",
                        NamesParc.STARK,personsesStark.get(position).getSeries().size()>0?personsesStark.get(position).getSeries().get(personsesStark.get(position).getSeries().size()-1).getSeries():"");
                Intent userIntent = new Intent(CharacterListScreen.this, ScreenCharacter.class);
                userIntent.putExtra(PARCELABLER_KEY, userProfile);
                startActivity(userIntent);
            }
        }));

        tabSpec = mTabHost.newTabSpec("tag2");
        tabSpec.setContent(R.id.tab2);
        tabSpec.setIndicator("Lannister");
        mTabHost.addTab(tabSpec);
        mRecyclerViewLannister.setAdapter(new LannisterAdapter(personsesLannister, new CustomClickListener() {
            @Override
            public void onUserItemClickListener(int position) {
                NamesParc userProfile = new NamesParc(personsesLannister.get(position),
                        personsesLannister.get(position).getAliases(),
                        personsesLannister.get(position).getTitles(),
                        "Hear Me Roar!",
                        NamesParc.LANNISTER,personsesLannister.get(position).getSeries().size()>0?personsesLannister.get(position).getSeries().get(personsesLannister.get(position).getSeries().size()-1).getSeries():"");
                Intent userIntent = new Intent(CharacterListScreen.this, ScreenCharacter.class);
                userIntent.putExtra(PARCELABLER_KEY, userProfile);
                startActivity(userIntent);
            }
        }));

        tabSpec = mTabHost.newTabSpec("tag3");
        tabSpec.setContent(R.id.tab3);
        tabSpec.setIndicator("Targarien");
        mTabHost.addTab(tabSpec);
        mRecyclerViewTargarien.setAdapter(new TargarienAdapter(personsesTargarien, new CustomClickListener() {
            @Override
            public void onUserItemClickListener(int position) {
                NamesParc userProfile = new NamesParc(personsesTargarien.get(position),
                        personsesTargarien.get(position).getAliases(),
                        personsesTargarien.get(position).getTitles(),
                        "Fire and Blood",
                        NamesParc.TARGARIEN,personsesTargarien.get(position).getSeries().size()>0?personsesTargarien.get(position).getSeries().get(personsesTargarien.get(position).getSeries().size()-1).getSeries():"");
                Intent userIntent = new Intent(CharacterListScreen.this, ScreenCharacter.class);
                userIntent.putExtra(PARCELABLER_KEY, userProfile);
                startActivity(userIntent);
            }
        }));

        mTabHost.setCurrentTab(0);

        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
         DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
