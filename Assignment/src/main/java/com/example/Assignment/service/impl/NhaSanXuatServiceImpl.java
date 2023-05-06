package com.example.Assignment.service.impl;

import com.example.Assignment.entity.NhaSanXuat;
import com.example.Assignment.repository.NhaSanXuatRepository;
import com.example.Assignment.service.NhaSanXuatService;

import java.util.List;
import java.util.UUID;

public class NhaSanXuatServiceImpl implements NhaSanXuatService {
    private NhaSanXuatRepository nhaSanXuatRepository = new NhaSanXuatRepository();
    @Override
    public List<NhaSanXuat> getAll() {
        return nhaSanXuatRepository.getAll();
    }

    @Override
    public NhaSanXuat getOneNSX(UUID id) {
        return nhaSanXuatRepository.getOneNsx(id);
    }

    @Override
    public Boolean add(NhaSanXuat kh) {
        return nhaSanXuatRepository.add(kh);
    }

    @Override
    public Boolean update(NhaSanXuat kh) {
        return nhaSanXuatRepository.update(kh);
    }

    @Override
    public Boolean remove(NhaSanXuat kh) {
        return nhaSanXuatRepository.delete(kh);
    }
}
