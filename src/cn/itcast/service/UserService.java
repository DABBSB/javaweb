package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User login(User user);

    void addUser(User user);

    void delUer(String id);

    User findUserByid(String id);

    void updaet(User user);

    List<User> findyname1(String name);
}
