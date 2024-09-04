import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 칠공주_BOJ_1941 {
	static char[][] map;
	static boolean existArr[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 }, an = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new char[5][5];
		existArr = new boolean[5][5];

		for (int i = 0; i < 5; i++) {
			map[i] = sc.next().toCharArray();
		}
		combination(new int[7], 0, 0, 0);
		System.out.println(an);
	}

	private static void combination(int[] arr, int cnt, int st, int sCount) {
		if (cnt == 7) {
			if (sCount >= 4) {
				bfs(arr[0]);
			}
			return;
		}
		for (int i = st; i < 25; i++) {
			arr[cnt] = i;
			existArr[i / 5][i % 5] = true;
			if (map[i / 5][i % 5] == 'S') {
				combination(arr, cnt + 1, i + 1, sCount + 1);
			} else
				combination(arr, cnt + 1, i + 1, sCount);
			existArr[i / 5][i % 5] = false;
		}

	}

	private static void bfs(int start) {
		boolean[][] nowVisit = new boolean[5][5]; // 방문 체크 하기위한 배열
		int count = 1;

		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		nowVisit[start / 5][start % 5] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now / 5 + dx[i];
				int ny = now % 5 + dy[i];
				if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && existArr[nx][ny] && !nowVisit[nx][ny]) {
					// 4방위에 부분집합으로 고른 숫자(existArr 배열이 true)가 있으며 방문한 적이있는지 확인 (nowVisit)
					q.add(nx * 5 + ny);
					nowVisit[nx][ny] = true;
					count++;
				}
			}
		}
		if (count == 7) {
			an++;
		}
	}

}
