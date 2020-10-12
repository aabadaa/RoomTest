package com.abada.roomtest;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tests")
public class Test {
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "number")
    private String nubmer;
    @PrimaryKey(autoGenerate = true)
    private int id;

    @Ignore
    public Test(String name) {
        this.name = name;
    }

    @Ignore
    public Test(String name, String nubmer) {
        this(name);
        this.nubmer = nubmer;
    }

    public Test() {
    }

    public String getNubmer() {
        return nubmer;
    }

    public void setNubmer(String nubmer) {
        this.nubmer = nubmer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
