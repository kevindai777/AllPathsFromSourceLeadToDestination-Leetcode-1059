//Java Solution

class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<Integer>());
            }
            map.get(edge[0]).add(edge[1]);
        }
        
        if (map.containsKey(destination)) {
            return false;
        }
        
        Set<Integer> visited = new HashSet<>();
        return dfs(source, visited, map, destination);
    }
    
    public boolean dfs(int node, Set<Integer> visited, Map<Integer, List<Integer>> map, int destination) {
        if (!map.containsKey(node)) {
            return node == destination;
        }
        
        for (int i = 0; i < map.get(node).size(); i++) {
            int neighbor = map.get(node).get(i);
            
            if (visited.contains(neighbor)) {
                return false;
            }
            
            visited.add(neighbor);
            
            if (!dfs(neighbor, visited, map, destination)) {
                return false;
            }
            
            visited.remove(neighbor);
        }
        
        return true;
    }
}