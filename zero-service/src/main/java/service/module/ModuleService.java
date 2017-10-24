package service.module;

import common.model.Module;

import java.util.List;

/**
 * @author ningcheng
 * @date 2017/10/9
 */
public interface ModuleService {

    Module get(long id);

    List<Module> getAll();

    void createOrUpdate(Module module);

    void remove(long id);
}
