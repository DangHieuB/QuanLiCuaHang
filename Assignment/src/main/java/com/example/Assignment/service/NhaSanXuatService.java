package com.example.Assignment.service;

import com.example.Assignment.entity.NhaSanXuat;

import java.util.List;
import java.util.UUID;

public interface NhaSanXuatService {

    List<NhaSanXuat> getAll();

    NhaSanXuat getOneNSX(UUID id);

    Boolean add(NhaSanXuat kh);

    Boolean update(NhaSanXuat kh);

    Boolean remove(NhaSanXuat kh);
}
