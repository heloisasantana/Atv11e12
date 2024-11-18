package com.example.atv11;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class JogadorDao implements ICRUDDao<Jogador> {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public JogadorDao(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    @Override
    public void insert(Jogador jogador) throws SQLException {
        open();
        ContentValues values = new ContentValues();
        values.put("nome", jogador.getNome());
        values.put("idade", jogador.getIdade());
        values.put("idTime", jogador.getIdTime());
        db.insert("Jogador", null, values);
        close();
    }

    @Override
    public int update(Jogador jogador) throws SQLException {
        open();
        ContentValues values = new ContentValues();
        values.put("nome", jogador.getNome());
        values.put("idade", jogador.getIdade());
        values.put("idTime", jogador.getIdTime());
        int rows = db.update("Jogador", values, "id = ?", new String[]{String.valueOf(jogador.getId())});
        close();
        return rows;
    }

    @Override
    public void delete(Jogador jogador) throws SQLException {
        open();
        db.delete("Jogador", "id = ?", new String[]{String.valueOf(jogador.getId())});
        close();
    }

    @Override
    public Jogador findOne(int id) throws SQLException {
        open();
        Cursor cursor = db.query("Jogador", null, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            Jogador jogador = new Jogador(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getInt(cursor.getColumnIndex("idade")),
                    cursor.getInt(cursor.getColumnIndex("idTime"))
            );
            cursor.close();
            close();
            return jogador;
        }
        close();
        return null;
    }

    @Override
    public List<Jogador> findAll() throws SQLException {
        open();
        List<Jogador> jogadores = new ArrayList<>();
        Cursor cursor = db.query("Jogador", null, null, null, null, null, "nome ASC");
        while (cursor.moveToNext()) {
            Jogador jogador = new Jogador(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getInt(cursor.getColumnIndex("idade")),
                    cursor.getInt(cursor.getColumnIndex("idTime"))
            );
            jogadores.add(jogador);
        }
        cursor.close();
        close();
        return jogadores;
    }
}

