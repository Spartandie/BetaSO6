public class ColaProcesos{
    
    private Pnode head;
    private Pnode tail;
    
    private int size=0;

    //private ColaProcesos lista_eliminados = new ColaProcesos();

    public ColaProcesos() {
        this.head=null;
        this.tail=null;
    }

    /*
    //@Override
    public ColaProcesos(Pnode head, Pnode tail) {
        this.head = head;
        this.tail = tail;
    }*/


    public int correrActual(Ram ram, ListaFinalizados lf, ListaEliminados le, int faltantes){
        if(is_empty())
        {
            return 0;
        }

        return this.head.correrProceso(this, lf, ram, le, faltantes);
   
    }

    /**
     * 
     * @return  head es el head de la lista 
     */
    public Pnode getHead() {
        return head;
    }
    /**
     * 
     * @return tail es el tail de la lista
     */
    public Pnode getTail() {
        return tail;
    }
    
    public int getSize(){
        return this.size;
    }

    /*
    /**
     * 
     * @param head es el head de la lista 
     */
    /*
    public void setHead(Pnode head) {
        this.head = head;
    }*/

    /*
    /**
     * 
     * @param tail es el tail de la lista
     */
    /*
    public void setTail(Pnode tail) {
        this.tail = tail;
    }*/
    
     
    /**
     * Añadir al final
     * @param l es la lista
     * @param n es el nodo
     * @return retorna un boolean
     */
    public boolean add_fin(Pnode n){
        if(this.head==null){
            this.head=n;
            this.tail=n;
            n.setPrev(n);
            n.setNext(n);
            size++;
            return true;
        }
        this.head.setPrev(n);
        this.tail.setNext(n);
        n.setNext(this.head);
        n.setPrev(this.tail);
        this.tail=n;

        size++;
        
        return true;
    }

    public boolean print_actual(){
        if(is_empty())
        {
            return false;
        }

        System.out.println("\n-------------------Proceso Actual----------------------\n");

        /*
        Nombre
        id
        Instrucciones totales
        Instrucciones ejecutadas
        Direacciones de memoria asignadas
        Tabla de páginas
        */

        System.out.println("Nombre: "+this.head.getThread().getName());
        System.out.println("Pid: "+this.head.getPid());
        System.out.println("Instrucciones totales: "+this.head.getTotalInstructions());
        System.out.println("Instrucciones ejecutadas: "+this.head.getEjecutadas());

        this.head.getTable().imprimirDirecciones();



        /*
        System.out.println("-------------RAM (localidades) -------");
        for (int i = 0;i<ram.length; i++){
            if (ram[i]!=0){
                System.out.print("Localidad "+i+" tiene el proceso: ");
                System.out.println(ram[i]);
            }
            else {
                System.out.println("Localidad "+i+" vacia");
            }
        }*/


        return true;


    }   

    /**
     * Funcion para imprimir la lista completa
     * @param l es la lista
     * @return boolean
     */
    public boolean print_list(){
        if(is_empty())
        {
            return false;
        }

        Pnode t = new Pnode();
        
        System.out.println("\n------------------- IMPRIMIENDO COLA DE PROCESOS ----------------------\n");
        
        for(t=this.head; t!=this.tail; t=t.getNext()){
            System.out.print("Proceso "+t.getPid()+" \""+t.getThread().getName()+"\"");
            System.out.println(" Size: "+t.getSize());
            System.out.println("");
             
        }
        System.out.print("Proceso "+t.getPid()+" \""+t.getThread().getName()+"\"");
        System.out.println(" Size: "+t.getSize());
        System.out.println("");
        System.out.println("\n-------------------------------------------------------------\n");
        return true;
    }

    
    
    /**
     * Funcion para ver si la lista esta vacia
     * @param l es la lista
     * @return  boolean
     */
    public boolean is_empty(){
        if(this.head==null && this.tail==null){
            System.out.println("Cola vacia");
            return true;
        }
        return false;
    }
   
    /**
     * Funcion para borrar lista
     * @param l es la lista
     * 
     */
    public void del_list(){
        
        
        this.head=null;
        this.tail=null;
        
    }

    /**
     * Elimina el primer nodo
     * @param l es la lista
     */
    public void del_first_node(Ram ram, ListaEliminados le,int faltantes){
        //Checa si cola está vacia


        if(is_empty())
        {
            return;
        }

        
        //Borra proceso de ram
        ram.borrarProceso(this.head);
        if(faltantes !=0){
            //AÑade a eliminados
            le.add_DeletedNode(this.head.getPid());
        }



        //Borra el proceso de la cola
        if(this.head!=this.tail)
        {
            
            //Añade a lista deprocesos interrumpidos (eliminados)
            //if(this.head.getFaltantes()!=0){
                //Añadiralistaeliminados;
            //}

            this.tail.setNext(this.head.getNext());
            this.head.setPrev(null);
            this.head.getNext().setPrev(this.tail);
            this.head.setNext(null);
            this.head=this.tail.getNext();
        }
        else{
            this.head.setPrev(null);
            this.head.setNext(null);
            this.head=null;
            this.tail=null;  
        }

        size--;

        return;
        
    }

    /*
    /**
     * Elimina el ultimo nodo
     * @param l es la lista
     */
    /*
    public void del_last_node(){
        if(this.head!=this.tail){
            this.head.setPrev(this.tail.getPrev());
            this.tail.getPrev().setNext(this.head);
            this.tail.setPrev(null);
            this.tail.setNext(null);
            this.tail=this.head.getPrev();
        }
        else{
            this.tail.setPrev(null);
            this.tail.setNext(null);
            this.head=null;
            this.tail=null;
        }
    }*/


    public void sendCurrentToTail(){
        if(this.head!=this.tail){
            this.head=this.head.getNext();
            this.tail=this.tail.getNext();
            //this.head.setNext(this.)
            //this.tail.setPrev(this.head.getNext())

        }
    }



    
}


