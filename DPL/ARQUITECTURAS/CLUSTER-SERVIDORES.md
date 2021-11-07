<div align="justify">

# CLUSTER DE SERVIDORES

## Introducción

  Un cluster está compuesto por dos o más computadores (llamados nodos o miembros) que trabajan juntos para ejecutar una tarea. Hay cuatro clases de cluster:
  - __Almacenamiento__.
  - __Alta disponibilidad__.
  - __Balance de carga__.
  - __Alto rendimiento__.


  Los cluster de almacenamiento proporcionan una imagen de sistema de archivos consistente a lo largo de los servidores en el cluster, permitiendo que los servidores lean y escriban de forma simultánea a un sistema de archivos compartido. Un cluster de almacenamiento simplifica la administración de almacenamiento al limitar la instalación de aplicaciones a un sistema de archivos. Asimismo, con un sistema de archivos a lo largo del cluster, un cluster de almacenamiento elimina la necesidad de copias de más de los datos de la aplicación y simplifica la creación de copias de seguridad y recuperación contra desastres.

  ___Un ejemplo de cluster es el siguiente:___.

  <div align="center">
    <img src="https://sites.google.com/site/servidores153uteq/_/rsrc/1441223105166/clusters-de-servidores/bizagi_weblogic_cluster.png
" >
  </div>

## Ventajas de un servidor en clúster

  Existen múltiples beneficios y ventajas del uso de servidores en clúster:

  - __Alta disponibilidad__: este es uno de los grandes beneficios de la tecnología de clustering, es decir, ofrecer un mejor uptime de servidores gracias a que si falla uno, el resto tomará el trabajo ofreciendo así una alta disponibilidad del servicio.

  - __Alta velocidad de despacho__: se obtiene gracias al equilibrio de las cargas, haciendo que los servidores que reciben las solicitudes de los clientes puedan despachar los datos de forma inmediata, sin delays ni retrasos de ningún tipo.

  - __Balanceo de carga__: se establecen diferentes métodos de balanceo de carga, haciendo que una o varias peticiones se deriven a determinados hosts, mientras que otras irán destinadas a otro grupo de servidores bajo el clúster. Esto hace que ningún servidor se vea saturado.

  - __Escalabilidad__: la mayoría de los clúster de servidores soportan escalabilidad de forma horizontal, permitiendo agregar más servidores de forma masiva según se necesite debido a una posible creciente demanda de parte de los usuarios.

  - __Resistencia ante ataques DDOS__: tener un clúster de servidores ofrece un beneficio adicional de soportar mejor las cargas de sistema que se originan ante ataques DDOS masivos, donde se suelen inundar los servidores con peticiones no deseadas. El uso de múltiples servidores puede ayudar a resistir mejores diferentes tipos de ataque destinados a agotar los recursos de sistema o red.

## Desventajas de un servidor en clúster

  Los clúster, a pesar de estar tan idealizados en la industria, también tienen sus desventajas o contras, veamos algunas de ellas:

  - __Altos costos__: esta es una de las principales desventajas que tiene trabajar con un clúster de servidores, y es que el setup y puesta a punto de tecnologías como este tipo cuesta bastante más caro que trabajar con servidores dedicados tradicionales, o con servidores en la nube. No solo es caro para montarlo, también se debe tener en cuenta que al necesitar escalar se necesitará agregar más servidores al esquema de red, incrementando así los gastos.

  - __Complejidad__: no todas las empresas proveedores de servicios de Internet, o de web hosting tienen el tiempo, la infraestructura y el personal técnico calificado para montar este tipo de soluciones. La alta complejidad a nivel técnico hace que montar un servidor en clúster se logre hoy por hoy en muy pocos proveedores del mundo hispano.

  __Tiempo de implementación__: montar, configurar y dejar a punto un clúster de servidores puede tomar varias semanas, a varios meses, dependiendo de la complejidad del sistema, de las aplicaciones y tipos de balanceo de carga y replicación de datos (servidores en espejo por ejemplo) usados en la arquitectura. Por lo que no suele ser una solución para quienes necesitan una opción rápida.

  - __No son a prueba de fallos__: contrario a su finalidad y naturaleza, lamentablemente, los servidores en clúster también pueden fallar, le ha sucedido a Gmail, Yahoo, Hotmail, la NASA, tarde o temprano la perfecta arquitectura del clúster puede fallar por errores de red, software o hardware, siempre debes tenerlo en cuenta. Lo que si te pueden garantizar es que fallarán mucho menos que otras soluciones.

## Tipos de servidor en clúster

  Cuando comenzamos a adentrarnos en el concepto de clustering aparecen diferentes tipos de clúster que conviene diferenciar bien. Vamos a ver las características de cada uno de ellos.

### Dependiendo de la arquitectura usada

  - __Clúster en la nube__: son servicios de clustering, balanceo y replicación basados en la nube, suelen implementarse más rápido, pero permiten menos personalización para adaptarse a las necesidades de la aplicación.
  - __Clúster de servidores dedicados__: son la solución ideal para adaptarse al 100% a las necesidades de la aplicación, aunque se demora un poco más en su implementación.

### Dependiendo de la solución que ofrecen:

  - __Clúster de alto rendimiento (High Performance Computing Cluster)__: se utilizan para realizar tareas que implican gran procesamiento de datos, utilizan gran potencia a nivel de CPU, memoria o velocidad de lectura/escritura en disco.

  - __Clúster de alta disponibilidad (High Availability Computing Cluster)__: son los que brindan mejores garantías ante fallas de red, hardware o software para permitir que tu aplicación siempre esté online las 24 hs.
  - __Clúster de alta eficiencia (High Throughput Computing Cluster)__: se utilizan para que el procesamiento de datos sea lo más eficiente posible, realizando grandes cantidades de tareas en el menor tiempo posible.

### Dependiendo del campo donde se aplican:

  - __Clúster comercial__: son los que se utilizan por empresas, corporaciones y multinacionales para soportar las demandas de sus servicios.

  - __Clúster gubernamental__: son utilizados por los gobiernos y agencias de cada país para despachar de forma eficiente, manteniendo la alta disponibilidad para los ciudadanos de una región determinada.

  - __Clúster científico__: se utiliza para procesamiento de datos científicos en instituciones de investigación de determinados campos como ingeniería, biología, medicina, genética, etc.


## Conclusión

___Podemos y debemos clusterizar todo aquello que sea necesario para que nuestra arquitectura sea robusta___.

## Referencias

- [Cluster de servidores en RedHad](https://access.redhat.com/documentation/es-es/red_hat_enterprise_linux/5/html/cluster_suite_overview/ch.gfscs.cluster-overview-cso#s1-clstr-basics-CSO)
- [Cluster de servicios](https://blog.infranetworking.com/servidor-en-cluster/).
</div>
