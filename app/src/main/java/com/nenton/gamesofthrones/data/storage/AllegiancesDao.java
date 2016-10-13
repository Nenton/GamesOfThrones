package com.nenton.gamesofthrones.data.storage;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ALLEGIANCES".
*/
public class AllegiancesDao extends AbstractDao<Allegiances, Long> {

    public static final String TABLENAME = "ALLEGIANCES";

    /**
     * Properties of entity Allegiances.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Allegiance = new Property(2, String.class, "allegiance", false, "ALLEGIANCE");
    }

    private Query<Allegiances> persons_AllegiancesQuery;

    public AllegiancesDao(DaoConfig config) {
        super(config);
    }
    
    public AllegiancesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ALLEGIANCES\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"ALLEGIANCE\" TEXT);"); // 2: allegiance
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ALLEGIANCES\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Allegiances entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String allegiance = entity.getAllegiance();
        if (allegiance != null) {
            stmt.bindString(3, allegiance);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Allegiances entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String allegiance = entity.getAllegiance();
        if (allegiance != null) {
            stmt.bindString(3, allegiance);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Allegiances readEntity(Cursor cursor, int offset) {
        Allegiances entity = new Allegiances( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // allegiance
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Allegiances entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAllegiance(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Allegiances entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Allegiances entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Allegiances entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "allegiances" to-many relationship of Persons. */
    public List<Allegiances> _queryPersons_Allegiances(String name) {
        synchronized (this) {
            if (persons_AllegiancesQuery == null) {
                QueryBuilder<Allegiances> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Name.eq(null));
                persons_AllegiancesQuery = queryBuilder.build();
            }
        }
        Query<Allegiances> query = persons_AllegiancesQuery.forCurrentThread();
        query.setParameter(0, name);
        return query.list();
    }

}
