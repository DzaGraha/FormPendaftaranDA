package id.sch.smktelkom_mlg.learn.formpendaftaranda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNama;
    EditText etPanggilan;
    RadioButton rbLk, rbPr;
    Spinner spKelas;
    CheckBox cbSmph, cbSandi, cbTl, cbPbb, cbJl;
    int nHal;
    Button Sm;
    TextView tvHasil, tvHal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etPanggilan = (EditText) findViewById(R.id.editTextPanggilan);
        rbLk = (RadioButton) findViewById(R.id.radioButtonLk);
        rbPr = (RadioButton) findViewById(R.id.radioButtonPr);
        spKelas = (Spinner) findViewById(R.id.spinnerKelas);
        cbSmph = (CheckBox) findViewById(R.id.checkBoxSmph);
        cbSandi = (CheckBox) findViewById(R.id.checkBoxSandi);
        cbTl = (CheckBox) findViewById(R.id.checkBoxTl);
        cbPbb = (CheckBox) findViewById(R.id.checkBoxPBB);
        cbJl = (CheckBox) findViewById(R.id.checkBoxJl);
        Sm = (Button) findViewById(R.id.buttonSm);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHal = (TextView) findViewById(R.id.textViewCan);

        cbSmph.setOnCheckedChangeListener(this);
        cbSandi.setOnCheckedChangeListener(this);
        cbTl.setOnCheckedChangeListener(this);
        cbPbb.setOnCheckedChangeListener(this);
        cbJl.setOnCheckedChangeListener(this);

        Sm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String hasil = null;
        String hasil1 = "\nHal yang dikuasai : \n";

        if (rbLk.isChecked()) {
            hasil = rbLk.getText().toString();
        } else if (rbPr.isChecked()) {
            hasil = rbPr.getText().toString();
        }

        int startlen = hasil1.length();
        if (cbSmph.isChecked()) hasil1 += "- " + cbSmph.getText() + "\n";
        if (cbSandi.isChecked()) hasil1 += "- " + cbSandi.getText() + "\n";
        if (cbTl.isChecked()) hasil1 += "- " + cbTl.getText() + "\n";
        if (cbPbb.isChecked()) hasil1 += "- " + cbPbb.getText() + "\n";
        if (cbJl.isChecked()) hasil1 += "- " + cbJl.getText() + "\n";
        if (hasil1.length() == startlen) hasil1 += "Tidak ada";

        if (isValid()) {
            String nama = etNama.getText().toString();
            String panggilan = etPanggilan.getText().toString();
            tvHasil.setText("Nama Lengkap   : \t" + nama + "\nNama Panggilan : \t" + panggilan + "\nJenis Kelamin     : \t" + hasil + "" + "\nKelas                    : \t" + spKelas.getSelectedItem().toString() + hasil1);
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

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) nHal += 1;
        else nHal -= 1;

        tvHal.setText(nHal + " hal yang dikuasai");
    }
}
