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

public class MahasiswaRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private DBAdapter db;
    private List<Mahasiswa> ListMobil = new ArrayList<Mahasiswa>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_read);
        db = new DBAdapter(this);
        adapter_off = new CustomListAdapter(this, ListMobil );
        mListView = (ListView) findViewById(R.id.lvMahasiswa);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMobil.clear();
        List<Mahasiswa> mobil = db.getAllMahasiswa();
        for (Mahasiswa mb : mobil) {
            Mahasiswa mhs = new Mahasiswa();
            mhs.set_id_mahasiswa(mb.get_id_mahasiswa());
            mhs.set_username(mb.get_username());
            mhs.set_password(mb.get_password());
            mhs.set_nama(mb.get_nama());
            ListMobil.add(mhs);
            if ((ListMobil.isEmpty()))
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
        goUpdel.putExtra("Ijenis", Sjenis);
        goUpdel.putExtra("Imerk", Smerk);
        goUpdel.putExtra("Itahun_buat", Stahun_buat);
        goUpdel.putExtra("Iwarna", Swarna);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListMobil.clear();
        mListView.setAdapter(adapter_off);
        List<Mobil> mobil = db.ReadMobil();
        for (Mobil mb : mobil) {
            Mobil judulModel = new Mobil();
            judulModel.set_id(mb.get_id());
            judulModel.set_no_plat(mb.get_no_plat());
            judulModel.set_jenis(mb.get_jenis());
            judulModel.set_merk(mb.get_merk());
            judulModel.set_tahun_buat(mb.get_tahun_buat());
            judulModel.set_warna(mb.get_warna());
            ListMobil.add(judulModel);
            if ((ListMobil.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}