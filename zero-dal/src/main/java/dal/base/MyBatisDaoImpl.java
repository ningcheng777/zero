package dal.base;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBatisDaoImpl {

    @Autowired
    protected SqlSessionTemplate sqlSession;
}
