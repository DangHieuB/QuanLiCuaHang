package com.example.Assignment.service.impl;

import com.example.Assignment.entity.ChucVu;
import com.example.Assignment.repository.ChucVuRepository;
import com.example.Assignment.service.ChucVuService;

import java.util.List;
import java.util.UUID;

public class ChucVuServiceImpl implements ChucVuService {
    private ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.getAll();
    }

    @Override
    public ChucVu getOneCV(UUID id) {
        return chucVuRepository.getOneCV(id);
    }

    @Override
    public Boolean add(ChucVu kh) {
        return chucVuRepository.add(kh);
    }

    @Override
    public Boolean update(ChucVu kh) {
        return chucVuRepository.update(kh);
    }

    @Override
    public Boolean remove(ChucVu kh) {
        return chucVuRepository.delete(kh);
    }
}
