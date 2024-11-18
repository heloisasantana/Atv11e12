package com.example.atv11;

import android.content.Context;
import java.sql.SQLException;
import java.util.List;

public class JogadorController {
    private JogadorDao jogadorDao;

    public JogadorController(Context context) {
        jogadorDao = new JogadorDao(context);
    }

    public void insertJogador(String nome, int idade, int idTime) throws SQLException {
        Jogador jogador = new Jogador(0, nome, idade, idTime);
        jogadorDao.insert(jogador);
    }

    public List<Jogador> listAllJogadores() throws SQLException {
        return jogadorDao.findAll();
    }

    public Jogador findJogador(int id) throws SQLException {
        return jogadorDao.findOne(id);
    }

    public int updateJogador(int id, String nome, int idade, int idTime) throws SQLException {
        Jogador jogador = new Jogador(id, nome, idade, idTime);
        return jogadorDao.update(jogador);
    }

    public void deleteJogador(int id) throws SQLException {
        Jogador jogador = new Jogador(id, null, 0, 0);
        jogadorDao.delete(jogador);
    }
}
