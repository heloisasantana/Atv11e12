package com.example.atv11;

import android.content.Context;
import java.sql.SQLException;
import java.util.List;

public class TimeController {
    private TimeDao timeDao;

    public TimeController(Context context) {
        timeDao = new TimeDao(context);
    }

    public void insertTime(String nome, String cidade) throws SQLException {
        Time time = new Time(0, nome, cidade);
        timeDao.insert(time);
    }

    public List<Time> listAllTimes() throws SQLException {
        return timeDao.findAll();
    }

    public Time findTime(int id) throws SQLException {
        return timeDao.findOne(id);
    }

    public int updateTime(int id, String nome, String cidade) throws SQLException {
        Time time = new Time(id, nome, cidade);
        return timeDao.update(time);
    }

    public void deleteTime(int id) throws SQLException {
        Time time = new Time(id, null, null);
        timeDao.delete(time);
    }
}

