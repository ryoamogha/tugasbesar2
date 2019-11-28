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
    private EditText Enim, Eusername, Epassword, Enama;
    private String Snim, Susername, Spassword, Snama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_create);
        db = new DBAdapter(this);
        Enim = (EditText) findViewById(R.id.create_nim);
        Eusername = (EditText) findViewById(R.id.create_username);
        Epassword = (EditText) findViewById(R.id.create_password);
        Enama = (EditText) findViewById(R.id.create_nama);
        Button btnTambah = (Button) findViewById(R.id.create_btn);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snim = String.valueOf(Enim.getText());
                Susername = String.valueOf(Eusername.getText());
                Spassword = String.valueOf(Epassword.getText());
                Snama = String.valueOf(Enama.getText());
                if (Snim.equals("")){
                    Enim.requestFocus();
                    Toast.makeText(MahasiswaCreate.this, "Silahkan isi NIM Mahasiswa",
                            Toast.LENGTH_SHORT).show();
                } else if (Susername.equals("")){
                    Eusername.requestFocus();
                    Toast.makeText(MahasiswaCreate.this, "Silahkan isi Username",
                            Toast.LENGTH_SHORT).show();
                } else if (Spassword.equals("")){
                    Epassword.requestFocus();
                    Toast.makeText(MahasiswaCreate.this, "Silahkan isi Password",
                            Toast.LENGTH_SHORT).show();
                } else if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MahasiswaCreate.this, "Silahkan isi Nama",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enim.setText("");
                    Eusername.setText("");
                    Epassword.setText("");
                    Enama.setText("");
                    Toast.makeText(MahasiswaCreate.this, "Data telah berhasil ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateMahasiswa(new Mahasiswa(null, Snim, Susername, Spassword, Snama));
                    Intent a = new Intent(MahasiswaCreate.this, AdminActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

