package com.ningcheng.zero.service.module.impl;

import com.ningcheng.zero.common.model.Module;
import com.ningcheng.zero.dal.module.ModuleDO;
import com.ningcheng.zero.dal.module.ModuleDao;
import com.ningcheng.zero.service.module.ModuleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ningcheng
 * @date 2017/10/9
 */
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleDao moduleDao;

    @Override
    public Module get(long id) {
        Module ret = new Module();
        ModuleDO moduleDO = moduleDao.get(id);
        if (moduleDO == null) {
            return null;
        }
        BeanUtils.copyProperties(moduleDO, ret);
        return ret;
    }

    @Override
    public List<Module> getAll() {
        List<Module> ret = new ArrayList<Module>();
        List<ModuleDO> queryList = moduleDao.getAll();
        if (CollectionUtils.isEmpty(queryList)) {
            return ret;
        }
        for (ModuleDO moduleDO : queryList) {
            if (moduleDO != null) {
                Module module = new Module();
                BeanUtils.copyProperties(moduleDO, module);
                ret.add(module);
            }
        }
        return ret;
    }
}
