package ict.umb.com.ictquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void btn_create(View view) {
        Intent a = new Intent(AdminActivity.this,
                MahasiswaCreate.class);
        startActivity(a);
    }

    public void btn_read(View view) {
        Intent b = new Intent(AdminActivity.this,
                MahasiswaRead.class);
        startActivity(b);
    }
}
