package cn.javabs.cei.dao;

import cn.javabs.cei.entity.Column;

import java.util.List;

public interface ColumnDao {
    int addColumn(Column column);

    int delColumn(int id);

    int updateColumn(Column column);

    List<Column> getAllColumn();

    Column getColumnById(int id);

    Column getColumnByName(String name);
}
