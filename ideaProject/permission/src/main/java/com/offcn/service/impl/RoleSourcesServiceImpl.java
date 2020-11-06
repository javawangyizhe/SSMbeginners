package com.offcn.service.impl;

import com.offcn.mapper.RoleSourcesMapper;
import com.offcn.pojo.RoleSources;
import com.offcn.service.RoleSourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleSourcesServiceImpl implements RoleSourcesService {
    @Autowired
    private RoleSourcesMapper roleSourcesMapper;
    @Override
    public List<RoleSources> findSourcesByRid(Integer id) {
        List<RoleSources> list = roleSourcesMapper.findSourcesByRid(id);
        return list;
    }

}
