package com.example.Assignment.service.impl;

import com.example.Assignment.entity.NhanVien;
import com.example.Assignment.repository.NhanVienRepository;
import com.example.Assignment.service.NhanVienService;

import java.util.List;
import java.util.UUID;

public class NhanVienServiceImpl implements NhanVienService {
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.getAll();
    }

    @Override
    public List<NhanVien> searchNV(String ma) {
        return nhanVienRepository.searchNV(ma);
    }

    @Override
    public NhanVien getOneNV(UUID id) {
        return nhanVienRepository.getOneNv(id);
    }

    @Override
    public Boolean add(NhanVien kh) {
        return nhanVienRepository.add(kh);
    }

    @Override
    public Boolean update(NhanVien kh) {
        return nhanVienRepository.update(kh);
    }

    @Override
    public Boolean remove(NhanVien kh) {
        return nhanVienRepository.delete(kh);
    }
}
