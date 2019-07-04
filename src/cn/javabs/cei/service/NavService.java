package cn.javabs.cei.service;

import cn.javabs.cei.entity.Nav;

import java.util.List;

public interface NavService {
    int delNav(int id);

    Nav findNavById(int id);

    int updateNav(Nav nav);

    List<Nav> findAllNav();

    int addNav(Nav nav);

    Nav findNavByName(String name);
}
