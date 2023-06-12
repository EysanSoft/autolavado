package autolavado;
import java.util.Scanner;
import autolavado.DTO.DTO;

public class Servicios extends Autolavado {
    
    public int extra[] = new int[3];
    public int total;
    public int pago = 0;
    public int cambio = 0;
    public String tamaño;
    
    public void lavarAuto(DTO dato) {
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println(" ");
            System.out.println("Ingrese el tipo de su vehiculo");
            System.out.println("1. Motos/Bicicletas $" + dato.getPrecios1());
            System.out.println("2. Automoviles $" + dato.getPrecios2());
            System.out.println("3. Camionetas doble cabina $" + dato.getPrecios3());
            System.out.println("4. Camiones de transporte/Carga $" + dato.getPrecios4());
            System.out.print("Tipo: ");
            opcion = teclado.nextInt();
            switch(opcion) {
                case 1: tamaño = "Motos/Bicicletas"; cobrar(dato); break;
                case 2: tamaño = "Automoviles"; salir = 1; break;
                case 3: tamaño = "Camionetas doble cabina"; salir = 1; break;
                case 4: tamaño = "Camiones de transporte/Carga"; salir = 1; break;
                default: System.out.println("Opcion no valida.");
            }  
        }
        while(salir != 1);
        salir = 0;
        if(!"Motos/Bicicletas".equals(tamaño)){
            do{
                System.out.println(" ");
                System.out.println("¿Quiere un lavado de motor? (son " + dato.getPrecios5() + " pesos extra)");
                System.out.println("1. Si");
                System.out.println("2. No");
                System.out.print("Opcion: ");
                opcion = teclado.nextInt();
                switch(opcion) {
                    case 1: extra[0] = 1; salir = 1; break;
                    case 2: salir = 1; break;
                    default: System.out.println("Opcion no valida.");
                }  
            }
            while(salir != 1);
            salir = 0;
            do{
                System.out.println(" ");
                System.out.println("¿Quiere un lavado de tapizado? (son " + dato.getPrecios6() + " pesos extra)");
                System.out.println("1. Si");
                System.out.println("2. No");
                System.out.print("Opcion: ");
                opcion = teclado.nextInt();
                switch(opcion) {
                    case 1: extra[1] = 1; salir = 1; break;
                    case 2: salir = 1; break;
                    default: System.out.println("Opcion no valida.");
                }  
            }
            while(salir != 1);
            salir = 0;
            do{
                System.out.println(" ");
                System.out.println("¿Quiere una pulida completa en su vehiculo? (son " + dato.getPrecios7() + " pesos extra)");
                System.out.println("1. Si");
                System.out.println("2. No");
                System.out.print("Opcion: ");
                opcion = teclado.nextInt();
                switch(opcion) {
                    case 1: extra[2] = 1; salir = 1; break;
                    case 2: salir = 1; break;
                    default: System.out.println("Opcion no valida.");
                }  
            }
            while(salir != 1);
            salir = 0;
            cobrar(dato);
        }
    }
    
    public void cobrar(DTO dato) {
        int num = 0;
        Scanner teclado = new Scanner(System.in);
        if(tamaño.equals("Motos/Bicicletas")) {
            total = total + dato.getPrecios1();
            num = 1;
            System.out.println(" ");
            System.out.println("Sera un total de " + total + " pesos");
            System.out.print("Pago: ");
            pago = teclado.nextInt();
            cambio = total - pago;
            if(cambio > 0) {
                System.out.println("Pago insuficiente, regresara al menu");
                total = 0;
                cambio = 0;
                extra[0] = 0;
                extra[1] = 0;
                extra[2] = 0;
                dato.setEspaciosDisponibles(dato.getEspaciosDisponibles() + 1);
                switch(dato.getEspaciosDisponibles()) {
                    case 5: dato.setId1("nada");
                    case 4: dato.setId2("nada");
                    case 3: dato.setId3("nada");
                    case 2: dato.setId4("nada");
                    case 1: dato.setId5("nada");
                    case 0: dato.setId6("nada");
                }
                dato.setAutosDia(dato.getAutosDia() - 1);
                System.out.println(" ");
                Autolavado acceder = new Autolavado();
                acceder.elegirOpciones();
            }
            else{
                cambio = cambio * -1;
                dato.setGananciasDia(dato.getGananciasDia() + total);
                System.out.println("Gracias, aqui esta su ticket, y recuerde retirar su coche"); 
                generarTicket(dato,num);
                Autolavado acceder = new Autolavado();
                acceder.elegirOpciones();
            }
        }
        if(tamaño.equals("Automoviles")) {
            total = total + dato.getPrecios2();
        }
        if(tamaño.equals("Camionetas doble cabina")) {
            total = total + dato.getPrecios3();
        }
        if(tamaño.equals("Camiones de transporte/Carga")) {
            total = total + dato.getPrecios4();
        }
        if(extra[0] == 1){
            total = total + dato.getPrecios5();
        }
        if(extra[1] == 1){
            total = total + dato.getPrecios6();
        }
        if(extra[2] == 1){
            total = total + dato.getPrecios7();
        }
        System.out.println(" ");
        System.out.println("Sera un total de " + total + " pesos");
        System.out.print("Pago: ");
        pago = teclado.nextInt();
        cambio = total - pago;
        if(cambio > 0) {
            System.out.println("Pago insuficiente, regresara al menu");
            total = 0;
            cambio = 0;
            extra[0] = 0;
            extra[1] = 0;
            extra[2] = 0;
            dato.setEspaciosDisponibles(dato.getEspaciosDisponibles() + 1);
            switch(dato.getEspaciosDisponibles()) {
                case 5: dato.setId1("nada");
                case 4: dato.setId2("nada");
                case 3: dato.setId3("nada");
                case 2: dato.setId4("nada");
                case 1: dato.setId5("nada");
                case 0: dato.setId6("nada");
            }
            dato.setAutosDia(dato.getAutosDia() - 1);
            System.out.println(" ");
            Autolavado acceder = new Autolavado();
            acceder.elegirOpciones();
        }
        else{
            cambio = cambio * -1;
            dato.setGananciasDia(dato.getGananciasDia() + total);
            System.out.println("Gracias, aqui esta su ticket, y recuerde retirar su coche"); 
            generarTicket(dato);
        }
    }
    
    public void generarTicket(DTO dato) {
        System.out.println("--------------------------------"); 
        System.out.println("            TICKET"); 
        System.out.println("     Autolavado  Hernandez");
        System.out.println("Folio: " + dato.getFolio());
        System.out.println("Tipo de vehiculo: " + tamaño);
        System.out.print("Lavado completo: ");
        if(tamaño.equals("Automoviles")) {
            System.out.println("$" + dato.getPrecios2()); 
            dato.setProducto1(dato.getProducto1() - 1);
        }
        if(tamaño.equals("Camionetas doble cabina")) {
            System.out.println("$" + dato.getPrecios3());
            dato.setProducto1(dato.getProducto1() - 2);
        }
        if(tamaño.equals("Camiones de transporte/Carga")) {
            System.out.println("$" + dato.getPrecios4()); 
            dato.setProducto1(dato.getProducto1() - 3);
        }
        if(extra[0] == 1){
            System.out.print("Lavado de motor: ");
            System.out.println("$" + dato.getPrecios5());
            dato.setProducto2(dato.getProducto2() - 1);
        }
        if(extra[1] == 1){
            System.out.print("Lavado de tapizado: ");
            System.out.println("$" + dato.getPrecios6());
            dato.setProducto3(dato.getProducto3() - 1);
        }
        if(extra[2] == 1){
            System.out.print("Pulida completa: ");
            System.out.println("$" + dato.getPrecios7());
            dato.setProducto4(dato.getProducto4() - 1);
        }
        System.out.println("Total: $" + total);
        System.out.println("Pago: $" + pago);
        System.out.println("Cambio: $" + cambio);
        System.out.println("--------------------------------");
        System.out.println(" ");
        total = 0;
        cambio = 0;
        extra[0] = 0;
        extra[1] = 0;
        extra[2] = 0;
    }
    public void generarTicket(DTO dato, int bandera) {
        System.out.println("--------------------------------"); 
        System.out.println("            TICKET"); 
        System.out.println("     Autolavado  Hernandez");
        System.out.println("Folio: " + dato.getFolio());
        System.out.println("Tipo de vehiculo: " + tamaño);
        System.out.print("Lavado completo: ");
        if(tamaño.equals("Motos/Bicicletas")) {
            System.out.println("$" + dato.getPrecios1()); 
            dato.setProducto1(dato.getProducto1() - 1);
        }
        System.out.println("Total: $" + total);
        System.out.println("Pago: $" + pago);
        System.out.println("Cambio: $" + cambio);
        System.out.println("--------------------------------");
        System.out.println(" ");
        total = 0;
        cambio = 0;
        extra[0] = 0;
        extra[1] = 0;
        extra[2] = 0;
    }
    
    public void administrador(DTO dato) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Antes de continuar, ingrese la contraseña para verifica que eres el administrador");
        System.out.print("Contraseña: ");
        opcion = teclado.nextInt();
        if(opcion == contraseña) {
            System.out.println(" ");
            System.out.println("Estos son los registros de este dia:");    
            System.out.println("Se lavaron en el dia " + dato.getAutosDia()+ " vehiculo(s).");
            System.out.println("Las ganacias del dia son de: " + dato.getGananciasDia() + " peso(s).");
            System.out.println(" ");
            System.out.println("Estos son los productos de limpieza restantes:");
            System.out.println("Shampoo para Vehiculos: " + dato.getProducto1() + " bote(s) de 1Lt");
            System.out.println("Aceite: " + dato.getProducto2() + " bote(s) de 1Lt");
            System.out.println("Abrillantador: " + dato.getProducto3() + " bote(s) de 1Lt");
            System.out.println("Cera Liquida: " + dato.getProducto4() + " bote(s) de 1Lt");
            System.out.println(" ");
            do{
                System.out.println("¿Quiere modificar los precios?");
                System.out.println("1. Si");
                System.out.println("2. No");
                System.out.print("Opcion: ");
                opcion = teclado.nextInt();
                switch(opcion) {
                    case 1:
                    do{
                        System.out.println(" ");
                        System.out.println("¿Que producto desea cambiarle de precio?");
                        System.out.println("1. Lavado de Motos/Bicicletas ($" + dato.getPrecios1() + ")");
                        System.out.println("2. Lavado de Automoviles ($" + dato.getPrecios2() + ")");
                        System.out.println("3. Lavado de Camionetas doble cabina ($" + dato.getPrecios3() + ")");
                        System.out.println("4. Lavado de Camiones de transporte/Carga ($" + dato.getPrecios4() + ")");
                        System.out.println("5. Lavado de Motor ($" + dato.getPrecios5() + ")");
                        System.out.println("6. Lavado de Tapizado ($" + dato.getPrecios6() + ")");
                        System.out.println("7. Pulida Completa  ($" + dato.getPrecios7() + ")");
                        System.out.println("8. Salir");
                        System.out.print("Opcion: ");
                        opcion = teclado.nextInt();
                        switch(opcion) {
                            case 1: System.out.println("Ingrese el nuevo precio a reemplazar (en enteros): ");
                                    System.out.print("Nuevo Precio: ");
                                    opcion = teclado.nextInt();
                                    dato.setPrecios1(opcion); break;
                            case 2: System.out.println("Ingrese el nuevo precio a reemplazar (en enteros): ");
                                    System.out.print("Nuevo Precio: ");
                                    opcion = teclado.nextInt();
                                    dato.setPrecios2(opcion); break;
                            case 3: System.out.println("Ingrese el nuevo precio a reemplazar (en enteros): ");
                                    System.out.print("Nuevo Precio: ");
                                    opcion = teclado.nextInt();
                                    dato.setPrecios3(opcion); break;
                            case 4: System.out.println("Ingrese el nuevo precio a reemplazar (en enteros): ");
                                    System.out.print("Nuevo Precio: ");
                                    opcion = teclado.nextInt();
                                    dato.setPrecios4(opcion); break;
                            case 5: System.out.println("Ingrese el nuevo precio a reemplazar (en enteros): ");
                                    System.out.print("Nuevo Precio: ");
                                    opcion = teclado.nextInt();
                                    dato.setPrecios5(opcion); break;
                            case 6: System.out.println("Ingrese el nuevo precio a reemplazar (en enteros): ");
                                    System.out.print("Nuevo Precio: ");
                                    opcion = teclado.nextInt();
                                    dato.setPrecios6(opcion); break;
                            case 7: System.out.println("Ingrese el nuevo precio a reemplazar (en enteros): ");
                                    System.out.print("Nuevo Precio: ");
                                    opcion = teclado.nextInt();
                                    dato.setPrecios7(opcion); break;
                            case 8: salir = 1; break;
                            default: System.out.println("Opcion no valida.");
                        }    
                    }
                    while(salir != 1);
                    case 2: salir = 1; break;
                    default: System.out.println("Opcion no valida.");
                }  
            }
            while(salir != 1);
            salir = 0;
            System.out.println(" ");
            do{
                System.out.println("¿Quiere abastecer los productos de limpieza?");
                System.out.println("1. Si");
                System.out.println("2. No");
                System.out.print("Opcion: ");
                opcion = teclado.nextInt();
                switch(opcion) {
                    case 1: 
                    do{
                        System.out.println(" ");
                        System.out.println("Elija el producto a abastecer");
                        System.out.println("1. Shampoo para Vehiculos (" + dato.getProducto1() + " bote(s) de 1Lt)");
                        System.out.println("2. Aceite (" + dato.getProducto2() + " bote(s) de 1Lt)");
                        System.out.println("3. Abrillantador (" + dato.getProducto3() + " bote(s) de 1Lt)");
                        System.out.println("4. Cera Liquida (" + dato.getProducto4() + " bote(s) de 1Lt)");
                        System.out.println("5. Salir");
                        System.out.print("Opcion: ");
                        opcion = teclado.nextInt();
                        switch(opcion) {
                            case 1: System.out.println("Ingrese la cantidad botes de Shampoo a ingresar (en enteros): ");
                                    System.out.print("Cantidad: ");
                                    opcion = teclado.nextInt();
                                    dato.setProducto1(dato.getProducto1() + opcion); break;
                            case 2: System.out.println("Ingrese la cantidad de botes de Aceite a ingresar (en enteros): ");
                                    System.out.print("Cantidad: ");
                                    opcion = teclado.nextInt();
                                    dato.setProducto2(dato.getProducto2() + opcion); break;
                            case 3: System.out.println("Ingrese la cantidad de botesitos de Abrillandador a ingresar (en enteros): ");
                                    System.out.print("Cantidad: ");
                                    opcion = teclado.nextInt();
                                    dato.setProducto3(dato.getProducto3() + opcion); break;
                            case 4: System.out.println("Ingrese la cantidad de botes de Cera Liquida a ingresar (en enteros): ");
                                    System.out.print("Cantidad: ");
                                    opcion = teclado.nextInt();
                                    dato.setProducto4(dato.getProducto4() + opcion); break;
                            case 5: salir = 1; break;
                            default: System.out.println("Opcion no valida.");
                        }
                    }
                    while(salir != 1);
                    case 2: salir = 1; break;
                    default: System.out.println("Opcion no valida.");
                }  
            }
            while(salir != 1);
            salir = 0;
        }
        else {
            System.out.println("Contraseña incorrecta"); 
        }
        System.out.println(" ");
    }
}
