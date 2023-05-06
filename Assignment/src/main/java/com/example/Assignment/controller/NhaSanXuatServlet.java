package com.example.Assignment.controller;

import com.example.Assignment.entity.NhaSanXuat;
import com.example.Assignment.service.NhaSanXuatService;
import com.example.Assignment.service.impl.NhaSanXuatServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhaSanXuatServlet", value = {
        "/nha-san-xuat/hien-thi",
        "/nha-san-xuat/detail",
        "/nha-san-xuat/remove",
        "/nha-san-xuat/view-update",
        "/nha-san-xuat/update",
        "/nha-san-xuat/add"
})
public class NhaSanXuatServlet extends HttpServlet {
    private NhaSanXuatService nhaSanXuatService = new NhaSanXuatServiceImpl();
    private List<NhaSanXuat> lists = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("remove")) {
            this.remove(request, response);
        } else {
            this.viewUpdate(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        } else {
            this.update(request, response);
        }
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhaSanXuat kh = nhaSanXuatService.getOneNSX(UUID.fromString(id));
        request.setAttribute("Detail", kh);
        request.getRequestDispatcher("/views/NhaSanXuat/update-nha-san-xuat.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        NhaSanXuat kh = nhaSanXuatService.getOneNSX(UUID.fromString(id));
        nhaSanXuatService.remove(kh);
        response.sendRedirect("/nha-san-xuat/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhaSanXuat kh = nhaSanXuatService.getOneNSX(UUID.fromString(id));
        request.setAttribute("Detail", kh);
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = nhaSanXuatService.getAll();
        request.setAttribute("listNSX", lists);
        request.getRequestDispatcher("/views/NhaSanXuat/nha-san-xuat.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("maNSX");
        String ten = request.getParameter("tenNSX");

        NhaSanXuat cv = NhaSanXuat.builder()
                .idNSX(UUID.fromString(id))
                .maNSX(ma)
                .tenNSX(ten)
                .build();
        nhaSanXuatService.update(cv);
        response.sendRedirect("/nha-san-xuat/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maNSX");
        String ten = request.getParameter("tenNSX");

        NhaSanXuat cv = NhaSanXuat.builder()
                .maNSX(ma)
                .tenNSX(ten)
                .build();
        nhaSanXuatService.add(cv);
        response.sendRedirect("/nha-san-xuat/hien-thi");
    }
}
