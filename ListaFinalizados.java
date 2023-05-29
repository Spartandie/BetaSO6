public class ListaFinalizados{
	private FinishedNode head;
    private FinishedNode tail;
    private int size=0;

     public ListaFinalizados() {
        this.head=null;
        this.tail=null;
    }


    public boolean add_FinishedNode(int pid){

        FinishedNode n = new FinishedNode();

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

    public void printFinishedList(){
        //System.out.println("ENTREEEEEEEEEEEEEEEEEEEEE");

        if(is_empty()){
            System.out.println("Lista Finalizados vacia");
            return ;
        }


        FinishedNode t = new FinishedNode();
        t=this.head;
        System.out.print("--------Lista de procesos finalizados");
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