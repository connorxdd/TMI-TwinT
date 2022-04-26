package es.ucm.twint;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import es.ucm.twint.databinding.FragmentCompletarRegistroBinding;

public class CompletarRegistroFragment extends Fragment {

    private FragmentCompletarRegistroBinding binding;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;
    EditText name;
    EditText password;
    Button createProfile;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        mAuth = FirebaseAuth.getInstance();
        firebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                  final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                  if (user != null){
                      Intent intent = new Intent(getActivity(), PrincipalActivity.class);
                      startActivity(intent);
                      //finish();
                  }
            }
        };

        binding = FragmentCompletarRegistroBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spPais.setAdapter(adapter);

        binding.btRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                final String currentName = binding.etNombre.getText().toString();
                final String currentPsswd = binding.etPassword.getText().toString();
                if(!currentName.isEmpty() && !currentPsswd.isEmpty()){
                   /* mAuth.createUserWithEmailAndPassword(currentName, currentPsswd).
                            addOnCompleteListener(CompletarRegistroFragment.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                        }
                    });*/
                }
            }
        });

        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(RegistroFragment.this)
//                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}