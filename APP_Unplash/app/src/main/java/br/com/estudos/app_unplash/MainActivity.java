package br.com.estudos.app_unplash;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button btnFetchImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        btnFetchImage = findViewById(R.id.btnFetchImage);

        btnFetchImage.setOnClickListener(v -> fetchRandomImage());
    }

    private void fetchRandomImage() {

        UnsplashApi api = RetrofitClient.getInstance().create(UnsplashApi.class);


        api.getPhotos("_57inNa5oy9RQ4HvmvTvEiUHzvP9SfOyi_aBwuZDVsQ").enqueue(new Callback<List<UnsplashImage>>() {
            @Override
            public void onResponse(Call<List<UnsplashImage>> call, Response<List<UnsplashImage>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Obtém uma imagem aleatória da lista
                    UnsplashImage randomImage = response.body().get((int) (Math.random() * response.body().size()));

                    // Carrega a imagem na ImageView
                    Picasso.get().load(randomImage.getUrls().getRegular()).into(imageView);
                } else {
                    Toast.makeText(MainActivity.this, "Erro ao buscar imagens", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<UnsplashImage>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Erro de conexão", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
