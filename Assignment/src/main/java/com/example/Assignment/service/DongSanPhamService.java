package com.example.Assignment.service;

import com.example.Assignment.entity.DongSanPham;

import java.util.List;
import java.util.UUID;

public interface DongSanPhamService {

    List<DongSanPham> getAll();

    DongSanPham getOneDSP(UUID id);

    Boolean add(DongSanPham kh);

    Boolean update(DongSanPham kh);

    Boolean remove(DongSanPham kh);
}
