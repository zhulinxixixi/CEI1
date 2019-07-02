package cn.javabs.cei.entity;

public class Column {
    //栏目id
    private int id;
    //栏目名字
    private String columnName;
    private int catId;
    private String categoryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Column{" +
                "id=" + id +
                ", columnName='" + columnName + '\'' +
                ", catId=" + catId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
