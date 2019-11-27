package Dijkstra;

public class Dijkstra {
	// 최단 경로 트리에 아직 포함되지 않은 정점에서 최소 거리값으로 정점을 찾는 함수
	static final int V = 9;
	int minDistance(int dist[], boolean sptSet[]) {
		// 최소값 초기화
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
	// 생성된 배열 출력 함수
	void printSolution(int dist[], int n) {
		System.out.println("Vertex Distance from Source");
		for(int i=0; i<V; i++) {
			System.out.println(i+" \t\t "+dist[i]);
		}
	}
	// 인접 행렬을 사용하여 표시된 그래프에 대해 Dijkstra의 단일 소스 최단 경로 알고리즘 구현하는 메인 기능
	void dijkstra(int graph[][], int src) {
		// 출력 배열, src에서 i까지 최단거리 
		int dist[] = new int[V];
		// sptSet[i]가 최단 경로 트리에 포함되거나 src에서 i까지 최단 거리에 도달하면 sptSet[] = true로 표시
		boolean sptSet[] = new boolean[V];
		// 최소값 초기화 및 모든 거리 sptSet[i]로 초기화
		for(int i=0; i<V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		// 정점의 거리는 항상 0
		dist[src] = 0;
		// 모든 정점들에 대한 최단 경로 찾기
		for(int count=0; count<V-1; count++) {
			// 아직 처리되지 않은 정점 집합에서 최소 거리 정점을 선택
			// 항상 첫번째 반복에서 src와 동등하다
			int u = minDistance(dist, sptSet);
			// 처리된 정점에 지정된 정점 표시
			sptSet[u] = true;
			// 선택된 정점의 인접한 정점값을 업데이트
			for(int v=0; v<V; v++) {
				// sptSet[v]에 있지 않은 경우에만 업데이트 진행, u에서 v까지 총 가중치는 srt에서 v까지의 값보다 작다
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
		// 예제 그래프 생성
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

