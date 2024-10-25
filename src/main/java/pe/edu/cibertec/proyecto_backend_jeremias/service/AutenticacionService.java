package pe.edu.cibertec.proyecto_backend_jeremias.service;

import pe.edu.cibertec.proyecto_backend_jeremias.dto.LoginRequestDTO;

public interface AutenticacionService {

    String[]validarUsuario(LoginRequestDTO loginRequestDTO);
}
