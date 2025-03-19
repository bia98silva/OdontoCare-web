package com.Fiap.OdontoCare.controller;

import com.Fiap.OdontoCare.entity.Consulta;
import com.Fiap.OdontoCare.service.ConsultaService;
import com.Fiap.OdontoCare.service.PacienteService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/gerenciamento")
public class GerenciamentoController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public String exibirGerenciamento(Model model) {
        model.addAttribute("pacientes", pacienteService.findAll());

        List<Consulta> consultas = consultaService.findAll();
        model.addAttribute("consultas", consultas);

        return "gerenciamento";
    }
}
