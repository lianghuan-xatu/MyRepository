package DijkstraAlgorithms;
import java.util.Arrays;

public class Dijkstra {
    public static void main(String[] args){
        char[] vertex={'A','B','C','D','E','F','G'};
        final int N=65535;//表示不可以连接
        int[][] matrix=new int[][]{
                {N, 5, 7, N, N, N, 2},
                {5, N, N, 9, N, N, 3},
                {7, N, N, N, 8, N, N},
                {N, 9, N, N, N, 4, N},
                {N, N, 8, N, N, 5, 4},
                {N, N, N, 4, 5, N, 6},
                {2, 3, N, N, 4, 6, N}
        };
        Graph graph=new Graph(vertex,matrix);
        graph.showGraph();
        graph.dsj(6);
        graph.showDijkstra();

    }}

class Graph{
    private char[] vertex;//顶点数组
    private int[][] matrix;//临接矩阵
    private VisitedVertex vv;
    //构造器
    public Graph(char[] vertex,int[][] matrix){
        this.vertex=vertex;
        this.matrix=matrix;

    }
    public void showGraph(){
        for(int[] link:matrix){
            System.out.println(Arrays.toString(link));
        }
    }
    //迪杰斯特拉算法实现
//index表示出发点对应的下标
    public void dsj(int index){
        vv=new VisitedVertex(vertex.length,index);
        update(index);
        for(int j=1;j<vertex.length;j++){
            index=vv.updateArr();//选择并返回新的访问顶点
            update(index);
        }
    }
    //更新index下标顶点到周围顶点的距离和周围前驱顶点
    private void update(int index){
        int len=0;
//根据遍历我们的临接矩阵matrix[index]行
        for(int j=0;j<matrix[index].length;j++){
//len的含义为出发顶点到index顶点的距离加上从index顶点的到j顶点的距离
            len=vv.getDis(index)+matrix[index][j];
            if(!vv.in(j)&&len<vv.getDis(j)){
                vv.updatePre(j,index);
                vv.updateDis(j,len);
            }
        }
    }
    public void showDijkstra(){
        vv.show();
    }

}

//已访问顶点集合

class VisitedVertex{
    //记录每个顶点是否被访问 1表示访问过 0表示未访问
    public int[] already_arr;
    //每个下标对应的值为前一个顶点，动态更新
    public int[] pre_visited;
    //记录出发顶点到其他所有顶点的距离
    public int[] dis;

    /**
     *
     * @param length 顶点个数
     * @param index 出发点对应的下标，比如G顶点对应下标就是6
     *
     */
    public VisitedVertex(int length,int index){
        this.already_arr=new int[length];
        this.pre_visited=new int[length];
        this.dis=new int[length];

//初始化数组dis
        Arrays.fill(dis,65535);
        this.already_arr[index]=1;//设置出发顶点被访问过
        this.dis[index]=0;//设置出发顶点的访问距离为0

    }

    /**
     * 功能：判断index顶点是否访问过
     * @param index
     * @return 如果访问过返回true
     */
    public boolean in(int index){
        return already_arr[index]==1;
    }

    /**
     * 更新出发顶点到index顶点的距离
     * @param index
     * @param len
     */
    public void updateDis(int index,int len){
        dis[index]=len;
    }

    /**
     * 更新结点的前驱结点为index结点
     * @param pre
     * @param index
     */
    public void updatePre(int pre,int index){
        pre_visited[pre]=index;

    }

    /**
     * 返回出发顶点到index顶点的距离
     * @param index
     */
    public int getDis(int index){
        return dis[index];
    }
    public int updateArr(){
        int min=65535,index=0;
        for(int i=0;i<already_arr.length;i++){
            if(already_arr[i]==0&&dis[i]<min){
                min=dis[i];
                index=i;
            }
        }
        already_arr[index]=1;
        return index;
    }
    //显示最后的结果
    public void show(){
        System.out.println("============================");
        for(int i:already_arr){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i:pre_visited){
            System.out.print(i+" ");
        }System.out.println();
        for(int i:dis){
            System.out.print(i+" ");
        }
//为了好看处理一下
        System.out.println();
        char[] vertex={'A','B','C','D','E','F','G'};
        int count=0;
        for(int i:dis){
            if(i!=65535){
                System.out.print(vertex[count]+"("+i+")" );
            }else{
                System.out.println("N");
            }
            count++;

        }System.out.println();
    }

}
