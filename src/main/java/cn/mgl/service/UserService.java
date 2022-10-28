package cn.mgl.service;

import cn.mgl.dao.UserDao;
import cn.mgl.pojo.User;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author MongieLee
 * @version 1.0
 * @date 2022/10/28 10:40
 */
@Service
public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public List<User> getAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return userDao.getAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public int insert(User user) {
        Integer i = userDao.insert(user);
        int o = 1 / 0;
        return i;
    }

    public int delete(Long id) {
        return userDao.delete(id);
    }

    public int update(User user) {
        return userDao.update(user);
    }
}
