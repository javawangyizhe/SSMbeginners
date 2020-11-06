package com.offcn.mapper;


import com.offcn.pojo.Sources;

import java.util.List;

public interface SourcesMapper {
    List<Sources> findAllSources();

    void deleteSourcesById(Integer id);

    Sources loadSourcesById(Integer id);

    List<Sources> findAllParentNodes();

    void updateResources(Sources sources);

    void insertResources(Sources sources);
}