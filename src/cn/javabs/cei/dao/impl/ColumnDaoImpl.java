package cn.javabs.cei.dao.impl;

import cn.javabs.cei.dao.ColumnDao;
import cn.javabs.cei.entity.Column;
import cn.javabs.cei.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ColumnDaoImpl implements ColumnDao {

    QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

    @Override
    public int addColumn(Column column) {

        try {
            System.out.println(column.getColumnName());
            System.out.println(column.getCatId());
            System.out.println(column);

            return qr.update("insert into columns(columnName,catId) values(?,?);",column.getColumnName(),column.getCatId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int delColumn(int id) {
        try {
            return qr.update("delete from columns where id = ?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateColumn(Column column) {

        try {

            return qr.update("update columns set columnName=?,catId=? where id=?",column.getColumnName(),column.getCatId(),column.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Column> getAllColumn() {
        List<Column> columns=null;
        try {
            columns = qr.query("select * from columns ,category  where columns.catId=category.categoryid",new BeanListHandler<Column>(Column.class));
            return columns;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Column getColumnById(int id) {

        try {
            Column column = qr.query("select * from columns col,category cat where col.catId=cat.categoryId and col.id=?",new BeanHandler<Column>(Column.class),id);
            return column;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Column getColumnByName(String name) {
        try {
            Column column = qr.query("select * from columns col,category cat where col.catId=cat.id and col.columnName=?",new BeanHandler<Column>(Column.class),name);
            return column;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
