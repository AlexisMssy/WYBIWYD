package org.diiage.amassey.wybiwyd.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.diiage.amassey.wybiwyd.Models.Beer;
import org.diiage.amassey.wybiwyd.R;
import org.diiage.amassey.wybiwyd.ViewHolders.BeerViewHolder;

import java.util.ArrayList;

public class BeerAdapter extends BaseAdapter {

    Activity context;
    ArrayList<Beer> beers;
    BeerViewHolder beerViewHolder;

    public BeerAdapter(Activity context, ArrayList<Beer> beers) {
        this.context = context;
        this.beers = beers;
    }

    @Override
    public int getCount() {
        return beers.size();
    }

    @Override
    public Object getItem(int i) {
        return beers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v;

        if(view != null){
            v = view;
            beerViewHolder = (BeerViewHolder) view.getTag();
        }else {
            LayoutInflater layoutInflater = this.context.getLayoutInflater();

            v = layoutInflater.inflate(R.layout.item_beer, viewGroup, false);

            TextView lblNom = v.findViewById(R.id.textViewNom);
            TextView lblDescription = v.findViewById(R.id.textViewDescription);
            TextView lblAlcool = v.findViewById(R.id.textViewAlcool);
            TextView lblPrix = v.findViewById(R.id.textViewPrix);


            beerViewHolder = new BeerViewHolder(lblNom, lblDescription, lblAlcool, lblPrix);

            v.setTag(beerViewHolder);
        }

        Beer clan = beers.get(position);

        beerViewHolder.Nom.setText(clan.getNom());
        beerViewHolder.Description.setText(clan.getDescription());
        beerViewHolder.Alcool.setText(clan.getAlcool().toString());
        beerViewHolder.Prix.setText(clan.getPrix().toString());


        return v;
    }
}