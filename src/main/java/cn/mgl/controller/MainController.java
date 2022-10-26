package cn.mgl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

    /**
     * 相当于Servlet的路径
     * @return
     */
    @RequestMapping("/getSome")
    @ResponseBody
    public String getSome() {
        System.out.println(123);
//        Map<String, Object> result = new HashMap();
//        result.put("code", 200);
//        result.put("msg", "ok");
        return "123";
    }
}

