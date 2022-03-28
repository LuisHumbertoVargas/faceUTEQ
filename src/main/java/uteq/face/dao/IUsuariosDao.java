package uteq.face.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uteq.face.model.UsuariosModel;

@Repository
public interface IUsuariosDao extends JpaRepository<UsuariosModel, Long>{
    UsuariosModel findByCorreo(String correo);
}
 