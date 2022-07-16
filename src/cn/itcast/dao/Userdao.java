package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

public interface Userdao {
    public List<User> findAll();

    public User findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    void del(int id);

    User findUserByid(int parseInt);

    void up(User user);

    List<User> findyname(String name);
}
