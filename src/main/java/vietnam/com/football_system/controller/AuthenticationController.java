package vietnam.com.football_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {

    @GetMapping("/")
    public ResponseEntity<String> uyQuyen(){
        String xacThuc = "Xac thuc thanh cong";
        return new ResponseEntity<>(xacThuc,HttpStatus.OK);
    }

}
