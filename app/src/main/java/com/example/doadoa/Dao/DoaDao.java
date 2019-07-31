package com.example.doadoa.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.doadoa.Entity.Doa;

import java.util.List;

@Dao
public interface DoaDao {

    @Query("SELECT * FROM Doa")
    List<Doa> getAll();

    @Insert
    void insertAll(Doa doas);

    @Update
    void update(Doa doas);

    @Delete
    void delete(Doa doa);

}
