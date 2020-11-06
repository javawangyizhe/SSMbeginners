package com.offcn.service;

import com.offcn.pojo.DialogResult;
import com.offcn.pojo.Sources;

import java.util.List;

public interface SourcesService {
    /**
     * 查询所有sources
     * @return
     */
    List<Sources> findAllSources();

    DialogResult deleteSourceById(Integer id);

    Sources loadSourcesById(Integer id);

    List<Sources> findAllParentNodes();

    DialogResult updateResources(Sources sources);

    DialogResult insertResources(Sources sources);
}
