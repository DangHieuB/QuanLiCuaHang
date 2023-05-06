package com.example.Assignment.controller;

import com.example.Assignment.entity.ChiTietSanPham;
import com.example.Assignment.entity.DongSanPham;
import com.example.Assignment.entity.MauSac;
import com.example.Assignment.entity.NhaSanXuat;
import com.example.Assignment.entity.SanPham;
import com.example.Assignment.service.ChiTietSanPhamService;
import com.example.Assignment.service.DongSanPhamService;
import com.example.Assignment.service.MauSacService;
import com.example.Assignment.service.NhaSanXuatService;
import com.example.Assignment.service.SanPhamService;
import com.example.Assignment.service.impl.ChiTietSanPhamServiceImpl;
import com.example.Assignment.service.impl.DongSanPhamServiceImpl;
import com.example.Assignment.service.impl.MauSacServiceImpl;
import com.example.Assignment.service.impl.NhaSanXuatServiceImpl;
import com.example.Assignment.service.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChiTietSanPhamServlet", value = {
        "/chi-tiet-san-pham/hien-thi",
        "/chi-tiet-san-pham/detail",
        "/chi-tiet-san-pham/remove",
        "/chi-tiet-san-pham/view-update",
        "/chi-tiet-san-pham/update",
        "/chi-tiet-san-pham/add"
})
public class ChiTietSanPhamServlet extends HttpServlet {
    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    private DongSanPhamService dongSanPhamService = new DongSanPhamServiceImpl();
    private MauSacService mauSacService = new MauSacServiceImpl();
    private NhaSanXuatService nhaSanXuatService = new NhaSanXuatServiceImpl();
    private ChiTietSanPhamService ctspService = new ChiTietSanPhamServiceImpl();
    private List<ChiTietSanPham> lists = new ArrayList<>();

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
        List<SanPham> listSP = sanPhamService.getAll();
        request.setAttribute("listSP", listSP);

        List<MauSac> listMS = mauSacService.getAll();
        request.setAttribute("listMS", listMS);

        List<DongSanPham> listDSP = dongSanPhamService.getAll();
        request.setAttribute("listDSP", listDSP);

        List<NhaSanXuat> listNhaSanXuats = nhaSanXuatService.getAll();
        request.setAttribute("listNSX", listNhaSanXuats);

        String id = request.getParameter("id");
        ChiTietSanPham ctsp = ctspService.getOneCTSP(UUID.fromString(id));
        request.setAttribute("Detail", ctsp);
        request.getRequestDispatcher("/views/ChiTietSanPham/update-chi-tiet-san-pham.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        ChiTietSanPham ctsp = ctspService.getOneCTSP(UUID.fromString(id));
        ctspService.remove(ctsp);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<SanPham> listSP = sanPhamService.getAll();
        request.setAttribute("listSP", listSP);

        List<MauSac> listMS = mauSacService.getAll();
        request.setAttribute("listMS", listMS);

        List<DongSanPham> listDSP = dongSanPhamService.getAll();
        request.setAttribute("listDSP", listDSP);

        List<NhaSanXuat> listNhaSanXuats = nhaSanXuatService.getAll();
        request.setAttribute("listNSX", listNhaSanXuats);

        String id = request.getParameter("id");
        ChiTietSanPham ctsp = ctspService.getOneCTSP(UUID.fromString(id));
        request.setAttribute("Detail", ctsp);
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SanPham> listSP = sanPhamService.getAll();
        request.setAttribute("listSP", listSP);

        List<MauSac> listMS = mauSacService.getAll();
        request.setAttribute("listMS", listMS);

        List<DongSanPham> listDSP = dongSanPhamService.getAll();
        request.setAttribute("listDSP", listDSP);

        List<NhaSanXuat> listNhaSanXuats = nhaSanXuatService.getAll();
        request.setAttribute("listNSX", listNhaSanXuats);

        lists = ctspService.getAll();
        request.setAttribute("listCTSP", lists);
        request.getRequestDispatcher("/views/ChiTietSanPham/chi-tiet-san-pham.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String giaBan = request.getParameter("giaBan");
        String giaNhap = request.getParameter("giaNhap");
        String moTa = request.getParameter("moTa");
        String namBH = request.getParameter("namBH");
        String soLuongTon = request.getParameter("soLuongTon");
        SanPham sp = sanPhamService.getOneSP(UUID.fromString(request.getParameter("sanPham")));
        MauSac ms = mauSacService.getOneMS(UUID.fromString(request.getParameter("mauSac")));
        DongSanPham dsp = dongSanPhamService.getOneDSP(UUID.fromString(request.getParameter("DSP")));
        NhaSanXuat nhaSanXuat = nhaSanXuatService.getOneNSX(UUID.fromString(request.getParameter("NSX")));

        ChiTietSanPham ctsp = ChiTietSanPham.builder()
                .id(UUID.fromString(id))
                .giaBan(Float.parseFloat(giaBan))
                .giaNhap(Float.parseFloat(giaNhap))
                .moTa(moTa)
                .namBH(Integer.parseInt(namBH))
                .soLuongTon(Integer.parseInt(soLuongTon))
                .sanPham(sp)
                .mauSac(ms)
                .dongSP(dsp)
                .nSX(nhaSanXuat)
                .build();
        ctspService.update(ctsp);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String giaBan = request.getParameter("giaBan");
        String giaNhap = request.getParameter("giaNhap");
        String moTa = request.getParameter("moTa");
        String namBH = request.getParameter("namBH");
        String soLuongTon = request.getParameter("soLuongTon");
        SanPham sp = sanPhamService.getOneSP(UUID.fromString(request.getParameter("sanPham")));
        MauSac ms = mauSacService.getOneMS(UUID.fromString(request.getParameter("mauSac")));
        DongSanPham dsp = dongSanPhamService.getOneDSP(UUID.fromString(request.getParameter("DSP")));
        NhaSanXuat nhaSanXuat = nhaSanXuatService.getOneNSX(UUID.fromString(request.getParameter("NSX")));

        ChiTietSanPham ctsp = ChiTietSanPham.builder()
                .giaBan(Float.parseFloat(giaBan))
                .giaNhap(Float.parseFloat(giaNhap))
                .moTa(moTa)
                .namBH(Integer.parseInt(namBH))
                .soLuongTon(Integer.parseInt(soLuongTon))
                .sanPham(sp)
                .mauSac(ms)
                .dongSP(dsp)
                .nSX(nhaSanXuat)
                .build();
        ctspService.add(ctsp);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");
    }
}
