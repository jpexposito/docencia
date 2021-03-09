/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.jpexposito.modelo.file;

import es.iespuertodelacruz.jpexposito.exception.FicheroNoExisteException;
import es.iespuertodelacruz.jpexposito.exception.GestionFicheroException;
import es.iespuertodelacruz.jpexposito.modelo.Usuario;
import java.io.*;


/**
 *
 * @author jpexposito
 */
public class UsuarioFile {
    
    File usuarioFile;

   
    /**
     * Metodo que verifica si existe el fichero y en caso negativo lo crea
     * @param rutaFichero
     * @throws FicheroNoExisteException 
     */
    public void crearFichero(String rutaFichero) throws GestionFicheroException {
        try {
            if (!existeFichero(rutaFichero)) {
                usuarioFile.createNewFile();     
            } 
           
        } catch (IOException e) {
            throw new GestionFicheroException("El fichero con ruta:" + rutaFichero +
                    ", no existe o no ha podido ser creado");
        }      
        
    }
    
    /**
     * Funcion que verifica si existe el fichero
     * @param rutaFichero Ruta del fichero a verificar
     * @return (true/false) con la existencia o no del fichero
     */
    public boolean existeFichero (String rutaFichero) {
        // TODO: Como se puede mejorar este codigo: Pregunta
         this.usuarioFile = new File(rutaFichero);   
         return obtenerUsuarioFile(rutaFichero).exists();
    }
    
    /**
     * Meotodo que cierra el File si se encuentra abierto
     */
    public void cerrarFichero() {
        if (this.usuarioFile != null) {
           this.usuarioFile = null;
        }
    }
     
    /**
     * Metoro que realiza la insercion dentro del fichero
     * @param usuario objeto que se va a insertar en la ultima linea del fichero

     */
    public void insertar(String rutaFichero, Usuario usuario) throws GestionFicheroException, FicheroNoExisteException {
        
        FileWriter fileWriter = null;
        PrintWriter escritor;

        try {
            crearFichero(rutaFichero);
            if (!existe(rutaFichero, usuario.getDni())) {
                //TODO: Para que es necesario en true? Permite add nuevas lineas
                fileWriter = new FileWriter(obtenerUsuarioFile(rutaFichero), true);                                     
                escritor = new PrintWriter(fileWriter) ;
                escritor.println(usuario.toString());
            } else {
                // Lanzar un error de que el usuario ya existe
            }
            
     
        } catch (IOException e) {
            throw new GestionFicheroException("No se ha podido realizar la "
                    + "insercion en el fichero:" + rutaFichero +
                    ", " +e.getMessage());
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException ex) {
                    // Hay que gestionar esta exception
                }
            }
           
        } 
    }
    
    /**
     * Metodo que permite mostrar el contenifo de un fichero
     * @param rutaFichero ruta del fichero a mostrar
     * @throws GestionFicheroException Error no controlado durante la lectura
     * @throws FicheroNoExisteException El fichero para la lectura no se encuentra
     */
    public void buscarTodos(String rutaFichero) throws GestionFicheroException, FicheroNoExisteException {
        
        BufferedReader buffer = null;

        try {
          buffer = new BufferedReader(new FileReader(obtenerUsuarioFile(rutaFichero)));
          String linea = null;
          while ((linea = buffer.readLine()) != null)
            System.out.println(linea);
        } catch (FileNotFoundException fnfe) { 
            throw new FicheroNoExisteException("No es encuentra el fichero:" + rutaFichero);
        } catch (IOException ioe) { 
            throw new GestionFicheroException("Se ha producido un error a "
                    + "trabajar con el fichero:" + rutaFichero);
        } finally {
          if (buffer != null)
          try {
            buffer.close();
          } catch (IOException ioe) { 
            throw new GestionFicheroException("Se ha producido un error al "
                    + "cerrar el fichero:" + rutaFichero);
          }
        }

    }
    
    
    public boolean existe(String rutaFichero, String dni) throws GestionFicheroException, FicheroNoExisteException {
        
        BufferedReader buffer = null;
        
        boolean encontrado = false;
        try {
          buffer = new BufferedReader(new FileReader(obtenerUsuarioFile(rutaFichero)));
          String linea = null;
          while ((linea = buffer.readLine() ) != null && !encontrado)
              if (linea.contains(dni)) {          
                    encontrado = true; 
                }
        } catch (FileNotFoundException fnfe) { 
            throw new FicheroNoExisteException("No es encuentra el fichero:" + rutaFichero);
        } catch (IOException ioe) { 
            throw new GestionFicheroException("Se ha producido un error a "
                    + "trabajar con el fichero:" + rutaFichero);
        } finally {
          if (buffer != null)
          try {
            buffer.close();
          } catch (IOException ioe) { 
            throw new GestionFicheroException("Se ha producido un error al "
                    + "cerrar el fichero:" + rutaFichero);
          }
        }
        return encontrado;   
    }
    
    
    public String buscar(String rutaFichero, String dni) throws GestionFicheroException, FicheroNoExisteException {
        
        BufferedReader buffer = null;
        String usuario = null;
        boolean encontrado = false;
        try {
          buffer = new BufferedReader(new FileReader(obtenerUsuarioFile(rutaFichero)));
          String linea = null;
          while ((linea = buffer.readLine() ) != null && !encontrado)
              if (linea.contains(dni)) {          
                    usuario =  linea;
                    encontrado = true; 
                }
        } catch (FileNotFoundException fnfe) { 
            throw new FicheroNoExisteException("No es encuentra el fichero:" + rutaFichero);
        } catch (IOException ioe) { 
            throw new GestionFicheroException("Se ha producido un error a "
                    + "trabajar con el fichero:" + rutaFichero);
        } finally {
          if (buffer != null)
          try {
            buffer.close();
          } catch (IOException ioe) { 
            throw new GestionFicheroException("Se ha producido un error al "
                    + "cerrar el fichero:" + rutaFichero);
          }
        }
        return usuario;   
    }
    
    public void eliminar(String rutaFichero, String dni) throws GestionFicheroException, FicheroNoExisteException {
        
        BufferedReader buffer = null;
        PrintWriter escritor = null;
        boolean encontrado = false;
        try {
          File file = obtenerUsuarioFile(rutaFichero);
          buffer = new BufferedReader(new FileReader(obtenerUsuarioFile(rutaFichero)));
          escritor = new PrintWriter(new FileWriter(file, true));
          String linea = null;
          while ((linea = buffer.readLine()) != null && !encontrado)
              if (linea.contains(dni)) {          
                    escritor.println(linea);
                    escritor.flush();
                    encontrado = true;
                }
        } catch (FileNotFoundException fnfe) { 
            throw new FicheroNoExisteException("No es encuentra el fichero:" + rutaFichero);
        } catch (IOException ioe) { 
            throw new GestionFicheroException("Se ha producido un error a "
                    + "trabajar con el fichero:" + rutaFichero);
        } finally {
          if (buffer != null)
          try {
            buffer.close();
          } catch (IOException ioe) { 
            throw new GestionFicheroException("Se ha producido un error al "
                    + "cerrar el fichero:" + rutaFichero);
          }
        }  
    }
    
    public void modificar(String rutaFichero, Usuario usuario) throws GestionFicheroException, FicheroNoExisteException {
        
       //TODO: A realizar por el alumno
    }

    public File obtenerUsuarioFile(String rutaFichero) {
        if (usuarioFile == null) {
            usuarioFile = new File (rutaFichero);
        }
        return usuarioFile;
    }
    
}
