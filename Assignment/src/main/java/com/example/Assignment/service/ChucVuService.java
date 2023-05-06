package com.example.Assignment.service;

import com.example.Assignment.entity.ChucVu;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {

    List<ChucVu> getAll();

    ChucVu getOneCV(UUID id);

    Boolean add(ChucVu kh);

    Boolean update(ChucVu kh);

    Boolean remove(ChucVu kh);
}
