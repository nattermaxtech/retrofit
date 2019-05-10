package com.targetcompetitions.retrofittutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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

        Retrofit client = APIClient.getClient();
        GitHubClient gitHubClient = client.create(GitHubClient.class);
        Call<List<GitHubRepo>> call = gitHubClient.reposForUser("kennethlove");
        call.enqueue(new Callback<List<GitHubRepo>>() {
            TextView repoView = findViewById(R.id.repoView);
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                List<GitHubRepo> repos = response.body();
                String output = "";
                for(GitHubRepo repo : repos){
                    output = output + "\n" + repo.getName() + " --> " + repo.getCreateDate();
                }
                repoView.setText(output);
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                repoView.setText(t.getMessage());
            }
        });
    }
}
