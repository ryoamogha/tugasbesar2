package ict.umb.com.ictquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ict.umb.com.ictquiz.db.DBAdapter;

public class MahasiswaUpDel extends AppCompatActivity {
    private DBAdapter db;
    private String Sid_mahasiswa, Snim, Susername, Spassword, Snama;
    private EditText Enim, Eusername, Epassword, Enama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_up_del);
        db = new DBAdapter(this);
        Intent i = this.getIntent();
        Sid_mahasiswa = i.getStringExtra("Iid_mahasiswa");
        Snim = i.getStringExtra("Inim");
        Susername = i.getStringExtra("Iusername");
        Spassword = i.getStringExtra("Ipassword");
        Snama = i.getStringExtra("Inama");
        Enim = (EditText) findViewById(R.id.updel_nim);
        Eusername = (EditText) findViewById(R.id.updel_username);
        Epassword = (EditText) findViewById(R.id.updel_password);
        Enama = (EditText) findViewById(R.id.updel_nama);
        Enim.setText(Snim);
        Eusername.setText(Susername);
        Epassword.setText(Spassword);
        Enama.setText(Snama);
        Button btnUpdate = (Button) findViewById(R.id.updel_btn_edit);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snim = String.valueOf(Enim.getText());
                Susername = String.valueOf(Eusername.getText());
                Spassword = String.valueOf(Epassword.getText());
                Snama = String.valueOf(Enama.getText());
                if (Snim.equals("")){
                    Enim.requestFocus();
                    Toast.makeText(MahasiswaUpDel.this, "Silahkan isi NIM",
                            Toast.LENGTH_SHORT).show();
                } else if (Susername.equals("")){
                    Eusername.requestFocus();
                    Toast.makeText(MahasiswaUpDel.this, "Silahkan isi Username",
                            Toast.LENGTH_SHORT).show();
                } else if (Spassword.equals("")){
                    Epassword.requestFocus();
                    Toast.makeText(MahasiswaUpDel.this, "Silahkan isi Password",
                            Toast.LENGTH_SHORT).show();
                } else if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MahasiswaUpDel.this, "Silahkan isi Nama",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateMahasiswa(new Mahasiswa(Sid_mahasiswa, Snim, Susername, Spassword, Snama));
                    Toast.makeText(MahasiswaUpDel.this, "Data telah berhasil diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.updel_btn_hapus);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteMahasiswa(new Mahasiswa(Sid_mahasiswa, Snim, Susername, Spassword, Snama));
                Toast.makeText(MahasiswaUpDel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

