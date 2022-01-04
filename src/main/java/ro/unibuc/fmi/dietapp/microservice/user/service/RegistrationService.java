package ro.unibuc.fmi.dietapp.microservice.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.unibuc.fmi.dietapp.microservice.user.exception.BadRequestException;
import ro.unibuc.fmi.dietapp.microservice.user.model.Account;
import ro.unibuc.fmi.dietapp.microservice.user.model.Registration;
import ro.unibuc.fmi.dietapp.microservice.user.model.User;

import javax.transaction.Transactional;

@Service
@Transactional
public class RegistrationService {
    private final UserService userService;
    private final CityService cityService;
    private final AccountService accountService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserService userService, CityService cityService, AccountService accountService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.cityService = cityService;
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    public void create(Registration registration){
        if(! userService.existsByUsername(registration.getUsername())) {

            User registeredUser = User.builder()
                    .username(registration.getUsername())
                    .first_name(registration.getFirst_name())
                    .last_name(registration.getLast_name())
                    .birth_date(registration.getBirth_date())
                    .gender(registration.getGender())
                    .city(cityService.findById(registration.getCity()))
                    .build();

            User resultedUser = userService.create(registeredUser);

            Account registeredAccount = Account.builder()
                    .user(resultedUser)
                    .password(passwordEncoder.encode(registration.getPassword()))
                    .role("ROLE_USER")
                    .active("1")
                    .build();

            Account resultedAccount = accountService.create(registeredAccount);
        } else {
            throw new BadRequestException("This username is already taken");
        }
    }
}
