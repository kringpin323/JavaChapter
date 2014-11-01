package Axin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author 吴鑫
 * @author 学号：20111003813
 * @author 班级：网络工程
 * @time 2014-10-25
 */
public class SuJianYu_Problem {

	/**
	 */
	private int Captain_Iron_heuristic(State state) {
		final int m = state.m;
		final int c = state.c;
		final int b = state.b;
		return (m + c - 2 * b);
	}
	
	/**
	 */
	private List<State> Captain_Iron_nextSteps(int N, int K, State current) {
		List<State> states = new ArrayList<State>();
		final int m = current.m;
		final int c = current.c;
		final int b = current.b;
		int nb = (b == 1 ? 0 : 1);

		if (m < c && m != 0) {
			return states;
		}

		int dm, dc;
		for (int i = 1; i < K + 1; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (b == 0) {
					// 返程，增加人数
					dm = -j;
					dc = j - i;
				} else {
					// 去程，减少人数
					dm = j;
					dc = i - j;
				}

				int nm = m - dm;
				int nc = c - dc;
				if ((nm >= nc || nm == 0) && nc >= 0 && 
						(Math.abs(dm) >= Math.abs(dc) || dm == 0)) {
					states.add(new State(nm, nc, nb, 0));
				}
			}
		}
		return states;
	}

	

	public static void main(String[] args) {
		SuJianYu_Problem p = new SuJianYu_Problem();

		Map<State, State> cameFrom = new HashMap<State, State>();
		Map<State, Integer> SuJianYu_trips = new HashMap<State, Integer>();

		int N = 2;	
		int K = 3;	

		p.A_Star(N, K, cameFrom, SuJianYu_trips);

		List<State> steps = p.Captain_Iron_reconstructPath(cameFrom);

		p.Captain_Iron_prettyPrint(steps, N);

		System.out.println(steps);
	}
	
	/**
	 */
	private void A_Star(
			int N, int K, 
			Map<State, State> cameFrom, 
			Map<State, Integer> SuJianYu_trips) {

		State START = new State(N, N, 1, 1);
		State FINISH = new State(0, 0, 0, 0);

		// 待扩展的结点集，按优先级决定扩展的先后顺序
		PriorityQueue<State> frontier = new PriorityQueue<State>(10, new Comparator<State>() {

			@Override
			public int compare(State lhs, State rhs) {
				return Integer.compare(lhs.priority, rhs.priority);
			}
		});

		frontier.offer(START);
		cameFrom.put(START, null);
		SuJianYu_trips.put(START, 0);

		while (!frontier.isEmpty()) {
			State current = frontier.poll();

			if (current.equals(FINISH)) {
				break;
			}

			for (State next : Captain_Iron_nextSteps(N, K, current)) {
				int newTripCount = SuJianYu_trips.get(current) + 1;
				if (!cameFrom.containsKey(next) || newTripCount < SuJianYu_trips.get(next)) {
					SuJianYu_trips.put(next, newTripCount);
					cameFrom.put(next, current);
					int priority = newTripCount + Captain_Iron_heuristic(next);
					next.priority = priority;
					frontier.offer(next);
				}
			}
		}		
	}

	

	/**
	 */
	private List<State> Captain_Iron_reconstructPath(Map<State, State> cameFrom) {
		List<State> steps = new ArrayList<State>();
		State current = new State(0, 0, 0, 0);
		steps.add(current);

		while (true) {
			State parent = cameFrom.get(current);
			if (parent == null) {
				break;
			}
			steps.add(0, parent);
			current = parent;
		}

		return steps;
	}



	/**
	 * 打印出渡河的整个过程
	 */
	private void Captain_Iron_prettyPrint(List<State> steps, int N) {
		int n = steps.size() - 1;
		System.out.println("初始状态：" + steps.get(0));
		System.out.println("终结状态：(0, 0, 0)");
		System.out.println("\n总共需渡河" + n + "次：");
		for (int i = 1; i < n + 1; i++) {
			int dm = steps.get(i).m - steps.get(i-1).m;
			int dc = steps.get(i).c - steps.get(i-1).c;
			int db = steps.get(i).b - steps.get(i-1).b;

			String s;
			if (db == -1) {
				s = String.format("#%d 去程，船上传道士=%d，钢铁侠=%d", i, -dm, -dc);
			} else {
				s = String.format("#%d 返程，船上传道士=%d，钢铁侠=%d", i, dm, dc);
			}
			System.out.println(s);
		}
	}

	/**
	 * 每个状态的表示
	 */
	static class State {
		int m;
		int c;
		int b;
		// 当前状态的优先级，取值越小，优先级越高，扩展结点时越优先选择
		int priority;

		public State() {
			this(0, 0, 0, 0);
		}

		public State(int m, int c, int b, int priority) {
			this.m = m;
			this.c = c;
			this.b = b;
			this.priority = priority;
		}

		@Override
		public boolean equals(Object arg) {
			if (arg == null || !(arg instanceof State)) {
				return false;
			}
			State other = (State) arg;
			return (this.m == other.m && this.c == other.c && this.b == other.b);
		}

		@Override
		public String toString() {
			return "(" + m + ", " + c + ", " + b + ")";
		}

		@Override
		public int hashCode() {
			return m << 16 + c << 8 + b;
		}
	}

	
}
