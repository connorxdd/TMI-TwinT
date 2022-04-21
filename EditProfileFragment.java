package es.ucm.twint;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.net.URI;

import es.ucm.mocks.Perfil;
import es.ucm.twint.databinding.FragmentEditProfileBinding;

public class EditProfileFragment extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 1;
    View profileView;

    Perfil perfil;

    EditText etPreferences;
    EditText etPersonalDescription;
    EditText etEmail;

    Button btUploadPicture;
    Button btUploadMultimedia;
    Button btSave;
    private Uri myImage;
    private ImageView mImageView;
    public EditProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        profileView = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        return profileView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etPreferences = (EditText) profileView.findViewById(R.id.et_preferences);
        etPersonalDescription = (EditText) profileView.findViewById(R.id.et_personal_description
        );
        etEmail = (EditText) profileView.findViewById(R.id.et_email);

        btUploadPicture = (Button) profileView.findViewById(R.id.bt_upload_pictures);
        btUploadMultimedia = (Button) profileView.findViewById(R.id.bt_upload_multimedia);
        btSave = (Button) profileView.findViewById(R.id.bt_save_changes);

    }

    @Override
    public void onStart() {
        super.onStart();

        perfil = new Perfil();

        etPersonalDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                perfil.setPersonalDescription(editable.toString());
            }
        });

        etPreferences.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                perfil.setPreferences(editable.toString());
            }
        });

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                perfil.setEmail(editable.toString());
            }
        });

        btUploadPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*StorageReference stref = FirebaseStorage.getInstance().
                        getReferenceFromUrl("https://console.firebase.google.com/project/twint-347715/storage/twint-347715.appspot.com/files/~2F?hl=es-419");
                stref.child("images/" + "photo.jpg");
                myImage = Uri.parse(String.valueOf(new File("/data/photo.jpg")));

                UploadTask upt = stref.putFile(imageURI);*/
                openFileChooser();
            }
        });
        btUploadMultimedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = 0;
            }
        });

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = 0;
            }
        });
    }

    public void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == 0 &&
                data != null && data.getData() != null){
            myImage = data.getData();

            Picasso.get().load(myImage).into(mImageView);
            mImageView.setImageURI(myImage);
        }
    }
}