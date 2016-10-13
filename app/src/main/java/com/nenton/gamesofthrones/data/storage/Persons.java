package com.nenton.gamesofthrones.data.storage;

import com.nenton.gamesofthrones.data.network.res.ListNames;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

@Entity
public class Persons {
    @Id(autoincrement = true)
    private Long id;
    
    private String url;

    private String name;

    private String born;

    private String died;

    private String father;

    private String mother;

    private String culture;

    private String house;

    @ToMany(joinProperties = {@JoinProperty(name = "url",referencedName = "name")})
    private List<Aliases> aliases;

    @ToMany(joinProperties = {@JoinProperty(name = "url",referencedName = "name")})
    private List<Titles> titles;

    @ToMany(joinProperties = {@JoinProperty(name = "url",referencedName = "name")})
    private List<Allegiances> allegiances;

    @ToMany(joinProperties = {@JoinProperty(name = "url",referencedName = "name")})
    private List<TvSeries> series;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 244700660)
    private transient PersonsDao myDao;

    public Persons(ListNames names, String house) {
        this.url = names.getUrl();
        this.name = names.getName();
        this.born = names.getBorn();
        this.father = names.getFather();
        this.mother = names.getMother();
        this.culture = names.getCulture();
        this.house = house;
        this.died = names.getDied();
    }


    @Generated(hash = 1519000671)
    public Persons() {
    }


    @Generated(hash = 278607865)
    public Persons(Long id, String url, String name, String born, String died, String father,
            String mother, String culture, String house) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.born = born;
        this.died = died;
        this.father = father;
        this.mother = mother;
        this.culture = culture;
        this.house = house;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorn() {
        return this.born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getFather() {
        return this.father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return this.mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1824773338)
    public List<Aliases> getAliases() {
        if (aliases == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AliasesDao targetDao = daoSession.getAliasesDao();
            List<Aliases> aliasesNew = targetDao._queryPersons_Aliases(url);
            synchronized (this) {
                if (aliases == null) {
                    aliases = aliasesNew;
                }
            }
        }
        return aliases;
    }


    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 731614754)
    public synchronized void resetAliases() {
        aliases = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1570363735)
    public List<Titles> getTitles() {
        if (titles == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TitlesDao targetDao = daoSession.getTitlesDao();
            List<Titles> titlesNew = targetDao._queryPersons_Titles(url);
            synchronized (this) {
                if (titles == null) {
                    titles = titlesNew;
                }
            }
        }
        return titles;
    }


    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1506933621)
    public synchronized void resetTitles() {
        titles = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 429284493)
    public List<Allegiances> getAllegiances() {
        if (allegiances == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AllegiancesDao targetDao = daoSession.getAllegiancesDao();
            List<Allegiances> allegiancesNew = targetDao._queryPersons_Allegiances(url);
            synchronized (this) {
                if (allegiances == null) {
                    allegiances = allegiancesNew;
                }
            }
        }
        return allegiances;
    }


    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1685960620)
    public synchronized void resetAllegiances() {
        allegiances = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 605428333)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPersonsDao() : null;
    }

    public String getCulture() {
        return this.culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getHouse() {
        return this.house;
    }

    public void setHouse(String house) {
        this.house = house;
    }


    public String getUrl() {
        return this.url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public String getDied() {
        return this.died;
    }


    public void setDied(String died) {
        this.died = died;
    }


    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 289386359)
    public List<TvSeries> getSeries() {
        if (series == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TvSeriesDao targetDao = daoSession.getTvSeriesDao();
            List<TvSeries> seriesNew = targetDao._queryPersons_Series(url);
            synchronized (this) {
                if (series == null) {
                    series = seriesNew;
                }
            }
        }
        return series;
    }


    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 690907782)
    public synchronized void resetSeries() {
        series = null;
    }

  
   }
