package eg.edu.alexu.csd.datastructure.iceHockey.cs48;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class PlayersFinder implements IPlayersFinder {

	private boolean[][] visited;
	int counter, in_r, in_d, down, right, n;

	public Point[] findPlayers(String[] photo, int team, int threshold) {
		counter = in_r = in_d = down = right = n = 0;
		Point[] arrp = new Point[100];

		if (photo == null) {
			return null;
		}
		if (photo.length == 0) {
			Point[] points = {};
			return points;
		}
		team = team + 48;

		visited = new boolean[photo.length][photo[0].length()];
		for (int x = 0; x < photo.length; x++) {
			for (int y = 0; y < photo[0].length(); y++) {
				visited[x][y] = false;
			}
		}
		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[0].length(); j++) {
				counter = 0;
				in_r = j * 2;
				in_d = i * 2;
				right = in_r;
				down = in_d;
				if (!visited[i][j]) {
					if (photo[i].charAt(j) == (char) team) {
						counter += 4;
						visited[i][j] = true;
						right += 2;
						down += 2;
						right(i, j, photo, team);
						down(i, j, photo, team);
						left(i, j, photo, team);
					}
					if (counter >= threshold) {
						arrp[n] = new Point();
						arrp[n].x = (right + in_r) / 2;
						arrp[n].y = (down + in_d) / 2;
						n++;

					}
				}
			}
		}
		if (arrp[0] == null) {
			arrp[0] = new Point();
		} else {

			sort(arrp, n);

		}
		if (n == 0) {
			Point[] points = new Point[0];
			return points;
		} else {
			Point[] points = new Point[n];
			for (int j = 0; j < n; j++) {
				points[j] = arrp[j];
			}
			counter = 0;
			return points;
		}
	}

	// ----------------------------------------------------------------------
	void right(int i, int j, String[] photo, int team) {
		j = j + 1;
		if (j < photo[0].length()) {
			if (!visited[i][j]) {
				if (photo[i].charAt(j) == (char) team) {
					counter += 4;
					visited[i][j] = true;
					if (j * 2 >= right) {
						right += 2;
					}
					right(i, j, photo, team);
					left(i, j, photo, team);
					down(i, j, photo, team);
				}
			}
		}
	}

	// ----------------------------------------------------------------------
	void down(int i, int j, String[] photo, int team) {
		i = i + 1;
		if (i < photo.length) {
			if (!visited[i][j]) {
				if (photo[i].charAt(j) == (char) team) {
					counter += 4;
					visited[i][j] = true;
					if (i * 2 >= down) {
						down += 2;
					}
					right(i, j, photo, team);
					left(i, j, photo, team);
					down(i, j, photo, team);

				}
			}
		}
	}

	// ------------------------------------------------------------------------
	void left(int i, int j, String[] photo, int team) {
		j = j - 1;
		if (j >= 0) {
			if (!visited[i][j]) {
				if (photo[i].charAt(j) == (char) team) {
					counter += 4;
					visited[i][j] = true;
					if (j * 2 < in_r) {
						in_r -= 2;
					}
					right(i, j, photo, team);
					left(i, j, photo, team);
					down(i, j, photo, team);

				}
			}
		}
	}

	// -------------------------------------------------------------------------
	public void sort(Point[] points, int n) {

		int s = 0;
		do {
			s = 0;
			Point tmp = new Point();
			for (int i = 0; i < (n - 1); i++) {
				if (points[i].x > points[i + 1].x) {
					tmp = points[i];
					points[i] = points[i + 1];
					points[i + 1] = tmp;
					s++;
				} else if (points[i].x == points[i + 1].x) {
					if (points[i].y > points[i + 1].y) {
						tmp = points[i];
						points[i] = points[i + 1];
						points[i + 1] = tmp;
						s++;
					}
				}
			}
		} while (s > 0);
	}
}
