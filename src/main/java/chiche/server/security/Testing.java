package chiche.server.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chiche.server.utility.TokensTransform;

@RestController
@RequestMapping("test")
public class Testing {

    TokensTransform util = new TokensTransform();
    Tokens token = new Tokens();
    Encryptor encrypt = new Encryptor();

    @GetMapping("token")
    public String generateToken() {
        return token.generateToken("12", "Subject", "Yadira", (long) 360000);
    }

    // @PostMapping("{tk}")
    // public Claims decode (@PathVariable String tk){
    // return token.decode(tk);
    // }

    @GetMapping("{password}")
    public String encrypt(@PathVariable String password) {
        return encrypt.encrypt(password);
    }

    @PostMapping("{weirdStuff}")
    public Boolean descrypt(@PathVariable String weirdStuff) {
        return encrypt.validate(weirdStuff, "$2a$10$..VDJGYj.oVzH6fv2twnT.FnzWvn.SjyLXKhY9Tp6ztYI7WJZjZ/i");
    }

    @GetMapping("h")
    public String header(@RequestHeader(value = "Authorization") String au) {
        return token.decode(util.getToken(au)).toString();
    }

}
