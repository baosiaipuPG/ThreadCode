package fork.join;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Max_childString {
	
 
    public static void main(String[] args) {
    	int[] a = {10,-1,2,2,2,2,2,2,-1,10};
    	int n = a.length;
    	int k = 2;
    	int ans = Integer.MIN_VALUE;
		 int[][] sum = new int[n][n];
		 for(int i=0;i<n;i++){
	          sum[i][i]=a[i];
	          if(sum[i][i]>ans) ans=sum[i][i];
	          for(int j=i+1;j<n;j++){
	              sum[i][j]=sum[i][j-1]+a[j];
	              if(sum[i][j]>ans) ans=sum[i][j];
	          }
	      }
//		 for(int i=0;i<n;i++){
//	          for(int j=0;j<n;j++){
//	             System.out.print(sum[i][j]+"  ");  
//	          }
//	          System.out.println();  
//	      }
		   
		 Queue<Integer> temp=new PriorityQueue<Integer>();
		 Set<Integer> add = new HashSet<>();
		 
		 for(int i=0;i<n;i++){
	          for(int j=i;j<n;j++){
	              for(int o=i;o<=j;o++){//���Ҵ�i��jΪ������С��k��
	                  if(a[o]<0) temp.add(a[o]);
	                  if(temp.size()>k) temp.poll();
	              }
	              if((j-i+1)==temp.size()){//ȫΪ��
	                  sum[i][j]=(int)temp.poll();
	                  while(!temp.isEmpty()) temp.poll();//���
	              }else{
	                  while(!temp.isEmpty()){//���
	                      sum[i][j]-= temp.poll();//�������Ƴ�
	                  }
	              }
	  
	              add.clear();//���add
	              //���ڷ�[i,j]����ȡk���������
	              for(int o=i-1;o>=0;o--){
	                  if(a[o]>0) add.add(a[o]);
//	                  if(add.size()>k) add.remove(add.toArray()[0]);
	              }
	              for(int o=j+1;o<n;o++){
	                  if(a[o]>0) add.add(a[o]);
//	                  if(add.size()>k) add.remove(add.toArray()[0]);
	              }
	              List<Integer> addlist =new ArrayList<Integer>(add);
	              addlist=addlist.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	              if(!addlist.isEmpty()){
	            	  for(int o=0;o<k && o<addlist.size() ;o++){
	            		  sum[i][j]+= addlist.get(o);
		              } 
	              }
//	              while(!add.isEmpty()){
//	                  sum[i][j]+= (int)add.toArray()[0];
//	                  add.remove(add.toArray()[0]);
//	              }
	              if(sum[i][j]>ans) ans=sum[i][j];//����ans
	          }
	      }
		 System.out.println(ans);
     

	}
}

