<div align="justify">

# Diagramas de Páquetes

Los __diagramas de paquetes__ son una herramienta de modelado en UML que se utiliza para __organizar y estructurar__ _elementos en una aplicación_. Se centran en la agrupación lógica de elementos relacionados, proporcionando una vista jerárquica y modular del sistema.

```mermaid
packageDiagram
  PaquetePrincipal {
    [ClasePrincipal]
    [OtraClase]
    [InterfazPrincipal]
  }

  PaquetePrincipal --|> PaqueteSecundario1
  PaquetePrincipal --|> PaqueteSecundario2

  PaqueteSecundario1 {
    [ClaseSecundaria1]
    [OtraInterfaz1]
  }

  PaqueteSecundario2 {
    [ClaseSecundaria2]
    [OtraInterfaz2]
  }

  ClasePrincipal --> ClaseSecundaria1
  ClasePrincipal --> OtraInterfaz1
  OtraInterfaz1 --> ClaseSecundaria2
```

</div>