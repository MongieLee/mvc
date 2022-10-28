package cn.mgl.dao;

import cn.mgl.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author MongieLee
 * @version 1.0
 * @date 2022/10/28 10:40
 */
public interface UserDao {
    User getUserById(Long id);


    int insert(User user);

    int delete(Long id);

    int update(User user);

    List<User> getAll();
}
