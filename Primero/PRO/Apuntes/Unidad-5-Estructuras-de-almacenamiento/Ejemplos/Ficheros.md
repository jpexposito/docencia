<div align="justify">

# Ejemplos de trabajo con Ficheros 

- Solicita al usuario que ingrese un nombre de archivo y un contenido, luego crea un archivo de texto con ese nombre y escribe el contenido en él.

```java
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateTextFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del archivo: ");
        String fileName = scanner.nextLine();
        System.out.print("Ingrese el contenido del archivo: ");
        String content = scanner.nextLine();
        
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println("Archivo creado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }
}
```

- Pide al usuario que ingrese el nombre de un archivo de texto existente y muestra su contenido en la consola.

```java
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadTextFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del archivo a leer: ");
        String fileName = scanner.nextLine();
        
        try {
            FileReader reader = new FileReader(fileName);
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

```

- Pide al usuario que ingrese el nombre de un archivo de origen y otro de destino. Copia el contenido del archivo de origen al archivo de destino.

```java
import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingrese el nombre del archivo de origen: ");
            String sourceFileName = reader.readLine();
            System.out.print("Ingrese el nombre del archivo de destino: ");
            String destFileName = reader.readLine();
            
            File sourceFile = new File(sourceFileName);
            File destFile = new File(destFileName);
            
            FileReader fileReader = new FileReader(sourceFile);
            FileWriter fileWriter = new FileWriter(destFile);
            int character;
            
            while ((character = fileReader.read()) != -1) {
                fileWriter.write(character);
            }
            
            fileReader.close();
            fileWriter.close();
            
            System.out.println("Archivo copiado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al copiar el archivo: " + e.getMessage());
        }
    }
}

```

- Solicita al usuario que ingrese el nombre actual y el nuevo nombre de un archivo. __Renombra__ el archivo con el nuevo nombre.

```java
import java.io.File;
import java.util.Scanner;

public class RenameFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del archivo a renombrar: ");
        String oldFileName = scanner.nextLine();
        System.out.print("Ingrese el nuevo nombre: ");
        String newFileName = scanner.nextLine();
        
        File file = new File(oldFileName);
        File newFile = new File(newFileName);
        
        if (file.exists()) {
            if (file.renameTo(newFile)) {
                System.out.println("Archivo renombrado exitosamente.");
            } else {
                System.out.println("No se pudo renombrar el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }
}

```

- Pide al usuario que ingrese el nombre de un archivo y __elimina__ ese archivo si existe.

```java
import java.io.File;
import java.util.Scanner;

public class DeleteFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del archivo a eliminar: ");
        String fileName = scanner.nextLine();
        
        File file = new File(fileName);
        
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Archivo eliminado exitosamente.");
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }
}
```

- Solicita al usuario que ingrese el nombre de un __directorio__ y __crea ese directorio__ en el sistema de archivos.

>Nota: Utiliza las siguientes funciones:
 - file.isFile();
 - file.isDirectory();
 - file.mkdir();