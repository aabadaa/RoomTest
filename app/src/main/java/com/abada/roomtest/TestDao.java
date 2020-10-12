package com.abada.roomtest;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TestDao {
    @Query("select*from tests")
    List<Test> getAll();

    @Query("select*from tests where id=:id")
    Test getTestById(int id);

    @Insert
    void insert(Test test);

    @Delete
    void delete(Test t);
}
