package zero.dubbo;

public class TestServiceImpl implements TestService {
    @Override
    public String sayHello(String name) {
//        return "Hello " + name;
        System.out.println("asd");
        return "asd";
//        throw new RuntimeException("error");
    }
}
