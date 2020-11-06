package com.offcn.service;

import com.offcn.pojo.RoleSources;

import java.util.List;

public interface RoleSourcesService {
    List<RoleSources> findSourcesByRid(Integer id);

}
