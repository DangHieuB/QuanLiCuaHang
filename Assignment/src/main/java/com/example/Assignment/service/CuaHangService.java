package com.example.Assignment.service;

import com.example.Assignment.entity.CuaHang;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {

    List<CuaHang> getAll();

    CuaHang getOneCH(UUID id);

    Boolean add(CuaHang kh);

    Boolean update(CuaHang kh);

    Boolean remove(CuaHang kh);
}
