<div align="justify">
# VERSIONADO SEMANTICO

## Definición

En el mundo de la administración de software existe un temido lugar llamado __Infierno de Dependencias__. Mientras más crece tu sistema y más paquetes integras dentro de tu software, más probable se hace que un día te encuentres en este pozo de desesperación.

En sistemas con muchas dependencias, lanzar nuevas versiones de los paquetes puede convertirse en una pesadilla. Si las especificaciones de la dependencias son muy estrictas, estarás en peligro de bloquear una versión (la inhabilidad de actualizar un paquete sin tener que publicar una nueva versión de cada otro paquete dependiente). Si las dependencias son especificadas de forma muy relajada, inevitablemente serás mordido por versiones promiscuas (asumir la compatibilidad con próximas versiones más allá de lo razonable). El Infierno de Dependencias es donde estás cuando una versión bloqueada y/o promiscua previenen que muevas tu proyecto adelante de forma fácil y segura.

Como solución a este problema, propuse un conjunto simple de reglas y requerimientos que dicten cómo asignar e incrementar los números de la versión. Estas reglas están basadas en prácticas preexistentes de uso generalizado tanto en software de código cerrado como de código abierto, pero no necesariamente limitadas a éstas. Para que este sistema funcione, primero debes declarar un API público. Éste puede consistir en documentación aparte o ser impuesto por el código mismo. Independientemente de lo anterior, es importante que este API sea claro y preciso. Una vez identifiques tu API público, debes comunicar los cambios realizados a éste con incrementos específicos a tu número de versión. Considera un formato de versión X.Y.Z (_Mayor.Menor.Parche_). Las correcciones de errores que no afectan el API incrementan la versión parche. Adiciones o sustracciones compatibles con versiones anteriores incrementan la versión menor, y cambios en el API incompatibles con versiones anteriores incrementan la versión mayor.

Llamo a este sistema __Versionado Semántico__. Bajo este esquema, los números de versión y la forma en la que cambian transmiten el sentido del código y lo que ha sido modificado de una versión a otra.

<div align="center">
  <img src="https://docs.google.com/drawings/d/e/2PACX-1vRk1PZ0E2PNryW8zsmD-MKJAJ6iSTOPqlvEhUt9nmuUuXdbn5IknEqlDjHkx4Xahwi_RJcDSKeKz49g/pub?w=443&h=172" alt="Versionado Semantico" >
</div>

# Referencias
- [Descripción de versionado semánticoE](https://semver.org/lang/es/).


</div>
