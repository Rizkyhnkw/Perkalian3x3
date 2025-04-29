package com.example.kali;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText bilsatu;
    private EditText bildua;
    private EditText biltiga;
    private Button hitung;
    private TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mengatur padding untuk menghindari tumpang tindih dengan sistem bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Menghubungkan elemen UI
        bilsatu = findViewById(R.id.satu);
        bildua = findViewById(R.id.dua);
        biltiga = findViewById(R.id.tiga);
        hitung = findViewById(R.id.hitung);
        hasil = findViewById(R.id.text_hasil);

        hitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.hitung) {
            // Mengambil input dari EditText
            String inputs = bilsatu.getText().toString().trim();
            String inputd = bildua.getText().toString().trim();
            String inputt = biltiga.getText().toString().trim();

            boolean isKosong = false;

            // Validasi input
            if (inputs.isEmpty()) {
                isKosong = true;
                bilsatu.setError("isi!");
            }
            if (inputd.isEmpty()) {
                isKosong = true;
                bildua.setError("isi!");
            }
            if (inputt.isEmpty()) {
                isKosong = true;
                biltiga.setError("isi!");
            }

            // Jika semua input valid, lakukan perhitungan
            if (!isKosong) {
                try {
                    double nilaiSatu = Double.parseDouble(inputs);
                    double nilaiDua = Double.parseDouble(inputd);
                    double nilaiTiga = Double.parseDouble(inputt);
                    double operasi = nilaiSatu * nilaiDua * nilaiTiga;
                    hasil.setText(String.valueOf(operasi));
                } catch (NumberFormatException e) {
                    hasil.setText("Input tidak valid");
                }
            }
        }
    }
}