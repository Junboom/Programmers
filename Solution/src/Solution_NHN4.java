import java.io.*;
import java.util.*;

class Trie {
	Trie[] child;
	int cost;
	
	Trie() {
		child = new Trie[26];
		cost = 0;
	}
	
	void add(char ch, int cost) {
		this.cost = cost;
		Trie trie = new Trie();
		trie = child[ch-'A'];
		trie.cost += cost;
	}
}

class Solution_NHN4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		Trie root = new Trie();
		StringTokenizer st;
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			st.nextToken();
			root.add(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
		}
	}
}