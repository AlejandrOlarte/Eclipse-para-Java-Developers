package generado.datos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {

	  // Método para generar archivo de ventas de un vendedor
    public static void createSalesMenFile(int randomSalesCount, String name, long id) {
        Random rand = new Random();
        try (FileWriter writer = new FileWriter(name + "_" + id + "_sales.txt")) {
            for (int i = 0; i < randomSalesCount; i++) {
                writer.write("CC;" + id + "\n");
                for (int j = 0; j < rand.nextInt(5) + 1; j++) { // Entre 1 y 5 productos por venta
                    int productId = rand.nextInt(100) + 1; // IDs entre 1 y 100
                    int quantity = rand.nextInt(10) + 1; // Cantidades entre 1 y 10
                    writer.write(productId + ";" + quantity + ";\n");
                }
            }
            System.out.println("Archivo de ventas generado exitosamente para: " + name);
        } catch (IOException e) {
            System.err.println("Error al generar archivo de ventas: " + e.getMessage());
        }
    }

    // Método para generar archivo de información de vendedores
    public static void createSalesManInfoFile(int salesmanCount) {
        String[] names = {"Juan", "Maria", "Pedro", "Luis", "Ana"};
        String[] lastNames = {"Perez", "Gomez", "Rodriguez", "Lopez", "Diaz"};
        Random rand = new Random();

        try (FileWriter writer = new FileWriter("salesmen_info.txt")) {
            for (int i = 0; i < salesmanCount; i++) {
                String name = names[rand.nextInt(names.length)];
                String lastName = lastNames[rand.nextInt(lastNames.length)];
                long id = 100000000L + rand.nextInt(99999999); // IDs pseudoaleatorios
                writer.write("CC;" + id + ";" + name + ";" + lastName + "\n");
            }
            System.out.println("Archivo de información de vendedores generado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al generar archivo de información de vendedores: " + e.getMessage());
        }
    }

    // Método para generar archivo de productos
    public static void createProductsFile(int productsCount) {
        String[] productNames = {"Manzana", "Banana", "Naranja", "Leche", "Pan"};
        Random rand = new Random();

        try (FileWriter writer = new FileWriter("products_info.txt")) {
            for (int i = 0; i < productsCount; i++) {
                int productId = i + 1;
                String productName = productNames[rand.nextInt(productNames.length)];
                double price = rand.nextDouble() * 10 + 1; // Precios entre 1 y 10 unidades
                writer.write(productId + ";" + productName + ";" + String.format("%.2f", price) + "\n");
            }
            System.out.println("Archivo de productos generado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al generar archivo de productos: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        // Generar archivos de prueba
        createSalesMenFile(10, "Maria Perez", 123456789L);
        createSalesManInfoFile(5);
        createProductsFile(10);
    }
}










