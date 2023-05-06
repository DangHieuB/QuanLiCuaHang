package com.example.Assignment.service.impl;

import com.example.Assignment.entity.CuaHang;
import com.example.Assignment.repository.CuaHangRepository;
import com.example.Assignment.service.CuaHangService;

import java.util.List;
import java.util.UUID;

public class CuaHangServiceImpl implements CuaHangService {
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    public List<CuaHang> getAll() {
        return cuaHangRepository.getAll();
    }

    @Override
    public CuaHang getOneCH(UUID id) {
        return cuaHangRepository.getOneCH(id);
    }

    @Override
    public Boolean add(CuaHang kh) {
        return cuaHangRepository.add(kh);
    }

    @Override
    public Boolean update(CuaHang kh) {
        return cuaHangRepository.update(kh);
    }

    @Override
    public Boolean remove(CuaHang kh) {
        return cuaHangRepository.delete(kh);
    }
}
