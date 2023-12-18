<div align="justify">

# Debud de Aplicaciones con Java

## Debug de Aplicaciones en VS-Code

### Instalar la extensión de Java Debugger

Asegúrate de tener instalada la extensión "Java Extension Pack" en VSCode. Puedes instalarla desde el menú de extensiones en VSCode.

### Abrir tu proyecto en VSCode

Abre la carpeta que contiene tu proyecto Java en VSCode.

### Configurar el punto de entrada (main class) del programa

Abre el archivo que contiene tu clase principal (donde se encuentra el método `main`). Haz clic en el margen izquierdo del editor, junto a la línea donde comienza el método `main`, para establecer un punto de interrupción (breakpoint). Esto será donde el programa se detendrá cuando esté en modo de depuración.

### Configurar la configuración de depuración

- Haz clic en la pestaña de "Run" en la barra lateral izquierda de VSCode.
- En la parte superior, busca el icono de engranaje (configuración) y haz clic en "Add Configuration...".
- Selecciona "Java" en la lista y elige el tipo de configuración que mejor se adapte a tu proyecto. Puedes configurar el punto de entrada y otros parámetros según sea necesario.

### Iniciar la sesión de depuración

- Vuelve a la pestaña de "Run" en la barra lateral izquierda.
- Selecciona la configuración de depuración que acabas de crear.
- Haz clic en el botón de reproducir (start debugging) o presiona F5.

Esto iniciará el programa en modo de depuración y se detendrá en el punto de interrupción que estableciste. Desde aquí, puedes usar las herramientas de depuración de VSCode para avanzar paso a paso, inspeccionar variables y realizar otras operaciones de depuración.

Recuerda que estos pasos pueden variar ligeramente según la configuración específica de tu proyecto y tu entorno de desarrollo. Además, asegúrate de tener Java instalado en tu sistema y configurado correctamente en tu entorno de desarrollo.

## Debug de Aplicaciones en Intelijj-Idea

### Abrir tu proyecto en IntelliJ IDEA

Abre IntelliJ IDEA y carga tu proyecto Java.

### Configurar el punto de entrada (main class) del programa

Encuentra la clase principal que contiene el método `main`. Haz clic en el margen izquierdo del editor, junto a la línea donde comienza el método `main`, para establecer un punto de interrupción (breakpoint). Esto será donde el programa se detendrá cuando esté en modo de depuración.

### Configurar la configuración de depuración

- Ve a la barra de menú y selecciona "Run" > "Edit Configurations...".
- En la ventana que aparece, haz clic en el signo de "+" en la esquina superior izquierda y selecciona "Application".
- Configura el nombre de la configuración y selecciona la clase principal que contiene el método `main`.
- Ajusta cualquier otro parámetro según sea necesario.

### Iniciar la sesión de depuración

- Haz clic en el botón de depuración (botón con ícono de insecto) en la esquina superior derecha de IntelliJ IDEA o utiliza la combinación de teclas correspondiente (por defecto, Shift + F9).
- El programa se ejecutará en modo de depuración y se detendrá en el punto de interrupción que estableciste.

### Utilizar las herramientas de depuración

Una vez en modo de depuración, puedes utilizar las herramientas proporcionadas por IntelliJ IDEA, como inspeccionar variables, avanzar paso a paso y más.

Recuerda que estos pasos pueden variar ligeramente según la configuración específica de tu proyecto y tu entorno de desarrollo. Además, asegúrate de tener la JDK (Java Development Kit) instalada y configurada correctamente en IntelliJ IDEA.

## Referencias

- [Debug de Aplicaciones en VSCODE](https://code.visualstudio.com/blogs/2017/09/28/java-debug)

</div>