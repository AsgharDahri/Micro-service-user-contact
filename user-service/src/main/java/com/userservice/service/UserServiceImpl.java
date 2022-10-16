package com.userservice.service;

import com.userservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {


    //fake user List for now, then db will be attached
    List<User> list=List.of(
            new User(13111L,"Jack","02205645821"),
            new User(13145L,"Ali","09205645821"),
            new User(13011L,"John","05205645821")
    );
    @Override
    public User getUser(Long id) {
        return this.list.stream().filter(user->user.getUserId().equals(id)).findAny().orElse(null);
    }
}
