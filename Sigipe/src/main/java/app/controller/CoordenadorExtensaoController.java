package app.controller;

import app.entity.CoordenadorExtensao;
import app.service.CoordenadorExtensaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coordenadorExtensao")
@Validated
public class CoordenadorExtensaoController {

    @Autowired
    CoordenadorExtensaoService coordenadorExtensaoService;

    @PostMapping("/save")
    public ResponseEntity<String> save (@Valid @RequestBody CoordenadorExtensao coordenadorExtensao){
        try{

            String save = this.coordenadorExtensaoService.save(coordenadorExtensao);
            return new ResponseEntity<>(save,HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @Valid @RequestBody CoordenadorExtensao coordenadorExtensao){

        try{

            String update = this.coordenadorExtensaoService.update(id,coordenadorExtensao);
            return new ResponseEntity<>(update,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<CoordenadorExtensao> findById(@PathVariable long id){

        try {

            CoordenadorExtensao coordenadorExtensao = this.coordenadorExtensaoService.findById(id);
            return new ResponseEntity<>(coordenadorExtensao,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<CoordenadorExtensao>> findAll(){

        try {

            List<CoordenadorExtensao> list = this.coordenadorExtensaoService.findAll();
            return new ResponseEntity<>(list,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){

        try {

            String delete = this.coordenadorExtensaoService.delete(id);
            return new ResponseEntity<>(delete,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
