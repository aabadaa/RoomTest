package com.abada.roomtest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivty extends AppCompatActivity {
    Button saveButton;
    EditText nameEditText, numberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_activty);
        saveButton = findViewById(R.id.save);
        nameEditText = findViewById(R.id.name);
        numberEditText = findViewById(R.id.number);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameEditText.getText().toString().isEmpty()) {
                    nameEditText.setError("write a name");
                    nameEditText.requestFocus();
                } else if (numberEditText.getText().toString().isEmpty()) {
                    numberEditText.setError("write a name");
                    numberEditText.requestFocus();
                } else {
                    String name = nameEditText.getText().toString();
                    String number = numberEditText.getText().toString();
                    TestRepo.getInstance(getApplication()).insert(new Test(name, number));
                    nameEditText.setText("");
                    numberEditText.setText("");
                    Toast.makeText(AddActivty.this, "saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}