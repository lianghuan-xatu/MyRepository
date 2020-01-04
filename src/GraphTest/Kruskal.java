package GraphTest;

public class Kruskal {
    class Edge{
        private int begin;
        private int end;
        private int weight;
        public Edge(int begin,int end,int weight){
            this.begin=begin;
            this.end=end;
            this.weight=weight;
        }
    }
    private Edge[] edges;
    private int edgeSize;
    public Kruskal(int edgeSize){
        this.edgeSize=edgeSize;
        this.edges=new Edge[edgeSize];
    }
    public void createEdges(){
        edges[0]=new Edge(4,7,7);
        edges[1] = new Edge(2, 8, 8);
        edges[2] = new Edge(0, 1, 10);
        edges[3] = new Edge(0, 5, 11);
        edges[4] = new Edge(1, 8, 12);
        edges[5] = new Edge(3, 7, 16);
        edges[6] = new Edge(1, 6, 16);
        edges[7] = new Edge(5, 6, 17);
        edges[8] = new Edge(1, 2, 18);
        edges[9] = new Edge(6, 7, 19);
        edges[10] = new Edge(3, 4, 20);
        edges[11] = new Edge(3, 8, 21);
        edges[12] = new Edge(2, 3, 22);
        edges[13] = new Edge(3, 6, 24);
        edges[14] = new Edge(4, 5, 26);
    }
    public void functionKruskal(){
        int[] fromTo=new int[edgeSize];
        int sum=0;
        for(int i=0;i<edgeSize;i++){
            int n=find(fromTo,edges[i].begin);
            int m=find(fromTo,edges[i].end);
            if(n!=m){
                fromTo[n]=m;
                System.out.println();
                System.out.println("起始顶点:"+edges[i].begin+"------结束顶点："+edges[i].end);
                sum=sum+edges[i].weight;
            }else{
                System.out.println("第"+i+"条边出现回路");
            }
        }
    }
    private int find(int[] fromTo,int f){
        System.out.print("|||***>"+f);
        while(fromTo[f]>0){
            f=fromTo[f];
            System.out.print("------->"+f);
        }
        return f;
    }
    public static void main(String[] args){
        Kruskal kruskal=new Kruskal(15);
        kruskal.createEdges();
        kruskal.functionKruskal();
    }
    


}
