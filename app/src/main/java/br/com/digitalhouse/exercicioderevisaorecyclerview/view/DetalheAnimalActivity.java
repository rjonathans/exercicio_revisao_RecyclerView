package br.com.digitalhouse.exercicioderevisaorecyclerview.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.exercicioderevisaorecyclerview.R;
import br.com.digitalhouse.exercicioderevisaorecyclerview.RecyclerViewOnClick;
import br.com.digitalhouse.exercicioderevisaorecyclerview.model.Animais;

import static br.com.digitalhouse.exercicioderevisaorecyclerview.view.MainActivity.ANIMAL_KEY;

public class DetalheAnimalActivity extends AppCompatActivity {
    private TextView textNome;
    private TextView textDetalhe;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_animal);

        initViews();

        if (getIntent()!=null &&getIntent().getExtras()!=null){
            Animais animais = getIntent().getExtras().getParcelable(ANIMAL_KEY);

            Drawable drawable = getResources().getDrawable(animais.getImage());
            imageView.setImageDrawable(drawable);
            textNome.setText(animais.getNome());
    }



}
    private void initViews() {
        textNome = findViewById(R.id.textNome);
        textDetalhe = findViewById(R.id.textDetalhes);
        imageView = findViewById(R.id.imageCachorroDetalhes);
    }
}
