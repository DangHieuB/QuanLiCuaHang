package com.example.Assignment.service;

import com.example.Assignment.entity.KhachHang;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {

    List<KhachHang> getAll();

    List<KhachHang> searchKH(String ma);

    KhachHang getOneKH(UUID id);

    Boolean add(KhachHang kh);

    Boolean update(KhachHang kh);

    Boolean remove(KhachHang kh);
}
