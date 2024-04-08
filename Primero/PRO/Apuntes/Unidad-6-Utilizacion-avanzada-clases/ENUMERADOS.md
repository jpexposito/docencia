<div align="justify">

# ENUMERADOS EN PROGRAMACIÓN

En Java, un _enumerado_ (o __enum__) es un tipo de datos especial que permite definir un conjunto fijo de constantes con nombre. Estas constantes representan valores que son mutuamente exclusivos y predefinidos. Los enumerados son útiles cuando necesitas representar un conjunto finito y conocido de valores, como los días de la semana, los meses del año, opciones de menú, etc.

```java
// Definición de un enum para los días de la semana
public enum DiaSemana {
    LUNES,
    MARTES,
    MIERCOLES,
    JUEVES,
    VIERNES,
    SABADO,
    DOMINGO
}

public class Main {
    public static void main(String[] args) {

        DiaSemana dia = DiaSemana.MIERCOLES;
        
        System.out.println("Hoy es: " + dia);  
        if (dia == DiaSemana.MIERCOLES) {
            System.out.println("¡Hoy es mi día favorito!");
        }
        
        System.out.println("Días de la semana:");
        for (DiaSemana d : DiaSemana.values()) {
            System.out.println(d);
        }
    }
}

```

</div>