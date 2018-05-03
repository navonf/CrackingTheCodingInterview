// Navon Francis

import java.util.*;

public class graph {
  public static final Scanner sc = new Scanner(System.in);
  public static HashMap<Integer, Node> map;
  public static void main(String[] args) {
    int n = sc.nextInt();
    map = new HashMap<Integer, Node>(n);
    initGraph(n, map);
    int target = 6;
    bfs(map.get(0), n);
    System.out.println("DFS:");
    ddfs(map.get(0), new boolean[n]);
  }

  static void bee(Node root, int size) {
    ArrayDeque<Integer> q = new ArrayDeque<Integer>(size);
    boolean[] v = new boolean[size];
    q.add(root.order);
    v[root.order] = true;

    while(!q.isEmpty()) {
      int n = q.remove();
      Node node = map.get(n);

      // process our node! (print)
      System.out.println(n);

      for(int curr : node.adj)
        if(!v[curr]) {
          v[curr] = true;
          q.add(curr);
        }
    }
  }

  static void beefs(Node root, int size) {
    ArrayDeque<Integer> q = new ArrayDeque<Integer>(size);
    boolean[] visited = new boolean[size];
    int count = 0;
    q.add(root.order);
    visited[root.order] = true;

    while(!q.isEmpty()) {
      int curr = q.remove();
      Node node = map.get(curr);

      count++;
      if(count < size) System.out.print(curr + " -> ");
      else System.out.println(curr);

      for(int n : node.adj)
        if(!visited[n]) {
          visited[n] = true;
          q.add(n);
        }
    }
  }

  static void bfs(Node root, int size, int target) {
    System.out.println("BFS:");
    ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
    boolean[] visited = new boolean[size];
    visited[root.order] = true;
    queue.add(root.order);

    while(!queue.isEmpty()) {
      int n = queue.remove();
      Node node = map.get(n);
      System.out.println(n);

      for(int curr : node.adj)
        if(!visited[curr]) {
          visited[curr] = true;
          queue.add(curr);
        }
    }
    System.out.println("-------");
  }

  static void ddfs(Node root, boolean[] v) {
    if(root == null) return;

    System.out.println(root.order);
    v[root.order] = true;

    for(int n : root.adj)
      if(!v[n])
        ddfs(map.get(n), v);
  }
  static void dfs(Node root, boolean[] visited) {
    if(root == null) return;
    System.out.println(root.order);
    visited[root.order] = true;

    for(int curr : root.adj)
      if(!visited[curr])
        dfs(map.get(curr), visited);

  }

  static void initGraph(int n, HashMap<Integer, Node> map) {
    // graph set up
    sc.nextLine();
    for(int i = 0; i < n; i++) {
      String s = sc.nextLine();
      String[] nums = s.split(" ");
      String[] edges = Arrays.copyOfRange(nums, 1, nums.length);
      ArrayList<Integer> k = new ArrayList<Integer>(edges.length);
      for(int j = 0; j < edges.length; j++) {
        k.add(Integer.parseInt(edges[j]));
      }
      Node node = new Node(k, i);
      map.put(i, node);
    }
  }

  static class Node {
    public int order;
    public ArrayList<Integer> adj;
    public boolean marked;

    Node(ArrayList<Integer> k, int o) {
      order = o;
      marked = false;
      adj = k;
    }
  }
}
