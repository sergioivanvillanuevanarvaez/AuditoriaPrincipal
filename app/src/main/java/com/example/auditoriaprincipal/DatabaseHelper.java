package com.example.auditoriaprincipal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "historial.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "historial_sensores";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TIPO = "tipo_sensor";
    public static final String COLUMN_VALOR = "valor";
    public static final String COLUMN_FECHA = "fecha";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String tabla = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TIPO + " TEXT, " +
                COLUMN_VALOR + " TEXT, " +
                COLUMN_FECHA + " TEXT)";

        db.execSQL(tabla);

        insertarEjemplo(db, "LDR", "75", "26/09/2026 09:00:00");
        insertarEjemplo(db, "Infrarrojo", "1", "26/09/2026 09:01:00");
        insertarEjemplo(db, "LDR", "63", "26/09/2026 09:02:00");
        insertarEjemplo(db, "Infrarrojo", "0", "26/09/2026 09:03:00");
    }

    private void insertarEjemplo(
            SQLiteDatabase db,
            String tipo,
            String valor,
            String fecha) {

        ContentValues valores = new ContentValues();

        valores.put(COLUMN_TIPO, tipo);
        valores.put(COLUMN_VALOR, valor);
        valores.put(COLUMN_FECHA, fecha);

        db.insert(TABLE_NAME, null, valores);
    }

    @Override
    public void onUpgrade(
            SQLiteDatabase db,
            int oldVersion,
            int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }

    public long insertarRegistro(
            String tipo,
            String valor,
            String fecha) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put(COLUMN_TIPO, tipo);
        valores.put(COLUMN_VALOR, valor);
        valores.put(COLUMN_FECHA, fecha);

        return db.insert(
                TABLE_NAME,
                null,
                valores
        );
    }

    public Cursor obtenerRegistros() {

        SQLiteDatabase db = this.getReadableDatabase();

        return db.query(
                TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                COLUMN_ID + " DESC"
        );
    }
}