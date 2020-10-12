package com.abada.roomtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TestModel testModel;
    TestAdapter testAdapter;
    RecyclerView recyclerView;
    Button change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        change = findViewById(R.id.change);

        testModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(TestModel.class);
        testAdapter = new TestAdapter(testModel.get().getValue());
        recyclerView.setAdapter(testAdapter);
        testModel.get().observe(this, new Observer<List<Test>>() {
            @Override
            public void onChanged(List<Test> tests) {
                testAdapter.setTests(tests);
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddActivty.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}