package ict.umb.com.ictquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ict.umb.com.ictquiz.db.DBAdapter;

public class MahasiswaRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private DBAdapter db;
    private List<Mahasiswa> ListMahasiswa = new ArrayList<Mahasiswa>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_read);
        db = new DBAdapter(this);
        adapter_off = new CustomListAdapter(this, ListMahasiswa );
        mListView = (ListView) findViewById(R.id.lvMahasiswa);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMahasiswa.clear();
        List<Mahasiswa> mahasiswa = db.getAllMahasiswa();
        for (Mahasiswa mhs : mahasiswa) {
            Mahasiswa mh = new Mahasiswa();
            mhs.set_id_mahasiswa(mh.get_id_mahasiswa());
            mhs.set_nim(mh.get_nim());
            mhs.set_username(mh.get_username());
            mhs.set_password(mh.get_password());
            mhs.set_nama(mh.get_nama());
            ListMahasiswa.add(mhs);
            if ((ListMahasiswa.isEmpty()))
                Toast.makeText(MahasiswaRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Mahasiswa obj_itemDetails = (Mahasiswa)o;
        String Sid_mahasiswa = obj_itemDetails.get_id_mahasiswa();
        String Susername = obj_itemDetails.get_username();
        String Spassword = obj_itemDetails.get_password();
        String Snama = obj_itemDetails.get_nama();
        Intent goUpdel = new Intent(MahasiswaRead.this, MahasiswaUpDel.class);
        goUpdel.putExtra("Iid_mahasiswa", Sid_mahasiswa);
        goUpdel.putExtra("Iusername", Susername);
        goUpdel.putExtra("Ipassword", Spassword);
        goUpdel.putExtra("Inama", Snama);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListMahasiswa.clear();
        mListView.setAdapter(adapter_off);
        List<Mahasiswa> mahasiswa = db.getAllMahasiswa();
        for (Mahasiswa mh : mahasiswa) {
            Mahasiswa judulModel = new Mahasiswa();
            judulModel.set_id_mahasiswa(mh.get_id_mahasiswa());
            judulModel.set_username(mh.get_username());
            judulModel.set_password(mh.get_password());
            judulModel.set_nama(mh.get_nama());
            ListMahasiswa.add(judulModel);
            if ((ListMahasiswa.isEmpty()))
                Toast.makeText(MahasiswaRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}