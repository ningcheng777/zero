package web.controller;

import common.model.Module;
import org.springframework.web.bind.annotation.RequestBody;
import service.module.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ningcheng
 * @date 2017/10/9
 */
@Controller
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody
    List<Module> getAll() {
        return moduleService.getAll();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody
    Module get(@RequestParam("id") long id) {
        return moduleService.get(id);
    }

    @RequestMapping(value = "/createOrUpdate", method = RequestMethod.POST)
    public @ResponseBody
    void createOrUpdate(@RequestBody Module module) {
        moduleService.createOrUpdate(module);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public @ResponseBody
    void remove(@RequestParam("id") long id) {
        moduleService.remove(id);
    }
}
