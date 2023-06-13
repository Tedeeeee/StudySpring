package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    // Slf4j 가 이것을 적어놓는것과 같다
    //private final Logger log = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        // 이렇게 작성하면 안된다.
        // log.trace("trace log = " + name);
        // 왜냐하면 "+" 가 붙으면서 컴퓨터가 연산을 한다. 하지만 우리가 사용하는 로그가 꼭 나타나란 법은 없는것이다.
        // 즉, 쓸모없는 리소스 사용이 일어나는것이다. 그래서 {} 를 사용해서 값을 보이게 한다.

        System.out.println(" ---------------------------------------------------------------------------------------------------------- 로그 시작 ");
        log.trace("trace log = {} ", name);
        log.debug("debug log = {} ", name);
        log.info("info log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log = {}", name);
        System.out.println(" ---------------------------------------------------------------------------------------------------------- 로그 끝 ");


        return "OK";
    }
}
