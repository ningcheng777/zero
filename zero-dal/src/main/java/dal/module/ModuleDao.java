package dal.module;


import java.util.List;

public interface ModuleDao {

    List<ModuleDO> getAll();

    ModuleDO get(long id);

    void insertOrUpdate(ModuleDO moduleDO);

    void delete(long id);
}