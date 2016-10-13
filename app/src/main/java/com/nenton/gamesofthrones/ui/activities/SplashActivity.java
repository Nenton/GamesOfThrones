package com.nenton.gamesofthrones.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nenton.gamesofthrones.R;
import com.nenton.gamesofthrones.data.manager.DataManager;
import com.nenton.gamesofthrones.data.network.res.ListNames;
import com.nenton.gamesofthrones.data.storage.Aliases;
import com.nenton.gamesofthrones.data.storage.AliasesDao;
import com.nenton.gamesofthrones.data.storage.Allegiances;
import com.nenton.gamesofthrones.data.storage.AllegiancesDao;
import com.nenton.gamesofthrones.data.storage.Persons;
import com.nenton.gamesofthrones.data.storage.PersonsDao;
import com.nenton.gamesofthrones.data.storage.Titles;
import com.nenton.gamesofthrones.data.storage.TitlesDao;
import com.nenton.gamesofthrones.data.storage.TvSeries;
import com.nenton.gamesofthrones.data.storage.TvSeriesDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    private static final String BD = "BD";
    public static final String STARK_HOUSE = "http://www.anapioficeandfire.com/api/houses/362";
    public static final String LANNISTER_HOUSE = "http://www.anapioficeandfire.com/api/houses/229";
    public static final String TARGARYEN_HOUSE = "http://www.anapioficeandfire.com/api/houses/378";

    private PersonsDao mPersonsDao;
    private AliasesDao mAliasesDao;
    private TitlesDao mTitlesDao;
    private TvSeriesDao mTvSeriesDao;
    private AllegiancesDao mAllegiancesDao;

    String mHouse;

    private List<Persons> mListNames = new ArrayList<>();
    private List<Titles> mTitles = new ArrayList<>();
    private List<TvSeries> mTV = new ArrayList<>();
    private List<Aliases> mAliases = new ArrayList<>();
    private List<Allegiances> mAllegiances = new ArrayList<>();
    private DataManager mDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mDataManager = DataManager.getInstanse();
        int f = DataManager.getInstanse().getSharedPref().getInt(BD, 0);

        if (f == 0) {

            for (int i = 1; i < 44; i++) {

                Call<List<ListNames>> call = DataManager.getInstanse().getListNames(i);
                call.enqueue(new Callback<List<ListNames>>() {
                    @Override
                    public void onResponse(Call<List<ListNames>> call, Response<List<ListNames>> response) {
                        try {
                            if (response.code() == 200) {
                                for (ListNames names : response.body()) {
                                    mHouse = "";
                                    mAliases.addAll(makeListAlieses(names));
                                    mAllegiances.addAll(makeListAllegiances(names));
                                    mTV.addAll(makeListTvSeriesList(names));
                                    mTitles.addAll(makeListTitles(names));
                                    mListNames.add(new Persons(names, mHouse));
                                    int j = mDataManager.getSharedPref().getInt(BD, 0);
                                    SharedPreferences.Editor editor = mDataManager.getSharedPref().edit();
                                    editor.putInt(BD, ++j);
                                    editor.apply();
                                }
                                mPersonsDao = DataManager.getInstanse().getDaoSession().getPersonsDao();
                                mAliasesDao = DataManager.getInstanse().getDaoSession().getAliasesDao();
                                mTitlesDao = DataManager.getInstanse().getDaoSession().getTitlesDao();
                                mTvSeriesDao = DataManager.getInstanse().getDaoSession().getTvSeriesDao();
                                mAllegiancesDao = DataManager.getInstanse().getDaoSession().getAllegiancesDao();

                                mPersonsDao.insertOrReplaceInTx(mListNames);
                                mTitlesDao.insertOrReplaceInTx(mTitles);
                                mAliasesDao.insertOrReplaceInTx(mAliases);
                                mTvSeriesDao.insertOrReplaceInTx(mTV);
                                mAllegiancesDao.insertOrReplaceInTx(mAllegiances);
                            }
                        } catch (RuntimeException e) {

                        }
                    }

                    @Override
                    public void onFailure(Call<List<ListNames>> call, Throwable t) {

                    }
                });
            }

        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, CharacterListScreen.class);
                startActivity(intent);
            }
        }, 3000);

    }

    private List<Allegiances> makeListAllegiances(ListNames names) {
        List<Allegiances> aliases = new ArrayList<>();
        for (String s : names.getAllegiances()) {
            aliases.add(new Allegiances(names.getUrl(), s));
            switch (s) {
                case STARK_HOUSE:
                    mHouse = DataManager.STARK_FAMILY;
                    break;
                case LANNISTER_HOUSE:
                    mHouse = DataManager.LANNISTER_FAMILY;
                    break;
                case TARGARYEN_HOUSE:
                    mHouse = DataManager.TARGARYEN_FAMILY;
                    break;
            }
        }
        return aliases;
    }

    private List<Titles> makeListTitles(ListNames names) {
        List<Titles> titles = new ArrayList<>();
        for (Object s : names.getTitles()) {
            titles.add(new Titles(names.getUrl(), (String) s));
        }
        return titles;
    }

    private List<TvSeries> makeListTvSeriesList(ListNames names) {
        List<TvSeries> titles = new ArrayList<>();
        for (String s : names.getTvSeries()) {
            titles.add(new TvSeries(names.getUrl(), (s)));
        }
        return titles;
    }

    private List<Aliases> makeListAlieses(ListNames names) {
        List<Aliases> aliases = new ArrayList<>();
        for (String s : names.getAliases()) {
            aliases.add(new Aliases(names.getUrl(), s));
        }
        return aliases;
    }
}
