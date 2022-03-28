package uteq.face.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uteq.face.model.CarrerasModel;

@Repository
public interface ICarrerasDao extends JpaRepository<CarrerasModel, Long> {
    
}
