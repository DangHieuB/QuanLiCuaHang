package com.example.Assignment.controller;

import com.example.Assignment.entity.MauSac;
import com.example.Assignment.service.MauSacService;
import com.example.Assignment.service.impl.MauSacServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "MauSacServlet", value = {
        "/mau-sac/hien-thi",
        "/mau-sac/detail",
        "/mau-sac/remove",
        "/mau-sac/view-update",
        "/mau-sac/update",
        "/mau-sac/add"
})
public class MauSacServlet extends HttpServlet {
    private MauSacService mauSacService = new MauSacServiceImpl();
    private List<MauSac> lists = new ArrayList<>();

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
        MauSac ms = mauSacService.getOneMS(UUID.fromString(id));
        request.setAttribute("Detail", ms);
        request.getRequestDispatcher("/views/MauSac/update-mau-sac.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        MauSac ms = mauSacService.getOneMS(UUID.fromString(id));
        mauSacService.remove(ms);
        response.sendRedirect("/mau-sac/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MauSac ms = mauSacService.getOneMS(UUID.fromString(id));
        request.setAttribute("Detail", ms);
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = mauSacService.getAll();
        request.setAttribute("listMS", lists);
        request.getRequestDispatcher("/views/MauSac/mau-sac.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("maMauSac");
        String ten = request.getParameter("tenMauSac");

        MauSac cv = MauSac.builder()
                .idMS(UUID.fromString(id))
                .maMauSac(ma)
                .tenMauSac(ten)
                .build();
        mauSacService.update(cv);
        response.sendRedirect("/mau-sac/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maMauSac");
        String ten = request.getParameter("tenMauSac");

        MauSac cv = MauSac.builder()
                .maMauSac(ma)
                .tenMauSac(ten)
                .build();
        mauSacService.add(cv);
        response.sendRedirect("/mau-sac/hien-thi");
    }
}
