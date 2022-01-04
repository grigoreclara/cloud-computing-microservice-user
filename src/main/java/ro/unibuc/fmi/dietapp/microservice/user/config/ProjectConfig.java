package ro.unibuc.fmi.dietapp.microservice.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.unibuc.fmi.dietapp.microservice.user.mapper.*;

@Configuration
public class ProjectConfig {
    @Bean
    public AccountMapper accountMapper() { return new AccountMapperImpl(); }

    @Bean
    public CityMapper cityMapper() { return new CityMapperImpl();
    }

    @Bean
    public CountryMapper countryMapper() { return new CountryMapperImpl(); }

    @Bean
    public HappinessMapper happinessMapper() { return new HappinessMapperImpl(); }

    @Bean
    public RegistrationMapper registrationMapper() { return new RegistrationMapperImpl(); }

    @Bean
    public UserMapper userMapper() { return new UserMapperImpl(); }

    @Bean
    public WeightMapper weightMapper() { return new WeightMapperImpl(); }
}
