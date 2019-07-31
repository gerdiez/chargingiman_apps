package com.example.doadoa.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.doadoa.Dao.DoaDao;
import com.example.doadoa.Entity.Doa;

@Database(entities = {Doa.class}, version = 1)
    public abstract class AppDatabase  extends RoomDatabase {

        public abstract DoaDao doaDao();

}

