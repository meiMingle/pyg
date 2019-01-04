package com.pinyougou.shop.service;/*
 * @Description  -  -    :  商家登陆处理
 * @Create    -  -  -    ： 2019/1/2 21:25
 * @Author    -  -  -    ： Ti
 * @Version   -  -  -    :  1.0
 **/

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailServiceImpl implements UserDetailsService {

    private SellerService sellerService;

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //创建角色列表
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_SELLER"));

        //得到商家对象
        TbSeller seller = sellerService.findOne(username);

        if (seller != null) {
            if (seller.getStatus().equals("1")) {
                return new User(username, seller.getPassword(), grantedAuthorityList);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
