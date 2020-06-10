package com.perennialsys.snapshot.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perennialsys.snapshot.model.IGenericVo;

import java.util.List;

public interface Dao {
    public boolean save(List<IGenericVo> objectData, String key) throws JsonProcessingException;

    public boolean saveObject(IGenericVo iGenericVo,String key);

    public Object getData(String key);
}
