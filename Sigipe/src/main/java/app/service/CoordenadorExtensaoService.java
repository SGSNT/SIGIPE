package app.service;

import app.entity.CoordenadorExtensao;
import app.repository.CoordenadorExtensaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordenadorExtensaoService {

    @Autowired
    CoordenadorExtensaoRepository coordenadorExtensaoRepository;

    public String save(CoordenadorExtensao coordenadorExtensao){

        this.coordenadorExtensaoRepository.save(coordenadorExtensao);
        return "Salvo com sucesso";
    }

    public String update(long id, CoordenadorExtensao coordenadorExtensao){

        coordenadorExtensao.setId(id);
        this.coordenadorExtensaoRepository.save(coordenadorExtensao);

        return "Alterado com sucesso";
    }

    public List<CoordenadorExtensao> findAll(){
        return this.coordenadorExtensaoRepository.findAll();
    }

    public CoordenadorExtensao findById(long id){
        CoordenadorExtensao coordenadorExtensao = this.coordenadorExtensaoRepository.findById(id).get();
        return coordenadorExtensao;
    }

    public String delete(long id){
        this.coordenadorExtensaoRepository.deleteById(id);
        return "Coordenador Extensão excluido!";
    }
}
