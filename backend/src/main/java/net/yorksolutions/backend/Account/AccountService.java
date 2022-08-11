package net.yorksolutions.backend.Account;

import net.yorksolutions.backend.Inventory.Inventory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public ArrayList<Account> list() {

        return new ArrayList<Account>(accountRepository.getAllBy());
    }

    public void create(String username, String password, String role) {

        if (username == null || password == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Optional<Account> existingAccount = accountRepository.findByUsernameIgnoreCase(username);

        if (existingAccount.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Account account = new Account(username, password, role);

        accountRepository.save(account);

    }

    public HashMap<String, Object> login(String username, String password) {

        HashMap<String, Object> data = new HashMap<String, Object>();

        if (username == null || password == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        Optional<Account> existingAccount = accountRepository.findByUsernameIgnoreCaseAndPassword(username, password);

        if (existingAccount.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        Account account = existingAccount.get();

        data.put("id", account.id);
        data.put("username", account.username);
        data.put("role", account.role);

        return data;
    }

    public void delete(Long id) {

        Optional<Account> existingAccount = accountRepository.findById(id);

        if (existingAccount.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        accountRepository.delete(existingAccount.get());

    }

    public void edit(Long id, String username, String password, String role) {

        Optional<Account> existingAccount = accountRepository.findById(id);

        if (existingAccount.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Account account = existingAccount.get();

        if (username != null) {
            account.username = username;
        }

        if (password != null) {
            account.password = password;
        }

        if (role != null) {
            account.role = role;
        }

        accountRepository.save(account);
    }


}
