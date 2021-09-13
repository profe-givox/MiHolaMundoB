package net.ivanvega.miholamundob;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    EditText txtU;
    Button btnEnter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        txtU = findViewById(R.id.txtUs);

        Intent intentPara =  getIntent();

        String parnom =
                intentPara.getStringExtra("nombre");

        txtU.setText(parnom);

        btnEnter = findViewById(R.id.btnEntrar);
        btnEnter.setOnClickListener(view -> {
            Intent intent= new Intent();
            intent.putExtra("token", "0x23kjhlksdf8o7w234llkjhsid");

            /*
            Usuario u = new Usuario();
            u.setNombre(txtU.getText().toString());
            u.email(txtE.getText());
            ...
            intent.putExtra("user", u);
*/

            setResult(RESULT_OK, intent);
            finish();

        });

    }

}
