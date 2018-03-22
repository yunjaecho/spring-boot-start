package com.yunjae;

import com.yunjae.config.CustomApplicationLisenter;
import org.springframework.boot.Banner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);

        application.setBannerMode(Banner.Mode.OFF);

        // Application Context 생성전 applicatonStarted 리스너 등록
        // 빈을 사용할수 없고, 주입도 받지 못합
        // ApplicationRunner , CommandLineRunner (program argument 받을수 있음)
        application.addListeners(new CustomApplicationLisenter());
        // Application Type 지정하도록 처리
        // 일반 : WebApplicationType.NONE
        // reactive Web : WebApplicationType.REACTIVE
        application.setWebApplicationType(WebApplicationType.SERVLET);
        application.run(args);



	}
}
