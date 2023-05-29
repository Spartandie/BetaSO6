public class ListaLigada{
	private LinkedNode head;
    private LinkedNode tail;
    private int size=0;

     public ListaLigada() {
        this.head=null;
        this.tail=null;
    }


    public boolean add_LinkedNode(String tipo, int inicio, int size){

        LinkedNode n = new LinkedNode();

        n.setTipo(tipo);
        n.setInicio(inicio);
        n.setSize(size);

        if(this.head==null){
            this.head=n;
            this.tail=n;
            //System.out.println("cabeza tiene"+this.head.getFrame());
            this.size++;
            return true;
        }
        this.tail.setNext(n);
        this.tail=n;
        this.size++;
        
        return true;
    }

    public void printLinkedList(){


        if(is_empty()){
            System.out.println("Lista ligada vacia");
            return ;
        }


        LinkedNode t = new LinkedNode();
        t=this.head;
        int i;
        System.out.print("--------Lista ligada de procesos y huecos");
        System.out.println("--------");
         System.out.println("Tipo   Inicio   Tamaño(Loc)");

        for (; t!=this.tail;t=t.getNext()){
            System.out.println(t.getTipo()+":"+t.getInicio()+":"+t.getSize());        
        }
        System.out.println(t.getTipo()+":"+t.getInicio()+":"+t.getSize());   
        
    }

    public void refreshLinkedList(int[] ram){
        int contador=1;
        int inicia=0;
        int i;
        restartList();


        for (i = 0;i<ram.length ; i++){             
            if (i!=0){
                //Mismo proceso
                if(ram[i] == ram[i-1]){
                    contador++;
                }   
                else//Cambio de proceso 
                {
                    if(ram[i-1]!=0)
                    {
                        //Agrega nodo de proceso con inicia y tamaño
                        add_LinkedNode("P", inicia,contador);
                        //System.out.println("P:"+inicia+":"+contador);
                    }
                    else{
                        //Agrega nodo de hueco con inicia y tamaño
                        add_LinkedNode("H", inicia,contador);
                        //System.out.println("H:"+inicia+":"+contador);
                    }
                    contador=1;
                    inicia=i;
                }
                
        
            }
                    
        }

        if(ram[i-1]!=0){
            add_LinkedNode("P", inicia,contador);
        }
        else{
            add_LinkedNode("H", inicia,contador);
        }
        
    }

    public void restartList(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public boolean is_empty(){
        if(this.head==null && this.tail==null){
            return true;
        }
        return false;
    }

}