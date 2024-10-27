class List{
	private Node start;
	private Node last;
	
	public void addLast(int data){
		Node n1=new Node(data); //-->1
		if(start==null){
			start=n1;
			last=start;
		}else{
			last.next=n1;
			last=last.next;
		}
	}
	public void addFirst(int data){ //push(int)
		Node n1=new Node(data);
		n1.next=start;
		start=n1;
	}
	public void removeFirst(){ //pop()
		if(start!=null){
			start=start.next;
		}
	}
	public void removeLast(){
		if(isEmpty()){
			return;
		}
		if(start.next==null){
			start=null;
		}
		Node beforelast=start;
		while(beforelast.next.next!=null){
			beforelast=beforelast.next;
		}
		beforelast.next=null;
	}
	public void add(int index, int data){
		Node n1=new Node(data);
		Node temp=start;
		Node before=start;
		int i=-1;
		while(temp!=null){
			index++;
			if(i==index){
				n1.next=temp;
				before.next=n1;
				return;
			}
			before=temp;
			temp=temp.next;
		}
	}
	public void remove(int index){
		Node temp=start;
		int i=-1;
		while(temp!=null){
			i++;
			if(i==index){
				
			}
			temp=temp.next;
		}
	}
	public int get(int index){
		Node temp=start;
		int i=-1;
		while(temp!=null){
			i++;
			if(i==index){
				return temp.data;
			}
			temp=temp.next;
		}return -1;
	}
	public void printList(){
		Node temp=start;
		System.out.print("[");
		while(temp!=null){
			System.out.print(temp.data+", ");
			temp=temp.next;
		}
		System.out.println(isEmpty()? "empty]":"\b\b]");		
	}
	public boolean isEmpty(){
		return start==null;
	}
	public int search(int data){
		Node temp=start;
		int index=-1;
		while(temp!=null){
			index++;
			if(temp.data==data){
				return index;
			}
			temp=temp.next;
		}
		return -1;
	}
	public int size(){
		Node temp=start;
		int index=0;
		while(temp!=null){
			index++;
			temp=temp.next;
		}
		return index;
	}
	public void clear(){
		start=null;
	}
	//-----------Inner class---------------
	class Node{
		private int data;
		private Node next;
		Node(int data){this.data=data;}
	}
}
class Demo{
	public static void main(String args[]){
		List list1=new List();
		list1.addLast(10);
		list1.addLast(20);
		list1.addLast(30);
		list1.addLast(40);
		list1.addLast(50);
		list1.printList();//[10,20,30,40,50]
		
		list1.add(3,99);
		list1.printList();//[100,10,20,30,40,50]
		
		list1.removeLast();
		list1.printList();//[100,10,20,30,40,50]
		
		System.out.println(list1.get(2));
	}
}
