import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:service-context.xml"})
public class BaseTest extends AbstractJUnit4SpringContextTests {

    @Before
    public void setup() throws Exception {
        initData();
    }

    public <T> T getBean(String beanName) {
        return (T) this.applicationContext.getBean(beanName);
    }

    public <T> T getBean(Class<T> clazz) {
        return this.applicationContext.getBean(clazz);
    }

    public <T> T getBean(String beanName, Class<T> clazz) {
        return this.applicationContext.getBean(beanName, clazz);
    }

    public void initData() throws Exception {
    }

    @Test
    public void test() {

    }
}