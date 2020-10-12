package com.abada.roomtest;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


public class TestModel extends AndroidViewModel {
    private TestRepo testRepo;
    private LiveData<List<Test>> tests;

    public TestModel(final Application application) {
        super(application);
        testRepo = TestRepo.getInstance(application);
        tests = testRepo.getTests();
    }

    public LiveData<List<Test>> get() {
        return tests;
    }
}
