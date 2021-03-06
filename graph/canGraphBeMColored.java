
/*
    Given an adjacency matrix of 0's and 1's with 1 meaning the two can't have the same color,
    find whether the graph can me m-colored or not.
    
    Things used: track[i] is a list with (color, beenOnQueue, OPTIONAL: list of connections)
    
    Comments: Accidentally used graph[i][j] value for look for color when I should've used j to look for color
    
    BFS Way
*/
public class Main {
    public static void main(String[] args) {
        int[][] testGraph1 = {{0, 0, 1, 0, 0, 0, 0, 0},
                              {0, 0, 0, 1, 0, 0, 0, 0},
                              {1, 0, 0, 0, 1, 1, 1, 0},
                              {0, 1, 0, 0, 0, 0, 0, 0},
                              {0, 0, 1, 0, 0, 0, 0, 0},
                              {0, 0, 1, 0, 0, 0, 0, 0},
                              {0, 0, 1, 0, 0, 0, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0}};
        
        int[][] testGraph2 = {{0, 1, 1, 1},
                              {1, 0, 0, 1},
                              {1, 0, 0, 1},
                              {1, 1, 1, 0}};
        
        int[][] testGraph3 = {{0, 1, 0 ,0},
                              {1, 0, 1, 0},
                              {0, 1, 0, 1},
                              {0, 0, 1, 0}};
        
        int[][] testGraph4 = {{0, 0, 0},
                              {0, 0, 0},
                              {0, 0, 0}};
        
        boolean canBeColored = canBeMColored(testGraph4, 2);
        System.out.println(canBeColored);
    }
    
