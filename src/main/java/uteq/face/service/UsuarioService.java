package uteq.face.service;
  
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uteq.face.dao.IUsuariosDao;
import uteq.face.model.UsuariosModel;

@Service("userDetailsService")
@Slf4j
public class UsuarioService implements UserDetailsService {
 
    @Autowired
    private IUsuariosDao usuariosDao;
 
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        
        UsuariosModel usuario = usuariosDao.findByCorreo(correo);
        
        if (usuario == null) {
            throw new UsernameNotFoundException(correo);
        }
        
        ArrayList<GrantedAuthority> roles = new ArrayList<>();

        roles.add(new SimpleGrantedAuthority(usuario.getRol()));

        User user = new User(usuario.getCorreo(), usuario.getPassword(), roles);
        
        return user;
    }
}
