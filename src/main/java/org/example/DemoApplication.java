package org.example;

import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class);
  }

  @Bean
  @ConditionalOnProperty("virtual-threads.enabled")
  public TomcatProtocolHandlerCustomizer<?> protocolHandlerVirtualThreadExecutorCustomizer() {
    return protocolHandler -> protocolHandler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
  }

  @RestController
  static class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    void test() {
      log.info("Started to sleep {}", Thread.currentThread());
      try {
        Thread.sleep(5_000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      log.info("Finished to sleep {}", Thread.currentThread());
    }
  }
}