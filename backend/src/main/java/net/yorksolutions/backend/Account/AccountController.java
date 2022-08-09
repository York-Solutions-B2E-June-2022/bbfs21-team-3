package net.yorksolutions.backend.Account;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public void create(@RequestBody AccountCreateRequest requestBody) {

        accountService.create(requestBody.username, requestBody.password, requestBody.role);
    }

    @PostMapping("/login")
    public HashMap<String, Object> login(@RequestBody AccountAuthRequest requestBody) {

        return accountService.login(requestBody.username, requestBody.password);
    }
}

class AccountCreateRequest{
    public String username;
    public String password;
    public String role;
}
class AccountAuthRequest {
    public String username;
    public String password;
}
