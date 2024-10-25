package pe.edu.cibertec.proyecto_backend_jeremias.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyecto_backend_jeremias.dto.LoginRequestDTO;
import pe.edu.cibertec.proyecto_backend_jeremias.dto.LoginResponseDTO;
import pe.edu.cibertec.proyecto_backend_jeremias.service.AutenticacionService;
import pe.edu.cibertec.proyecto_backend_jeremias.service.UsuarioService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    AutenticacionService autenticacionService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
        try {

            Thread.sleep(5000);
            String[] datosUsuario = autenticacionService.validarUsuario(loginRequestDTO);
            System.out.println("Resultado: " + Arrays.toString(datosUsuario));
            if (datosUsuario == null) {
                return new LoginResponseDTO("01", "Error: Usuario no entrado", "", "");

            }
            return new LoginResponseDTO("00", "", datosUsuario[0], datosUsuario[1]);

        } catch (Exception e) {
            return new LoginResponseDTO("99", "Error: Ocurrio un problema", "", "");


        }
    }

    @GetMapping("/listar-usuarios")
    public List<LoginRequestDTO> listarUsuarios() {
        try {
            return usuarioService.listarUsuarios();
        } catch (IOException e) {
            throw new RuntimeException("Error al listar usuarios", e);
        }
    }


}