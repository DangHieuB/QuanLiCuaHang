package com.example.Assignment.service;

import com.example.Assignment.entity.NhanVien;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {

    List<NhanVien> getAll();

    List<NhanVien> searchNV(String ma);

    NhanVien getOneNV(UUID id);

    Boolean add(NhanVien kh);

    Boolean update(NhanVien kh);

    Boolean remove(NhanVien kh);
}
