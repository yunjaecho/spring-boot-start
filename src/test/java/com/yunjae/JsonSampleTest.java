package com.yunjae;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@JsonTest
public class JsonSampleTest {

    @Autowired
    JacksonTester<Sample> json;

    @Test
    public void testJson() throws IOException {
        Sample sample = new Sample();
        sample.setName("yunjae");
        sample.setNumber(100);

        assertThat(this.json.write(sample))
                .hasJsonPathStringValue("@.name")
                .extractingJsonPathStringValue("@.name")
                .isEqualTo("yunjae");

        assertThat(this.json.write(sample))
                .hasJsonPathNumberValue("@.number")
                .extractingJsonPathNumberValue("@.number")
                .isEqualTo(100);
    }
}
