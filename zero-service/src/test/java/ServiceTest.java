import com.ningcheng.zero.common.model.Module;
import com.ningcheng.zero.dal.module.ModuleDO;
import com.ningcheng.zero.service.module.ModuleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author ningcheng
 * @date 2017/10/9
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:service-context.xml"})
public class ServiceTest {

    @Autowired
    private ModuleService moduleService;

    @Test
    public void serviceTest() throws Exception {
        List<Module> ret = moduleService.getAll();
        System.out.println(1);
    }
}
