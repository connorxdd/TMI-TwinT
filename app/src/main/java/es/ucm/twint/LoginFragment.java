package es.ucm.twint;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import es.ucm.twint.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    private void onUserLogin() {
        String username = binding.etUsuario.getText().toString();
        String password = binding.etPassword.getText().toString();

        Snackbar.make(getView(), "USUARIO: " + username +" - CONTRASENA: " + password, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        Intent intent = new Intent(getActivity(), PrincipalActivity.class);
        startActivity(intent);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(LoginFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
                if(TextUtils.isEmpty(binding.etUsuario.getText().toString()) || TextUtils.isEmpty(binding.etPassword.getText().toString())){
                    Toast.makeText(getActivity(), "No se puede iniciar sesión con campos vacíos", Toast.LENGTH_SHORT).show();
                }
                else {
                    binding.etUsuario.setText("");
                    binding.etPassword.setText("");
                    onUserLogin();
                }
            }
        });


        binding.btRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Log.e("TEST","Test: START...");
                Database db= new Database();
                db.getUser(1);
                Log.e("TEST", "Test: END.");
                */
//                NavHostFragment.findNavController(LoginFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
                RegistroFragment fragment = new RegistroFragment();
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
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}