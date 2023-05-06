package com.example.Assignment.service;

import com.example.Assignment.entity.SanPham;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    List<SanPham> getAll();

    SanPham getOneSP(UUID id);

    Boolean add(SanPham kh);

    Boolean update(SanPham kh);

    Boolean remove(SanPham kh);
}
