package pe.edu.cibertec.proyecto_backend_jeremias.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyecto_backend_jeremias.dto.LoginRequestDTO;
import pe.edu.cibertec.proyecto_backend_jeremias.service.UsuarioService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public List<LoginRequestDTO> listarUsuarios() throws IOException {
        List<LoginRequestDTO> listaUsuarios = new ArrayList<>();
        Resource resource = resourceLoader.getResource("classpath:usuarios.txt");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("Leyendo línea: " + linea); // Imprime cada línea para depurar
                String[] datos = linea.split(";");
                if (datos.length == 4) {
                    LoginRequestDTO usuario = new LoginRequestDTO(datos[0], datos[1], datos[2], datos[3]);
                    listaUsuarios.add(usuario);
                }
            }
        } catch (IOException e) {
            throw new IOException("Error al leer el archivo usuarios.txt", e);
        }

        return listaUsuarios;
    }
}
