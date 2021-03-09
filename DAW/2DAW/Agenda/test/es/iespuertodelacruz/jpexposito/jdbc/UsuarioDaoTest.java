/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.jpexposito.jdbc;

import es.iespuertodelacruz.jpexposito.modelo.Usuario;
import es.iespuertodelacruz.jpexposito.modelo.jdbc.dao.UsuarioDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpexposito
 */
public class UsuarioDaoTest {
    
    static UsuarioDao usuarioDao;
    static Usuario usuario;
    
    public UsuarioDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        if (usuarioDao == null) {
            usuarioDao = new UsuarioDao();
        }
        if (usuario == null) {
             usuario = new Usuario("00000000T", "test", "test");
        } 
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        insertUsuario();
    }
    
    @After
    public void tearDown() {
       eliminarUsuario();
    }


    public void insertUsuario() {
        try {
            usuarioDao.insertar(usuario);
        }catch (Exception e){
            Assert.fail("Se ha producido un error no controlado en"
                    + " insertUsuarioTest:" +e.getMessage());
        }
    }
    
    @Test
    public void buscarUsuarioTest() {
        try {
            Usuario usuarioRespuesta = usuarioDao.buscar(usuario.getDni());
            Assert.assertTrue("EL valor obtenido no es igual al insertado",
                    usuario.equals(usuarioRespuesta));
        }catch (Exception e){
            Assert.fail("Se ha producido un error no controlado en"
                    + " insertUsuarioTest:" +e.getMessage());
        }
    
    }
   
    
    
    public void eliminarUsuario() {
        try {
            usuarioDao.eliminar(usuario.getDni());
        }catch (Exception e){
            Assert.fail("Se ha producido un error no controlado en"
                    + " insertUsuarioTest:" +e.getMessage());
        }
    
    }
    
    /**
    @Test
    public void modificarUsuarioTest() {
        String dni = null;
    
    }
    
    @Test
    public void buscarUsuariosTest() {
        String dni = null;
    
    }
    * **/
}
