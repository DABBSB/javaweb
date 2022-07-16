package cn.itcast.service.impl;

import cn.itcast.dao.Userdao;
import cn.itcast.dao.impl.Userdaoimpl;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;

public class UserServiceimpl implements UserService {
    private Userdao dao = new Userdaoimpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void delUer(String id) {
        dao.del(Integer.parseInt(id));
    }

    @Override
    public User findUserByid(String id) {
        return dao.findUserByid(Integer.parseInt(id));
    }

    @Override
    public void updaet(User user) {
        dao.up(user);
    }

    @Override
    public List<User> findyname1(String name) {
        return dao.findyname(name);
    }


}
