package com.ningcheng.zero.web.controller;

import com.ningcheng.zero.common.model.Module;
import com.ningcheng.zero.service.module.ModuleService;
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
@RequestMapping(value = "/module")
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
}
