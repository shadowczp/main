package com.example.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FeignClient 这个注解用来指定调用了哪个服务，这里是说调用了service-hi服务
 * 这里的RequestMapping  /hi  应该是说，调用了service-hi服务的/hi接口吧？
 * 然后我们直接使用标注了这个注解的方法，就像是RMI一样
 * 当我们调用了sayHiFromClientOne(name)，就会根据服务名和 /hi 这个接口，
 * 去调用那个服务的接口，就像RMI一样，最终返回给我们
 * fallback是说，当调用失败的时候如何返回，fallback的那个类要实现我们的接口
 * 就相当于是说RMI调用失败的时候，给了一个自己的默认实现
 */
@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
