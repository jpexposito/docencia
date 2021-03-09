/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito;

import es.iespuertolacruz.jpexposito.exceptions.LongitudException;
import es.iespuertolacruz.jpexposito.exceptions.MailException;
import javax.swing.JOptionPane;

/**
 *
 * @author jpexposito
 */
public class CompruebaMail {
    public static void main(String[] args) throws MailException {
		// TODO Auto-generated method stub
		
		int arroba = 0;
		
		boolean punto = false;
		
		String mail = JOptionPane.showInputDialog("Introduce mail");
               
                /**
		for(int i = 0; i < mail.length(); i++){
                    if(mail.charAt(i) == '@'){
                            arroba++;	
                    }
                    if(mail.charAt(i) == '.'){	
                            punto = true;
                    }
		}
                ***/
                
                bucleError(mail, arroba, punto);
		
		if(arroba == 1 && punto){
			System.out.println("El mail es correcto");
		}else {
                    /**
                        String mensaje = "";
                             if (arroba > 1) {
                                 mensaje = "El numero de @ es incorrecto, encontrado:" +arroba;
                             } else {
                                mensaje = "El numero de @ es incorrecto, encontrado:" +arroba;
                             }
                             if (punto == false) {
                                 mensaje += "el email carece de .";
                             }
                             throw new MailException(mensaje);
                         }
                     */
                    evaluarError(arroba, punto);
                    /**
                    throw new MailException("Email incorrecto");
                    */
		}

	}
    /**
     * Metodo que construye un mensaje de error en funcion de los parametros 
     * @param arroba numero de @ encontrados en la cadena
     * @param punto numero de puntos encontrados en la cadena
     * @throws MailException 
     */
    private static void evaluarError(int arroba, boolean punto) throws MailException{
      String mensaje = "";
        if (arroba > 1 || arroba < 0) {
            mensaje = "El numero de @ es incorrecto, encontrado:" +arroba;
        } 
        if (punto == false) {
            mensaje += "el email carece de .";
        }
        throw new MailException(mensaje);
    }
    
    private static void bucleError(String mail,int arroba,boolean punto){
        for(int i = 0; i < mail.length(); i++){
            if(mail.charAt(i) == '@'){
                arroba++;
            } else if (mail.charAt(i) == '.') {
                punto = true;
            }
   
        }  
    }

}
