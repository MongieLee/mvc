package cn.mgl.controller;

import cn.mgl.pojo.User;
import cn.mgl.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Object selectById(@PathVariable("id") Long id) {
        User userById = userService.getUserById(id);
        if (userById != null) {
            System.out.println(userById.getUsername());
        }
        return userById;
    }

    @PutMapping
    public Object update(@RequestBody User user) {
        userService.update(user);
        return null;
    }

    @PostMapping
    public Object insert(@RequestBody User user) {
        userService.insert(user);
        return null;
    }

    @GetMapping
    public Object selectAll(Integer pageNo, Integer pageSize) {
        System.out.println(pageNo);
        System.out.println(pageSize);
        List<User> all = userService.getAll(pageNo, pageSize);
        all.forEach(System.out::println);
        PageInfo<User> tPageInfo = new PageInfo<>(all);
        System.out.println(tPageInfo.getTotal());
        return all;
    }
}
