package com.example.Assignment.service;

import com.example.Assignment.entity.MauSac;

import java.util.List;
import java.util.UUID;

public interface MauSacService {

    List<MauSac> getAll();

    MauSac getOneMS(UUID id);

    Boolean add(MauSac kh);

    Boolean update(MauSac kh);

    Boolean remove(MauSac kh);
}
