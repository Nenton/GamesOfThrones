package com.nenton.gamesofthrones.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nenton.gamesofthrones.R;
import com.nenton.gamesofthrones.data.manager.DataManager;
import com.nenton.gamesofthrones.data.storage.NamesParc;
import com.nenton.gamesofthrones.data.storage.Persons;

import static com.nenton.gamesofthrones.ui.activities.CharacterListScreen.PARCELABLER_KEY;

public class ScreenCharacter extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView mImageView;
    private Persons mother;
    private Persons father;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_character);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mImageView = (ImageView) findViewById(R.id.imageView3);
        setSupportActionBar(toolbar);
        initData();
    }

    private void initData() {

        final NamesParc namesParc = getIntent().getParcelableExtra(PARCELABLER_KEY);

        TextView textWords = (TextView) findViewById(R.id.words_txt);
        TextView textBorn = (TextView) findViewById(R.id.born_txt);
        TextView born = (TextView) findViewById(R.id.born);
        TextView textTitles = (TextView) findViewById(R.id.titles_txt);
        TextView textAliase = (TextView) findViewById(R.id.alliase_txt);
        Button textFather = (Button) findViewById(R.id.buttonfather);
        Button textMother = (Button) findViewById(R.id.buttonmother);

        if (!namesParc.getMother().isEmpty()) {
            mother = DataManager.getInstanse().getPerson(namesParc.getMother());
            textMother.setText(mother.getName());
            textMother.setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.mother)).setVisibility(View.VISIBLE);
            textMother.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NamesParc userProfile = new NamesParc(mother,
                            mother.getAliases(),
                            mother.getTitles(),mother.getSeries().size()>0?mother.getSeries().get(mother.getSeries().size()-1).getSeries():"");
                    Intent userIntent = new Intent(ScreenCharacter.this, ScreenCharacter.class);
                    userIntent.putExtra(PARCELABLER_KEY, userProfile);
                    startActivity(userIntent);
                }
            });
        }
        if (!namesParc.getFather().isEmpty()) {
            father = DataManager.getInstanse().getPerson(namesParc.getFather());
            textFather.setText(father.getName());
            textFather.setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.father)).setVisibility(View.VISIBLE);
            textFather.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NamesParc userProfile = new NamesParc(father,
                            father.getAliases(),
                            father.getTitles(),father.getSeries().size()>0?father.getSeries().get(father.getSeries().size()-1).getSeries():"");
                    Intent userIntent = new Intent(ScreenCharacter.this, ScreenCharacter.class);
                    userIntent.putExtra(PARCELABLER_KEY, userProfile);
                    startActivity(userIntent);
                }
            });
        }
        textWords.setText(namesParc.getWords());

        if (namesParc.getDied().isEmpty()){
            textBorn.setText(namesParc.getBorn());
        } else {
            born.setText("Died");
            textBorn.setText(namesParc.getDied());
            Snackbar.make((CoordinatorLayout)findViewById(R.id.coordinator), "Was died in " + namesParc.getSeries(), Snackbar.LENGTH_LONG).show();
        }
        textTitles.setText(namesParc.getTitles());
        textAliase.setText(namesParc.getAliases());


        setupToolbar(namesParc.getName());

        if (namesParc.getHouse().equals(NamesParc.STARK)) {
            mImageView.setImageDrawable(this.getResources().getDrawable(R.drawable.starks));
        } else if (namesParc.getHouse().equals(NamesParc.LANNISTER)) {
            mImageView.setImageDrawable(this.getResources().getDrawable(R.drawable.lannister));
        } else if (namesParc.getHouse().equals(NamesParc.TARGARIEN)) {
            mImageView.setImageDrawable(this.getResources().getDrawable(R.drawable.targarien));
        }

    }

    private void setupToolbar(String s) {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(s);

        }
    }

}
