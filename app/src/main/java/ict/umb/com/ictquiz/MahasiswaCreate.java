package ict.umb.com.ictquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ict.umb.com.ictquiz.db.DBAdapter;

public class MahasiswaCreate extends AppCompatActivity {
    private DBAdapter db;
    private EditText Eid_mahasiswa, Eusername, Epassword, Enama;
    private String Sid_mahasiswa, Susername, Spassword, Snama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_create);
        db = new DBAdapter(this);
        Eid_mahasiswa = (EditText) findViewById(R.id.create_id_mahasiswa);
        Eusername = (EditText) findViewById(R.id.create_username);
        Epassword = (EditText) findViewById(R.id.create_password);
        Enama = (EditText) findViewById(R.id.create_nama);
        Button btnTambah = (Button) findViewById(R.id.create_btn);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sid_mahasiswa = String.valueOf(Eid_mahasiswa.getText());
                Susername = String.valueOf(Eusername.getText());
                Spassword = String.valueOf(Epassword.getText());
                Snama = String.valueOf(Enama.getText());
                if (Sid_mahasiswa.equals("")){
                    Eid_mahasiswa.requestFocus();
                    Toast.makeText(MahasiswaCreate.this, "Silahkan isi ID Mahasiswa",
                            Toast.LENGTH_SHORT).show();
                } else if (Susername.equals("")){
                    Eusername.requestFocus();
                    Toast.makeText(MahasiswaCreate.this, "Silahkan isi Username",
                            Toast.LENGTH_SHORT).show();
                } else if (Spassword.equals("")){
                    Epassword.requestFocus();
                    Toast.makeText(MahasiswaCreate.this, "Silahkan isi Merk",
                            Toast.LENGTH_SHORT).show();
                } else if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MahasiswaCreate.this, "Silahkan isi Tahun Buat",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Eid_mahasiswa.setText("");
                    Eusername.setText("");
                    Epassword.setText("");
                    Enama.setText("");
                    Toast.makeText(MahasiswaCreate.this, "Data telah berhasil ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateMahasiswa(new Mahasiswa(null, Susername, Spassword, Snama));
                    Intent a = new Intent(MahasiswaCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

