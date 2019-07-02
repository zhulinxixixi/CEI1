package cn.javabs.cei.service;

import cn.javabs.cei.entity.Column;

import java.util.List;

public interface ColumnService {
    int delColumn(int id);

    Column findColumnById(int id);

    int updateColumn(Column column);

    List<Column> findAllColumn();

    int addColumn(Column column);

    Column findColumnByName(String name);
}
