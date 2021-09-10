package net.ivanvega.miholamundob;

import static java.net.Proxy.Type.HTTP;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
    Button btnMT, btnActForResul;
    EditText txtMT;
    ActivityResultLauncher<Intent> launcherActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMT = findViewById(R.id.txt1);
        btnMT = findViewById(R.id.btn1);
        btnActForResul = findViewById(R.id.btnAR);
        btnActForResul.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,
                    SecondActivity.class);
            launcherActivity.launch(intent);
        });

        launcherActivity = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode()==RESULT_OK) {
                            Intent intent =
                                    result.getData();
                            Toast.makeText(getApplicationContext(),
                                    intent.getStringExtra("token"),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    }
                }
        );


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

        /*
        Intent i = new
                Intent(android.content.Intent.ACTION_PICK);
        i.setType(ContactsContract.Contacts.CONTENT_TYPE);
        startActivity(i);*/

       /* // Map point based on address
        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
        // Or map point based on latitude/longitude
         //Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        startActivity(mapIntent);*/

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
// The intent does not have a URI, so declare the "text/plain" MIME type
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jan@example.com"}); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
        //emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
// You can also attach multiple items by passing an ArrayList of Uris

        startActivity(emailIntent);


    }

}