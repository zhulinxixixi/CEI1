package cn.javabs.cei.dao;

import cn.javabs.cei.entity.Nav;

import java.util.List;

public interface NavDao {
    int addNav(Nav nav);

    int delNav(int id);

    int updateNav(Nav nav);

    List<Nav> getAllNav();

    Nav getNavById(int id);

    Nav getNavByName(String name);
}
