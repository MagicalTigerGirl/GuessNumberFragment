package com.example.guessnumberfragment.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Information implements Serializable, Parcelable {
    public static final String KEY = "information";
    private String usuario;
    private String intentos;
    private String numero;
    private String acertado = "0";

    public Information(String usuario, String intentos, String numero, String acertado) {
        this.usuario = usuario;
        this.intentos = intentos;
        this.numero = numero;
        this.acertado = acertado;
    }

    public Information(String usuario, String intentos){
        this.usuario = usuario;
        this.intentos = intentos;
    }

    public Information(){}

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getIntentos() {
        return intentos;
    }

    public void setIntentos(String intentos) {
        this.intentos = intentos;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAcertado() {
        return acertado;
    }

    public void setAcertado(String acertado) {
        this.acertado = acertado;
    }


    // Métodos para el Parcelable

    protected Information(Parcel in){
        usuario=in.readString();
        intentos= in.readString();
        numero= in.readString();
        acertado= in.readString();
    }

    public static final Creator<Information> CREATOR = new Creator<Information>() {
        @Override
        public Information createFromParcel(Parcel in) {
            return new Information(in);
        }

        @Override
        public Information[] newArray(int size) {
            return new Information[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @NonNull
    @Override
    public String toString() {
        return getUsuario() + "->" + getIntentos() ;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(usuario);
        dest.writeString(intentos);
        dest.writeString(numero);
        dest.writeString(acertado);
    }
}