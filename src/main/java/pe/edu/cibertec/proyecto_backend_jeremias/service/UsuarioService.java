package pe.edu.cibertec.proyecto_backend_jeremias.service;

import pe.edu.cibertec.proyecto_backend_jeremias.dto.LoginRequestDTO;

import java.io.IOException;
import java.util.List;

public interface UsuarioService {
    List<LoginRequestDTO> listarUsuarios() throws IOException;
}
