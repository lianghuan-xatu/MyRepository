package Graph;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class Graph {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited;
    public Graph(int n){
        edges=new int[n][n];
        isVisited=new boolean[n];
        numOfEdges=0;
        vertexList=new ArrayList<>();
    }
    public int getFirstNeighbor(int index){
        for(int j=0;j<vertexList.size();j++){
            if(edges[index][j]>0){
                return j;
            }
        }
        return -1;
    }
    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1,int v2){
        for(int j=v2+1;j<vertexList.size();j++){
            if(edges[v1][j]>0){
                return j;
            }
        }  return -1;
    }

    //深度优先搜索
    public void dfs(boolean isVisited[],int i){

        System.out.print(getValByIndex(i)+"=>");
        isVisited[i]=true;
        int  w=getFirstNeighbor(i);
         while(w!=-1){
             if(!isVisited[w]){
                 dfs(isVisited,w);
             }
             w=getNextNeighbor(i,w);
         }


    }
    public void dfs(){
        isVisited=new boolean[vertexList.size()];
        for(int j=0;j<vertexList.size();j++){
            if(!isVisited[j]){
                dfs(isVisited,j);
            }
        }

    }
    //广度优先搜索
    public void bfs(){
        isVisited=new boolean[vertexList.size()];
        for(int j=0;j<vertexList.size();j++){
            if(!isVisited[j]){
                bfs(isVisited,j);
            }
        }

    }

    public void bfs(boolean isVisited[],int i){
        int u;
        int w;
        LinkedList queue=new LinkedList();
        System.out.print(getValByIndex(i)+"=>");
        isVisited[i]=true;
        queue.addLast(i);
        while(!queue.isEmpty()){
            u=(Integer)queue.removeFirst();
           w=getFirstNeighbor(u);
           while(w!=-1){
               if(!isVisited[w]){
                   System.out.print(getValByIndex(w)+"=>");
                  isVisited[w]=true;
                   queue.addLast(w);
               }
              w=getNextNeighbor(u,w);

           }
        }



    }


    public void showGraph(){
        for( int[] link:edges){
            System.out.println(Arrays.toString(link));

        }
    }
    public void insertEdges(int i,int j,int weight){
        edges[i][j]=weight;
        edges[j][i]=weight;
        numOfEdges++;
    }
    public int getWeight(int i,int j){
        return edges[i][j];
    }
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    public int getNumOfEdges(){
        return numOfEdges;
    }
    public int  getNumOfVertex(){
        return vertexList.size();
    }
    public String getValByIndex(int index){
        return vertexList.get(index);
    }
    public static void main(String[] args) {
        int n = 8; //结点数
        String [] Vertaxs={"1","2","3","4","5","6","7","8"};

        Graph graph=new Graph(8);
        for(String str:Vertaxs){
                graph.insertVertex(str);
        }
        graph.insertEdges(0,1,1);
        graph.insertEdges(0,2,1);
        graph.insertEdges(1,3,1);
        graph.insertEdges(1,4,1);
        graph.insertEdges(3,7,1);
        graph.insertEdges(4,7,1);
        graph.insertEdges(2,5,1);
        graph.insertEdges(2,6,1);
        graph.insertEdges(5,6,1);
        graph.showGraph();
        System.out.println();
        System.out.println("深度优先：");
        graph.dfs();
        System.out.println();
        System.out.println("广度优先：");
       
       graph.bfs();



        }
    }
