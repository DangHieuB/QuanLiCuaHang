package com.example.Assignment.service.impl;

import com.example.Assignment.entity.ChiTietSanPham;
import com.example.Assignment.repository.ChiTietSanPhamRepository;
import com.example.Assignment.service.ChiTietSanPhamService;

import java.util.List;
import java.util.UUID;

public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    private ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();

    @Override
    public List<ChiTietSanPham> getAll() {
        return chiTietSanPhamRepository.getAll();
    }

    @Override
    public ChiTietSanPham getOneCTSP(UUID id) {
        return chiTietSanPhamRepository.getOneCTTSP(id);
    }

    @Override
    public Boolean add(ChiTietSanPham kh) {
        return chiTietSanPhamRepository.add(kh);
    }

    @Override
    public Boolean update(ChiTietSanPham kh) {
        return chiTietSanPhamRepository.update(kh);
    }

    @Override
    public Boolean remove(ChiTietSanPham kh) {
        return chiTietSanPhamRepository.delete(kh);
    }
}
