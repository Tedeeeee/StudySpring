package hello.core.singleton;

public class SingletonService {
    // static 을 이용해서 new 로 다른곳에서 객체 생성을 막아버린다
    private static final SingletonService instance = new SingletonService();

    // instance 를 통해 만든 객체를 getInstance 를 사용해서만 가져올수 있고 이는 단 한개의 객체만 사용한다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 다른곳에서 아무나 사용하지 못하게 하기위해 생성자를 만들어버린다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
