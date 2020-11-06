package com.offcn.service.impl;

import com.offcn.mapper.RoleSourcesMapper;
import com.offcn.mapper.SourcesMapper;
import com.offcn.pojo.DialogResult;
import com.offcn.pojo.RoleSources;
import com.offcn.pojo.Sources;
import com.offcn.service.SourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourcesServiceImpl implements SourcesService {
    @Autowired
    private SourcesMapper sourcesMapper;
    @Autowired
    private RoleSourcesMapper roleSourcesMapper;
    /**
     * 查询所有sources
     * @return
     */
    @Override
    public List<Sources> findAllSources() {
        List<Sources> list = sourcesMapper.findAllSources();
        return list;
    }

    @Override
    public DialogResult deleteSourceById(Integer id) {

        DialogResult dr = new DialogResult();
        try {
           List<RoleSources> rs = roleSourcesMapper.findSourcesById(id);
           if(rs != null && rs.size()>0){
               dr.setError("删除失败");
           }else {
                sourcesMapper.deleteSourcesById(id);
                dr.setMsg("删除成功");
           }
        } catch (Exception e) {
            e.printStackTrace();
            dr.setError("删除失败");
        }
        return dr;
    }

    @Override
    public Sources loadSourcesById(Integer id) {
        Sources sources = sourcesMapper.loadSourcesById(id);
        return sources;
    }

    @Override
    public List<Sources> findAllParentNodes() {
        List<Sources> sources = sourcesMapper.findAllParentNodes();
        return sources;
    }

    /**
     * 添加sources
     * @param sources
     * @return
     */
    @Override
    public DialogResult updateResources(Sources sources) {
        DialogResult result = new DialogResult();
        try {
            sourcesMapper.updateResources(sources);
            result.setMsg("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setError("修改失败");
        }

        return result;
    }

    @Override
    public DialogResult insertResources(Sources sources) {
        DialogResult result = new DialogResult();
        try {
            sourcesMapper.insertResources(sources);
            result.setMsg("增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("增加成功");
        }

        return result;
    }
}
