package es.ucm.twint;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.ucm.mocks.ChatListItem;
import es.ucm.mocks.Perfiles;
import es.ucm.twint.adapters.ChatListAdapter;
import es.ucm.twint.adapters.PerfilesAdapter;
import es.ucm.twint.databinding.FragmentChatListBinding;
import es.ucm.twint.databinding.FragmentPerfilesBinding;

public class ChatListFragment extends Fragment {

    private FragmentChatListBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentChatListBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ChatListAdapter adapter = new ChatListAdapter(requireContext(), ChatListItem.generateTestList());
        binding.lvChatList.setAdapter(adapter);
    }
}