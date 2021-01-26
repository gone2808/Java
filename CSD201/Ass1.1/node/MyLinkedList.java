package node;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class MyLinkedList<T> {
    private Node head;
    private Node tail;

    public MyLinkedList() {
        this.head=this.tail=null;
    }
    
    public boolean IsEmpty(){
        return this.head==null;
    }
    
    public void clear(){
        this.head=this.tail=null;
    }
    
    public void addlast(T x){
        Node q = new Node(x);
        if(IsEmpty()){
            head=tail=q;
            return;
        } 
        tail.setNext(q);
        tail=q;
    }
    
    public void addFirst(T x){
         head = new Node(x);
         if(tail==null) tail = head;
    }
    
    public void visit(Node p){
        if(p!=null)
            System.out.println(p.getInfo());
    }

    public void traverse(){
        Node q=head;
        while(q!=null){
            visit(q);
            q=q.getNext();
        }
        System.out.println("");
    }
    public void insertAfter(Node q, T x){
        if(q==null) return;
        Node q1= q.getNext();
        Node t = new Node(x, q1);
        q.setNext(t);
        if(tail==q) tail = t;
    }
    
    public void insertBefore(Node q, T x){
        if(q==null) return;
        if(q==head){
            addFirst(x);
            return ;
        }
        Node p=head;
        while(p!=null && p.getNext()!=head){
            p=p.getNext();
        }
        if(p==null) return; // p is not in the list
        insertAfter(p, x);
    }
    
    public void removeHead(){
        if(IsEmpty()) {
            System.out.println("List is empty");
            return;
        }
        head=head.getNext();
        if(head==null) tail=null;
        System.out.println("Successfully deleted");
    }
    
    public void removeTail(){
        if(IsEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if(head==tail) {
            head=tail=null;
            System.out.println("Sucessfully deleted");
        }
        Node p=head;
        while(p.getNext()!=tail){
            p=p.getNext();
        }
        tail = p;
        tail.setNext(null);
        System.out.println("Sucessfully deleted");
    }
    
    public Node SearchNode(T x){
        if(IsEmpty()) return null;
        Node p=head;
        while(p!=null){
            if(p.getInfo()==x){
                System.out.println("Found node data = "+x);
                 return p;
            }
            p=p.getNext();
            
        }
        System.out.println("Not Found !!");
        return null;
    }
    
    public void remove(Node q){
        if (q == null)
        return;
        if (q == head) {
            removeHead();
            return;
        }
    Node f = head;
    while (f != null && f.getNext() != q)
      f = f.getNext();
    if (f == null)
      return; // q is not in the list
    Node q1 = q.getNext();
    f.setNext(q1);
    if (f.getNext() == null)
      tail = f;
        
    }
    
    public Node pos(int k){
        int i=0;
        Node p=head;
        while(p!=null){
            if(i==k) return p;
            ++i;
            p=p.getNext();
        }
        return null;
    }
    
    public void  removePos(int k){
        remove(pos(k));
    }
    
    public int size(){
        int s=0;
        Node  p=head;
        while(p!=null){
            p=p.getNext();
            s++;
        }
        return s;
    }
    
    public void reverse() {
    MyLinkedList t = new MyLinkedList();
    Node p = head;
    while (p != null) {
      t.addFirst(p.getInfo());
      p = p.getNext();
    }
    head = t.head;
    tail = t.tail;
    }
    
    public void setData(Node p, T x) {
    if (p != null)
      p.setInfo(x);
    }
    
    
}
