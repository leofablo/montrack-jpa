package com.montrack_jpa.montract_jpa.auth.Entity;
import com.montrack_jpa.montract_jpa.user.entity.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
public class UserAuth extends User implements UserDetails {
     private final User user;

     public UserAuth(User user){
        this.user = user;
     }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(() -> "Role User");
         return authorities;
    }

    @Override
     public String getPassword(){
         return user.getUserAuth().getPassword();
     }

     public String getUsername(){
         return user.getEmail();
     }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
