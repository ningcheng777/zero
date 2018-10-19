/**
 * @author ningcheng
 * @date 2018/1/25
 */
public class MainTest {

    public static void main(String[] args) {
        A a = new A();
    }

    public static class A {

        {
            System.out.println(2);
        }

        {
            System.out.println(3);
        }

        public A() {
            System.out.println(1);
        }

    }

}
