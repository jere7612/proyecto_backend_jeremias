package pe.edu.cibertec.proyecto_backend_jeremias.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyecto_backend_jeremias.dto.LoginRequestDTO;
import pe.edu.cibertec.proyecto_backend_jeremias.service.AutenticacionService;

import java.io.*;

@Service
public class AutenticacionServiceImpl implements AutenticacionService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] validarUsuario(LoginRequestDTO loginRequestDTO){

        String[] datosUsuario = null;

        Resource resource = resourceLoader.getResource("classpath:usuarios.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos= linea.split(";");
                //verificar si codigo de alumno y contrasena
                if (loginRequestDTO.codigoAlumno().equals(datos[0])&&
                        loginRequestDTO.password().equals(datos[1])){

                    // Si coincide, almacenar nombre y correo (o apellidos)
                    datosUsuario=new String[2];
                    datosUsuario[0] = datos [3];
                    break;

                }
            }

        } catch (IOException e){

            datosUsuario = null;
           // throw new IOException(e);

        }


        return datosUsuario;
    }


}