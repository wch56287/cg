package com.changgou.oauth.count;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: WangChunHui
 * @Date: 2020-04-02 23:40
 * @Description:
 */
@Component
@RequestMapping("/loginCount")
public class LoginCount {

    private AtomicInteger atomicInteger = new AtomicInteger();

    private Set<String> loginUser = new CopyOnWriteArraySet<>();

    public int increment(){
        return atomicInteger.incrementAndGet();
    }

    public int decremrnt(){
        return atomicInteger.decrementAndGet();
    }

    public void addUser2Set(String username){
        loginUser.add(username);
    }

    public void removeUserFromSet(String username){
        loginUser.remove(username);
    }



    @RequestMapping("/getCount")
    @ResponseBody
    public int getCount(){
        return loginUser.size();
    }



}
