package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Testconfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : A 사용자가 10000원을 주문
        int userAPrice = statefulService1.order("userA", 10000);

        // ThreadB : B 사용자가 20000원을 주문
        int userBPrice = statefulService2.order("userB", 20000);

        // ThreadA : 사용자 A 주문 금액 조회
        // int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice);
        // 이때 객체가 같아서 이름이 바뀌어도 값을 바꾸면 1 과 2 모두 영향이 간다.

        // Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class Testconfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }


}