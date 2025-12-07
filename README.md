# Inventario de Productos - Aplicación Java (POO y Arreglos)
## autores
### Jhojanth Camilo Alegria Escobar
###    Andres Mauricio Quintero Rios

## Resumen

Aplicación de consola en Java para gestionar un inventario básico de productos. Fue desarrollada como entrega para la unidad de Programación Orientada a Objetos (POO) con uso de arreglos.

## 1. Formulación del problema

Contexto
: Una tienda pequeña necesita un programa sencillo para registrar y consultar los productos en inventario (código, nombre, precio unitario y cantidad disponible).

Objetivo del programa
: Permitir al administrador registrar productos, listar los registros de forma ordenada, calcular el valor total del inventario y buscar productos por su código.

Datos a gestionar
: Cada producto contiene:
- `codigo` (String): identificador único.
- `nombre` (String): nombre del producto.
- `precioUnitario` (double): precio por unidad.
- `cantidad` (int): unidades en inventario.

## 2. Programación Orientada a Objetos (POO)

Clases principales propuestas:

- `Producto` (clase de dominio)
  - Atributos privados: `codigo`, `nombre`, `precioUnitario`, `cantidad`.
  - Constructores: vacío y con parámetros.
  - Métodos `get`/`set` para cada atributo.
  - Método `double valorTotal()` que devuelve `precioUnitario * cantidad`.
  - Método `String obtenerFilaFormateada()` que devuelve una fila con formato para la tabla de salida.

- `App` (clase principal con `main`)
  - Contiene el arreglo que almacena `Producto` (se puede usar `Producto[]` o `ArrayList<Producto>`).
  - Implementa el menú interactivo y las operaciones solicitadas.

## 3. Uso obligatorio de un arreglo

El inventario se mantiene en un arreglo de objetos `Producto`. Se puede usar un arreglo de tamaño fijo o un `ArrayList<Producto>` para mayor flexibilidad.

## 4. Menú principal (opciones mínimas)

1. Ingresar datos
   - Permite agregar productos al arreglo.
2. Mostrar datos
   - Presenta todos los registros usando `System.out.printf()` y máscaras numéricas para alinear columnas.
3. Cálculo general (total)
   - Calcula el valor total del inventario (suma de `valorTotal()` de cada producto).
4. Consulta por registro (búsqueda)
   - Busca por `codigo` y muestra los datos del producto si existe.
5. Salir
   - Finaliza la ejecución.

## 5. Validaciones y manejo de excepciones

- Se usan bloques `try`/`catch` para validar entradas numéricas (`double`, `int`) y la opción del menú.
- Al detectar una entrada inválida, se informa y se solicita reintentar; el programa no debe terminar por excepción de formato.

Ejemplos de validaciones a implementar en `App`:
- Validar que `precioUnitario` sea un número positivo.
- Validar que `cantidad` sea un entero no negativo.
- Manejar `InputMismatchException` y `NumberFormatException` al convertir cadenas.

## 6. Formato de salida

Se deberá presentar la lista de productos con alineación y máscaras numéricas, por ejemplo:

```
Código   Nombre                 Precio        Cantidad   Valor total
P001     Leche 1L               $  2.500,00        10   $ 25.000,00
P002     Arroz 1kg              $  3.200,50         5   $ 16.002,50

Total valor inventario: $ 41.002,50
```

Usar `System.out.printf("%-6s %-20s %12s %10d %15s\n", ...)` y `%,.2f` para números con separadores y dos decimales.

## Cómo compilar y ejecutar (Windows - cmd.exe)

Desde la raíz del proyecto donde están las carpetas `src` y `bin` ejecute:

```bat
:: Compilar todas las clases en src y colocar .class en bin
javac -d bin src\\*.java

:: Ejecutar la clase principal
java -cp bin App
```

Si se usa paquetes (package), adapte la compilación y ejecución incluyendo rutas y nombres de paquete.

## Sugerencias y mejoras opcionales

- Persistencia: guardar/leer inventario a/desde CSV o JSON.
- Cambiar a `ArrayList<Producto>` para no limitar la cantidad de productos.
- Añadir pruebas unitarias con JUnit para `Producto` y utilidades.

---

Si quieres, puedo ahora:

- Generar/ajustar automáticamente el código fuente (`Producto.java`, `App.java`) con el menú y validaciones (recomendado).
- Añadir persistencia CSV y ejemplo de archivo.
- Crear pruebas unitarias y un script por lotes para Windows.

Indica qué prefieres que implemente a continuación.

