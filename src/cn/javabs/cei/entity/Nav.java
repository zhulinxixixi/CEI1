package cn.javabs.cei.entity;

public class Nav {
    //栏目id
    private int id;
    //栏目名字
    private String NavName;
    private int catId;
    private String categoryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavName() {
        return NavName;
    }

    public void setNavName(String NavName) {
        this.NavName = NavName;
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
        return "Nav{" +
                "id=" + id +
                ", NavName='" + NavName + '\'' +
                ", catId=" + catId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
