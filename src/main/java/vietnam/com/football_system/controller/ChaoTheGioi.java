package vietnam.com.football_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class ChaoTheGioi {

    @GetMapping("/hi")
    public String hello(){
        return "Chao the gioi";
    }
}
