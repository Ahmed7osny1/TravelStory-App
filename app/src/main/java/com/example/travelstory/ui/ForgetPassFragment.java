package com.example.travelstory.ui;

import static android.content.Context.MODE_PRIVATE;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.travelstory.R;
import com.example.travelstory.databinding.FragmentForgetPassBinding;

public class ForgetPassFragment extends Fragment {

    FragmentForgetPassBinding binding;
    SharedPreferences prefs;
    SharedPreferences.Editor prefsEditor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentForgetPassBinding.inflate(inflater, container, false);

        // Create Shared Preferences
        prefs = this.requireActivity()
                .getSharedPreferences("authUser", MODE_PRIVATE);
        prefsEditor = prefs.edit();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.ForgetPassword.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                if(binding.emailTil.getEditText().getText().toString().equals(
                        prefs.getString("email","")
                )){
                    binding.passwordView.setText("Password: " +
                            prefs.getString("password",""));
                }else {
                    Toast.makeText(requireActivity(), "Please Check your Email" +
                            "or Create Account", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.backPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(
                        R.id.action_forgetPassFragment_to_loginFragment
                );
            }
        });

    }
}