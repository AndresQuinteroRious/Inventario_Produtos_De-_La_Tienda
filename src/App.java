
import java.util.ArrayList;
import java.util.Scanner;


class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    // constructor vacio
    public Producto() {
    }

    // constructor con parametros
    public Producto(String codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // metodo to string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("codigo=").append(codigo);
        sb.append(", nombre=").append(nombre);
        sb.append(", precio=").append(precio);
        sb.append(", cantidad=").append(cantidad);
        sb.append('}');
        return sb.toString();
    }

    // metodo para calcular el valor total del inventario de este producto
    public double calcularValorTotal() {
        return precio * cantidad;
    }

    //metodo para mostrar informacion formateada
    public String mostrarInfo() {

        System.out.printf("Codigo: %s\n", codigo);
        System.out.printf("Nombre: %s\n", nombre);
        System.out.printf("Precio: %.2f\n", precio);
        System.out.printf("Cantidad: %d\n", cantidad);
        System.out.printf("Valor Total: %.2f\n", calcularValorTotal());
        return "";
    }


}
public class App {
    private static  ArrayList<Producto> inventario = new ArrayList<>();
    private static  Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int opcion=0;
        do { 
            System.out.println("\n=====MENU PRINCIPAL=====");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. calcular Valor Total del Inventario");
            System.out.println("4. Buscar Producto por Codigo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        agregarProducto();
                        break;
                    case 2:
                        mostrarInventario();
                        break;
                    case 3:
                        calcularValorTotalInventario();
                        break;
                    case 4:
                        buscarProductoPorCodigo();
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un numero valido");
            }
        } while (opcion != 5);
    }
    // metodo para agregar producto
    private static void agregarProducto() {
        try {
            System.out.print("Ingrese el codigo del producto: ");
            String codigo = scanner.nextLine();
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el precio del producto: ");
            double precio = Double.parseDouble(scanner.nextLine());
            System.out.print("Ingrese la cantidad del producto: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            Producto producto = new Producto(codigo, nombre, precio, cantidad);
            inventario.add(producto);
            System.out.println("Producto agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar el producto. Por favor intente de nuevo.");
        }
    }
    // metodo para mostrar productos en el inventario
    private static void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario esta vacio.");
            
        } else {
            System.out.println("\n=====INVENTARIO DE PRODUCTOS=====");
            for (Producto producto : inventario) {
                System.out.println(producto.mostrarInfo());
                System.out.println("---------------------------");
            }
        }
    }
    // metodo para calcular el valor total del inventario
    private static void calcularValorTotalInventario() {
        double valorTotal = 0;
        for (Producto producto : inventario) {
            valorTotal += producto.calcularValorTotal();
        }
        System.out.printf("El valor total del inventario es: %.2f\n", valorTotal);
    }

    // metodo para buscar producto por codigo
    private static void buscarProductoPorCodigo() {
        System.out.print("Ingrese el codigo del producto a buscar: ");
        String codigoBuscado = scanner.nextLine();
        boolean encontrado = false;
        for (Producto producto : inventario) {
            if (producto.getCodigo().equalsIgnoreCase(codigoBuscado)) {
                System.out.println("Producto encontrado:");
                System.out.println(producto.mostrarInfo());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado en el inventario.");
        }
    }
}
