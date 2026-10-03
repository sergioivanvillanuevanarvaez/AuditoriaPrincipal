package com.example.auditoriaprincipal;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private NetworkReceiver networkReceiver;
    private TextView tvEstado;
    private Button btnHistorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tvEstado = findViewById(R.id.tv_estado);
        btnHistorial = findViewById(R.id.btn_historial);

        networkReceiver = new NetworkReceiver();

        btnHistorial.setOnClickListener(v -> {

            tvEstado.setText(
                    "La aplicación está funcionando"
            );
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter filtro = new IntentFilter(
                ConnectivityManager.CONNECTIVITY_ACTION
        );

        registerReceiver(
                networkReceiver,
                filtro
        );
    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(
                networkReceiver
        );
    }
}