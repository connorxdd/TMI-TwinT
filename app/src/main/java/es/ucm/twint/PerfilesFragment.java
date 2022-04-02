package es.ucm.twint;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import es.ucm.mocks.Perfiles;
import es.ucm.twint.adapters.PerfilesAdapter;
import es.ucm.twint.databinding.FragmentPerfilesBinding;

public class PerfilesFragment extends Fragment {

    private FragmentPerfilesBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentPerfilesBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PerfilesAdapter adapter = new PerfilesAdapter(requireContext(), Perfiles.getPerfiles());
        binding.lvPerfiles.setAdapter(adapter);
//        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(PerfilesFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
//            }
//        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}