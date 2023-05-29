public class ListaEliminados{
	private DeletedNode head;
    private DeletedNode tail;
    private int size=0;

     public ListaEliminados() {
        this.head=null;
        this.tail=null;
    }


    public boolean add_DeletedNode(int pid){

        DeletedNode n = new DeletedNode();

        n.setPid(pid);

        if(this.head==null){
            this.head=n;
            this.tail=n;
            this.size++;
            return true;
        }
        this.tail.setNext(n);
        this.tail=n;
        this.size++;
        
        return true;
    }

    public void printDeletedList(){


        if(is_empty()){
            System.out.println("Lista eliminados vacia");
            return ;
        }


        DeletedNode t = new DeletedNode();
        t=this.head;
        System.out.print("--------Lista de procesos eliminados");
        System.out.println("--------");

        for (; t!=this.tail;t=t.getNext()){
            System.out.println("Proceso: "+t.getPid());    
        }
        System.out.println("Proceso: "+t.getPid()); 
        
    }

    public boolean is_empty(){
        if(this.head==null && this.tail==null){
            return true;
        }
        return false;
    }

}