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
import com.example.travelstory.databinding.FragmentRegisterBinding;

import java.util.Objects;

public class RegisterFragment extends Fragment {

    FragmentRegisterBinding binding;
    SharedPreferences prefs;
    SharedPreferences.Editor prefsEditor;

    String name, phone, email, password, confirmPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false);

        // Create Shared Preferences
        prefs = this.requireActivity()
                .getSharedPreferences("authUser", MODE_PRIVATE);
        prefsEditor = prefs.edit();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

            binding.RegisterBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(CreateAccount()) {

                        Toast.makeText(requireActivity(), "Account Created Successful",
                                Toast.LENGTH_LONG).show();

                        // Storing Account Data
                        prefsEditor.putString("name", name);
                        prefsEditor.putString("phone", phone);
                        prefsEditor.putString("email", email);
                        prefsEditor.putString("password", password);

                        prefsEditor.commit();

                        Navigation.findNavController(view).navigate(
                                R.id.action_registerFragment_to_loginFragment);

                    }
                }
            });
    }

    private boolean CreateAccount(){
        name = binding.firstname.getText() + " " + binding.lastname.getText();
        phone = binding.phoneInput.getText().toString();
        email = binding.emailInput.getEditableText().toString();
        password = binding.passwordInputEditText.getEditableText().toString();
        confirmPassword = binding.confirmPasswordEdit.getEditText().getText().toString();

        if(binding.firstname.getText().toString().isEmpty() ||
                binding.lastname.getText().toString().isEmpty() ||
                email.isEmpty() || confirmPassword.isEmpty()
                || password.length() != 8 || phone.length() != 11){

            if(binding.firstname.getText().toString().isEmpty())
                Toast.makeText(requireActivity(), "Please Enter First Name",
                        Toast.LENGTH_LONG).show();

            if(binding.lastname.getText().toString().isEmpty())
                Toast.makeText(requireActivity(), "Please Enter Last Name",
                        Toast.LENGTH_LONG).show();

            if(phone.length() != 11)
                Toast.makeText(requireActivity(), "Please check your Phone = 11",
                        Toast.LENGTH_LONG).show();

            if(email.isEmpty())
                Toast.makeText(requireActivity(), "Please Enter Email",
                        Toast.LENGTH_LONG).show();

            if(password.length() != 8)
                Toast.makeText(requireActivity(), "Please check your Password = 8",
                        Toast.LENGTH_LONG).show();


            if(confirmPassword.equals(password))
                Toast.makeText(requireActivity(), "Please check your Confirm Password",
                        Toast.LENGTH_LONG).show();

        }else return true;

        return false;
    }
}