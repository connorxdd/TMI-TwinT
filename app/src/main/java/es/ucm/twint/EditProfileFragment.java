package es.ucm.twint;

import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Set;

import es.ucm.mocks.Perfil;

public class EditProfileFragment extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 1;
    View profileView;

    Perfil perfil;

    EditText etPreferences;
    EditText etPersonalDescription;
    EditText etBiogrphy;

    TextView tvSocialNetwork;
    Boolean bSocialNetworkDropDownIsOn;

    TableLayout tlSocialNetworks;

    Button btUploadPicture;
    Button btSave;
    private Uri myImage;
    private ImageView mImageView;
    FirebaseStorage storage;
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
        etPersonalDescription = (EditText) profileView.findViewById(R.id.et_personal_description);
        etBiogrphy = (EditText) profileView.findViewById(R.id.et_biography);
        tvSocialNetwork = (TextView) profileView.findViewById(R.id.tv_social_network);
        bSocialNetworkDropDownIsOn = false;
        tlSocialNetworks = (TableLayout) profileView.findViewById(R.id.tl_social_networks);
        setTvSocialNetworkDropDown(bSocialNetworkDropDownIsOn);

        btUploadPicture = (Button) profileView.findViewById(R.id.bt_upload_pictures);
        btSave = (Button) profileView.findViewById(R.id.bt_save_changes);
        mImageView = profileView.findViewById(R.id.profile_image);
        storage = FirebaseStorage.getInstance();
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

        etBiogrphy.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                perfil.setBiography(editable.toString());
            }
        });

        btUploadPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContent.launch("image/*");
            }
        });

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadImage();
                int a = 0;
            }
        });

        tvSocialNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bSocialNetworkDropDownIsOn = !bSocialNetworkDropDownIsOn;
                setTvSocialNetworkDropDown(bSocialNetworkDropDownIsOn);
            }
        });

        Set<String> keys = perfil.getSocialNetworks().keySet();
        for ( String key : keys ) {
            TableRow row = new TableRow(getActivity());
            CheckBox checkBox = new CheckBox(getActivity());
            checkBox.setClickable(false);
            TextView textView = new TextView(getActivity());
            EditText editText = new EditText(getActivity());

            String value = perfil.getSocialNetwork(key);
            checkBox.setChecked(!(value == null || value.isEmpty()));
            textView.setText(key);
            editText.setText(value == null ? "" : value);

            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    String editedText = editable.toString();
                    perfil.setSocialNetwork(key, editedText);
                    checkBox.setChecked(!editedText.isEmpty());
                }
            });

            row.addView(checkBox);
            row.addView(textView);
            row.addView(editText);

            tlSocialNetworks.addView(row);

        }

    }

    private void setTvSocialNetworkDropDown(Boolean isOn) {
        tvSocialNetwork.setCompoundDrawablesWithIntrinsicBounds(0, 0, isOn ? android.R.drawable.arrow_up_float : android.R.drawable.arrow_down_float, 0);
        tlSocialNetworks.setVisibility(isOn ? View.VISIBLE : View.GONE);
    }

    private void uploadImage() {
        if(myImage != null){
            String imagePath = "images/" + perfil.getId();
            StorageReference reference = storage.getReference().child(imagePath);
            reference.putFile(myImage).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    if(task.isSuccessful()){
                        perfil.setPicture(imagePath);
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
                    mImageView.setImageURI(result);
                    myImage = result;
                    //uploadImage();
                }
            }
        });
}