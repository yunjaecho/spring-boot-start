package com.yunjae.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Created by USER on 2018-03-27.
 * bound to structured objects
 */
@Data
//@Component  // Bean register
//@ConfigurationProperties("yunjae")
public class YunjaeProperties {
    @NotEmpty
    private String name;
    private String workFor;
    private String whereToGo;
    private String fooBar;

    @DurationUnit(ChronoUnit.SECONDS)
    private Duration timeOne;

    @DurationUnit(ChronoUnit.SECONDS)
    private Duration timeTwo;

    @DurationUnit(ChronoUnit.SECONDS)
    private Duration timeThree;

    @Min(10)
    @Max(100)
    private int number;

    private List<MyPojo> list;
}
