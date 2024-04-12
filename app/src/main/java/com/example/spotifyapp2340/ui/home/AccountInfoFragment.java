package com.example.spotifyapp2340.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.spotifyapp2340.GameActivity2;
import com.example.spotifyapp2340.Fill_in_blank;
import com.example.spotifyapp2340.Connections;
import com.example.spotifyapp2340.R;
import com.example.spotifyapp2340.databinding.FragmentHomeBinding;

public class AccountInfoFragment extends Fragment {
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // ViewModel setup can be added here if needed
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Set up the account management buttons
        binding.updateLoginTextButton.setOnClickListener(view -> showUpdateDialog());
        binding.DeleteAccountTextButton.setOnClickListener(view -> showDeleteDialog());

        // Set up the game activity buttons
        binding.gameBtn.setOnClickListener(v -> startActivity(new Intent(getActivity(), GameActivity2.class)));
        binding.game2Btn.setOnClickListener(v -> startActivity(new Intent(getActivity(), Fill_in_blank.class)));
        binding.game3Btn.setOnClickListener(v -> startActivity(new Intent(getActivity(), Connections.class)));

        return root;
    }

    private void showUpdateDialog() {
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View popupView = inflater.inflate(R.layout.update_login_info_popup, null);

        EditText editTextEmail = popupView.findViewById(R.id.editTextEmail);
        EditText editTextPassword = popupView.findViewById(R.id.editTextPassword);
        Button buttonUpdate = popupView.findViewById(R.id.buttonUpdate);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(popupView);
        builder.setTitle("Update Login Information");
        builder.setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();

        buttonUpdate.setOnClickListener(v -> {
            // Update logic here
            dialog.dismiss();
        });
    }

    private void showDeleteDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Delete Account");
        builder.setMessage("Are you sure you want to delete your account? This action cannot be undone.");
        builder.setPositiveButton("Delete", (dialog, which) -> {
            // Delete logic here
            dialog.dismiss();
        });
        builder.setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
