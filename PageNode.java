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

