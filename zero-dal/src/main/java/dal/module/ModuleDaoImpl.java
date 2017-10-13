package dal.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dal.base.MyBatisDaoImpl;
import org.springframework.stereotype.Repository;

@Repository("moduleDao")
public class ModuleDaoImpl extends MyBatisDaoImpl implements ModuleDao {

    @Override
    public List<ModuleDO> getAll() {
        return sqlSession.selectList("module.selectAll");
    }

    @Override
    public ModuleDO get(long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return sqlSession.selectOne("module.select", params);
    }
}