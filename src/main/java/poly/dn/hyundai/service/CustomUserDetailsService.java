package poly.dn.hyundai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import poly.dn.hyundai.Entity.Account;



@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountService accountService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomUserDetailsService(AccountService accountService, PasswordEncoder passwordEncoder) {
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findById(username).get();
        if (account == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomUserDetails(
                account.getUsername(),
                account.getPassword(),
                account.getFullname(),
                account.getEmail(),
                account.getPhoneNumber(),
                account.getAuthorities()
        );
    }
}