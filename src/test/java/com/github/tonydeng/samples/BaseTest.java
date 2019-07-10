package com.github.tonydeng.samples;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@SpringBootTest(classes = BaseTest.SpringTestConfiguration.class)
@ExtendWith(SpringExtension.class)
public class BaseTest {

    @SpringBootApplication(scanBasePackages = {"com.github.tonydeng.samples"})
    static class SpringTestConfiguration {

    }

    @Test
    void test() {
        log.info("test");
    }
}
