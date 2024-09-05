import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 칠공주_BOJ_1941 {
	static char[][] map; // 입력 받은 문자
	static boolean existArr[][]; // 조합으로 뽑은 7자리 수의 위치를 표현
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
		// 고른 수 7개를 existArr배열에 표현
		for (int i = st; i < 25; i++) {
			arr[cnt] = i;
			existArr[i / 5][i % 5] = true; // 일반 수를 좌표 값으로 계산 (i/5,i%5)
			if (map[i / 5][i % 5] == 'S') {
				combination(arr, cnt + 1, i + 1, sCount + 1);
			} else
				combination(arr, cnt + 1, i + 1, sCount);
			existArr[i / 5][i % 5] = false;
		}

	}

	private static void bfs(int start) { // 모든 수가 연결되어야하니 7개 숫자중 시작은 상관 없음
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
					// 4방위에 부분집합으로 고른 숫자(existArr 배열이 true)가 있으며 방문한 적이있는지 (nowVisit)
					q.add(nx * 5 + ny); // 배열 위치 좌표를 숫자로 면환 한 후 삽입
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
