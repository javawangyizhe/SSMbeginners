package com.offcn.controller;

import com.offcn.pojo.DialogResult;
import com.offcn.pojo.Sources;
import com.offcn.service.SourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SourcesController {

    @Autowired
    private SourcesService sourcesService;

    @RequestMapping("findAllSources")
    @ResponseBody
    public List<Sources> findAllSources(){
        List<Sources> sources = sourcesService.findAllSources();
        return sources;
    }

    @RequestMapping("deleteSourceById")
    @ResponseBody
    public DialogResult findAllSources(Integer id){

        DialogResult dia = sourcesService.deleteSourceById(id);
        return dia;
    }

    @RequestMapping("loadSourcesById")
    public String loadSourcesById(Integer id, Model model){
        Sources sources =sourcesService.loadSourcesById(id);
        model.addAttribute("sources",sources);
        return "forward:update-resources.jsp";
    }

    @RequestMapping("findAllParentNodes")
    @ResponseBody
    public List<Sources> findAllParentNodes(){
        List<Sources> sources = sourcesService.findAllParentNodes();
        return sources;
    }

    @RequestMapping("saveResources")
    @ResponseBody
    public DialogResult saveResources(Sources sources){
        DialogResult dialogResult =sourcesService.updateResources(sources);
        return dialogResult;
    }

    @RequestMapping("insertResources")
    @ResponseBody
    public DialogResult insertResources(Sources sources){
        System.out.println(sources);
        DialogResult dialogResult =sourcesService.insertResources(sources);
        return dialogResult;
    }
}
