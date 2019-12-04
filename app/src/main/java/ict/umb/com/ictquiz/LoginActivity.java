package ict.umb.com.ictquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ict.umb.com.ictquiz.db.DBAdapter;

public class LoginActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DBAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DBAdapter(this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mButtonLogin = (Button)findViewById(R.id.btnLogin);
        mTextViewRegister = (TextView)findViewById(R.id.tvRegister);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this,DaftarActivity.class);
                startActivity(registerIntent);
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res = db.checkUser(user, pwd);
                if(res == true)
                {
                    Intent AdminPage = new Intent(LoginActivity.this,ConceptActivity.class);
                    startActivity(AdminPage);
                    Toast.makeText(LoginActivity.this,"Login Telah Berhasil",Toast.LENGTH_SHORT).show();
                }
                else if(user.equals("admin")&& pwd.equals("admin"))
                {
                    Intent UserPage = new Intent(LoginActivity.this,AdminActivity.class);
                    startActivity(UserPage);
                    Toast.makeText( LoginActivity.this,"Login Telah Berhasil",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText( LoginActivity.this,"Login Gagal",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
