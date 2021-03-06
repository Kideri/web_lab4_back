package kideri.web.controller;

import kideri.web.orm.User;
import kideri.web.services.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
@CrossOrigin(origins = "http://localhost:3000/main/")
public class TestController {
    @GetMapping
    public String list() {
        System.out.println("1");
        return "{ \"item\":\"AAaaAA\"}";
    }


    @Autowired
    UserDataService userDataService;

    @GetMapping("{login}")
    public String getUserBylogin(@PathVariable String login) {



        User user = userDataService.GetUserByLogin(login);


        return "{ \"item\":"+user.getId()+"}";
    }


}
