package uteq.face.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uteq.face.model.EstadosModel;

@Repository
public interface IEstadosDao extends JpaRepository<EstadosModel, Long>{
    
}
