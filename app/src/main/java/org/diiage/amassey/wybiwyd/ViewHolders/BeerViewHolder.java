package org.diiage.amassey.wybiwyd.ViewHolders;

import android.widget.ImageView;
import android.widget.TextView;

public class BeerViewHolder{

    public TextView Nom;
    public TextView Description;
    public TextView Alcool;
    public TextView Prix;

    public BeerViewHolder(TextView nom, TextView description, TextView alcool, TextView prix) {
        Nom = nom;
        Description = description;
        Alcool = alcool;
        Prix = prix;
    }
}