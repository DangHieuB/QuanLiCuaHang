package com.example.Assignment.service.impl;

import com.example.Assignment.entity.DongSanPham;
import com.example.Assignment.repository.DongSanPhamRepository;
import com.example.Assignment.service.DongSanPhamService;

import java.util.List;
import java.util.UUID;

public class DongSanPhamServiceImpl implements DongSanPhamService {
    private DongSanPhamRepository dongSanPhamRepository = new DongSanPhamRepository();

    @Override
    public List<DongSanPham> getAll() {
        return dongSanPhamRepository.getAll();
    }

    @Override
    public DongSanPham getOneDSP(UUID id) {
        return dongSanPhamRepository.getOneDSP(id);
    }

    @Override
    public Boolean add(DongSanPham kh) {
        return dongSanPhamRepository.add(kh);
    }

    @Override
    public Boolean update(DongSanPham kh) {
        return dongSanPhamRepository.update(kh);
    }

    @Override
    public Boolean remove(DongSanPham kh) {
        return dongSanPhamRepository.delete(kh);
    }
}
