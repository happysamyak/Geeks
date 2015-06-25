package DataStructures;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author Aakansha Doshi
 *
 *I have added insert at end and delete at any position
 */
public class CircularLinkList {
static Node start;	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub		
		CircularLinkList ob=new CircularLinkList();			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("\nEnter 1 for insertion at begining\nEnter 2 for display\nEnter 3 to delete at any position\nEnter 4 to insert at end");
			int choice=Integer.parseInt(br.readLine().trim());
			switch(choice)
			{
			case 1:
				System.out.println("Enter the number to be inserted at begining ");
				int num=Integer.parseInt(br.readLine().trim());				
				ob.insertbegin(num);
				break;
			case 2:
				ob.display();
				break;
			case 3:
				System.out.println("Enter the position to be deleted");
				int pos=Integer.parseInt(br.readLine());
				if(!ob.delete(pos))
				System.out.println("Nothing to delete");
				break;
			case 4:
				System.out.println("Enter the number to be inserted at end ");
				num=Integer.parseInt(br.readLine().trim());				
				ob.insertend(num);
				break;
			default:
				System.exit(0);;
				
			}
			
		}

	}
private void insertend(int num) {
		Node p=new Node();
		p.data=num;
		Node temp=start;
                Node pre=start;
		if(start==null)
		{
			start=p;
			p.link=p;
		}
		else
		{
			while(temp.link!=start)
			{
                                pre=temp;
				temp=temp.link;
			}
			pre.link=p;
			p.link=start;
		}
	}
	private int count()
	{
		Node p=start;
		int c=0;
		if(p!=null){
			while(p.link!=start)
			{
				c++;
				p=p.link;
			}
			c++;
		}
		return c;
	}
private boolean  delete(int pos) {
	//Considering the first node inseretd as the starting position
				Node p=start;int del;
		int i=2;
                Node temp=start;
		int c=count();
		if(c>0)
		{
			if(pos==1)
					{
				                              if(start.link!=start)
                                                             {
                                                                   while(temp.link!=start)
                                                                   temp=temp.link;
                                               
                                                                   }
				System.out.println("pos= "+pos);
				start=start.link;
                                temp.link=start;
                                return 1;

			}
			while(i<pos-1)
			{p=p.link;i++;}
			del=p.link.data;
			p.link=p.link.link;
			if(pos==count()+1){start=p;}
			System.out.println("The deleted node is "+del);return true;}
		else
		{return false;}
	
	}


	private  void display() {
		// TODO Auto-generated method stub
		Node p=start;
		//System.out.println(start.data);
		if(p!=null){
		while(p.link!=start)
		{
			System.out.print(p.data+"-->");
			p=p.link;
		}
		System.out.print(p.data+"\n");
		}
		else
		{
			System.out.println("Empty");
		}
	}

	private  void insertbegin(int num) {
		// TODO Auto-generated method stub
		Node p=new Node();
		p.data=num;
		p.link=start;
		Node temp=start;
		if(start==null)
		{
			System.out.println("inserted first");
			p.link=p;
		}
		else
		{
			while(temp.link!=start)
			{
				temp=temp.link;
			}
			temp.link=p;
		}
		start=p;
		//System.out.println(start.data);
		
		
		
	}	
	private class Node
	{
		int data;
		Node link;
		
	}

	}


