package br.com.digitalhouse.exercicioderevisaorecyclerview.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.exercicioderevisaorecyclerview.R;
import br.com.digitalhouse.exercicioderevisaorecyclerview.RecyclerViewOnClick;
import br.com.digitalhouse.exercicioderevisaorecyclerview.adapter.Adaptador;
import br.com.digitalhouse.exercicioderevisaorecyclerview.model.Animais;

public class MainActivity extends AppCompatActivity implements RecyclerViewOnClick {


    private RecyclerView recyclerView;
    private Adaptador adapter;
    private List<Animais> listaDeAnimais = new ArrayList<>();
    public final static String ANIMAL_KEY = "nome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();


    }

    private void initViews() {

        recyclerView = findViewById(R.id.recyclerViewAnimais);
        adapter =new Adaptador(retornarAnimais(),this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private List<Animais> retornarAnimais() {
        listaDeAnimais.add(new Animais("Bidu",R.drawable.cachorro));
        listaDeAnimais.add(new Animais("Bidu",R.drawable.cachorro));
        listaDeAnimais.add(new Animais("Bidu",R.drawable.cachorro));
        listaDeAnimais.add(new Animais("Bidu",R.drawable.cachorro));
        listaDeAnimais.add(new Animais("Bidu",R.drawable.cachorro));
        listaDeAnimais.add(new Animais("Bidu",R.drawable.cachorro));
        listaDeAnimais.add(new Animais("Bidu",R.drawable.cachorro));
        listaDeAnimais.add(new Animais("Bidu",R.drawable.cachorro));
        listaDeAnimais.add(new Animais("Bidu",R.drawable.cachorro));
        return listaDeAnimais;

    }

    @Override
    public void onClick(Animais animal) {
        Intent intent = new Intent(MainActivity.this,DetalheAnimalActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(ANIMAL_KEY, animal);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
