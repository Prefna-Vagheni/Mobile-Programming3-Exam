package com.example.payzug;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SignupFragment extends Fragment {
    View display;
    EditText name, username, password, repassword;
    Button signup;
    private String URL ="http://192.168.42.200/LoginDetails/signup.php";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        display = inflater.inflate(R.layout.fragment_signup, container, false);
        name = display.findViewById(R.id.name);
        username = display.findViewById(R.id.username);
        password = display.findViewById(R.id.pass);
        repassword = display.findViewById(R.id.repass);
        signup = display.findViewById(R.id.register);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regist();
            }
        });

        return display;
    }

    public void Regist(){

        final String nam = name.getText().toString().trim();
        final String user = username.getText().toString().trim();
        final String pass = password.getText().toString().trim();
        final String repass = repassword.getText().toString().trim();

        if (pass.equals(repass)) {
            if (!user.equals("") && !pass.equals("")) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("Login Success")) {
                            Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> data = new HashMap<>();
                        data.put("name", nam);
                        data.put("username", user);
                        data.put("password", pass);
                        return data;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                requestQueue.add(stringRequest);
            } else {
                Toast.makeText(getContext(), "All fields are required", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getContext(),"Passwords don't match!!", Toast.LENGTH_SHORT).show();
        }

    }
}