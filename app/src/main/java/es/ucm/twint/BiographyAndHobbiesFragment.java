package es.ucm.twint;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import es.ucm.twint.databinding.FragmentBiographyAndHobbiesBinding;

public class BiographyAndHobbiesFragment extends Fragment {

    private DatabaseReference dbRef;
    private FirebaseAuth mAuth;
    private FirebaseStorage storage;
    private FragmentBiographyAndHobbiesBinding binding;
    View hobbieAndBio;

    private Uri myImage;
    private ImageView mImageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        dbRef = FirebaseDatabase.getInstance().getReference().child("users").child(mAuth.getCurrentUser().getUid().toString());
        storage = FirebaseStorage.getInstance();

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

        binding.btFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!binding.etBiografia.getText().toString().isEmpty()){
                    dbRef.child("Biography").setValue(binding.etBiografia.getText().toString());

                    for(int i = 0; i < getActivity().getSupportFragmentManager().getBackStackEntryCount(); ++i) {
                        getActivity().getSupportFragmentManager().popBackStack();

                    }

                    uploadImage();
                    Intent intent = new Intent(getActivity(), PrincipalActivity.class);
                    startActivity(intent);
                }

            }
        });

        binding.btUploadPictures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetContent.launch("image/*");
            }
        });
    }
    private void uploadImage() {
        if(myImage != null){
            String imagePath = "images/" + mAuth.getCurrentUser().getUid().toString();
            StorageReference reference = storage.getReference().child(imagePath).child(mAuth.getCurrentUser().getUid().toString());
            reference.putFile(myImage).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getActivity(), "Imagen subida", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    if (result != null){
                        binding.profileImage.setImageURI(result);
                        myImage = result;
                        //uploadImage();
                    }
                }
            });
}