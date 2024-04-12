/*
package com.example.spotifyapp2340.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.spotifyapp2340.R;

public class LoginFragment extends Fragment {

    private EditText loginEmail, loginPassword;
    private TextView signUpText;
    private Button loginButton, backButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_login, container, false);

        loginEmail = root.findViewById(R.id.login_email);
        loginPassword = root.findViewById(R.id.login_password);
        loginButton = root.findViewById(R.id.login_button);
        signUpText = root.findViewById(R.id.signupdirectText);
        backButton = root.findViewById(R.id.back_to_dashboard_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement login logic here
            }
        });

        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement sign up navigation here
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the dashboard or the previous screen
                if (NavHostFragment.findNavController(LoginFragment.this) != null) {
                    NavHostFragment.findNavController(LoginFragment.this).popBackStack();
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
*/
package com.example.spotifyapp2340.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.spotifyapp2340.TokenActivity;
import com.example.spotifyapp2340.R;

public class LoginFragment extends Fragment {

    private EditText loginEmail, loginPassword;
    private Button loginButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_login, container, false);

        loginEmail = root.findViewById(R.id.login_email);
        loginPassword = root.findViewById(R.id.login_password);
        loginButton = root.findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start TokenActivity when login button is pressed
                startActivity(new Intent(getActivity(), TokenActivity.class));
            }
        });

        return root;
    }
}

