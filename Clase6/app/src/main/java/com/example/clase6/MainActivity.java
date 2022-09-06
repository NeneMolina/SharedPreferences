package com.example.clase6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText usuario,clave;
    TextView user,password;
    Button guardar,recuperar;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.TextoUsuario);
        clave = findViewById(R.id.TextoClave);
        user = findViewById(R.id.Usuario);
        password = findViewById(R.id.Clave);
        guardar = findViewById(R.id.Guardar);
        recuperar = findViewById(R.id.Recuperar);
        imagen = findViewById(R.id.imagen);

        imagen.setImageDrawable(R.drawable.descarga);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferencias =getSharedPreferences("Datos", Context.MODE_PRIVATE);

                SharedPreferences.Editor ObjetoEditor = preferencias.edit();
                //Guardamos lo que tenemos en edit text con id usuario
                ObjetoEditor.putString("Usuarios", usuario.getText().toString());
                ObjetoEditor.putString("Clave",clave.getText().toString());
                //guardamos los datos
                ObjetoEditor.commit();
                //Terminar la aplicacion
                //finish();

            }
        });

        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("Datos", Context.MODE_PRIVATE);
                user.setText(preferences.getString("Usuarios",""));
                password.setText(preferences.getString("Clave",""));
            }
        });

        SharedPreferences Preferencia = getSharedPreferences("Datos", Context.MODE_PRIVATE);

        usuario.setText(Preferencia.getString("Usuarios",""));
        clave.setText(Preferencia.getString("Clave",""));
        imagen.setImageDrawable(Preferencia.getString("Imagen","");
        //Usuarios es donde tendremos guardados el valor de Edittext
        //Si, es para cuando se inicializa la aplicaciòn dejar un campo vacio
    }
}