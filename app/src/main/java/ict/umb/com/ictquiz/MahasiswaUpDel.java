package ict.umb.com.ictquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MahasiswaUpDel extends AppCompatActivity {
    private db_rentalMobil db;
    private String Sid, Sno_plat, Sjenis, Smerk, Stahun_buat, Swarna;
    private EditText Eno_plat, Ejenis, Emerk, Etahun_buat, Ewarna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new db_rentalMobil(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Sno_plat = i.getStringExtra("Ino_plat");
        Sjenis = i.getStringExtra("Ijenis");
        Smerk = i.getStringExtra("Imerk");
        Stahun_buat = i.getStringExtra("Itahun_buat");
        Swarna = i.getStringExtra("Iwarna");
        Eno_plat = (EditText) findViewById(R.id.updel_no_plat);
        Ejenis = (EditText) findViewById(R.id.updel_jenis);
        Emerk = (EditText) findViewById(R.id.updel_merk);
        Etahun_buat = (EditText) findViewById(R.id.updel_tahun_buat);
        Ewarna = (EditText) findViewById(R.id.updel_warna);
        Eno_plat.setText(Sno_plat);
        Ejenis.setText(Sjenis);
        Emerk.setText(Smerk);
        Etahun_buat.setText(Stahun_buat);
        Ewarna.setText(Swarna);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sno_plat = String.valueOf(Eno_plat.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                Smerk = String.valueOf(Emerk.getText());
                Stahun_buat = String.valueOf(Etahun_buat.getText());
                Swarna = String.valueOf(Ewarna.getText());
                if (Sno_plat.equals("")){
                    Eno_plat.requestFocus();
                    Toast.makeText(MainUpDel.this, "Silahkan isi Nomer Plat",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainUpDel.this, "Silahkan isi Jenis",
                            Toast.LENGTH_SHORT).show();
                } else if (Smerk.equals("")){
                    Emerk.requestFocus();
                    Toast.makeText(MainUpDel.this, "Silahkan isi Merk",
                            Toast.LENGTH_SHORT).show();
                } else if (Stahun_buat.equals("")){
                    Etahun_buat.requestFocus();
                    Toast.makeText(MainUpDel.this, "Silahkan isi Tahun Buat",
                            Toast.LENGTH_SHORT).show();
                } else if (Swarna.equals("")){
                    Ewarna.requestFocus();
                    Toast.makeText(MainUpDel.this, "Silahkan isi Warna",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateMobil(new Mobil(Sid, Sno_plat, Sjenis, Smerk, Stahun_buat, Swarna));
                    Toast.makeText(MainUpDel.this, "Data telah berhasil diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteMobil(new Mobil(Sid, Sno_plat, Sjenis, Smerk, Stahun_buat, Swarna));
                Toast.makeText(MainUpDel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

