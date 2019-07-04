package cn.javabs.cei.entity;

public class Category {
    //private:外边的方法等不能去随意的访问和修改这些属性

    //分类id
    private int categoryId;
    //分类名字
    private String categoryName;

    //getter和setter方法：
    // 私有对象对外访问方式
    //Getter是对类对象的属性值的获得
    //Setter是对类对象的属性的赋值方法。
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
