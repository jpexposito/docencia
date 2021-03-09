package es.iespuertodelacruz.jpexposito.file;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.iespuertodelacruz.jpexposito.modelo.Usuario;
import es.iespuertodelacruz.jpexposito.modelo.file.UsuarioFile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpexposito
 */
public class UsuarioFileTest {
    
    static UsuarioFile usuarioFile;
    final static String NOMBRE_FICHERO = "nombreFichero.txt";
    
    @BeforeClass
    public static void setUpClass() {
        
        if (usuarioFile == null) {
            usuarioFile = new UsuarioFile();
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void hello() {
        assertTrue("Este mensaje se muestra sólo si falla el test", true);
    }
    
    @Test
    public void crearFicheroTest() {
        try {
            usuarioFile.crearFichero(NOMBRE_FICHERO);
            assertTrue("El fichero que debiera estar creado no existe", usuarioFile.existeFichero(NOMBRE_FICHERO));
        } catch (Exception ex) {
          fail("Este error no deberia de suceder porque se crea el fichero");
        }
    }
    
    @Test
    public void insertarUsuarioFicheroTest() {
        Usuario usuario = new Usuario ("00000000T","Juam Pablo","Español Español" );
        
        try {
            usuarioFile.insertar(NOMBRE_FICHERO, usuario);
        } catch (Exception ex) {
          fail("Este error no deberia de suceder porque se crea el fichero");
        }
    }
    
    @Test
    public void buscarTodosFicheroTest() {
        
        try {
            usuarioFile.buscarTodos(NOMBRE_FICHERO);
        } catch (Exception ex) {
          fail("Este error no deberia de suceder porque se crea el fichero");
        }
    }
    
    @Test
    public void buscarUsuarioFicheroTest() {
        Usuario usuario = new Usuario ("00000000H","Juam Pablo","Español Español" );
        String busqueda = null;
        try {
            usuarioFile.insertar(NOMBRE_FICHERO, usuario);
            busqueda = usuarioFile.buscar(NOMBRE_FICHERO, "00000000H");
            assertEquals("El usuario buscado no es el correcto", busqueda, usuario.toString());
            
        } catch (Exception ex) {
          fail("Este error no deberia de suceder porque se crea el fichero");
        }
    }
    
    @Test
    public void eliminarUsuarioFicheroTest() {
        
        try {
            usuarioFile.eliminar(NOMBRE_FICHERO, "00000000H");
        } catch (Exception ex) {
          fail("Este error no deberia de suceder porque se crea el fichero");
        }
    }
    
    //@Test
    public void modificarUsuarioFicheroTest() {
        
    }
        
}
