package PrimAlgorithms;

import java.util.Arrays;

public class prim {
    public static void main(String[] args){
    char[] data=new char[]{'A','B','C','D','E','F','G'};
    int vertex=data.length;
    int[][] weight=new int[][]{
            //10000表示不联通
            {10000,5,7,10000,10000,10000,2},
            {5,10000,10000,9,10000,10000,3},
            {7,10000,10000,10000,8,10000,10000},
            {10000,9,10000,10000,10000,4,10000},
            {10000,10000,8,10000,10000,5,4},
            {10000,10000,10000,4,5,10000,6},
            {2,3,10000,10000,4,6,10000}
    };
    MyGraph mGraph=new MyGraph(vertex);
    MinTree minTree=new MinTree();
    minTree.createGraph(mGraph,vertex,data,weight);
    minTree.showGraph(mGraph);
    minTree.Prim(mGraph,0);

    }
}
//创建最小生成树   村庄图
class MinTree{
    //创建图的临接矩阵
    public void createGraph(MyGraph graph,int vertex,char data[],int[][]weight){
        int i,j;
        for(i=0;i<vertex;i++){
            graph.data[i]=data[i];
            for(j=0;j<vertex;j++){
                graph.weight[i][j]=weight[i][j];
            }
        }
    }
    public void showGraph(MyGraph graph){
        for(int[] link:graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }

    public void Prim(MyGraph graph,int v){
        /*
        v表示从图的第几个顶点开始生成
         */
        int visited[]=new int[graph.vertex];  //标记顶点是否被访问过
        //默认元素为0未访问过
        visited[v]=1;
        int h1=-1;
        int h2=-1;
        int minWeight=10000;//将minWeight初始化为大数,遍历过程中会被替换
        for(int k=1;k<graph.vertex;k++){
            //因为有graph.vertex顶点，prim之后有graph.vertex-1条边

            //确定每一次生成的子图，和哪个节点距离最近
            for(int i=0;i<graph.vertex;i++){      //i结点表示访问过的结点
                                                //j表示还未被访问过的结点
                for (int j=0;j<graph.vertex;j++){
                if(visited[i]==1&&visited[j]==0&&graph.weight[i][j]<minWeight){
            //替换minWeight
                    minWeight=graph.weight[i][j];
                h1=i;
                h2=j;}
                }

            }
            System.out.println("边>"+graph.data[h1]+","+graph.data[h2]+">权值"+minWeight);
            //将这个结点标记为已经访问过
            visited[h2]=1;
            //minWeight重新设置最大值
            minWeight=10000;

        }

    }

}
class MyGraph{
    int vertex;//节点数
    char[] data;//节点数据
    int[][] weight;//存放边，邻接矩阵
    public MyGraph(int vertex){
        this.vertex=vertex;
        data=new char[vertex];
        weight=new int[vertex][vertex];
    }

}