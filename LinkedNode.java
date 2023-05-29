public class LinkedNode{
	private LinkedNode next;
    private int size;
    private int inicio;

    private String tipo;

    public LinkedNode()
    {
        this.next=null;
 
    }


    public void setSize(int size){
    	this.size=size;
    }
    
    public int getSize(){
    	return this.size;
    }

    public void setInicio(int inicio){
        this.inicio=inicio;
    }

    public void setTipo(String tipo){
        this.tipo=tipo;
    }

    public LinkedNode getNext(){
        return this.next;
    }

    public void setNext(LinkedNode n){
        this.next=n;
    }

    public int getInicio(){
        return this.inicio;
    }

    public String getTipo(){
        return this.tipo;
    }
    
}

