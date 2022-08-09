package net.yorksolutions.backend.Account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findByUsernameIgnoreCaseAndPassword(String username, String password);

    Optional<Account> findByUsernameIgnoreCase(String username);
}
