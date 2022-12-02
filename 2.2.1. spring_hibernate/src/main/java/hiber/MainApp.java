package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("BMV",1);
      Car car2 = new Car("LADA",2);
      Car car3 = new Car("MERCEDES",3);
      Car car4 = new Car("BUGATTI",4);
      Car car5 = new Car("LEXUS",5);

      User user1 = new User("ANDREY","PECHTEREV","PECHTEREV@MAIL.RU");
      User user2 = new User("IVAN","POGOSOV","POGOSOV@MAIL.RU");
      User user3 = new User("KOLYA","VITAS","VITAS@MAIL.RU");
      User user4 = new User("ARTUR","GALKIN","GALKIN@MAIL.RU");
      User user5 = new User("STAS","ERSHOV","ERSHOV@MAIL.RU");

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);
      user5.setCar(car5);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
      userService.add(user5);
      System.out.println(userService.getUserByCar("MERCEDES", 3 ));
      List<User> users = userService.listUsers();
      for (User user: users) {
         System.out.println(user);
      }

      context.close();
   }
}
