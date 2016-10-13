package com.nenton.gamesofthrones.data.manager;

import android.content.SharedPreferences;

import com.nenton.gamesofthrones.data.network.RestService;
import com.nenton.gamesofthrones.data.network.ServiceGen;
import com.nenton.gamesofthrones.data.network.res.ListNames;
import com.nenton.gamesofthrones.data.storage.Allegiances;
import com.nenton.gamesofthrones.data.storage.AllegiancesDao;
import com.nenton.gamesofthrones.data.storage.DaoSession;
import com.nenton.gamesofthrones.data.storage.Persons;
import com.nenton.gamesofthrones.data.storage.PersonsDao;
import com.nenton.gamesofthrones.utils.GOTAplication;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class DataManager {

    private static DataManager INSTANCE = null;

    public final static String STARK_FAMILY = "STARK_FAMILY";
    public static String LANNISTER_FAMILY = "LANNISTER_FAMILY";
    public static String TARGARYEN_FAMILY = "TARGARYEN_FAMILY";

    RestService mRestService;

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    DaoSession mDaoSession;

    private DataManager() {
        mRestService = ServiceGen.createService(RestService.class);
        mDaoSession = GOTAplication.getDaoSession();
    }

    public static DataManager getInstanse() {
        if (INSTANCE == null) {
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    public Call<List<ListNames>> getListNames(int i) {
        return mRestService.getNames(String.valueOf(i));
    }

    public void setNamesInBd(ListNames namesInBd) {

    }

    public List<Persons> getStarkHouse() {
        List<Persons> personsList = new ArrayList<>();
        try {
            personsList = mDaoSession.queryBuilder(Persons.class)
                    .where(PersonsDao.Properties.House.eq(STARK_FAMILY))
                    .build()
                    .list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return personsList;
    }

    public List<Persons> getLannisterHouse() {
        List<Persons> personsList = new ArrayList<>();
        try {
            personsList = mDaoSession.queryBuilder(Persons.class)
                    .where(PersonsDao.Properties.House.eq(LANNISTER_FAMILY))
                    .build()
                    .list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return personsList;
    }

    public List<Persons> getTargaryenHouse() {
        List<Persons> personsList = new ArrayList<>();
        try {
            personsList = mDaoSession.queryBuilder(Persons.class)
                    .where(PersonsDao.Properties.House.eq(TARGARYEN_FAMILY))
                    .build()
                    .list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return personsList;
    }

    public SharedPreferences getSharedPref() {
        return GOTAplication.getSharedPreferences();
    }

    public Persons getPerson(String url) {
        Persons person = null;
        try {
            person = mDaoSession.queryBuilder(Persons.class)
                    .where(PersonsDao.Properties.Url.eq(url))
                    .build()
                    .unique();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }
}
