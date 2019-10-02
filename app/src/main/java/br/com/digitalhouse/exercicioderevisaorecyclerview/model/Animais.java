package br.com.digitalhouse.exercicioderevisaorecyclerview.model;


import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

public class Animais implements Parcelable {

    private String nome;
    private int image;


    public Animais() {
    }

    public Animais(String nome, int image) {
        this.nome = nome;
        this.image = image;
    }

    protected Animais(Parcel in) {
        nome = in.readString();
        image = in.readInt();
    }

    public static final Creator<Animais> CREATOR = new Creator<Animais>() {
        @Override
        public Animais createFromParcel(Parcel in) {
            return new Animais(in);
        }

        @Override
        public Animais[] newArray(int size) {
            return new Animais[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeInt(image);
    }
}
