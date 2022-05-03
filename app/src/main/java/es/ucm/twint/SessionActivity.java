package es.ucm.twint;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import es.ucm.twint.databinding.ActivitySessionBinding;

public class SessionActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySessionBinding binding;


    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySessionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        FirebaseAuth.getInstance().signOut();
        for(int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); ++i) {
            getSupportFragmentManager().popBackStack();
        }
        mAuth = FirebaseAuth.getInstance();
        /*firebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null){
                    Intent intent = new Intent(SessionActivity.this, PrincipalActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };*/
        if (savedInstanceState == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("pepe", 0); // For testing
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.cv_session, LoginFragment.class, bundle)
                    .commit();
        }

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_session);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    //public FirebaseAuth getmAuth() {
        //return mAuth;
    //}

    /*public FirebaseAuth.AuthStateListener getFirebaseAuthStateListener() {
        return firebaseAuthStateListener;
    }*/

    /*public DatabaseReference getDbRef() {
        return dbRef;
    }*/

    /*@Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthStateListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthStateListener);
    }*/
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_session);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}