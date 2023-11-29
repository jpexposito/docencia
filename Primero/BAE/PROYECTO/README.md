<div align="justify">

# Sistema de Gestión de una Universidad

## Descripción

Una universidad desea gestionar la información relacionada con sus __estudiantes, profesores, cursos, asignaturas, aulas, departamentos, programas académicos, matrículas, notas, eventos, becas, biblioteca, instalaciones deportivas, empleados administrativos, y empresas asociadas__.

Se pide:

 - Diseña un modelo entidad-relación que satisfaga los siguientes requisitos:
   - Cada estudiante está asociado con un único programa académico, y cada programa académico tiene múltiples estudiantes.
   - Cada curso pertenece a un único programa académico, y un programa académico puede tener varios cursos.
   - Los profesores imparten uno o más cursos, y cada curso es impartido por al menos un profesor.
   - Cada asignatura está relacionada con uno o más cursos, y cada curso tiene al menos una asignatura asociada.
   - Cada asignatura tiene un conjunto de prerequisitos, que son otras asignaturas que deben ser completadas antes de tomarla.
   - Las aulas son utilizadas para llevar a cabo uno o más cursos, y cada curso se lleva a cabo en al menos una sala de clases.
   - Cada departamento está asociado con uno o más programas académicos, y un programa académico puede pertenecer a varios departamentos.
   - Los estudiantes pueden matricularse en múltiples cursos, y cada curso puede tener múltiples estudiantes matriculados.
   - Se debe mantener un registro de las notas de cada estudiante en cada asignatura.
   - Los eventos pueden ser organizados por la universidad, y cada evento puede tener uno o más patrocinadores (empresas asociadas).
   - Algunos estudiantes pueden recibir becas, y cada beca está asociada con al menos un estudiante.
   - La biblioteca tiene una colección de libros, y cada libro puede estar en uno o más géneros.
   - Los empleados administrativos trabajan en departamentos, y cada departamento puede tener varios empleados administrativos.
   - Se deben registrar las instalaciones deportivas de la universidad, y cada instalación puede ser utilizada para uno o más eventos deportivos.
   - Las empresas asociadas pueden patrocinar eventos y proporcionar becas a estudiantes.
   - Los estudiantes están identificados por su dni, nombre y apellidos y pueden tener múltiples emails. Además de su dirección postal (calle, número, piso, código postal, municipio, y provincia).
   - Los profesores están identificados por un id_profesor, y además tendrán los campos dni, nombre y apellidos y tendrán un único dni.
   - Cada estudiante tendrá un tutor y cada tutor a su vez será un profesor, pudiendo este ser tutor o no.

 >__Nota__: Indentifica entidades, relaciones, propiedades simples, propiedades compuestas, y propiedades múltiples.

</div>