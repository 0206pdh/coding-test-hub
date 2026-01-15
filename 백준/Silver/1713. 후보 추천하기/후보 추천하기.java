import java.util.*;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.StreamTokenizer;

public class Main {
	static class Student{
		int id;
		int voted;
		int time;
		
		Student(int id, int voted, int time){
			this.id = id;
			this.voted = voted;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		ArrayList<Student> list = new ArrayList<>();
		int time = 0;

		for (int i = 0; i < K; i++) {
		    int x = Integer.parseInt(st.nextToken());
		    boolean existed = false;

		    for (int j = 0; j < list.size(); j++) {
		        if (list.get(j).id == x) {
		            list.get(j).voted++;
		            existed = true;
		            break;
		        }
		    }

		    if (!existed) {
		        if (list.size() == N) {
		            int removeIdx = 0;
		            for (int j = 1; j < list.size(); j++) {
		                Student cur = list.get(j);
		                Student target = list.get(removeIdx);

		                if (cur.voted < target.voted ||
		                   (cur.voted == target.voted && cur.time < target.time)) {
		                    removeIdx = j;
		                }
		            }
		            list.remove(removeIdx);
		        }
		        list.add(new Student(x, 1, time));
		        time++;
		    }
		}

		// 출력
		list.sort((a, b) -> a.id - b.id);
		for (Student s : list) {
		    System.out.print(s.id + " ");
		}

	}
		
}
				

	
