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
import uteq.face.dao.IUsuariosDao;
import uteq.face.model.UsuariosModel;

@RestController
@RequestMapping("/UsuariosRest")
public class UsuariosRestController {

    @Autowired
    private IUsuariosDao usuariosDao;

    @GetMapping
    public List<UsuariosModel> list() {
        return usuariosDao.findAll();
    }

    @GetMapping("/{id}")
    public UsuariosModel get(@PathVariable Long id) {
        return usuariosDao.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuariosModel> put(@PathVariable Long id, @RequestBody UsuariosModel usuario) {

        UsuariosModel usuarioActual = usuariosDao.findById(id).orElse(null);

        if (usuarioActual == null) {
            return new ResponseEntity<>(usuarioActual, HttpStatus.NOT_FOUND);
        }

        usuarioActual.setCorreo(usuario.getCorreo());
        usuarioActual.setPassword(usuario.getPassword());
        usuarioActual.setFoto(usuario.getFoto());
        usuarioActual.setRol(usuario.getRol());
        usuarioActual.setNombre(usuario.getNombre());
        usuarioActual.setApellido1(usuario.getApellido1());
        usuarioActual.setApellido2(usuario.getApellido2());
        usuarioActual.setEdad(usuario.getEdad());
        usuarioActual.setGustos(usuario.getGustos());
        usuarioActual.setFormacion(usuario.getFormacion());
        usuarioActual.setTrabajo(usuario.getTrabajo());
        usuarioActual.setIdCarrera(usuario.getIdCarrera());
        usuarioActual.setIdSentimental(usuario.getIdSentimental());
        usuarioActual.setIdEstado(usuario.getIdEstado());

        UsuariosModel usuarioActualizado = usuariosDao.save(usuarioActual);
        HttpStatus generatedStatus = HttpStatus.CREATED;

        return new ResponseEntity<>(usuarioActualizado, generatedStatus);
    }

    @PostMapping("/add")
    public ResponseEntity<UsuariosModel> post(@RequestBody UsuariosModel usuario) {

        UsuariosModel usuarioNuevo = usuariosDao.save(usuario);
        HttpStatus generatedStatus = HttpStatus.CREATED;

        return new ResponseEntity<>(usuarioNuevo, generatedStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        usuariosDao.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
