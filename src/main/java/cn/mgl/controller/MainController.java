package cn.mgl.controller;

import cn.mgl.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class MainController {
    @PostMapping("/getSome")
    public String getSome(HttpServletRequest request) {
        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("username"));
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = requestAttributes.getRequest();
        System.out.println(req == request);
        return "123";
    }
}

