package cn.javabs.cei.service.impl;

import cn.javabs.cei.dao.NavDao;
import cn.javabs.cei.dao.impl.NavDaoImpl;
import cn.javabs.cei.entity.Nav;
import cn.javabs.cei.service.NavService;

import java.util.List;

public class NavServiceImpl implements NavService {

    NavDao navDao = new NavDaoImpl();

    @Override
    public int addNav(Nav nav) {
        return navDao.addNav(nav);
    }

    @Override
    public int delNav(int id) {
        return navDao.delNav(id);
    }

    @Override
    public int updateNav(Nav nav ) {
        return navDao.updateNav(nav);
    }

    @Override
    public List<Nav> findAllNav() {
        return navDao.getAllNav();
    }

    @Override
    public Nav findNavById(int id) {

        return navDao.getNavById(id);
    }

    @Override
    public Nav findNavByName(String name) {
        return navDao.getNavByName(name);
    }
}
