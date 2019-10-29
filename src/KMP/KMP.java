package KMP;

public class KMP {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] pattern= {'d','e','r','y'};
        char[] text= {'g','j','d','e','r','y'};
        int k=pattern.length;
        int prefix[]=new int[k];
        int n=pattern.length;
        prefixtable(pattern,prefix,n);
        Move_PrTable(prefix,n);
        int m=text.length;

        int i=0,j=0;
        while(i<m) {
            if(j==n-1&&text[i]==pattern[j]) {
                System.out.format("found pattern at%d",i-j);
                j=prefix[j];
            }
            if(text[i]==pattern[j]) {
                i++;j++;
            }
            else {
                j=prefix[j];
                if(j==-1) {
                    i++;
                    j++;
                }
            }
        }


    }
    private Object prefix;
    public static void prefixtable(char[] pattern,int[] prefix,int n) {
        prefix[0]=0;
        int len=0;
        int i=1;
        while(i<n) {
            if(pattern[i]==pattern[len]) {
                len++;
                prefix[i]=len;
                i++;
            }
            else {
                if(len>0) {
                    len=prefix[len-1];
                }else {
                    prefix[i]=len;
                    i++;
                }
            }
        }
    }
    public static void Move_PrTable(int[]prefix,int n ) {
        int i;
        for(i=n-1;i>0;i--) {
            prefix[i]=prefix[i-1];

        }
        prefix[0]=-1;
    }


}

