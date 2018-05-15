package org.diiage.amassey.wybiwyd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WYBIWYDDbHelper extends SQLiteOpenHelper {

    private static final int VERSION = 2;
    private static final String DB_NAME = "wybiwyd.db";

    // Beer
    public static final String TABLE_BEER = "beer";
    public static final String TABLE_BEER_ID = "id";
    public static final String TABLE_BEER_NOM = "nom";
    public static final String TABLE_BEER_DESCRIPTION = "description";
    public static final String TABLE_BEER_ALCOOL = "alcool";
    public static final String TABLE_BEER_PRIX = "prix";
    public static final String TABLE_BEER_ID_GAMME = "idGamme";

    // Gamme
    public static final String TABLE_GAMME = "gamme";
    public static final String TABLE_GAMME_ID = "id";
    public static final String TABLE_GAMME_NOM = "nom";
    public static final String TABLE_GAMME_DESCRIPTION = "description";

    // Ingredient
    public static final String TABLE_INGREDIENT = "ingredient";
    public static final String TABLE_INGREDIENT_ID = "id";
    public static final String TABLE_INGREDIENT_NOM = "nom";
    public static final String TABLE_INGREDIENT_DESCRIPTION = "description";
    public static final String TABLE_INGREDIENT_PRIX = "prix";

    // LinkBeerIngredient
    public static final String TABLE_LINK_BEER_INGREDIENT = "linkBeerIngredient";
    public static final String TABLE_INGREDIENT_ID_BEER = "idBeer";
    public static final String TABLE_INGREDIENT_ID_INGREDIENT = "idIngredient";

    public WYBIWYDDbHelper(Context context) {
        super(context, DB_NAME,null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_BEER +" ( " +
                TABLE_BEER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABLE_BEER_NOM + " TEXT, " +
                TABLE_BEER_DESCRIPTION + " TEXT, " +
                TABLE_BEER_ALCOOL + " REAL, " +
                TABLE_BEER_PRIX + " REAL )");

    }

    //Méthode apellé lorsqu'il est nécéssaire de mettre a jour la structure de la base de données
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (oldVersion == 1 && newVersion == 2) {
            sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_GAMME +" ( " +
                    TABLE_GAMME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TABLE_GAMME_NOM + " TEXT, " +
                    TABLE_GAMME_DESCRIPTION  + " TEXT )");

            sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_INGREDIENT +" ( " +
                    TABLE_INGREDIENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TABLE_INGREDIENT_NOM + " TEXT, " +
                    TABLE_INGREDIENT_DESCRIPTION + " TEXT, " +
                    TABLE_INGREDIENT_PRIX + " REAL )");

            sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_LINK_BEER_INGREDIENT +" ( " +
                    TABLE_INGREDIENT_ID_BEER + " INTEGER, " +
                    TABLE_INGREDIENT_ID_INGREDIENT + " INTEGER )");

            sqLiteDatabase.execSQL("ALTER TABLE " + TABLE_BEER + " ADD " + TABLE_BEER_ID_GAMME + " INTEGER");
        }
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
