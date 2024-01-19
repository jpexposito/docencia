<div align="justify">


# Estructuras de almacenamiento

 El árbol de dependencias de las __interfaces__ de __colecciones__ y __mapas__ se organiza de manera __jerárquica__. A continuación, te proporcionaré un esquema básico del árbol de dependencias:

```mathematica
java.util.Collection
├── java.util.List
│   ├── java.util.ArrayList
│   └── java.util.LinkedList
├── java.util.Set
│   ├── java.util.HashSet
│   ├── java.util.LinkedHashSet
│   └── java.util.TreeSet
└── java.util.Queue
    └── java.util.LinkedList

java.util.Map
├── java.util.HashMap
├── java.util.Hashtable
├── java.util.LinkedHashMap
├── java.util.TreeMap
└── java.util.IdentityHashMap
```

En este árbol:
__Collection__ es la __interfaz__ principal para las __colecciones__.
__List__, __Set__, y __Queue__ son subinterfaces de __Collection__, cada una __PROPORCINA DIFERENTES COMPORTAMIENTOS__:
_ArrayList_, _LinkedList_, _HashSet_, _LinkedHashSet_, _TreeSet_, y _LinkedList_ son __IMPLEMENTACIONES ESPECÍFICAS__ de estas _interfaces_.

En el caso de los mapas:
__Map__ es la __interfaz__ principal para los __mapas__.
_HashMap_, _Hashtable_, _LinkedHashMap_, _TreeMap_, y _IdentityHashMap_ son __IMPLEMENTACIONES ESPECÍFICAS__ de la interfaz __Map__.
Es importante destacar que _Hashtable_ es una implementación más antigua y está sincronizada, lo que significa que es segura para operaciones en __entornos concurrentes__ pero puede tener un rendimiento inferior en comparación con las implementaciones no sincronizadas más modernas, como HashMap.

## 1. [Creación de arrays](Creacion-de-arrays.md)
## 2. [Colecciones](Colecciones.md)
## 3. [](.md)
## 4. [](.md)
## 5. [](.md)
## 6. [](.md)
## 7. [](.md)
## 8. [](.md)


</div>