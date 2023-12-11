<div align="justify">

# Correo Electrónico
<img src="https://www.ajapublicidad.es/wp-content/uploads/2015/10/emailmarketing.jpg" />

## Descripción

Implementa un programa en Java que permita validar direcciones de correo electrónico. El programa debe utilizar clases, excepciones y expresiones regulares para asegurarse de que las direcciones de correo ingresadas cumplan con ciertos criterios.

## Requisitos

Crea una clase llamada __CorreoElectronico__ que represente una dirección de correo electrónico.
Incluye un constructor que tome una cadena de texto (la dirección de correo electrónico) como parámetro y la almacene internamente.

## Validación de Correos Electrónicos

- Implementa un método en la clase CorreoElectronico llamado validar que lance una excepción personalizada (CorreoInvalidoException) si la dirección de correo no cumple con los siguientes criterios:
- Debe contener exactamente un símbolo "@".
- El símbolo "@" no puede estar al principio ni al final de la dirección.
- Debe haber al menos un carácter antes y después del símbolo "@".
- Después del símbolo "@" debe haber al menos un punto ".".
- Después del último punto "." debe haber al menos dos caracteres.

## Manejo de Excepciones

Crea una excepción personalizada llamada CorreoInvalidoException que se lance cuando la validación de la dirección de correo electrónico falle.
En el método principal del programa, captura y maneja esta excepción, mostrando un mensaje descriptivo al usuario.

## Interfaz de Usuario

En el método principal (main), solicita al usuario que ingrese una dirección de correo electrónico.
- Crea una instancia de la clase CorreoElectronico con la dirección ingresada y llama al método validar.
- Maneja las excepciones según sea necesario y muestra mensajes informativos al usuario.

</div>