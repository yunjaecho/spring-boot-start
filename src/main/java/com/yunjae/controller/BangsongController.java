package com.yunjae.controller;

import com.yunjae.domain.Bangsong;
import com.yunjae.exception.BangsongException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class BangsongController {

    // @CrossOrigin value 없으면 모든 도메인 허용
    //@CrossOrigin
    @GetMapping("/bs")
    public Bangsong bangsong() {
        Bangsong bangsong = new Bangsong();
        bangsong.setId(1);
        bangsong.setStreamer("ChoYunjae");
        bangsong.setEnded(new Date());
        bangsong.setStarted(new Date());
        bangsong.setTitle("스프링 부트 2.0");
        return bangsong;
    }


    @GetMapping("/bs/{id}")
    public Bangsong getBangsong(@PathVariable("id") Bangsong bangsong) {
        if (bangsong.getId() == 100) {
            throw new BangsongException();
        }

        return bangsong;
    }

//    @ExceptionHandler(BangsongException.class)
//    public ResponseEntity<String> handleException(BangsongException e) {
//        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
//
//    }

}
