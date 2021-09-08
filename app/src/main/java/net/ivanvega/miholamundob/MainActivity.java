package net.ivanvega.miholamundob;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnMT;
    EditText txtMT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMT = findViewById(R.id.txt1);
        btnMT = findViewById(R.id.btn1);

        btnMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = txtMT.getText().toString();

                Toast.makeText(MainActivity.this,
                        texto,
                        Toast.LENGTH_LONG
                        ).show();

                btnMT.setText("Cancel");

            }
        });

    }

    public void btnAbrirActivity_click(View v){
        Intent intent =
                new Intent(MainActivity.this,
                SecondActivity.class);

        intent.putExtra("nombre",
                txtMT.getText().toString()  );

        startActivity(intent);

    }

    public void btnInvocarAV_click (View v){
        /*
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://developer.android.com"));
        startActivity(
                intent        );
    */

        Intent i = new
                Intent(android.content.Intent.ACTION_PICK);
        i.setType(ContactsContract.Contacts.CONTENT_TYPE);
        startActivity(i);


    }

}