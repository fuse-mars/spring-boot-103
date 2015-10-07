// controller and application starter/entry point
package apispec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiSpecController {

  public static void main(String [] arguments){
    SpringApplication.run(ApiSpecController.class, arguments);
  }
}
