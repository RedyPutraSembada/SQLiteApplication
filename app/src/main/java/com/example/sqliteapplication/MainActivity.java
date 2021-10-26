package com.example.sqliteapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button simpanBtn,tampilBtn;
    private EditText namaEditText;
    private DatabaseHelper databaseHelper;
    private TextView namaTextView;
    private ArrayList<String> namaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpanBtn = (Button) findViewById(R.id.btnSimpan);
        tampilBtn = (Button) findViewById(R.id.btnTampil);
        namaTextView = (TextView) findViewById(R.id.tampilNama);
        namaEditText = (EditText) findViewById(R.id.editNama);

        databaseHelper = new DatabaseHelper(this);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addStudentDetail(namaEditText.getText().toString());
                namaEditText.setText("");
                Toast.makeText(MainActivity.this,"Sudah Disimpan",Toast.LENGTH_SHORT).show();
            }
        });

        tampilBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namaArrayList = databaseHelper.getALLStudentsList();
                namaTextView.setText("");
                for(int i=0;i<namaArrayList.size();i++) {
                    if (i == 0) {
                        namaTextView.setText(namaArrayList.get(i));

                    } else {
                        namaTextView.setText(namaTextView.getText().toString()+" \n "+namaArrayList);
                    }
                }

            }
        });
    }

}