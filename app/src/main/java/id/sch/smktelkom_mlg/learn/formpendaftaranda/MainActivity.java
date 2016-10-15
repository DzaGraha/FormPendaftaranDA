package id.sch.smktelkom_mlg.learn.formpendaftaranda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etPanggilan;
    Button Sm;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etPanggilan = (EditText) findViewById(R.id.editTextPanggilan);
        Sm = (Button) findViewById(R.id.buttonSm);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        Sm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String panggilan = etPanggilan.getText().toString();
            tvHasil.setText("Nama Lengkap : \t" + nama + "\nNama Panggilan : \t" + panggilan);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String Nama = etNama.getText().toString();
        String Panggilan = etPanggilan.getText().toString();

        if (Nama.isEmpty()) {
            etNama.setError("Nama panjang belum diisi");
            valid = false;
        } else if (Nama.length() < 5) {
            etNama.setError("Nama panjang kurang dari 5 karakter");
            valid = false;
        } else
            etNama.setError(null);

        if (Panggilan.isEmpty()) {
            etPanggilan.setError("Nama panjang belum diisi");
            valid = false;
        } else
            etPanggilan.setError(null);

        return valid;
    }
}
