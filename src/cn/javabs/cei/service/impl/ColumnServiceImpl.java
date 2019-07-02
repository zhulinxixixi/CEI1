package cn.javabs.cei.service.impl;

import cn.javabs.cei.dao.ColumnDao;
import cn.javabs.cei.dao.impl.ColumnDaoImpl;
import cn.javabs.cei.entity.Column;
import cn.javabs.cei.service.ColumnService;

import java.util.List;

public class ColumnServiceImpl implements ColumnService {

    ColumnDao columnDao = new ColumnDaoImpl();

    @Override
    public int addColumn(Column column) {
        return columnDao.addColumn(column);
    }

    @Override
    public int delColumn(int id) {
        return columnDao.delColumn(id);
    }

    @Override
    public int updateColumn(Column column ) {
        return columnDao.updateColumn(column);
    }

    @Override
    public List<Column> findAllColumn() {
        return columnDao.getAllColumn();
    }

    @Override
    public Column findColumnById(int id) {

        return columnDao.getColumnById(id);
    }

    @Override
    public Column findColumnByName(String name) {
        return columnDao.getColumnByName(name);
    }
}
