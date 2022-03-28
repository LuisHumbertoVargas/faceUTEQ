package uteq.face.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import uteq.face.dao.IEstadosDao;
import uteq.face.model.EstadosModel;

@RestController
@RequestMapping("/EstadosRest")
public class EstadosRestController {

    @Autowired
    private IEstadosDao estadosDao;

    @GetMapping
    public List<EstadosModel> list() {
        return estadosDao.findAll();
    }

    @GetMapping("/{id}")
    public EstadosModel get(@PathVariable Long id) {
        return estadosDao.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadosModel> put(@PathVariable Long id, @RequestBody EstadosModel estado) {

        EstadosModel estadoActual = estadosDao.findById(id).orElse(null);

        if (estadoActual == null) {
            return new ResponseEntity<>(estadoActual, HttpStatus.NOT_FOUND);
        }

        estadoActual.setEstado(estado.getEstado());

        EstadosModel estadoActualizado = estadosDao.save(estadoActual);
        HttpStatus generatedStatus = HttpStatus.CREATED;

        return new ResponseEntity<>(estadoActualizado, generatedStatus);
    }

    @PostMapping
    public ResponseEntity<EstadosModel> post(@RequestBody EstadosModel estado) {
        return new ResponseEntity<>(estadosDao.save(estado), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        estadosDao.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
