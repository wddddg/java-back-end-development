package cn.wddxhz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cn.wddxhz"})
public class DevelopmentJavaBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevelopmentJavaBackEndApplication.class, args);
    }

}
