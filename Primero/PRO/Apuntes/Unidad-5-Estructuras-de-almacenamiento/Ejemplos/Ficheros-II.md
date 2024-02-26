<div align="justify">

# Ejemplos de trabajo con Ficheros II

>Nota: _Fichero de datos de pruebas (data.csv)_.

```csv
ID,Nombre,Edad,Ciudad
1,Ana,25,Madrid
2,Carlos,30,Barcelona
3,Luisa,28,Valencia
4,Pablo,35,Sevilla
5,Sofía,27,Bilbao
```

- Solicita al usuario que __ingrese una línea de datos y agrega esa línea al final del archivo__ CSV.

    ```java
    import com.opencsv.CSVWriter;

    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.Scanner;

    public class AppendToCSV {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese datos para agregar al archivo CSV: ");
            String[] newData = scanner.nextLine().split(",");
            
            try {
                CSVWriter writer = new CSVWriter(new FileWriter("data.csv", true));
                writer.writeNext(newData);
                writer.close();
                System.out.println("Datos agregados exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al agregar datos al archivo CSV: " + e.getMessage());
            }
        }
    }
    ```

- Pide al usuario que ingrese una __clave de búsqueda y muestra el registro__ correspondiente si se encuentra en el archivo CSV.

    ```java
    import com.opencsv.CSVReader;

    import java.io.FileReader;
    import java.io.IOException;
    import java.util.Scanner;

    public class SearchByKey {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese la clave a buscar: ");
            String searchKey = scanner.nextLine();
            
            try {
                CSVReader reader = new CSVReader(new FileReader("data.csv"));
                String[] nextLine;
                boolean found = false;
                while ((nextLine = reader.readNext()) != null) {
                    if (nextLine[0].equals(searchKey)) {
                        System.out.println("Registro encontrado: " + String.join(",", nextLine));
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("No se encontró ningún registro con la clave especificada.");
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("Error al buscar en el archivo CSV: " + e.getMessage());
            }
        }
    }
    ```

- Solicita al usuario que ingrese una clave de búsqueda y los nuevos datos, luego __actualiza__ el registro correspondiente en el archivo CSV.

    ```java
    import com.opencsv.CSVReader;
    import com.opencsv.CSVWriter;

    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.Scanner;

    public class UpdateRecord {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese la clave del registro a actualizar: ");
            String searchKey = scanner.nextLine();
            
            try {
                CSVReader reader = new CSVReader(new FileReader("data.csv"));
                String[] nextLine;
                StringBuilder updatedData = new StringBuilder();
                boolean found = false;
                while ((nextLine = reader.readNext()) != null) {
                    if (nextLine[0].equals(searchKey)) {
                        System.out.print("Ingrese los nuevos datos separados por comas: ");
                        String newData = scanner.nextLine();
                        updatedData.append(newData).append("\n");
                        found = true;
                    } else {
                        updatedData.append(String.join(",", nextLine)).append("\n");
                    }
                }
                reader.close();
                
                if (!found) {
                    System.out.println("No se encontró ningún registro con la clave especificada.");
                    return;
                }
                
                CSVWriter writer = new CSVWriter(new FileWriter("data.csv"));
                writer.writeAll(CSVReader.parse(nextLine));
                writer.close();
                System.out.println("Registro actualizado exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al actualizar el archivo CSV: " + e.getMessage());
            }
        }
    }
    ```

- Pide al usuario que ingrese una __clave de búsqueda y elimina el registro correspondiente__ del archivo CSV.

    ```java
    import com.opencsv.CSVReader;
    import com.opencsv.CSVWriter;

    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.Scanner;

    public class DeleteRecord {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese la clave del registro a eliminar: ");
            String searchKey = scanner.nextLine();
            
            try {
                CSVReader reader = new CSVReader(new FileReader("data.csv"));
                String[] nextLine;
                StringBuilder updatedData = new StringBuilder();
                boolean found = false;
                while ((nextLine = reader.readNext()) != null) {
                    if (nextLine[0].equals(searchKey)) {
                        found = true;
                    } else {
                        updatedData.append(String.join(",", nextLine)).append("\n");
                    }
                }
                reader.close();
                
                if (!found) {
                    System.out.println("No se encontró ningún registro con la clave especificada.");
                    return;
                }
                
                CSVWriter writer = new CSVWriter(new FileWriter("data.csv"));
                writer.writeAll(CSVReader.parse(nextLine));
                writer.close();
                System.out.println("Registro eliminado exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al eliminar el registro del archivo CSV: " + e.getMessage());
            }
        }
    }
    ```

