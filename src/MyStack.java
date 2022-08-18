import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {
    Queue q;

    public MyStack() {
        q=new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        q.add(x);
        int sz = q.size();
        while (sz > 1) {
            q.add(q.remove());
            sz--;
        }
    }
    
    public int pop() {
       return (int) q.remove();
    }
    
    public int top() {
          return (int)q.peek();
    }
    
    public boolean empty() {
        return q.peek()==null?true:false;
    }
    public static void main(String args[]){
        MyStack st=new MyStack();
        st.push(1);
        System.out.println(st.top());
        st.push(3);
        st.push(2);
        System.out.println(st.pop());
        System.out.println(st.top());
    }
}
