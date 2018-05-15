package org.diiage.amassey.wybiwyd.Models;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.Nullable;

import static org.diiage.amassey.wybiwyd.WYBIWYDDbHelper.*;

public class Beer {
    Long id;
    String nom;
    String description;
    Double alcool;
    Double prix;


    public Beer() {

    }

    public Beer(String nom, String description, Double alcool, Double prix) {
        this.nom = nom;
        this.description = description;
        this.alcool = alcool;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAlcool() {
        return alcool;
    }

    public void setAlcool(Double alcool) {
        this.alcool = alcool;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public static Beer fromCursor(Cursor cursor){
        Beer b = new Beer();
        b.id = cursor.getLong(cursor.getColumnIndex(TABLE_BEER_ID));
        b.nom = cursor.getString(cursor.getColumnIndex(TABLE_BEER_NOM));
        b.description = cursor.getString(cursor.getColumnIndex(TABLE_BEER_DESCRIPTION));
        b.alcool = cursor.getDouble(cursor.getColumnIndex(TABLE_BEER_ALCOOL));
        b.prix = cursor.getDouble(cursor.getColumnIndex(TABLE_BEER_PRIX));
        return b;
    }

    public ContentValues toContentValues(){
        ContentValues cv = new ContentValues();
        if (nom != null) {
            cv.put(TABLE_BEER_NOM, nom);
        }
        if (nom != null) {
            cv.put(TABLE_BEER_DESCRIPTION, description);
        }
        if (nom != null) {
            cv.put(TABLE_BEER_ALCOOL, alcool);
        }
        if (nom != null) {
            cv.put(TABLE_BEER_PRIX, prix);
        }
        return cv;
    }
}
