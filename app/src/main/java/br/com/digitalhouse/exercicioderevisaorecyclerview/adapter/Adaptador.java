package br.com.digitalhouse.exercicioderevisaorecyclerview.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.exercicioderevisaorecyclerview.R;
import br.com.digitalhouse.exercicioderevisaorecyclerview.RecyclerViewOnClick;
import br.com.digitalhouse.exercicioderevisaorecyclerview.model.Animais;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {


    private List<Animais> listaDeAnimais;
    private RecyclerViewOnClick listener;

    public Adaptador(List<Animais> listaDeAnimais, RecyclerViewOnClick listener) {
        this.listaDeAnimais = listaDeAnimais;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Animais animal = listaDeAnimais.get(position);
        holder.onBind(animal);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(animal);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaDeAnimais.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView txtNome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            txtNome = itemView.findViewById(R.id.textViewNome);


        }

        public void onBind(Animais animal) {
            txtNome.setText(animal.getNome());
            Drawable drawable = itemView.getResources().getDrawable(animal.getImage());
            imageView.setImageDrawable(drawable);

        }
    }
}
