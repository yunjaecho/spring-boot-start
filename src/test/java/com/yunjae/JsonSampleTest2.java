package com.yunjae;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonSampleTest2 {

    JacksonTester<Sample> jsonTest;

    @Before
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void testJson() throws IOException {
        Sample sample = new Sample();
        sample.setName("yunjae");
        sample.setNumber(100);

        assertThat(this.jsonTest.write(sample))
                .hasJsonPathStringValue("@.name")
                .extractingJsonPathStringValue("@.name")
                .isEqualTo("yunjae");

        assertThat(this.jsonTest.write(sample))
                .hasJsonPathNumberValue("@.number")
                .extractingJsonPathNumberValue("@.number")
                .isEqualTo(100);
    }
}
