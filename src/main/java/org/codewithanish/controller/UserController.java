package org.codewithanish.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/name")
    public ResponseEntity<?> getName(@RequestParam(required = false) boolean isDelay, @RequestParam(required = false) boolean isError){
        if(isDelay)
        {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(isError)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>( "Anish", HttpStatus.OK);
    }

    @GetMapping("/address")
    public String getAddress(){
        return "Address1";
    }

    @GetMapping("/payment")
    public  ResponseEntity<?> makePayment( @RequestParam(required = false) boolean isError){
        if(isError)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>( "Payment successful", HttpStatus.OK);
    }

}
