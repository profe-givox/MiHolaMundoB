package net.ivanvega.miholamundob;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    EditText txtU;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        txtU = findViewById(R.id.txtUs);

        Intent intentPara =  getIntent();

        String parnom =
                intentPara.getStringExtra("nombre");

        txtU.setText(parnom);
    }

}
