package ict.umb.com.ictquiz;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Mahasiswa> mahasiswaItems;
    public CustomListAdapter(Activity activity, List<Mahasiswa> mobilItems) {
        this.activity = activity;
        this.mahasiswaItems = mobilItems;
    }
    @Override
    public int getCount() {
        return mahasiswaItems.size();
    }
    @Override
    public Object getItem(int location) {
        return mahasiswaItems.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.lists_mahasiswa, null);
        TextView id_mahasiswa = (TextView) convertView.findViewById(R.id.tv_id_mahasiswa);
        TextView username = (TextView) convertView.findViewById(R.id.tv_username);
        TextView password = (TextView) convertView.findViewById(R.id.tv_password);
        TextView nama = (TextView) convertView.findViewById(R.id.tv_nama);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);
        Mahasiswa m = mahasiswaItems.get(position);
        id_mahasiswa.setText("ID Mahasiswa : "+ m.get_id_mahasiswa());
        username.setText("Username : "+ m.get_username());
        password.setText("Password : "+ m.get_password());
        nama.setText("Nama : "+ m.get_nama());
        return convertView;
    }
}