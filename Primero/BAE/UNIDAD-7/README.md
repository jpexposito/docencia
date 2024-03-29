<div align="justify">

<div align="center">
    <img src="img/optimizacion-bd.png" width="300px" >
</div>

# Optimización de Base de Datos

Los elementos a tener en cuenta en la optimización de una base de datos son:

1. **Índices:**
   - Utiliza índices adecuadamente en columnas que se utilizan con frecuencia en cláusulas WHERE, JOIN y ORDER BY para mejorar el rendimiento de las consultas.

2. **Diseño de la Base de Datos:**
   - ___Diseña la base de datos de manera eficiente, normalizando cuando sea necesario para reducir la redundancia y mejorar la integridad de los datos__.
   - Evita el exceso de normalización que puede conducir a consultas complicadas y lentas.

3. **Consultas Eficientes:**
   - Escribe consultas SQL eficientes y optimizadas para minimizar la carga en el servidor de base de datos.
   - ___Evita el uso de consultas SELECT *___ y ___selecciona solo las columnas necesarias___.
   - Utiliza cláusulas ___WHERE y JOIN___ adecuadamente para limitar el conjunto de resultados.

4. **Optimización de Consultas:**
   - Utiliza herramientas de análisis de consultas para identificar consultas lentas y optimizarlas.
   - Considera la reescritura de consultas para mejorar el rendimiento.
   - Utiliza EXPLAIN en bases de datos que lo admitan para comprender el plan de ejecución de consultas y realizar ajustes si es necesario.

5. **Ajuste de Parámetros del Sistema:**
   - Ajusta los parámetros de configuración del sistema de base de datos, como el tamaño del búfer, el número de conexiones permitidas y la configuración de la memoria, para adaptarse a las necesidades de tu aplicación y carga de trabajo.

6. **Mantenimiento de la Base de Datos:**
   - Programa tareas de mantenimiento regular, como la actualización de estadísticas, la reconstrucción de índices y la eliminación de datos obsoletos para mantener la integridad y el rendimiento de la base de datos.

7. **Hardware y Almacenamiento:**
   - Considera el hardware y el almacenamiento subyacentes para la base de datos. Asegúrate de que el servidor de base de datos tenga suficiente memoria, CPU y almacenamiento para manejar la carga de trabajo esperada.
   - Utiliza discos rápidos y confiables para almacenar la base de datos y los registros de transacciones.

8. **Seguridad y Acceso:**
   - Implementa medidas de seguridad adecuadas para proteger la base de datos contra accesos no autorizados y ataques.
   - Limita el acceso a la base de datos solo a los usuarios y aplicaciones necesarios.

9. **Copias de Seguridad y Recuperación:**
   - Realiza copias de seguridad regulares de la base de datos y practica procedimientos de recuperación para garantizar la disponibilidad de los datos en caso de falla del sistema o pérdida de datos.

10. **Monitorización y Ajuste Continuo:**
   - Utiliza herramientas de monitorización para supervisar el rendimiento y la salud de la base de datos.
   - Realiza ajustes continuos en función de los cambios en la carga de trabajo y los patrones de acceso a los datos.

En esta unidad vamos a tratar con dos elementos:
- [Índices en Base de Datos](Indices.md).
- [Vistas en Base de datos](Vistas.md)

</div>