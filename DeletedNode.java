public class DeletedNode{
	private DeletedNode next;
    private int size;
    private int inicio;
    private int pid;

    public DeletedNode()
    {
        this.next=null;
 
    }

    public void setPid(int pid){
        this.pid=pid;
    }

    public int getPid(){
        return this.pid;
    }

    public void setSize(int size){
    	this.size=size;
    }
    
    public int getSize(){
    	return this.size;
    }

    public DeletedNode getNext(){
        return this.next;
    }

    public void setNext(DeletedNode n){
        this.next=n;
    }

    
}

/*
1:Corregir bug
2:
-Lista finalizados
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