- Muestra al usuario el número total de registros presentes en el archivo CSV.

    ```java
    import com.opencsv.CSVReader;

    import java.io.FileReader;
    import java.io.IOException;

    public class CountRecords {
        public static void main(String[] args) {
            try {
                CSVReader reader = new CSVReader(new FileReader("data.csv"));
                int count = 0;
                while (reader.readNext() != null) {
                    count++;
                }
                reader.close();
                System.out.println("Número total de registros: " + count);
            } catch (IOException e) {
                System.out.println("Error al contar registros en el archivo CSV: " + e.getMessage());
            }
        }
    }
    ```

- Realiza el promerio de la columna edad. Muestra los datos y realiza la operació.

    ```java
    import com.opencsv.CSVReader;

    import java.io.FileReader;
    import java.io.IOException;
    import java.util.Arrays;

    public class AverageColumn {
        public static void main(String[] args) {
            int columnNumber = 2; // Cambiar al número de la columna que deseas promediar
            try {
                CSVReader reader = new CSVReader(new FileReader("data.csv"));
                String[] nextLine;
                double sum = 0;
                int count = 0;
                while ((nextLine = reader.readNext()) != null) {
                    if (nextLine.length > columnNumber) {
                        sum += Double.parseDouble(nextLine[columnNumber]);
                        count++;
                    }
                }
                reader.close();
                double average = sum / count;
                System.out.println("Promedio de la columna " + columnNumber + ": " + average);
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error al calcular el promedio: " + e.getMessage());
            }
        }
    }
    ```

- Pide al usuario que ingrese el __número de la columna por la cual desea ordenar los registros__ y ordena el archivo CSV en función de esa columna.

    ```java
    import com.opencsv.CSVReader;
    import com.opencsv.CSVWriter;

    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.*;

    public class SortByColumn {
        public static void main(String[] args) {
            int columnNumber = 1; // Cambiar al número de la columna por la cual quieres ordenar
            List<String[]> data = new ArrayList<>();
            try {
                CSVReader reader = new CSVReader(new FileReader("data.csv"));
                String[] nextLine;
                while ((nextLine = reader.readNext()) != null) {
                    data.add(nextLine);
                }
                reader.close();
                
                Collections.sort(data, Comparator.comparing(o -> o[columnNumber]));
                
                CSVWriter writer = new CSVWriter(new FileWriter("sorted_data.csv"));
                writer.writeAll(data);
                writer.close();
                System.out.println("Registros ordenados y guardados en 'sorted_data.csv'.");
            } catch (IOException e) {
                System.out.println("Error al ordenar registros: " + e.getMessage());
            }
        }
    }
    ```

- Solicita al usuario que ingrese una columna y un valor, y __muestra solo los registros que cumplen con esa condición__.

    ```java
    import com.opencsv.CSVReader;

    import java.io.FileReader;
    import java.io.IOException;
    import java.util.Scanner;

    public class FilterByCondition {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el número de la columna para filtrar: ");
            int columnNumber = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese el valor para filtrar: ");
            String filterValue = scanner.nextLine();
            
            try {
                CSVReader reader = new CSVReader(new FileReader("data.csv"));
                String[] nextLine;
                while ((nextLine = reader.readNext()) != null) {
                    if (nextLine.length > columnNumber && nextLine[columnNumber].equals(filterValue)) {
                        System.out.println(String.join(",", nextLine));
                    }
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("Error al filtrar registros: " + e.getMessage());
            }
        }
    }
    ```

- Pide al usuario que ingrese un __nombre para el nuevo archivo y exporta los datos del archivo CSV actual a un nuevo archivo__ con el nombre especificado.

    ```java
    import com.opencsv.CSVReader;
    import com.opencsv.CSVWriter;

    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;

    public class ExportToCSV {
        public static void main(String[] args) {
            try {
                CSVReader reader = new CSVReader(new FileReader("data.csv"));
                CSVWriter writer = new CSVWriter(new FileWriter("exported_data.csv"));
                String[] nextLine;
                while ((nextLine = reader.readNext()) != null) {
                    writer.writeNext(nextLine);
                }
                reader.close();
                writer.close();
                System.out.println("Datos exportados exitosamente a 'exported_data.csv'.");
            } catch (IOException e) {
                System.out.println("Error al exportar datos: " + e.getMessage());
            }
        }
    }
    ```

- __Elimina todo el contenido del archivo CSV__, dejándolo vacío.

    ```java
    import java.io.FileWriter;
    import java.io.IOException;

    public class ClearCSV {
        public static void main(String[] args) {
            try {
                FileWriter writer = new FileWriter("exported-data.csv");
                writer.write("");
                writer.close();
                System.out.println("Contenido del archivo CSV eliminado correctamente.");
            } catch (IOException e) {
                System.out.println("Error al eliminar contenido del archivo CSV: " + e.getMessage());
            }
        }
    }

    ```