package dal.module;


import java.util.List;

public interface ModuleDao {

  List<ModuleDO> getAll();

  ModuleDO get(long id);
}