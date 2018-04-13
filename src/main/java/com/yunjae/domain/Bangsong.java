package com.yunjae.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Bangsong {

    private Integer Id;

    private String streamer;

    private Date started;

    private Date ended;

    private String title;
}
