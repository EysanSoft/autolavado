package autolavado;
import java.util.Scanner;
import autolavado.DTO.DTO;

public class Autolavado implements Interface {
    
    Scanner teclado = new Scanner(System.in);
   
    public int opcion;
    public int contraseña = 123456;
    public int salir = 0;
    public String idEquivalente;
    
    public void elegirOpciones() {
        DTO dato = new DTO();
        do{
            if(dato.getProducto1() - 3 <= 0){
            System.out.println("Queda muy poco Shampoo para autos, Administrador, abastezca de INMEDIATO mas por favor.");  
            System.out.println("¡Avise al administrador que acuda al sistema por favor cliente!."); 
            Servicios acceder = new Servicios(); 
            acceder.administrador(dato);
            }
            if(dato.getProducto2() - 1 <= 0){
            System.out.println("Queda muy poco Aceite, Administrador, abastezca de INMEDIATO mas por favor.");  
            System.out.println("¡Avise al administrador que acuda al sistema por favor cliente!."); 
            Servicios acceder = new Servicios(); 
            acceder.administrador(dato);   
            }
            if(dato.getProducto3() - 1 <= 0){
            System.out.println("Queda muy poco Abrillantador para autos, Administrador, abastezca de INMEDIATO mas por favor.");  
            System.out.println("¡Avise al administrador que acuda al sistema por favor cliente!."); 
            Servicios acceder = new Servicios(); 
            acceder.administrador(dato);    
            }
            if(dato.getProducto4() - 1 <= 0){
            System.out.println("Queda muy poca Seda Liquida para autos, Administrador, abastezca de INMEDIATO mas por favor.");  
            System.out.println("¡Avise al administrador que acuda al sistema por favor cliente!."); 
            Servicios acceder = new Servicios(); 
            acceder.administrador(dato);    
            }
            
            System.out.println("Estas en un autolavado, ¿que quieres hacer?");
            System.out.println("1. Ingresar vehiculo");
            System.out.println("2. Recibir vehiculo");
            System.out.println("3. Opciones de Administrador");
            System.out.println("4. Terminar el programa");
  
            try {
                opcion = leerEnteros(); 
            }
            catch(Exception e) {
                System.out.println("Ingrese solo numeros enteros.");
                opcion = 0; break;
            }
           
            switch(opcion) {
                case 1: System.out.println(" "); ingresarAuto(dato); dato.setFolio(dato.getFolio() + 1); dato.setAutosDia(dato.getAutosDia() + 1); break;
                case 2: System.out.println(" "); entregarAuto(dato); break;
                case 3: System.out.println(" "); Servicios acceder = new Servicios(); acceder.administrador(dato); break;
                case 4: salir = 1; break;
                default: System.out.println(" "); System.out.println("Opcion no valida.");
            }
        }
        while(salir != 1);  
    }
    
    public void ingresarAuto(DTO dato) {
        Scanner teclado = new Scanner(System.in);
        if(dato.getEspaciosDisponibles() == -1) {
        System.out.println("Todos los espacios estan ocupados, regrese mas tarde.");
        System.out.println(" ");
        elegirOpciones();
        }
        if(dato.getEspaciosDisponibles() >  0 || dato.getEspaciosDisponibles() < 5) {
        dato.setEspaciosDisponibles(dato.getEspaciosDisponibles() + 1);
        System.out.println("Actualmente, hay " + dato.getEspaciosDisponibles() + " espacio(s) disponible(s).");
        dato.setEspaciosDisponibles(dato.getEspaciosDisponibles() - 1);
        }
        System.out.println("Ingrese un identificador, para luego recoger su vehiculo");
        System.out.print("ID: ");
        if(dato.getEspaciosDisponibles() == 5) {
            dato.setId1(teclado.nextLine());   
        }
        if(dato.getEspaciosDisponibles() == 4) {
            dato.setId2(teclado.nextLine());   
        }
        if(dato.getEspaciosDisponibles() == 3) {
            dato.setId3(teclado.nextLine());   
        }
        if(dato.getEspaciosDisponibles() == 2) {
            dato.setId4(teclado.nextLine());   
        }
        if(dato.getEspaciosDisponibles() == 1) {
            dato.setId5(teclado.nextLine());   
        }
        if(dato.getEspaciosDisponibles() == 0) {
            dato.setId6(teclado.nextLine());   
        }
        dato.setEspaciosDisponibles(dato.getEspaciosDisponibles() - 1);
        Servicios hacer = new Servicios();
        hacer.lavarAuto(dato);
        System.out.println(" ");
    }
    
    public void entregarAuto(DTO dato) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el identificador para recibir su vehiculo");
        System.out.print("ID: ");
        idEquivalente = teclado.nextLine();
        if(idEquivalente.equals(dato.getId6())){
        dato.setId6("nada");
        System.out.println("Retiro su vehiculo, ¡Gracias por su preferencia!");
        dato.setEspaciosDisponibles(dato.getEspaciosDisponibles() + 1);
        }
        if(idEquivalente.equals(dato.getId5())){
        dato.setId5("nada");
        System.out.println("Retiro su vehiculo, ¡Gracias por su preferencia!");
        dato.setEspaciosDisponibles(dato.getEspaciosDisponibles() + 1);  
        }
        if(idEquivalente.equals(dato.getId4())){
        dato.setId4("nada");
        System.out.println("Retiro su vehiculo, ¡Gracias por su preferencia!");
        dato.setEspaciosDisponibles(dato.getEspaciosDisponibles() + 1);   
        }
        if(idEquivalente.equals(dato.getId3())){
        dato.setId3("nada");
        System.out.println("Retiro su vehiculo, ¡Gracias por su preferencia!");
        dato.setEspaciosDisponibles(dato.getEspaciosDisponibles() + 1); 
        }
        if(idEquivalente.equals(dato.getId2())){
        dato.setId2("nada");
        System.out.println("Retiro su vehiculo, ¡Gracias por su preferencia!");
        dato.setEspaciosDisponibles(dato.getEspaciosDisponibles() + 1);  
        }
        if(idEquivalente.equals(dato.getId1())){
        dato.setId1("nada");
        System.out.println("Retiro su vehiculo, ¡Gracias por su preferencia!");
        dato.setEspaciosDisponibles(dato.getEspaciosDisponibles() + 1);
        }
        System.out.println(" ");
    }
    
    public int leerEnteros() throws Exception {
      System.out.print("Opcion: ");
      opcion = teclado.nextInt();
      return opcion;
    } 
    public static void main(String[] args) {
        Autolavado metodo = new Autolavado();
         metodo.elegirOpciones();
    }
}
