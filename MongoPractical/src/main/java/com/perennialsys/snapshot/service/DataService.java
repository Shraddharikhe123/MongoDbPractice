package com.perennialsys.snapshot.service;

import com.perennialsys.snapshot.model.IGenericVo;

import java.util.List;

public interface DataService {
    public boolean saveData(List<IGenericVo> objectData, String key);
    public boolean saveObjectData(IGenericVo iGenericVo,String key);
    public Integer getData(String key);
}
