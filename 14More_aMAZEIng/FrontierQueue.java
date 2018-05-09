import java.util.*;
public class FrontierQueue implements Frontier{
    private ArrayList<Location> q;
    public FrontierQueue(){
	q = new ArrayList<Location>();
    }

    public void add(Location a){
	q.add(a);
    }

    public Location next(){
	return q.remove(0);
    }
    
    public boolean hasNext(){
	return q.size()!= 0;
    }
}
    
