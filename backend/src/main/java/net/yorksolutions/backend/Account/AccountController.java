package net.yorksolutions.backend.Account;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/list")
    public ArrayList<Account> list() {
        return accountService.list();
    }

    @PostMapping("/create")
    public void create(@RequestBody AccountCreateRequest requestBody) {

        accountService.create(requestBody.username, requestBody.password, requestBody.role);
    }

    @PostMapping("/login")
    public HashMap<String, Object> login(@RequestBody AccountAuthRequest requestBody) {

        return accountService.login(requestBody.username, requestBody.password);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody EditAccountReq requestBody) {
        accountService.delete(requestBody.id);
    }

    @PatchMapping("/edit")
    public void edit(@RequestBody EditAccountReq requestBody) {
        accountService.edit(requestBody.id, requestBody.username, requestBody.password, requestBody.role);
    }
}

class EditAccountReq {
    public Long id;
    public String username;
    public String password;

    public String role;
}

class AccountCreateRequest {
    public String username;
    public String password;
    public String role;
}
class AccountAuthRequest {
    public String username;
    public String password;
}
