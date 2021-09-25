package com.example.payzug.ui.login;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.payzug.R;

import java.util.HashMap;
import java.util.Map;

public class LoginFragment extends Fragment {
    View display;
    private EditText username,pass;
    private Button login;
    private static String url_login = "http://192.168.42.200/LoginDetails/login.php";
    private LoginViewModel loginViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        display = inflater.inflate(R.layout.fragment_login, container, false);
        username = display.findViewById(R.id.username);
        pass = display.findViewById(R.id.pass);
        login = display.findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString().trim();
                String mpass = pass.getText().toString().trim();

                if (!user.isEmpty() && !mpass.isEmpty()){
                    loginf(user, mpass);
                }else{
                    username.setError("Please insert username");
                    pass.setError("Please insert password");
                }
            }
        });
        return display;
    }

    private void loginf(final String username, final String password) {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_login, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getContext(),"ok",Toast.LENGTH_SHORT).show();
                if (response.equals("1")) {
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
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("username", username);
                data.put("password", password);
                return data;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

    }

}