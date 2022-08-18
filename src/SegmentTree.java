import java.util.ArrayList;

public class SegmentTree {
    static int[] st;
public static void buildSegTree(int st_idx,int[] arr,int s,int e){
   
    if(s>e) return;
    if(s==e){
        st[st_idx] =arr[s];
        return;
    }
    int mid=s+((e-s)/2);
    buildSegTree(2*st_idx,arr,s,mid);
    buildSegTree(2*st_idx+1,arr,mid+1,e);
    st[st_idx]=st[2*st_idx]+st[2*st_idx+1];
}
public static int query(int qs,int qe,int st_idx,int s,int e){
    if(qs<s || qe>e){
        return 0;
    }
    if(s>=qs && e<=qe){
        return st[st_idx];
    }
    int mid=s+((e-s)/2);
    int lsum=query(qs,qe,2*st_idx,s,mid);
    int rsum=query(qs,qe,2*st_idx+1,mid+1,e);
    return lsum+rsum;
}
public static void updateNode(int st_idx,int s,int e, int pos,int newValue){
    if(s>pos || e<pos) return;
    if(s==e){//total overlap
        st[st_idx]=newValue;
        return;
    }

    //internal node update
    int mid=s+(e-s)/2;
    updateNode(2*st_idx,s,mid,pos,newValue);
    updateNode(2*st_idx+1,mid+1,e,pos,newValue);
    st[st_idx]=st[2*st_idx]+st[2*st_idx+1];

}

public static void main(String[] args) {
    int n=6;
    int[] arr={1,3,2,-2,4,5};
    st = new int[(arr.length*4)+1];
    
    int st_idx=1;
    int start=0,end=n-1;
    buildSegTree(st_idx,arr,start,end);
    for(int x: st)
    System.out.println(x);
    System.out.println(query(2,5,st_idx,start,end));
    //update
    updateNode(st_idx,start,end,2,100);
}
}
