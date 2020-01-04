package DTGH;

public class knapsackProblem {
    public static void main(String[] args) {
        int[] w = {1,4,3};
        int[] val={1500,2000,3000};



        int m=4; //背包数量
        int n=val.length;
        int[][] path=new int[n+1][m+1];//为了记录商品存入的情况
        int[][] v=new int[n+1][m+1];//表示前i个商品中能装入容量为j的背包的最大价值
        for(int i=0;i<v.length;i++){
            v[i][0]=0;
        }
        for(int i=0;i<v[0].length;i++){
            v[0][i]=0;
        }


//i为物品数量   j为背包可存放的商品重量
        for(int i=1;i<v.length;i++){
            for(int j=1;j<v[0].length;j++){
                if(w[i-1]>j){
                    v[i][j]=v[i-1][j];
                }else{
                   // v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    if(v[i-1][j]<v[i-1][j]+v[i-1][j-w[i-1]]){
                        v[i][j]=v[i-1][j]+v[i-1][j-w[i-1]];
                        path[i][j]=1;
                    }else{
                        v[i][j]=v[i-1][j];
                    }
                }
            }
        }


        int i=v.length-1;
        int j=v[0].length-1;
        while(i>0&&j>0){
            if(path[i][j]==1){
                System.out.println("第I个商品放了");
                System.out.println(i);
                j-=w[i-1];
            }
            i=i-1;
        }

     }
}
