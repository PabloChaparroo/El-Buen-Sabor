package com.project.El_Buen_Sabor.services.UsuarioService;

import com.project.El_Buen_Sabor.repositories.BaseRepository;
import com.project.El_Buen_Sabor.repositories.UsuarioRepository;
import com.project.El_Buen_Sabor.services.BaseService.BaseServiceImpl;
import com.project.El_Buen_Sabor.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository) {
        super(baseRepository);
    }


    @Override
    public List<Usuario> search(String filtro) throws Exception {
        try {
            List<Usuario> usuarios = usuarioRepository.search(filtro);
            return usuarios;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Usuario> search(String filtro, Pageable pageable) throws Exception {
        try {

            Page<Usuario> usuarios = usuarioRepository.search(filtro, pageable);
            return usuarios;
        }catch (Exception e){
            throw  new Exception(e.getMessage());

        }
    }
}
