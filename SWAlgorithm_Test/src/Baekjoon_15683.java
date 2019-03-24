import java.util.*;

public class Baekjoon_15683{
	static Scanner sc = new Scanner(System.in);
	static int n, m, ans = Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<Node> list = new ArrayList<Node>();
	 
	public static void main(String [] args) {
	    n = sc.nextInt();
	    m = sc.nextInt();
	    map = new int[n][m];
	 
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            int v = sc.nextInt();
	            map[i][j] = v;
	            if (1 <= v && v <= 5) {
	                list.add(new Node(i, j, v));
	            }
	        }
	    }
	    search(0, map);
	    System.out.println(ans);
	    for(int i = 0; i < n; i ++) {
        	for(int j = 0; j < m; j ++)
        		System.out.print(map[i][j] + " ");
        	System.out.println();
        }
	}
	 
	public static void search(int cctvIndex, int[][] prev) {
	    int[][] visited = new int[n][m];
	    if (cctvIndex == list.size()) {
	        int temp = 0;
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                if (prev[i][j] == 0) {
	                    temp++;
	                }
	            }
	        }
	        System.out.println("Temp : " + temp);
	        if (temp < ans) {
	            ans = temp;
	        }
	        for(int i = 0; i < n; i ++) {
	        	for(int j = 0; j < m; j ++)
	        		System.out.print(map[i][j] + " ");
	        	System.out.println();
	        }
	        System.out.println();
	        
	    } else {
	        Node node = list.get(cctvIndex);
	        int idx = node.idx;
	        int x = node.x;
	        int y = node.y;
	 
	        switch (idx) {
	            case 1:
	                for (int k = 0; k < 4; k++) {
	                    for (int i = 0; i < n; i++) {
	                        visited[i] = Arrays.copyOf(prev[i], m);
	                    }
	                    detect(visited, y, x, k);
	                    search(cctvIndex + 1, visited);
	                }
	                for(int i = 0; i < n; i ++) {
        	        	for(int j = 0; j < m; j ++)
        	        		System.out.print(visited[i][j] + " ");
        	        	System.out.println();
        	        }
                    System.out.println();
	                break;
	            case 2:
	                for (int k = 0; k < 2; k++) {
	                    for (int i = 0; i < n; i++) {
	                        visited[i] = Arrays.copyOf(prev[i], m);
	                    }
	                    detect(visited, y, x, k);
	                    detect(visited, y, x, k + 2);
	                    search(cctvIndex + 1, visited);
	                }
	                for(int i = 0; i < n; i ++) {
        	        	for(int j = 0; j < m; j ++)
        	        		System.out.print(visited[i][j] + " ");
        	        	System.out.println();
        	        }
                    System.out.println();
	                break;
	            case 3:
	                for (int k = 0; k < 4; k++) {
	                    for (int i = 0; i < n; i++) {
	                        visited[i] = Arrays.copyOf(prev[i], m);
	                    }
	                    detect(visited, y, x, k);
	                    detect(visited, y, x, (k + 1) % 4);
	                    search(cctvIndex + 1, visited);
	                }
	                break;
	            case 4:
	                for (int k = 0; k < 4; k++) {
	                    for (int i = 0; i < n; i++) {
	                        visited[i] = Arrays.copyOf(prev[i], m);
	                    }
	                    detect(visited, y, x, k);
	                    detect(visited, y, x, (k + 1) % 4);
	                    detect(visited, y, x, (k + 2) % 4);
	                    search(cctvIndex + 1, visited);
	                }
	                break;
	            case 5:
	                for (int i = 0; i < n; i++) {
	                    visited[i] = Arrays.copyOf(prev[i], m);
	                }
	                detect(visited, y, x, 0);
	                detect(visited, y, x, 1);
	                detect(visited, y, x, 2);
	                detect(visited, y, x, 3);
	                search(cctvIndex + 1, visited);
	                for(int i = 0; i < n; i ++) {
        	        	for(int j = 0; j < m; j ++)
        	        		System.out.print(visited[i][j] + " ");
        	        	System.out.println();
        	        }
                    System.out.println();
	                break;
	        }
	    }
	}
	 
	public static void detect(int[][] visited, int i, int j, int direction) {
	    switch (direction) {
	        case 0:
	            for (int k = j; k >= 0; k--) {
	                if (map[i][k] == 6) {
	                    break;
	                }
	                visited[i][k] = 7;
	            }
	            break;
	        case 1:
	            for (int k = i; k >= 0; k--) {
	                if (map[k][j] == 6) {
	                    break;
	                }
	                visited[k][j] = 7;
	            }
	            break;
	        case 2:
	            for (int k = j; k < m; k++) {
	                if (map[i][k] == 6) {
	                    break;
	                }
	                visited[i][k] = 7;
	            }
	            break;
	        case 3:
	            for (int k = i; k < n; k++) {
	                if (map[k][j] == 6) {
	                    break;
	                }
	                visited[k][j] = 7;
	            }
	            break;
	    }
	}
	 
	public static class Node {
	    int x;
	    int y;
	    int idx;
	 
	    Node(int y, int x, int idx) {
	        this.x = x;
	        this.y = y;
	        this.idx = idx;
	    }
	}
}