package es.ucm.twint.data;


import android.util.Log;

import io.realm.RealmConfiguration;
import io.realm.Realm;
import io.realm.RealmQuery;

public class Database {

    public Database(){ super(); }

    public void getUser(Integer idUser) {
        //User user = new User();
        RealmConfiguration config = new RealmConfiguration.Builder()
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .build();
        Realm realm = Realm.getInstance(config);
        RealmQuery<User> query = realm.where(User.class);
        long num = query.equalTo("idUser", idUser).count();
        Log.e("TEST", "Test: Number of User with idUser=" + idUser + "is " + num + ".");
        //return user;
    }

}
