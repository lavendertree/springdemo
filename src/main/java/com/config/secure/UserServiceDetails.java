package com.config.secure;

import com.dao.UserDao;
import com.pojo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by weber on 2017/7/12.
 */
@Service
public class UserServiceDetails implements UserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user=userDao.findByUsername(username);
        if(username==null){
                throw new UsernameNotFoundException("找不到账号");
        }
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        return new User(username,user.getPassword(),authorities);
    }
}
