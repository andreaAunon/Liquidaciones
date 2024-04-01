package com.babel.liquidaciones.services;

import com.babel.liquidaciones.model.Cliente;
import com.babel.liquidaciones.repository.IClienteRepository;
import com.babel.liquidaciones.services.interfaces.ILoginService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements ILoginService {

    private Cliente clienteLogueado;
    private IClienteRepository clienteRepository;

    public LoginService(IClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public String login(String usuario, String password) {
        if (isUserPasswordCorrect(usuario, password)) {
            this.clienteLogueado = findByNombreAndPassword(usuario, password);
            return "Usuario encontrado";
        }
        return "Usuario o contraseña incorrectas";
    }

    @Override
    public Cliente getUsuarioLogueado() {
        return this.clienteLogueado;
    }

    @Override
    public Cliente findByNombreAndPassword(String nombre, String password) {
        Optional<Cliente> cliente = this.clienteRepository.findByNombreAndPassword(nombre, password);

        if(cliente.isPresent()){
            return cliente.get();
        }

        return null;
    }

    private boolean isUserPasswordCorrect(String usuario, String password) {
        return this.clienteRepository.findByNombreAndPassword(usuario, password) != null;
    }

}
