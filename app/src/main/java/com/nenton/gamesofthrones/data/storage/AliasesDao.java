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
 * DAO for table "ALIASES".
*/
public class AliasesDao extends AbstractDao<Aliases, Long> {

    public static final String TABLENAME = "ALIASES";

    /**
     * Properties of entity Aliases.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Aliase = new Property(2, String.class, "aliase", false, "ALIASE");
    }

    private Query<Aliases> persons_AliasesQuery;

    public AliasesDao(DaoConfig config) {
        super(config);
    }
    
    public AliasesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ALIASES\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"ALIASE\" TEXT);"); // 2: aliase
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ALIASES\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Aliases entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String aliase = entity.getAliase();
        if (aliase != null) {
            stmt.bindString(3, aliase);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Aliases entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String aliase = entity.getAliase();
        if (aliase != null) {
            stmt.bindString(3, aliase);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Aliases readEntity(Cursor cursor, int offset) {
        Aliases entity = new Aliases( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // aliase
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Aliases entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAliase(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Aliases entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Aliases entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Aliases entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "aliases" to-many relationship of Persons. */
    public List<Aliases> _queryPersons_Aliases(String name) {
        synchronized (this) {
            if (persons_AliasesQuery == null) {
                QueryBuilder<Aliases> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Name.eq(null));
                persons_AliasesQuery = queryBuilder.build();
            }
        }
        Query<Aliases> query = persons_AliasesQuery.forCurrentThread();
        query.setParameter(0, name);
        return query.list();
    }

}
