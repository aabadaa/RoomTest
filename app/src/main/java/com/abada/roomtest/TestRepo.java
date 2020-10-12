package com.abada.roomtest;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class TestRepo {
    public static TestRepo instance;

    private TestDao dao;
    private MutableLiveData<List<Test>> tests = new MutableLiveData<>();
    private MutableLiveData<Test> test = new MutableLiveData<>();

    private TestRepo(Application application) {
        dao = MyRoom.getInstance(application).getDao();
        MyRoom.executer.execute(() -> {
            tests.postValue((dao.getAll()));
            if (tests.getValue() == null)
                tests.postValue(new ArrayList<Test>());
        });
    }

    public static TestRepo getInstance(Application application) {
        if (instance == null)
            instance = new TestRepo(application);
        return instance;
    }

    public LiveData<List<Test>> getTests() {
        return tests;
    }

    public void insert(Test test) {
        MyRoom.executer.execute(() -> {
            dao.insert(test);
            tests.getValue().add(test);
            tests.postValue(tests.getValue());
        });
    }

    public LiveData<Test> getTestById(int id) {
        MyRoom.executer.execute(() -> {
            test.postValue(dao.getTestById(id));
        });
        return test;
    }

    public void delete(Test test) {
        MyRoom.executer.execute(() -> {
            dao.delete(test);
        });
    }

}
