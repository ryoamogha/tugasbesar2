package ict.umb.com.ictquiz;

public class Mahasiswa {
        private String _id_mahasiswa, _username, _password, _nama;
        public Mahasiswa (String id_mahasiswa, String username, String password, String nama) {
            this._id_mahasiswa = id_mahasiswa;
            this._username = username;
            this._password = password;
            this._nama = nama;
        }
        public Mahasiswa() {
        }
        public String get_id_mahasiswa() {
            return _id_mahasiswa;
        }
        public void set_id_mahasiswa(String _id_mahasiswa) {
            this._id_mahasiswa = _id_mahasiswa;
        }
        public String get_username() {
            return _username;
        }
        public void set_username(String _username) {
            this._username = _username;
        }
        public String get_password() {
            return _password;
        }
        public void set_password(String _password) {
            this._password = _password;
        }
        public String get_nama()
        {
            return _nama;
        }
        public void set_nama(String _nama)
        {
            this._nama = _nama;
        }
}


