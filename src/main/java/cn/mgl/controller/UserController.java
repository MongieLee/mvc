package cn.mgl.controller;

import cn.mgl.pojo.User;
import cn.mgl.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Object selectById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PutMapping
    public Object update(@RequestBody User user) {
        int i = userService.update(user);
        return i == 1 ? "更新成功" : "更新失败";
    }

    @PostMapping
    public Object insert(@RequestBody User user) {
        userService.insert(user);
        return "新增成功";
    }

    @DeleteMapping(value = "/{id}")
    public Object delete(@PathVariable("id") Long id) {
        int i = userService.delete(id);
        return i == 1 ? "删除成功" : "删除失败";
    }

    @GetMapping
    public Object selectAll(Integer pageNo, Integer pageSize) {
        if (pageNo == null) {
            pageNo = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        List<User> all = userService.getAll(pageNo, pageSize);
        PageInfo<User> tPageInfo = new PageInfo<>(all);
        System.out.println(tPageInfo.getTotal());
        Map<String, Object> result = new HashMap<>();
        result.put("result", all);
        result.put("total", tPageInfo.getTotal());
        return result;
    }
}
