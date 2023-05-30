package com.example.travelstory.ui;

import static android.content.Context.MODE_PRIVATE;

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
import com.example.travelstory.databinding.FragmentLoginBinding;
import com.example.travelstory.databinding.FragmentRegisterBinding;


public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    SharedPreferences prefs;
    SharedPreferences.Editor prefsEditor;
    String password, email;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        // Create Shared Preferences
        prefs = this.requireActivity()
                .getSharedPreferences("authUser", MODE_PRIVATE);
        prefsEditor = prefs.edit();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkLogin()) {

                    // Storing login action
                    prefsEditor.putString("condition", "logined");
                    prefsEditor.commit();

                    Navigation.findNavController(view).navigate(
                            R.id.action_loginFragment_to_enterActivity);
                }
            }
        });

        binding.noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(
                        R.id.action_loginFragment_to_registerFragment
                );
            }
        });

        binding.forgetTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(
                        R.id.action_loginFragment_to_forgetPassFragment
                );
            }
        });

    }

    private boolean checkLogin(){
        email = binding.emailTil.getEditText().getText().toString();
        password = binding.password.getEditText().getText().toString();
        if(email.isEmpty() || password.isEmpty()){

            if(email.isEmpty())
                Toast.makeText(requireActivity(), "Please Enter Email",
                        Toast.LENGTH_LONG).show();

            if(password.isEmpty())
                Toast.makeText(requireActivity(), "Please Enter your Password",
                        Toast.LENGTH_LONG).show();
        }else if(!prefs.getString("email", "").equals(email)
        || !prefs.getString("password","").equals(password)){

            if(!prefs.getString("email","").equals(email))
                Toast.makeText(requireActivity(),
                        "Please Check your Email or Create new Account",
                        Toast.LENGTH_SHORT).show();

            if(!prefs.getString("password","").equals(password))
                Toast.makeText(requireActivity(), "Please Check your Password",
                        Toast.LENGTH_SHORT).show();
        }else return true;

        return false;
    }
}