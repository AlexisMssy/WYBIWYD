package org.diiage.amassey.wybiwyd;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.diiage.amassey.wybiwyd.Adapters.BeerAdapter;
import org.diiage.amassey.wybiwyd.Models.Beer;

import java.util.ArrayList;

import static org.diiage.amassey.wybiwyd.WYBIWYDDbHelper.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WYBIWYDDbHelper helper = new WYBIWYDDbHelper(this);

        SQLiteDatabase db = helper.getWritableDatabase();

//        // Update beer already inserted
//        ContentValues contentValuesBeerUpdate = new ContentValues();
//
//        contentValuesBeerUpdate.put(helper.TABLE_BEER_ALCOOL, 4.7);
//        db.update(helper.TABLE_BEER,
//                contentValuesBeerUpdate,
//                "id = ?",
//                new String[]{String.valueOf(id)});

        // Click event AddBeer
        Button btnAddBeer = (Button)findViewById(R.id.buttonAddBeer);
        btnAddBeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddBeerActivity.class);
                startActivity(intent);
            }
        });

        // Get Beers
        ArrayList<Beer> mesBieres = new ArrayList<>();
        mesBieres = GetBeers(db);

        //Init listView of beers
        ListView lvBeers = (ListView) findViewById(R.id.ListViewBeers);
        BeerAdapter beerAdapter = new BeerAdapter(MainActivity.this, mesBieres);
        lvBeers.setAdapter(beerAdapter);

        // Fermeture de la connection à la base de données
        db.close();
    }

    public static void AddBeer(SQLiteDatabase db, String nom, String description, Double alcool, Double prix){
        ContentValues contentValuesBeer = new ContentValues();
        contentValuesBeer.put(TABLE_BEER_NOM, nom);
        contentValuesBeer.put(TABLE_BEER_DESCRIPTION, description);
        contentValuesBeer.put(TABLE_BEER_ALCOOL, alcool);
        contentValuesBeer.put(TABLE_BEER_PRIX, prix);
        long id = db.insert(TABLE_BEER, null, contentValuesBeer);

        Log.e("DEBUG", "Bière insérée : " + String.valueOf(id));
    }

    private void DeleteBeer(SQLiteDatabase db, Integer id){
        try {
            db.beginTransaction();
            // Delete beer
            db.delete(TABLE_BEER, "id = ?", new String[]{String.valueOf(id)});

            if(true){
                throw new Exception("Impossible de supprimmer les données");
            }
            db.setTransactionSuccessful();
            db.endTransaction();
        } catch (Exception ex){
            db.endTransaction();
        }

        Log.e("DEBUG", "Bière insérée : " + String.valueOf(id));
    }

    private ArrayList<Beer> GetBeers(SQLiteDatabase db){
        ArrayList<Beer> bieres = new ArrayList<>();

        // Lister toutes les bières
        Cursor cursor = db.query(TABLE_BEER,
                new String[]{"*"},
                null, null, null, null, null);


        while (cursor.moveToNext()){
            bieres.add(Beer.fromCursor(cursor));
        }
        cursor.close();

        return bieres;
    }
}
