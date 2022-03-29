package es.ucm.twint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword;
    Button btLogin;
    Button btVerPerfiles;
    Button btVerMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.etUser);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btLogin = (Button) findViewById(R.id.btLogin);
        btVerPerfiles = (Button) findViewById(R.id.btVerPerfiles);
        btVerMenu = (Button) findViewById(R.id.btVerMenu);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                Toast.makeText(MainActivity.this, "Hola Mario: " + userName + "@" + password, Toast.LENGTH_LONG).show();
            }
        });

        btVerPerfiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent verPerfiles = new Intent(MainActivity.this, VerPerfiles.class );
                startActivity(verPerfiles);
            }
        });

        btVerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent verMenu = new Intent(MainActivity.this, VerMenu.class );
                startActivity(verMenu);
            }
        });
    }



}