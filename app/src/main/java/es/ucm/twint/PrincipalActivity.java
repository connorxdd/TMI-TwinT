package es.ucm.twint;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.firebase.auth.FirebaseAuth;

import es.ucm.twint.databinding.ActivityPrincipalBinding;

public class PrincipalActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityPrincipalBinding binding;
    public Button btUploadImage;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.cv_principal, PerfilesFragment.class, null)
                    .commit();
        }
        btUploadImage = (Button) findViewById(R.id.bt_upload_pictures);
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_principal);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_item_perfil:
                loadProfileFragment();
                return true;
            case R.id.menu_item_chat:
                loadChatListFragment();
                return true;
            case R.id.menu_item_logout:
                FirebaseAuth.getInstance().signOut();

                for(int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); ++i) {
                    getSupportFragmentManager().popBackStack();
                }
                finish();
                //Intent intent = new Intent(this, SessionActivity.class);
                //startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadProfileFragment() {
        EditProfileFragment fragment = new EditProfileFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .addToBackStack("Editar perfil")
                .add(R.id.cv_principal, fragment)
                .commit();
    }

    private void loadChatListFragment() {
        ChatListFragment fragment = new ChatListFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .addToBackStack("Lista de chats")
                .add(R.id.cv_principal, fragment)
                .commit();
    }


//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_principal);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}