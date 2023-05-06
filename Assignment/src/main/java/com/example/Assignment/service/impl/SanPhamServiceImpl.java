package com.example.Assignment.service.impl;

import com.example.Assignment.entity.SanPham;
import com.example.Assignment.repository.SanPhamRepository;
import com.example.Assignment.service.SanPhamService;

import java.util.List;
import java.util.UUID;

public class SanPhamServiceImpl implements SanPhamService {
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    @Override
    public SanPham getOneSP(UUID id) {
        return sanPhamRepository.getOneSP(id);
    }

    @Override
    public Boolean add(SanPham kh) {
        return sanPhamRepository.add(kh);
    }

    @Override
    public Boolean update(SanPham kh) {
        return sanPhamRepository.update(kh);
    }

    @Override
    public Boolean remove(SanPham kh) {
        return sanPhamRepository.delete(kh);
    }
}
