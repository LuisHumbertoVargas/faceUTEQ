package uteq.face.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Carreras")
public class CarrerasModel implements Serializable {
    
    static final long serialVersionUID = 1L;
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarrera")
    private Long idCarrera;
    
    @Column(name = "carrera")
    private String carrera;
}
