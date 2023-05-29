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
            System.out.println("------------------------");
            System.out.println("Tabla vacia");
            System.out.println("------------------------");
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
        System.out.println("------------------------");
        
    }


    public void imprimirDirecciones(int[] ram, int pid){
        System.out.println("-------------Localidades asignadas proceso "+pid+"----------");
        for (int i = 0;i<ram.length ; i++){
            if (ram[i]==pid){
                System.out.println("Localidad "+i);
            }
        }
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


