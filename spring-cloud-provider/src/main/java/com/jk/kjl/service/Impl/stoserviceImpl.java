package com.jk.kjl.service.Impl;

import com.jk.kjl.entity.storerank;
import com.jk.kjl.mapper.storerankMapper;
import com.jk.kjl.service.stoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class stoserviceImpl implements stoservice {
    @Autowired
    private storerankMapper storerankMapper;

    @Override
    public List<storerank> sto() {

        return storerankMapper.find();
    }
}
