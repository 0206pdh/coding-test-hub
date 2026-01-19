import java.util.*;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.StreamTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int currentWeight =0;
		
		int count=0;
		int i=0;
		
		st = new StringTokenizer(br.readLine());
		int [] truck_weight = new int[n];
		for (int j=0; j<n; j++) {
			truck_weight[j] = Integer.parseInt(st.nextToken());
			//System.out.print(truck_weight[j]+ " ");
		}
		//System.out.println(" ");
		
		Queue<Integer> q = new LinkedList<>(); // 다리 위 트럭
		while(q.size() < w) {
			q.offer(0);
		}
		//System.out.println("before queue");
		
		while(i < n || currentWeight > 0) {
			//System.out.println("enter queue n num : " + n);
			int out = q.poll();
			currentWeight -= out;
			//count++;
			//System.out.println("currnetWeight in while : " + currentWeight);
			//System.out.println("i index in while : " + i);
			
			
			if(i < n && currentWeight + truck_weight[i] <= L) {
				//System.out.println("if n num : " + n);
				//q.poll();
				//System.out.println("i index : " + i);
				//System.out.println("truck weight : " + truck_weight[i]);
				q.offer(truck_weight[i]);
				count++;
				//S/ystem.out.println("offer count : " + count);
				
				currentWeight += truck_weight[i];
				//System.out.println("currnetWeight : " + currentWeight);
				
				i++;
				//System.out.println("i index : " + i);
			}
			else {
				//q.poll();
				q.offer(0);
				count++;
				//System.out.println("i index : " + i);
				//System.out.println("truck weight : " + truck_weight[i]);
				//System.out.println("offer 0 count : " + count);
			}
			
			//i++;
		}
		
		System.out.print(count);
	}
}