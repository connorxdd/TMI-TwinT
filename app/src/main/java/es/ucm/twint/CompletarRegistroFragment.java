package es.ucm.twint;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import es.ucm.twint.data.User;
import es.ucm.twint.databinding.FragmentCompletarRegistroBinding;

public class CompletarRegistroFragment extends Fragment {

    private FragmentCompletarRegistroBinding binding;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;
    private DatabaseReference dbRef;

    private User userInfo;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        dbRef = FirebaseDatabase.getInstance().getReference().child("users");
        firebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null){
                    Intent intent = new Intent(getActivity(), PrincipalActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                    return;
                }
            }
        };
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentCompletarRegistroBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spPais.setAdapter(adapter);


        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.sexo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spSexo.setAdapter(adapter);


        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.ocupacion, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spOcupacion.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.preferencias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spPreferencia.setAdapter(adapter);


        binding.btRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                final String currentName = binding.etNombre.getText().toString();
                final String currentPsswd = binding.etPassword.getText().toString();
                if(allFieldsCompleted()) {

                    mAuth.createUserWithEmailAndPassword(currentName + "@twint.com", currentPsswd)
                            .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        dbRef.child(mAuth.getCurrentUser().getUid().toString()).setValue(userInfo);
                                        Toast.makeText(getActivity(), "Congrats", Toast.LENGTH_SHORT).show();
                                        BiographyAndHobbiesFragment fragment = new BiographyAndHobbiesFragment();
                                        getActivity()
                                                .getSupportFragmentManager()
                                                .beginTransaction()
                                                .setReorderingAllowed(true)
                                                .addToBackStack("BioHobby")
                                                .add(R.id.cv_session, fragment)
                                                .commit();
                                    } else {
                                        Toast.makeText(getActivity(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 LoginFragment fragment = new LoginFragment();
                 getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .addToBackStack("Registro")
                        .add(R.id.cv_session, fragment)
                        .commit();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthStateListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthStateListener);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public boolean allFieldsCompleted(){
        if(!binding.etNombre.getText().toString().isEmpty() && !binding.etPassword.getText().toString().isEmpty()
            && (binding.etNombre.getText().toString().length() >= 6 && binding.etPassword.getText().toString().length() >= 6)
            &&!binding.etEdad.getText().toString().isEmpty() && !binding.spSexo.toString().isEmpty()
            && !binding.spPais.toString().isEmpty() && !binding.spOcupacion.toString().isEmpty()
            && !binding.spPreferencia.toString().isEmpty()){

            //Cambiar el nombre, actualmente se usa como ID
            userInfo = new User(binding.etNombre.getText().toString(), binding.etNombre.getText().toString(),
                    binding.etPassword.getText().toString(), binding.etNombre.getText().toString() + "@twint.com",
                    binding.spSexo.getSelectedItem().toString(), binding.spPais.getSelectedItem().toString(),
                    binding.spOcupacion.getSelectedItem().toString(), binding.spPreferencia.getSelectedItem().toString());
            return true;
        }
        else{
            Toast.makeText(getActivity(), "No puede haber campos en blanco.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}