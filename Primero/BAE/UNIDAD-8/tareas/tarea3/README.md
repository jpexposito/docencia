<div align="justify">

# Donación de Sangre

<div align="center">
<img width="300" src="https://tiposdesangre.org/wp-content/uploads/2017/05/Descubre-los-requisitos-para-Donar-Sangre-768x727.jpg"/>

</div>

¿Sabías que la mayoría de los adultos sanos pueden ser  donantes? Aunque existen ciertas condiciones que debes cumplir para realizar con éxito una donación. Descubre los requisitos básicos para donar sangre.

Para la poder donar sangre se deben cumplir varias condicones:
- Tener un peso superior a 50Kg.
- Ser apto para donar sangre.
- No haber donado en un periodo anterior a 90 días en caso de ser hombre y 120 días en caso de mujer.

Teniendo en cuenta esta información se pide:
- Crea una base datos llamada donacion.
    - [Crear BBDD en MySql](https://dev.mysql.com/doc/refman/8.0/en/creating-database.html).
- Crea una tabla llamada persona con los siguientes campos:
    - Peso. (Entero)
    - Admitido. Texto(Si/No).__(Valores de dominio:Si/No)__
    - Sexo. Texto (H/M).__(Valores de dominio:H/M)__
    - Fecha Última Donación. DateTime.
- Realiza al menos 10 insert en la tabla, con datos aleatorios, generados por el usuario.

- Realice un procedimiento para determinar si la persona puede donar sangre de acuerdo a las siguientes condiciones:
 
   - Si el peso es menor a 50 kg guarde en estado adminito "NO", en caso contrario seria "SI".
  

## Referencias

- [Tipos de Datos en MySql](https://dev.mysql.com/doc/refman/8.0/en/data-types.html).
- [Sentencia Update](https://dev.mysql.com/doc/refman/8.0/en/update.html)

</div>