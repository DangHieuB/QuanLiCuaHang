package com.example.Assignment.service.impl;

import com.example.Assignment.entity.KhachHang;
import com.example.Assignment.repository.KhachHangRepository;
import com.example.Assignment.service.KhachHangService;

import java.util.List;
import java.util.UUID;

public class KhachHangServiceImpl implements KhachHangService {
    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.getAll();
    }

    @Override
    public List<KhachHang> searchKH(String ma) {
        return khachHangRepository.searchKH(ma);
    }

    @Override
    public KhachHang getOneKH(UUID id) {
        return khachHangRepository.getOneKH(id);
    }

    @Override
    public Boolean add(KhachHang kh) {
        return khachHangRepository.add(kh);
    }

    @Override
    public Boolean update(KhachHang kh) {
        return khachHangRepository.update(kh);
    }

    @Override
    public Boolean remove(KhachHang kh) {
        return khachHangRepository.delete(kh);
    }
}
