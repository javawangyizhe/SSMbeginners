package com.offcn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.mapper.EmpRoleMapper;
import com.offcn.mapper.RoleMapper;
import com.offcn.mapper.RoleSourcesMapper;
import com.offcn.pojo.*;
import com.offcn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleSourcesMapper roleSourcesMapper;
    @Autowired
    private EmpRoleMapper empRoleMapper;

    /**
     * 增加角色
     * @param role
     * @param sourcesNode
     * @return
     */
    @Override
    public DialogResult insertRole(Role role, String sourcesNode) {
        DialogResult result = new DialogResult();
        try {
            roleMapper.insertRole(role);
            String[] split = sourcesNode.split(",");
            for (String s : split) {
                int sid = Integer.parseInt(s);
                RoleSources roleSources = new RoleSources();
                roleSources.setResourcesFk(sid);
                roleSources.setRoleFk(role.getRoleid());
                roleSourcesMapper.insertRoleSources(roleSources);
            }
            result.setMsg("增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("增加成功");
        }
        return result;
    }

    /**
     * 分页查询角色
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo findAllRolesWithPage(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Role> list = roleMapper.findAllRoles();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 根据id查询角色
     * @param id
     * @return
     */
    @Override
    public Role findRoleById(Integer id) {
        Role role = roleMapper.findRoleById(id);
        return role;
    }

    /**
     * 更新角色
     * @param sid
     * @param role
     */
    @Override
    public void updateRole(String sid,Role role) {
        roleMapper.updateRole(role);
        roleSourcesMapper.deleteSourcesByRid(role.getRoleid());
        String[] split = sid.split(",");
        for (String s : split) {
            int sourceid = Integer.parseInt(s);
            RoleSources roleSources = new RoleSources();
            roleSources.setRoleFk(role.getRoleid());
            roleSources.setResourcesFk(sourceid);
            roleSourcesMapper.insertRoleSources(roleSources);
        }

    }

    /**
     * 删除角色
     * @return
     */
    @Override
    public DialogResult deleteRoleById(Integer id) {
        DialogResult result = new DialogResult();
        try {
            //如果员工和角色的关联表有角色的数据，不能删除
            List<EmpRole> list = empRoleMapper.findRoleByRid(id);
            if(list.size() > 0){
                result.setError("角色已被使用，无法删除");
                return result;
            }
            //角色资源关联表
            roleSourcesMapper.deleteSourcesByRid(id);
            //删除角色表
            roleMapper.deleteRoleById(id);
            result.setMsg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setError("删除失败");
        }
        return result;
    }

    /**
     * 根据id删除多个角色
     */
    @Override
    public DialogResult deleteMutiRoles(String roles) {
        DialogResult result = new DialogResult();
        try {
            //截取字符串
            String[] role = roles.split(",");
            for (String s : role) {
                int sid = Integer.parseInt(s);
                //如果员工和角色的关联表有角色的数据，不能删除
                List<EmpRole> list = empRoleMapper.findRoleByRid(sid);
                if(list.size() > 0){
                    result.setError("角色已被使用，无法删除");
                    return result;
                }
                //角色资源关联表
                roleSourcesMapper.deleteSourcesByRid(sid);
                //删除角色表
                roleMapper.deleteRoleById(sid);
                result.setMsg("删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setError("删除失败");
        }
        return result;
    }

    /**
     * 查询全部角色
     * @return
     */
    @Override
    public List<Role> findAllRoles() {
        List<Role> allRoles = roleMapper.findAllRoles();
        return allRoles;
    }
}
