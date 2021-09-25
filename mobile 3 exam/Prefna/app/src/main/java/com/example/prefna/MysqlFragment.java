package com.example.payzug;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MysqlFragment extends Fragment {
    View display;
    RecyclerView recyclerView;
    List<Product> infoList;
    ProductAdapter adapter;
    private static String url_list = "http://192.168.42.200/retrieve_mysql/getDatab.php";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        display = inflater.inflate(R.layout.fragment_mysql, container, false);
        infoList = new ArrayList<>();
        recyclerView = display.findViewById(R.id.reclyclerid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        loadList();

        return display;
    }

    private void loadList() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_list,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i=0; i<array.length(); i++){
                                JSONObject object = array.getJSONObject(i);

                                int id = object.getInt("id");
                                String name = object.getString("name");
                                String username = object.getString("username");
                                String password = object.getString("password");
                                String date = object.getString("date");

                                Product product = new Product(id, name, username, password, date);
                                infoList.add(product);
                            }

                            adapter = new ProductAdapter(getContext(), infoList);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(getContext()).add(stringRequest);
    }
}