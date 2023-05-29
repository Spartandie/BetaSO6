public class PageNode{

	private int frame;
    private PageNode next;
    private int size;

    public PageNode()
    {
    	this.next=null;
 
    }
    
    public void setFrame(int frame){
    	this.frame=frame;
    }

    public PageNode getNext(){
    	return this.next;
    }

    public void setNext(PageNode n){
    	this.next=n;
    }

    public int getFrame(){
    	return this.frame;
    }

}

/*
1:Bug en menú de que no cabe 
2:Ya
3:Ya
4:Ya
5:Ya
6:Ya
7:Ya
8:Ya
9:No
10:
*/