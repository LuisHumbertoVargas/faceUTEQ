package uteq.face.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Usuarios")
public class UsuariosModel implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuarios")
    private Long idUsuarios;

    @Column(name = "correo")
    private String correo;

    @Column(name = "password")
    private String password;

    @Column(name = "foto")
    private String foto;

    @Column(name = "rol")
    private String rol;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido1")
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "gustos")
    private String gustos;

    @Column(name = "formacion")
    private String formacion;

    @Column(name = "trabajo")
    private String trabajo;

    /*
    @Column(name = "lastTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastTime;
    
    @PrePersist
    public void prePersist() {
        lastTime = new Date();
    }
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "idCarrera")
    private CarrerasModel idCarrera;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idSentimental")
    private SentimentalesModel idSentimental;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idEstado")
    private EstadosModel idEstado;

}
