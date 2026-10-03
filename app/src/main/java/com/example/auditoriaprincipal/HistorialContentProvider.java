package com.example.auditoriaprincipal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class HistorialContentProvider extends ContentProvider {

    public static final String AUTHORITY =
            "com.example.auditoriaprincipal";

    public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/historial_sensores");

    private DatabaseHelper databaseHelper;

    @Override
    public boolean onCreate() {

        databaseHelper =
                new DatabaseHelper(getContext());

        return true;
    }

    @Override
    public Cursor query(
            Uri uri,
            String[] projection,
            String selection,
            String[] selectionArgs,
            String sortOrder) {

        return databaseHelper.getReadableDatabase().query(
                DatabaseHelper.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );
    }

    @Override
    public String getType(Uri uri) {

        return "vnd.android.cursor.dir/vnd."
                + AUTHORITY
                + ".historial_sensores";
    }

    @Override
    public Uri insert(
            Uri uri,
            ContentValues values) {

        throw new UnsupportedOperationException(
                "La inserción no está permitida"
        );
    }

    @Override
    public int delete(
            Uri uri,
            String selection,
            String[] selectionArgs) {

        throw new UnsupportedOperationException(
                "La eliminación no está permitida"
        );
    }

    @Override
    public int update(
            Uri uri,
            ContentValues values,
            String selection,
            String[] selectionArgs) {

        throw new UnsupportedOperationException(
                "La actualización no está permitida"
        );
    }
}