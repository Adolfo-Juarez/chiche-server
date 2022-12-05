package chiche.server.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class Testing {

    Tokens token = new Tokens();
    Encryptor encrypt = new Encryptor();
    
    // @GetMapping
    // public String generateToken(){
    //     return token.generateToken("12", "Subject", "Adolfonsio", (long) 360000);
    // }

    // @PostMapping("{tk}")
    // public Claims decode (@PathVariable String tk){
    //     return token.decode(tk);
    // }

    @GetMapping("{password}")
    public String encrypt(@PathVariable String password){
        return encrypt.encrypt(password);
    }

    @PostMapping("{weirdStuff}")
    public Boolean descrypt(@PathVariable String weirdStuff){
        return encrypt.validate(weirdStuff,"[C@3a13ce");
    }

}
