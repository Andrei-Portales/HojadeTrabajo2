import java.util.Vector;;

public class StackVector<E> implements IStack<E> {

	protected Vector<E> data;
	
	public StackVector() {
		data = new Vector<E>();
	}
		
	public void push(E item) 
	// pre: 
	// post: item is added to stack
	// will be popped next if no intervening push
	{
		//Collections.reverse(data);
		data.add(item);
		//Collections.reverse(data);
	}
	   
	   
   public E pop() 
   // pre: stack is not empty
   // post: most recently pushed item is removed and returned
   {
	   return data.remove(size()-1);
   }
   
   public E peek() 
   // pre: stack is not empty
   // post: top value (next to be popped) is returned
   {
	   return data.get(size() - 1);
   }
   
   public boolean empty() 
   // post: returns true if and only if the stack is empty
   {
	   return data.size() == 0;
   }
   
   
   public int size() 
   //post: returns the number of elements in the stack
   {
	   return data.size();
   }
   
}
