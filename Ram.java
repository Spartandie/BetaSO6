import java.util.Scanner;
import java.io.IOException;

public class Ram{
	static Scanner in = new Scanner(System.in);
	static String option;
	static int[] ram = new int[1024];
	static int espacio_disponible=ram.length;

	private ListaLigada linkedList = new ListaLigada();

	/*
		si se crea y se guarda un proceso 
		entonces espacio_disponible=espacio_disponible-psize

		si se elimina un proceso
		entonces espacio_disponible=espacio_disponible+psize;
	*/

	public void guardarProceso(ColaProcesos l,ListaFinalizados lf,ListaEliminados le, Pnode proceso){
	
		if (validar(proceso) == true){
			//hay espacio;
			System.out.println("--------------Proceso "+proceso.getPid()+"------------");
			System.out.println("Ram disponible: "+espacio_disponible);
			System.out.println("Tamaño: "+proceso.getSize());
			System.out.println("Sí hay espacio en RAM");
			System.out.print("Resta: "+espacio_disponible+"-"+proceso.getSize());
			System.out.println(" = "+(espacio_disponible-proceso.getSize()));
			l.add_fin(proceso);
			guardardeadebis_ahorasifinal(proceso);
		}
		else{
			do{
				System.out.println("NO hay espacio en RAM ("+espacio_disponible+")");
				System.out.println("Tamaño de proceso:"+proceso.getSize());
				System.out.println("1.-Ejecutar actual\n2.-Matar actual\n3.-Pasar a siguiente");
				System.out.print("==> ");
				option = in.nextLine();

				switch(option){
				case "1":
					//1.-Debe terminar su ejecucion completamente
					//2.-Tamaño de proceso eliminado debe ser mayor o igual al
					//proceso que queremos meter
					l.correrActual(this,lf, le, proceso.getFaltantes());
					break;
				case "2":
					l.del_first_node(this, le, l.getHead().getFaltantes());
					//le.add_DeletedNode(proceso.getPid());
					System.out.println(espacio_disponible);
					break;
				case "3":
					l.sendCurrentToTail();
					break;
				default:
					
					System.out.println("Opción no valida");
					break;
				}

				if(espacio_disponible>=proceso.getSize()){
					l.add_fin(proceso);
					guardardeadebis_ahorasifinal(proceso);
					break;
				}

			}while(!option.equals("1") || !option.equals("2") || !option.equals("3"));
			
			System.out.println("Proceso guardado con éxito:)");
			//l.add_fin(proceso);
			//guardardeadebis_ahorasifinal(proceso);

			System.out.println("Tamaño: "+proceso.getSize());
			//no hay;
			//menu;
		}
		System.out.println("-------------------");
	}


	public static Boolean validar(Pnode proceso){

		if (proceso.getSize()<=espacio_disponible){
			return true;
		}

		return false;

	}

	public void guardardeadebis_ahorasifinal(Pnode proceso){
		int count = 0;

		for (int i = 0, p = 0;i<ram.length; i++){
			if (ram[i]==0){

					if(count<proceso.getSize())
					{	
						if(count%16==0){
						int marco = (i+1)/16;

						
						proceso.getTable().add_frame(marco);

					}
						ram[i] = proceso.getPid();
						count++;
					}
					else{
						break;
					}
					
			}

		}

		proceso.getTable().printTable(proceso);

		espacio_disponible=espacio_disponible-proceso.getSize();


		linkedList.refreshLinkedList(this.ram);

	}

	public void borrarProceso(Pnode proceso){
		for (int i = 0; i<ram.length;i++ ) {
			if(proceso.getPid()==ram[i]){
				ram[i]=0;
			}
		}
		espacio_disponible=espacio_disponible+proceso.getSize();
		linkedList.refreshLinkedList(this.ram);
		System.out.println("Proceso "+proceso.getPid()+" eliminado con éxito");
	}

	public static void imprimirRam(){
		System.out.println("-------------RAM (localidades) -------");
		System.out.println("N° localidades disponibles: "+espacio_disponible);
		for (int i = 0;i<ram.length ; i++){
			if (ram[i]!=0){
				System.out.print("Localidad "+i+" tiene el proceso: ");
				System.out.println(ram[i]);
			}
			else {
				System.out.println("Localidad "+i+" vacia");
			}
		}
		System.out.println("-------------------");
	}


	public void desfragmentar(){

		/*


			RAM FRAGMENTADA
			P:0:256
			H:256:256
			P:512:512
			*/

			/*RAM DESFRAGMENTADA
			P:0:256
			P:256:512
			H:768:256
		*/
		LinkedNode h = new LinkedNode();
		LinkedNode p = new LinkedNode();
		int baseh;
		int limiteh;
		int basep;
		int limitep;

		do{

			for(h=this.linkedList.getHead();h!=linkedList.getTail();h=h.getNext()){
				if(h.getTipo().equals("H")){
					baseh=h.getInicio();
					limiteh=h.getSize();
					p=h.getNext();
					basep=p.getInicio();
					limitep=p.getSize();
					System.out.println("H:"+baseh+":"+limiteh);
					System.out.println("P:"+basep+":"+limitep);


					for (int i = baseh, j = basep, c=0;c<limiteh;i++,j++,c++){
							ram[i]=ram[j];
							ram[j]=0;
							/*
								0 			1
								0	 		1	
								1 			1
								1 			1
								1           5
								1           .
								5   		.
							*/
					}
					for(int i = baseh+limiteh, j=basep+limiteh,c=0; c<limitep-limiteh;i++,j++,c++){
						ram[i]=ram[j];
						ram[j]=0;
					}

				}
			}
			linkedList.refreshLinkedList(this.ram);
			System.out.println(linkedList.getH());
		}while(linkedList.getH()!=1);

	}



	public void imprimirListaLigada(){
		linkedList.printLinkedList();
	}

	public int[] getRam(){
		return this.ram;
	}


}







