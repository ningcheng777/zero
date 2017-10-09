package com.ningcheng.zero.service.module;

import com.ningcheng.zero.common.model.Module;
import com.ningcheng.zero.dal.module.ModuleDO;

import java.util.List;

/**
 * @author ningcheng
 * @date 2017/10/9
 */
public interface ModuleService {

    Module get(long id);

    List<Module> getAll();
}
