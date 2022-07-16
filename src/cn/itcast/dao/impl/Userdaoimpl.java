package cn.itcast.dao.impl;

import cn.itcast.Utils.JDBCUtils;
import cn.itcast.dao.Userdao;
import cn.itcast.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Userdaoimpl implements Userdao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        List<User> users = template.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
        return users;
    }


    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username= ? and password= ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getEmail());
    }


    @Override
    public void del(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql, id);
    }

    @Override
    public User findUserByid(int id) {
        String sql = "select * from user where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }

    @Override
    public void up(User user) {
        String sql = "update user set name = ? ,gender = ? ,age =? ,address = ? ,qq= ? ,email = ? where  id = ? ";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());

    }

    @Override
    public List<User> findyname(String name) {
        String sql = "select * from user where name like ?";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class), "%" + name + "%");
        return users;
    }


}
