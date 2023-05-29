public class PageTable{

    private PageNode head;
    private PageNode tail;
    private int size=0;


    public PageTable() {
        this.head=null;
        this.tail=null;
    }





    public boolean add_frame(int frame){

        PageNode f = new PageNode();

        f.setFrame(frame);

        if(this.head==null){
            this.head=f;
            this.tail=f;
            System.out.println("cabeza tiene"+this.head.getFrame());
            size++;
            return true;
        }
        this.tail.setNext(f);
        this.tail=f;
        size++;
        
        return true;
    }



    public void printTable(Pnode proceso){
        if(is_empty()){
            System.out.println("Tabla vacia");
            return ;
        }


        PageNode t = new PageNode();
        t=this.head;
        int i;
        System.out.print("--------Tabla de Páginas de proceso "+proceso.getPid());
        System.out.println("--------");
         System.out.println("Página      Marco");

        for (i=0; t!=this.tail;t=t.getNext(),i++ ){
            System.out.println("["+i+"]"+"\t    F# "+t.getFrame());
            //System.out.println("La página "+i+"se conecta con el marco: "+t.getFrame());
            
        }
        System.out.println("["+i+"]"+"\t    F# "+t.getFrame());
        
    }


    public void imprimirDirecciones(){
        PageNode t = new PageNode();
        t=this.head;
        int i;
        System.out.print("--------Direcciones asignadas proceso");
        System.out.println("--------");
         System.out.println("Localidad(proceso)    Localidad(RAM)");

        for (i=0; t!=this.tail;t=t.getNext(),i++ ){

            System.out.println("["+i+"]"+"\t    Localidad: "+(t.getFrame()+1)*16);
            
        }
        System.out.println("["+i+"]"+"\t    Localidad "+(t.getFrame()+1)*16);
    }
   
    public boolean is_empty(){
        if(this.head==null && this.tail==null){
            return true;
        }
        return false;
    }

    
    /**
     * 
     * @return  head es el head de la lista 
     */
    public PageNode getHead() {
        return head;
    }
    /**
     * 
     * @return tail es el tail de la lista
     */
    public PageNode getTail() {
        return tail;
    }
    
    public int getSize(){
        return this.size;
    }

}


