package com.offcn.controller;

import com.github.pagehelper.PageInfo;
import com.offcn.pojo.DialogResult;
import com.offcn.pojo.Role;
import com.offcn.pojo.RoleSources;
import com.offcn.service.RoleService;
import com.offcn.service.RoleSourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleSourcesService roleSourcesService;

    @RequestMapping("insertRole")
    @ResponseBody
    public DialogResult insertRole(Role role,String sourcesNode){
        DialogResult result = roleService.insertRole(role,sourcesNode);
        return  result;
    }

    @RequestMapping("findAllRoles")
    public String findAllRolesWithPage(@RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum,
                               @RequestParam(name = "pageSize",defaultValue = "10")Integer pageSize,
                               Model model){
        PageInfo pageInfo = roleService.findAllRolesWithPage(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "forward:list-role.jsp";
    }

    /**
     * 通过id查找role信息
     */
    @RequestMapping("loadRoleInfo")
    @ResponseBody
    public Map<String,Object> loadRoleInfo(Integer roleid){
        Map map = new HashMap();
        Role role = roleService.findRoleById(roleid);
        map.put("role",role);
        List<RoleSources> roleSources = roleSourcesService.findSourcesByRid(roleid);
        map.put("roleSources",roleSources);
        return map;
    }

    /**
     * 修改role信息
     */
    @RequestMapping("updateRole")
    public String updateRole(String sid,Role role){
        roleService.updateRole(sid,role);
        return "forward:findAllRoles";
    }

    /**
     * 删除角色信息
     */
    @RequestMapping("deleteRoleById")
    @ResponseBody
    public DialogResult deleteRoleById(Integer id){
        DialogResult dialogResult = roleService.deleteRoleById(id);
        return dialogResult;
    }
    /**
     * 通过多个id删除角色信息
     */
    @RequestMapping("deleteMutiRoles")
    @ResponseBody
    public DialogResult deleteMutiRoles(String roles){
        DialogResult dialogResult = roleService.deleteMutiRoles(roles);
        return dialogResult;
    }
}
