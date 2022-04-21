package es.ucm.twint;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import es.ucm.twint.databinding.FragmentRegistroBinding;

public class RegistroFragment extends Fragment {

    private FragmentRegistroBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentRegistroBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(TextUtils.isEmpty(binding.etUsuario.getText().toString()) || TextUtils.isEmpty(binding.etPassword.getText().toString())){
                    Toast.makeText(getActivity(), "No se puede crear un usuario con campos vacíos", Toast.LENGTH_SHORT).show();
                }
                else {
                    CompletarRegistroFragment fragment = new CompletarRegistroFragment();
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .setReorderingAllowed(true)
                            .addToBackStack("CompletarRegistro")
                            .add(R.id.cv_session, fragment)
                            .commit();
                }

//                NavHostFragment.findNavController(RegistroFragment.this)
//                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
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
