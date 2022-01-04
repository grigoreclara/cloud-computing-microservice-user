package ro.unibuc.fmi.dietapp.microservice.user.mapper;

import org.mapstruct.Mapper;
import ro.unibuc.fmi.dietapp.microservice.user.dto.AccountDto;
import ro.unibuc.fmi.dietapp.microservice.user.model.Account;

@Mapper
public interface AccountMapper extends EntityMapper<AccountDto, Account>{
}
