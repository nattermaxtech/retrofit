package com.targetcompetitions.retrofittutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSubmitButtonClick(View view){
        Retrofit retrofit = APIClient.getClient();
        PostClient client = retrofit.create(PostClient.class);
        String userId = ((EditText)findViewById(R.id.userIdView)).getText().toString();
        String title = ((EditText)findViewById(R.id.titleView)).getText().toString();
        String body = ((EditText)findViewById(R.id.bodyView)).getText().toString();
        Post post = new Post(Integer.parseInt(userId), title, body);
        Call<Post> call = client.add(post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post responseBody = response.body();
                Toast.makeText(MainActivity.this, String.valueOf(responseBody.getId()).concat("\n" + responseBody.getBody()), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
