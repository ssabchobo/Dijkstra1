package Dijkstra;

public class Dijkstra {
	// �ִ� ��� Ʈ���� ���� ���Ե��� ���� �������� �ּ� �Ÿ������� ������ ã�� �Լ�
	static final int V = 9;
	int minDistance(int dist[], boolean sptSet[]) {
		// �ּҰ� �ʱ�ȭ
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		
		for(int v=0; v<V; v++) {
			if(sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}
		}
		return min_index;
	}
	// ������ �迭 ��� �Լ�
	void printSolution(int dist[], int n) {
		System.out.println("Vertex Distance from Source");
		for(int i=0; i<V; i++) {
			System.out.println(i+" \t\t "+dist[i]);
		}
	}
	// ���� ����� ����Ͽ� ǥ�õ� �׷����� ���� Dijkstra�� ���� �ҽ� �ִ� ��� �˰��� �����ϴ� ���� ���
	void dijkstra(int graph[][], int src) {
		// ��� �迭, src���� i���� �ִܰŸ� 
		int dist[] = new int[V];
		// sptSet[i]�� �ִ� ��� Ʈ���� ���Եǰų� src���� i���� �ִ� �Ÿ��� �����ϸ� sptSet[] = true�� ǥ��
		boolean sptSet[] = new boolean[V];
		// �ּҰ� �ʱ�ȭ �� ��� �Ÿ� sptSet[i]�� �ʱ�ȭ
		for(int i=0; i<V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		// ������ �Ÿ��� �׻� 0
		dist[src] = 0;
		// ��� �����鿡 ���� �ִ� ��� ã��
		for(int count=0; count<V-1; count++) {
			// ���� ó������ ���� ���� ���տ��� �ּ� �Ÿ� ������ ����
			// �׻� ù��° �ݺ����� src�� �����ϴ�
			int u = minDistance(dist, sptSet);
			// ó���� ������ ������ ���� ǥ��
			sptSet[u] = true;
			// ���õ� ������ ������ �������� ������Ʈ
			for(int v=0; v<V; v++) {
				// sptSet[v]�� ���� ���� ��쿡�� ������Ʈ ����, u���� v���� �� ����ġ�� srt���� v������ ������ �۴�
				if(!sptSet[v] && graph[u][v] != 0 
						&& dist[u] != Integer.MAX_VALUE 
						&& dist[u]+graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}
		printSolution(dist, V);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���� �׷��� ����
		int graph[][] = new int[][] {{0, 4, 0, 0, 0, 0, 0, 8, 0},
					     {4, 0, 8, 0, 0, 0, 0, 11, 0},
					     {0, 8, 0, 7, 0, 4, 0, 0, 2},
					     {0, 0, 7, 0, 9, 14, 0, 0, 0},
					     {0, 0, 0, 9, 0, 10, 0, 0, 0},
					     {0, 0, 4, 14, 10, 0, 2, 0, 0},
					     {0, 0, 0, 0, 0, 2, 0, 1, 6},
					     {8, 11, 0, 0, 0, 0, 1, 0, 7},
					     {0, 0, 2, 0, 0, 0, 6, 7, 0}};
									 
		Dijkstra t = new Dijkstra();
		t.dijkstra(graph, 0);
	}
}

