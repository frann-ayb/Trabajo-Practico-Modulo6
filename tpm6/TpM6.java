package ar.charlycimino.tpm6;

public class TpM6 {
    public static void main(String[] args) {

        Inventario inventario = new Inventario();

        Producto p1 = new Producto("A1", "Pan", 500, 50, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("V1", "Celular", 250000, 10, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("R11", "Campera", 15000, 25, CategoriaProducto.ROPA);
        Producto p4 = new Producto("H21", "Silla", 12000, 30, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("A2", "Yerba", 1800, 40, CategoriaProducto.ALIMENTOS);

        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);
        inventario.agregarProducto(p5);

        System.out.println("\nListado completo de productos:");
        inventario.listarProductos();

        System.out.println("\nBuscar producto con ID R11:");
        Producto encontrado = inventario.buscarProductoPorId("R11");
        if (encontrado != null) encontrado.mostrarInfo();

        System.out.println("\nProductos categoría ALIMENTOS:");
        inventario.filtrarPorCategoria(CategoriaProducto.ALIMENTOS);

        System.out.println("\nEliminando producto R11...");
        inventario.eliminarProducto("R11");
        System.out.println("Productos restantes:");
        inventario.listarProductos();

        System.out.println("\nActualizando stock de producto H21...");
        inventario.actualizarStock("H21", 45);
        inventario.buscarProductoPorId("H21").mostrarInfo();

        System.out.println("\nTotal de stock disponible: " + inventario.obtenerTotalStock());

        Producto mayor = inventario.obtenerProductoConMayorStock();
        System.out.println("\nProducto con mayor stock: " + mayor);

        System.out.println("\nProductos con precio entre $1000 y $3000:");
        inventario.filtrarProductosPorPrecio(1000, 3000);

        System.out.println("\nCategorías disponibles:");
        inventario.mostrarCategoriasDisponibles();
    }
}
