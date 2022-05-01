package es.ucm.twint;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import es.ucm.twint.databinding.FragmentBiographyAndHobbiesBinding;

public class BiographyAndHobbiesFragment extends Fragment {

    private DatabaseReference dbRef;
    private FirebaseAuth mAuth;
    private FragmentBiographyAndHobbiesBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        dbRef = FirebaseDatabase.getInstance().getReference().child("users");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBiographyAndHobbiesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*binding.btFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!binding.etBiografia.getText().toString().isEmpty()){
                    dbRef.child(mAuth.getCurrentUser().getUid().toString())
                            .child("biography")
                            .setValue(binding.etBiografia.getText().toString());
                    Intent intent = new Intent(getActivity(), PrincipalActivity.class);
                    startActivity(intent);
                }

            }
        });*/
    }
}