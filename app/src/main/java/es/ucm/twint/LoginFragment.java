package es.ucm.twint;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

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

        CompletarRegistroFragment fragment = new CompletarRegistroFragment();
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .addToBackStack("CompletarRegistro")
                .add(R.id.cv_session, fragment)
                .commit();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(LoginFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
                onUserLogin();
            }
        });

        binding.btRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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