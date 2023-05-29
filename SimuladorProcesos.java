import java.util.Scanner;
import java.io.IOException;


public class SimuladorProcesos{     
	static Scanner in = new Scanner(System.in);
	static String option;


	static int id_count=1;
    static int[] psize = {64, 128, 256, 512};
    static Ram ram = new Ram();
    static ColaProcesos l = new ColaProcesos();
    static ListaFinalizados lf = new ListaFinalizados();
    static ListaEliminados le = new ListaEliminados();


    //Lista listaLocalidades;
    //Lista ffList;
    public static void main(String[] args) {

   		limpiarPantalla();

        do{
            //limpiarPantalla();
            System.out.println("Elija una opción:\n1.-Crear Proceso nuevo\n2.-Ver estado de los procesos");
            System.out.println("3.-Ver estado de la memoria\n4.-Imprimir cola de procesos\n5.-Ver proceso actual");
            System.out.println("6.-Ejecutar proceso actual\n7.-Pasar al proceso siguiente\n8.-Matar proceso actual");
            System.out.print("9.-Desfragmentar memoria\n10.Devmode\n11.Salir\n==>");
            option = in.nextLine();
            //limpiarPantalla();
            switch (option) {
                case "1":
                    //do{
                        System.out.println("----------------Crear Proceso nuevo----------------------");
                        String nombre;
                        System.out.print("Nombre del proceso: ");
                        option = in.nextLine();
                        validarCrear(l, option);
                    do{
                        System.out.println("¿Quieres crear otro proceso?");
                        System.out.println("1.-Sí\n2.-No");
                        System.out.print("==> ");
                        option = in.nextLine();

                        switch (option){
                            case "1":
                                System.out.print("Nombre del proceso: ");
                                option = in.nextLine();
                                validarCrear(l, option);
                                break;

                            case "2":
                                break;

                            default:
                                System.out.print("Opción invalida, ");
                                System.out.print("Opción invalida, ");
                                break;
                        }
                    }while(!option.equals("2"));
                	

                    break;
                case "2":
                    estadoProcesos();
                    break;
                case "3":
                    estadoMemoria();
                    break;
                case "4":
                    imprimirCola();
                    break;
                case "5":
                    verActual();
                    break;
                case "6":
                    ejecutarActual();
                    break;
                case "7":
                    pasarSiguiente();
                    break;
                case "8":
                    matarActual();
                    break;

                case "9":
                    desfragmentarMemoria();
                    break;    

                case "10":
                    //Aquí va cualquier cosa que queramos testear

                    ram.imprimirRam();

                    
                    break;    

                case "11":
                    salir();
                    break;  

                default:
                    System.out.println("Opción no válida");
                    break;  
            }
        }while (!option.equals("11"));
    }

    public static void limpiarPantalla(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static void validarCrear(ColaProcesos l, String nombre){
        Pnode a = new Pnode();
        a.crearProceso(id_count, psize, nombre, l, ram, lf, le);
        id_count++;
        a.getThread().run();
    }

    public static void estadoProcesos(){
    	System.out.println("Ver estado de los procesos");

        System.out.println("N° de procesos listos: "+l.getSize());
        lf.printFinishedList();
        le.printDeletedList();
    }

    public static void estadoMemoria(){
    	System.out.println("Ver estado de la memoria");
        ram.imprimirListaLigada();
    }

    public static void imprimirCola(){
    	l.print_list();
    }


    public static void verActual(){
    	System.out.println("Ver proceso actual");
    	l.print_actual();
    }


    public static void ejecutarActual(){
    	System.out.println("Ejecutar proceso actual");
    	l.correrActual(ram, lf, le, l.getHead().getFaltantes());
    }


    public static void pasarSiguiente(){
    	System.out.println("Pasar al proceso siguiente");
        l.sendCurrentToTail();
    }

    public static void matarActual(){
    	System.out.println("Matar proceso actual");
        l.del_first_node(ram, le, l.getHead().getFaltantes());
    }

    public static void desfragmentarMemoria(){
    	System.out.println("desfragmentarRAM");
    }

    public static void salir(){
    	System.out.println("Salir del programa");
    	System.out.println("Presiona enter para salir");
    	limpiarPantalla();
    	//option = in.nextLine();
    }


}


