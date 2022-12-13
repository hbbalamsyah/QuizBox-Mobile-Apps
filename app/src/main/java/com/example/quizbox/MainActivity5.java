package com.example.quizbox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity5 extends AppCompatActivity {

    ListView listview;
    MyAdapter adapter;
    public static ArrayList<Soal> soalArrayList = new ArrayList<>();
    String url = "http://192.168.43.8/quizbox/pertanyaan.php";
    Soal soalnya;

    Button btnMulai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        listview = findViewById(R.id.myListView);
        adapter =  new MyAdapter(this, soalArrayList);

        retrieveData();


        btnMulai = findViewById(R.id.btn_mulai);
        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = soalArrayList.size();
                startActivity(new Intent(getApplicationContext(), MainActivity2.class)
                        .putExtra("length",length));
            }
        });
    }

    private void retrieveData() {
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        soalArrayList.clear();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            if(success.equals("1")){
                                for(int i=0; i<jsonArray.length(); i++){
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String id_soal = object.getString("id_soal");
                                    String soal = object.getString("soal");
                                    String pilihan_1 = object.getString("pilihan_1");
                                    String pilihan_2 = object.getString("pilihan_2");
                                    String pilihan_3 = object.getString("pilihan_3");
                                    String pilihan_4 = object.getString("pilihan_4");
                                    String jawaban = object.getString("jawaban");
                                    String id_kategori = object.getString("id_kategori");

                                    soalnya = new Soal(id_soal,soal,pilihan_1,pilihan_2,pilihan_3,pilihan_4,jawaban,id_kategori);
                                    soalArrayList.add(soalnya);
                                    adapter.notifyDataSetChanged();
                                }
                            }

                        }catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(com.example.quizbox.MainActivity5.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                Intent intent = getIntent();
                int position = intent.getExtras().getInt("position");
                int position1 = position +1;
                String position2 = String.valueOf(position1);
                params.put("id_kate", position2);
                return params;
            }
        }
                ;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }

}



















