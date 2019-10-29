package Queen;

public class Queen { 
    public static int[][] map=new int[8][8];
    public static int count=0;
    public static void main(String[] args){
            //初始化
       
            for (int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    map[i][j]=0;
                }
                   print();
                System.out.println("-----------------------------------");
                findQueen(0);

                System.out.println(count);

    }}
    public static void findQueen(int i){
        if(i>7){
            count++;
             print();
            return;
        }
        for(int j=0;j<8;j++){
            if(check(i,j)){
                map[i][j]=1;
                findQueen(i+1);
                map[i][j]=0;

            }
        }

    }
    public static boolean check(int k,int j){
        for(int i=0;i<8;i++){
            if(map[i][j]==1){
                return false;
            }
        }
        for(int i=k-1, m=j-1;i>=0&&m>=0;i--,m--){
            if(map[i][m]==1){
                return false;
            }
        }
        for(int i=k-1, m=j+1;i>=0&&m<8;i--,m++){
            if(map[i][m]==1){
                return false;
            }
        }
        return true;
        

    }
    public  static void print(){
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
