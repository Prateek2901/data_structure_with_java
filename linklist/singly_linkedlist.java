package linklist;
import java.util.Scanner;

class Node
{
    protected int data;
    protected Node link;
    public Node()
    {
        link = null;
        data = 0;
    }
    public Node(int data,Node link)
    {
        this.data=data;
        this.link=link;
    }
    public void setLink(Node node)
    {
        this.link=node;
    }
    public void setData(int data)
    {
        this.data=data;
    }
    public int getData()
    {
        return data;
    }
    public Node getLink()
    {
        return link;
    }
}


class linklist
{
    protected Node start;
    protected Node end;
    public int size;
    public linklist()
    {
        start=null;
        end=null;
        size=0;
    }
    public boolean isEmpty()
    {
        return start==null;
    }
    public int getSize()
    {
        return size;
    }
    public void insertAtStart(int val)
    {
        Node nptr= new Node(val,null);
        size++;
        if(start==null)
        {
            start=nptr;
            end=start;
        }
        else
        {
            nptr.setLink(start);
            start=nptr;
        }
    }
    public void insertAtEnd(int val)
    {
        Node ptr=new Node(val,null);
        size++;
        if(start==null)
        {
            start=ptr;
            end=start;
        }
        else
        {
            ptr.setLink(end);
            end=ptr;
        }
    }
    public void insertAtPos(int val,int pos)
    {
        Node ptr=new Node(val,null);
        Node trav=start;
        pos=pos-1;
        for(int i=1;i<size;i++)
        {
            if(pos==i)
            {
                Node n=new Node(val,null);
                Node tmp=trav.getLink();
                trav.setLink(n);
                n.setLink(tmp);
                break;
            }
            ptr=ptr.getLink();
        }
        size++;
    }
    public void deleteAtPos(int pos)
    {
        if(pos==1)
        {
            start=start.getLink();
            size--;
            return;
        }
        if(pos==size)
        {
            Node s=start;
            Node temp=start;
            while(s!=end)
            {
                temp=s;
                s=s.getLink();
            }
            end=temp;
            end.setLink(null);
            size--;
            return;
        }
        Node ptr=start;
        pos=pos-1;
        for(int i=1;i<pos;i++)
        {
            if(pos==i)
            {
                Node del = ptr.getLink();
                del=del.getLink();
                ptr.setLink(del);
                break;
            }
        }
        size--;
    }
    public void display()
    {
        System.out.println("Singly Linklist");
        if(size==0)
        {
            System.out.print("Empty");
            return;
        }
        if(start.getLink()==null)
        {
           System.out.println(start.getData());
           return;
        }
        Node ptr = start;
        System.out.print(start.getData()+"\n");
        ptr=ptr.getLink();
        while(ptr.getLink()!=null)
        {
            System.out.println(ptr.getData()+"->");
            ptr=ptr.getLink();
        }
        System.out.print(ptr.getData()+"\n");
        
        
    }
}




public class Linklist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       linklist list = new linklist();
       char ch;
       do
       {
           System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");            
            int c = sc.nextInt();
            switch(c)
            {
                case 1 : 
                System.out.println("Enter integer element to insert");
                list.insertAtStart( sc.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to insert");
                list.insertAtEnd( sc.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to insert");
                int num = sc.nextInt() ;
                System.out.println("Enter position");
                int pos = sc.nextInt() ;
                if (pos <= 1 || pos > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.insertAtPos(num, pos);
                break;                                          
            case 4 : 
                System.out.println("Enter position");
                int p = sc.nextInt() ;
                if (p < 1 || p > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.deleteAtPos(p);
                break;
            case 5 : 
                System.out.println("Empty status = "+ list.isEmpty());
                break;                   
            case 6 : 
                System.out.println("Size = "+ list.getSize() +" \n");
                break;                         
             default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /*  Display List  */ 
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = sc.next().charAt(0);   
        }while(ch=='Y'||ch=='y');
    }
    
}