    /** 
    * Loop through each person
    ** if person is not yet painted,
    *** add person to queue
    *** call bfs
    */
    static boolean canBeMColored(int[][] graph, int m) {
        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer>[] track = new List[graph.length];
        populateList(track);
        boolean canBeMColored = true;
        for (int i = 0; i < graph.length; i++) {
            if (track[i].get(1) == 0) {     //if person is not yet colored
                q.add(i);
                track[i].set(1, 1);
                canBeMColored = bfs(graph, m, q, track);
                //System.out.println("canBeMColored: " + canBeMColored);
                if(!canBeMColored){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
    * while queue is not empty
    ** get first one
    *** if not yet painted, try painting
    ** loop through everyone
    *** if you're not yourself
    **** make connection (add them to you, add you to them)
    **** if they're not colored yet,
    ***** put them into queue
    */
    
    static boolean bfs(int[][] graph, int m, Queue<Integer> q, List<Integer>[] track) {
        while(!q.isEmpty()) {
            int i = q.poll();
            //System.out.println("Evaluating user: " + i);
            boolean paintable = true;
            if(track[i].get(0) == -1) {     //if someone is not yet painted, try painting
                paintable = paintCurrent(i, m, track);
                //System.out.println("paintable: " + paintable);
                if(!paintable) {            //if someone can't be painted with available color, return false
                    return false;
                }
            }
            for (int j = 0; j < graph.length; j++) {
                if (j != i) {
                    if (graph[i][j] == 1) {
                        track[i].add(j);
                        track[j].add(i);
                        if (track[j].get(1) == 0) {
                            q.add(j);
                            track[j].set(1, 1);
                            //System.out.println("User added to queue: " + j);
                        }
                    }
                }
            }
        }
        return true;
    }
    
    /** 
    * get neighbors
    * call checkColors on each color while the color is within the available colors
    * keeps incrementing color if prev color is not working out
    */
    static boolean paintCurrent(int i, int m, List<Integer>[] track) {
        if(track[i].size() > 2) {
            List<Integer> subTrack  = track[i].subList(2, track[i].size());
            int color = 0;
            while(color < m) {
                if (checkNeighboringColors(track, subTrack, color)) {
                    track[i].set(0, color);
                    return true;
                }
                color++;
            }
            return false; 
        } else {
            track[i].set(0, 0);     //setting the color to first color since it has no connections
            return true;
        }    
    }
    
    
    /**
    * Loop through neighbors
    * if neighbor has color, false
    */
    static boolean checkNeighboringColors(List<Integer>[] track, List<Integer> subList, int c) {
        for (int k = 0; k < subList.size(); k++) {
            int neighbor = subList.get(k);
            //System.out.println("neighbor and color: " + neighbor + track[neighbor].get(0));
            if(track[neighbor].get(0) == c) {
                //System.out.println("Neighbor has the color");
                return false;
            }
        }
        return true;
    }
    
    static void populateList(List<Integer>[] track) {
        for (int i = 0; i< track.length; i++) {
            List<Integer> list =  new ArrayList<Integer>();
            list.add(-1);
            list.add(0);
            track[i] = list;
        }
    }
}


/***************************** DFS way ***************************/

public class Main {
    public static void main(String[] args) {
        int[][] test1 = {{0, 0, 1, 0, 0, 0, 0, 0},
                         {0, 0, 0, 1, 0, 0, 0, 0},
                         {1, 0, 0, 0, 1, 1, 1, 0},
                         {0, 1, 0, 0, 0, 0, 0, 0},
                         {0, 0, 1, 0, 0, 0, 0, 0},
                         {0, 0, 1, 0, 0, 0, 0, 0},
                         {0, 0, 1, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0}};
        
        int[][] test2 = {{0, 1, 1, 1},
                         {1, 0, 0, 1},
                         {1, 0, 0, 1},
                         {1, 1, 1, 0}};
        
        //a straight line
        int[][] test3 = {{0, 1, 0 ,0},
                         {1, 0, 1, 0},
                         {0, 1, 0, 1},
                         {0, 0, 1, 0}};
        
        int[][] test4 = {{0, 0, 0 ,0},
                         {0, 0, 0, 0},
                         {0, 0, 0, 0},
                         {0, 0, 0, 0}};
        
        int[][] test5 = {{1, 1, 1 ,1},
                         {1, 1, 1, 1},
                         {1, 1, 1, 1},
                         {1, 1, 1, 1}};
        
        int m = 3;
        boolean colorable = canBeMColored(test5, m);
        System.out.println("Can be "+ m + " colored: " + colorable);
    }
    static boolean canBeMColored(int[][] graph, int m) {
        int[] color = new int[graph.length];       //0 means not colored
        boolean[] beenOnStack = new boolean[graph.length];      //false means not been on stack at all
        Stack<Integer> stack = new Stack();
        boolean possible = true;    //assume it's true and then alert if it's not
        for (int i = 0; i < graph.length; i++) {
            if(!beenOnStack[i]) {
                stack.push(i);
                beenOnStack[i] = true;
                possible = dfs(graph, m, color, beenOnStack, stack);
                if(!possible) {
                    return false;
                }
            }
        }
        return true;    //true if no false flag has been raised at all
    }
    
    static boolean dfs(int[][] graph, int m, int[] color, boolean[] beenOnStack, Stack<Integer> stack) {
        boolean isValid = true;
        if(!stack.empty()) {
            int i = stack.peek();
            
            for (int j = 0; j < graph.length; j++) {
                if (j != i) {
                    if ((graph[i][j] == 1) && (!beenOnStack[j])) {
                        stack.push(j);
                        beenOnStack[j] = true;
                        isValid = dfs(graph, m, color, beenOnStack, stack);
                        if(!isValid) {
                            return false;
                        }
                    }
                }
            }
            
            //paint
            if(color[i] == 0) {
                isValid = canBePaintedAndPainted(graph, m, i, color);
                if (!isValid) {
                    return false;
                }
            }
            stack.pop();
        }
        return true;    //true if no false flag has been raised at all
    }
    
    static boolean canBePaintedAndPainted(int[][] graph, int m, int i, int[] color) {
        for (int c = 1; c <= m; c++) {
            boolean isAvailable = isColorAvailable(graph, c, i, color);
            if(isAvailable) {
                color[i] = c;
                //System.out.println(Arrays.toString(color));
                //System.out.println("Colored " + (i+1) + " with color: " + c);
                return true;
            }
        }
        return false;
    }
    
    static boolean isColorAvailable(int[][] graph, int c, int i, int[] color) {
        for (int j = 0; j < graph.length; j++) {
            if(j != i && graph[i][j] == 1) {
                //System.out.println((i+1)+"'s neighbor has color: "+ color[j]);
                if(color[j] == c) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    
}
