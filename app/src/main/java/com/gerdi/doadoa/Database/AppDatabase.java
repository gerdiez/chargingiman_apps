package com.gerdi.doadoa.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.gerdi.doadoa.Dao.DoaDao;
import com.gerdi.doadoa.Entity.Doa;

@Database(entities = {Doa.class}, version = 1)
    public abstract class AppDatabase  extends RoomDatabase {

        public abstract DoaDao doaDao();

}

