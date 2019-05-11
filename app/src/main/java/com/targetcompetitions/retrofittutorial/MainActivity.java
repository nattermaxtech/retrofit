package com.targetcompetitions.retrofittutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = APIClient.getClient();
        PostClient client = retrofit.create(PostClient.class);

        Call<List<Post>> call = client.get();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                RecyclerView view = findViewById(R.id.recyclerView);
                PostAdapter adapter = new PostAdapter(response.body());
                view.setAdapter(adapter);
                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                view.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
