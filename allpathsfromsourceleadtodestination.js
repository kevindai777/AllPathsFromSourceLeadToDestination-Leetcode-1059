//Objective is to see whether a path exists from a source to a destination node

let n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2


//O(n) solution that does a DFS traversal over the graph to see if a path exists

let graph = new Map()
    
//Build the graph
for (let [v1, v2] of edges) {
    if (!graph.has(v1)) {
        graph.set(v1, new Set())
    }
    graph.get(v1).add(v2)
}

//The destination cannot have any outgoing edges
if (graph.has(destination)) {
    return false
}

let visited = new Set()

//DFS through graph
function dfs(node) {
    //Once we reach a node without an outgoing edge, it must
    //be the destination
    if (!graph.has(node)) {
        return node == destination
    }
    
    for (let neighbor of graph.get(node)) {
        //Check for cycle
        if (visited.has(neighbor)) {
            return false
        }
        visited.add(neighbor)
        
        //Check all neighbors
        if (!dfs(neighbor)) {
            return false
        }
        visited.delete(neighbor)
    }
    
    return true
}
return dfs(source)