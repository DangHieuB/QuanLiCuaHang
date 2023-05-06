package com.example.Assignment.service;

import com.example.Assignment.entity.ChiTietSanPham;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {

    List<ChiTietSanPham> getAll();

    ChiTietSanPham getOneCTSP(UUID id);

    Boolean add(ChiTietSanPham kh);

    Boolean update(ChiTietSanPham kh);

    Boolean remove(ChiTietSanPham kh);
}
