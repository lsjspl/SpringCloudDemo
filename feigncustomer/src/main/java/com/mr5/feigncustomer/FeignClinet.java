package com.mr5.feigncustomer;

@FeignClient(name = "github-client", url = "https://api.github.com")
public interface FeignClinet {
    public String home();
}
