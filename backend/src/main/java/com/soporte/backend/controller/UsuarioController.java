package com.soporte.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soporte.backend.model.Usuario;

import com.soporte.backend.service.UsuarioService;
@RestController
@RequestMapping("/usuarios")
@CrossOrigin

public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping("/usuario")
    public List<Usuario> listar() {
        return usuarioService.listar();
    }
    
    @PostMapping("/usuario")
    public Usuario guardar(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        Usuario user = usuarioService.buscarPorEmail(usuario.getEmail())
                .orElse(null);

        if (user != null) {
            return "Login exitoso";
        } else {
            return "Credenciales incorrectas";
        }
    }
}