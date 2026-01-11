package io.crtp.cs.controllers;

import io.crtp.cs.model.Transaction;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


// http://localhost:8080/trx
//
// json
// (
//    "note":"seven11",
//    "ammount":"123.45"
// )
//
// curl
// curl -X POST \
//    http://localhost:8080/trx
//      -H 'cache-control: no-cache' \
//      -H 'content-type: application/json' \
//      -d '{
//          "note":"seven11",
//          "ammount":"123.45"
//          }'
//
//
// curl -X POST http://localhost:8080/trx -H 'cache-control: no-cache' -H 'content-type: application/json' -d '{ "note":"seven11","ammount":"123.45" }'

@RestController
public class TrxController {
    
    @PostMapping("/trx")
    public Transaction postTrx(@RequestBody Transaction transaction) {
        //TODO: process POST request
        
        System.out.println(transaction.getAmmount());
        System.out.println(transaction.getNote());

        return transaction;
    }
    
}
