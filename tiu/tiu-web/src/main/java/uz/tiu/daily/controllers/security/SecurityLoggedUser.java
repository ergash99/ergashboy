package uz.tiu.daily.controllers.security;

import org.springframework.security.core.GrantedAuthority;
import uz.tiu.daily.persistence.User;

import java.util.Collection;

/**
 * @author Sheroz Khaydarov
 * @since Date: 27.09.2007 Time: 16:03:58
 */

public class SecurityLoggedUser extends org.springframework.security.core.userdetails.User
{

    private Collection<GrantedAuthority> authorities;
    private User user;

    public Collection<GrantedAuthority> getAuthorities()
    {
        return authorities;
    }

    public User getUser() {
        return user;
    }

    public SecurityLoggedUser(String login, String password, Collection<GrantedAuthority> authorities, User user)
            throws IllegalArgumentException
    {
        super(login, password, true /*enabled*/, true /*accountNonExpired*/, true /*credentialsNonExpired*/, true /*accountNonLocked*/, authorities);
        this.authorities=authorities;
        this.user = user;
    }
}
