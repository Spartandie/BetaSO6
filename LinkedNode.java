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

/*
1:Corregir bug
2:
-Lista eliminados
3:Ya
4:Ya
5:Ya
6:
-Asignadas
-Ver tabla
7:Ya
8:Ya
9:Todo xd
*/

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