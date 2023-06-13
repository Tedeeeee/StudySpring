package hello.servlet.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV1 {

    // 왜 인터페이스 인가
    // 앞에서 우리는 한개의 frontController 로 모든 controller 를 다룬다고 앞서 말했다 그럼 한개의 인터페이스를 구현하는것이 로직의 일관성이 된다.
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
