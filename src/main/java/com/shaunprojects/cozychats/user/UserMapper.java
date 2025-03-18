package com.shaunprojects.cozychats.user;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class UserMapper {
    public User fromTokenAttributes(Map<String, Object> claims) {
        User user = new User();

        if(claims.containsKey("sub")) {
            user.setId(claims.get("sub").toString());
        }

        if(claims.containsKey("given_name")) {
            user.setFirstname(claims.get("given_name").toString());
        }else if(claims.containsKey("nickname")) {
            user.setFirstname(claims.get("nickname").toString());
        }

        if(claims.containsKey("family_name")){
            user.setLastname(claims.get("family_name").toString());
        }

        if(claims.containsKey("email")) {
            user.setEmail(claims.get("email").toString());
        }

        user.setLastSeen(LocalDateTime.now());

        return user;
    }

    public UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstname())
                .lastName(user.getLastname())
                .email(user.getEmail())
                .lastSeen(user.getLastSeen())
                .isOnline(user.isUserOnline())
                .build();
    }
}
