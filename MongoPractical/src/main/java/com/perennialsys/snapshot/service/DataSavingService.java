package com.perennialsys.snapshot.service;

import com.perennialsys.snapshot.dao.DaoImpl;
import com.perennialsys.snapshot.model.IGenericVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSavingService implements DataService {

    @Autowired
    DaoImpl daoImpl;

    @Override
    public boolean saveData(List<IGenericVo> objectData, String key){
        return daoImpl.save(objectData,key);
    }

    @Override
    public boolean saveObjectData(IGenericVo iGenericVo,String key) {
        return daoImpl.saveObject(iGenericVo,key);
    }

    @Override
    public Integer getData(String key) {
        return (Integer) daoImpl.getData(key);
    }
}
