package org.diiage.amassey.wybiwyd;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import org.diiage.amassey.wybiwyd.Models.Beer;

public class AddBeerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_beer);

        WYBIWYDDbHelper helper = new WYBIWYDDbHelper(this);

        SQLiteDatabase db = helper.getWritableDatabase();

        // Récupération des données saisies
        EditText editNom = findViewById(R.id.editNom);
        EditText editDescription = findViewById(R.id.editDescription);
        EditText editAlcool = findViewById(R.id.editAlcool);
        EditText editPrix = findViewById(R.id.editPrix);

        Beer beer = new Beer(editNom.toString(),
                editDescription.toString(),
                Double.parseDouble(editAlcool.toString()),
                Double.parseDouble(editPrix.toString()));

        //Ajout de la bière
        MainActivity.AddBeer(db, "Kro", "C'est bon pour le moral", 3.0, 1.2);

        // Fermeture de la connection à la base de données
        db.close();
    }
}
