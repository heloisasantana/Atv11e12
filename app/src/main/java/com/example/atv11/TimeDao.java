package com.example.atv11;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class TimeDao implements ICRUDDao<Time> {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public TimeDao(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    @Override
    public void insert(Time time) throws SQLException {
        open();
        ContentValues values = new ContentValues();
        values.put("nome", time.getNome());
        values.put("cidade", time.getCidade());
        db.insert("Time", null, values);
        close();
    }

    @Override
    public int update(Time time) throws SQLException {
        open();
        ContentValues values = new ContentValues();
        values.put("nome", time.getNome());
        values.put("cidade", time.getCidade());
        int rows = db.update("Time", values, "id = ?", new String[]{String.valueOf(time.getId())});
        close();
        return rows;
    }

    @Override
    public void delete(Time time) throws SQLException {
        open();
        db.delete("Time", "id = ?", new String[]{String.valueOf(time.getId())});
        close();
    }

    @Override
    public Time findOne(int id) throws SQLException {
        open();
        Cursor cursor = db.query("Time", null, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            Time time = new Time(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("cidade"))
            );
            cursor.close();
            close();
            return time;
        }
        close();
        return null;
    }

    @Override
    public List<Time> findAll() throws SQLException {
        open();
        List<Time> times = new ArrayList<>();
        Cursor cursor = db.query("Time", null, null, null, null, null, "nome ASC");
        while (cursor.moveToNext()) {
            Time time = new Time(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("cidade"))
            );
            times.add(time);
        }
        cursor.close();
        close();
        return times;
    }
}
