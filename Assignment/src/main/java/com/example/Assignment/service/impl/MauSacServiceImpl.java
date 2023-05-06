package com.example.Assignment.service.impl;

import com.example.Assignment.entity.MauSac;
import com.example.Assignment.repository.MauSacRepository;
import com.example.Assignment.service.MauSacService;

import java.util.List;
import java.util.UUID;

public class MauSacServiceImpl implements MauSacService {
    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.getAll();
    }

    @Override
    public MauSac getOneMS(UUID id) {
        return mauSacRepository.getOneMS(id);
    }

    @Override
    public Boolean add(MauSac kh) {
        return mauSacRepository.add(kh);
    }

    @Override
    public Boolean update(MauSac kh) {
        return mauSacRepository.update(kh);
    }

    @Override
    public Boolean remove(MauSac kh) {
        return mauSacRepository.delete(kh);
    }
}
