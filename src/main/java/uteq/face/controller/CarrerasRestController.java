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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import uteq.face.dao.ICarrerasDao;
import uteq.face.model.CarrerasModel;

@RestController
@RequestMapping("/CarrerasRest")
public class CarrerasRestController {

    @Autowired
    private ICarrerasDao carrerasDao;

    @GetMapping
    public List<CarrerasModel> list() {
        return carrerasDao.findAll();
    }

    @GetMapping("/{id}")
    public CarrerasModel get(@PathVariable Long id) {
        return carrerasDao.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarrerasModel> put(@PathVariable Long id, @RequestBody CarrerasModel carrera) {

        CarrerasModel carreraActual = carrerasDao.findById(id).orElse(null);

        if (carreraActual == null) {
            return new ResponseEntity<>(carreraActual, HttpStatus.NOT_FOUND);
        }

        carreraActual.setCarrera(carrera.getCarrera());

        CarrerasModel carreraActualizada = carrerasDao.save(carreraActual);
        HttpStatus generatedStatus = HttpStatus.CREATED;

        return new ResponseEntity<>(carreraActualizada, generatedStatus);
    }

    @PostMapping
    public ResponseEntity<CarrerasModel> post(@RequestBody CarrerasModel carrera) {
        return new ResponseEntity<>(carrerasDao.save(carrera), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        carrerasDao.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
