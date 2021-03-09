package es.iespuertolacruz.jpexposito;

import java.util.ArrayList;


/**
 *
 * @author jpexposito
 */
public class ProgramaPalabra {
    
    /**
     * Funcion que calcula el tamanio de la lista, mediate el metodo size()
     * @param listaPalabras
     * @return retorna el tamanio
     */
    public int contarPalabras(ArrayList<String> listaPalabras) {
        int tamanio = 0;
        
        if (listaPalabras != null) {
            tamanio = listaPalabras.size();
        }
        return tamanio;
    }
    
    /**
     * Funcion que add una palabra a la lista de palabras que se le pasa como
     * parametro. Utiliza el metodo add 
     * @param listaPalabras lista de palabras
     * @param palabra a incluir
     */
    public void insertarPalabra(ArrayList<String> listaPalabras, String palabra) {
        if (listaPalabras != null) {
            listaPalabras.add(palabra);
        }
    }
    
    /**
     * Funcion que cuenta el numero de veces que esta una palabra en la lista.
     * Utiliza el metodo equalsIgnoreCase 
     * @param listaPalabras Lista de palabras
     * @param palabraBuscar Palabra que estoy buscado
     * @return Numero de palabras que ha encontrado
     */
    public int contarPalabras(ArrayList<String> listaPalabras, String palabraBuscar) {
        int contador = 0;
        for (String palabra:listaPalabras ) {
            if (palabra.equalsIgnoreCase(palabraBuscar)) {
                contador++; 
            }
        
        }
        return contador;
    }
    
    
    public void contadorPalabras(ArrayList<String> listaPalabras, String palabra){
        //comprobamos si existe la palabra en la lista
        int contadorPalabra=0;
        for (int i = 0; i < listaPalabras.size(); i++) {
         if(listaPalabras.get(i).equalsIgnoreCase(palabra)){
              contadorPalabra+=1;

            }
        }
        System.out.println(contadorPalabra);
    }
    
    /**
     * Metodo que elimina todas las veces la palabra dentro de la lista. Uiliza 
     * contains y remove
     * @param listaPalabras Lista palabras 
     * @param palabra Palabra a eliminar
     */
    public void eliminarPalabra(ArrayList<String> listaPalabras, String palabra) {
        while (listaPalabras.contains(palabra)) {
            listaPalabras.remove(palabra);
        }
    }
    
    public void eliminarPalabraLista(ArrayList<String> listaPalabras, String palabra) throws Exception{
        if( listaPalabras == null || listaPalabras.size() == 0){
            throw new Exception("Error la lista no contiene palabras");
        }else{
            for (int i = 0; i < listaPalabras.size(); i++) {
                if(listaPalabras.get(i).contains(palabra)){
                    listaPalabras.remove(i);
                }
            }
        }
    }
    
    /**
     * FUncion que invierte una lista
     * @param listaPalabras
     * @return 
     */
    public ArrayList<String> invertirLista(ArrayList<String> listaPalabras) {
        ArrayList<String> listaInvertida = new ArrayList<String>(); 
        for (int i = listaPalabras.size() - 1; i >= 0; i--) { 
            listaInvertida.add(listaPalabras.get(i)); 
        } 
        return listaInvertida; 
        
    }
    
    /**
     * Funcion que elimina los elementos repetidos
     * @param listaPalabras
     * @return 
     */
    public ArrayList<String> eliminarRepetidos(ArrayList<String> listaPalabras) {
        ArrayList<String> listaSinRepetidos = new ArrayList<>();
        
        for (String elemento : listaPalabras) { 
            if (!listaSinRepetidos.contains(elemento)) { 
                listaSinRepetidos.add(elemento); 
            } 
        } 
        return listaSinRepetidos;    
    }
    
}
