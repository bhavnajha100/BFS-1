// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int dependent = prerequisite[0];
            int independent = prerequisite[1];
            indegrees[dependent]++;

            if (!map.containsKey(independent)) {
                map.put(independent, new ArrayList());
            }

            map.get(independent).add(dependent);
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        // populate indegrees array
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }
        if (count == numCourses)
            return true;
        // cyclic condition, no course was added in indegrees array
        if (count == 0)
            return false;

        while(!q.isEmpty()) {
            int currentCourse = q.poll();
            // check for dpendent courses for the current course in the map
            List<Integer> dependentCourses = map.get(currentCourse);
            if (dependentCourses != null) {
                for (int dependentCourse : dependentCourses) {
                    // reduce the indegrees of dependent course by 1
                    indegrees[dependentCourse]--;
                    // if count in indegrees array is 0, add in the queue
                    if (indegrees[dependentCourse] == 0) {
                        q.add(dependentCourse);
                        // increase the size of the queue
                        count++;
                        if (count == numCourses)
                            return true;
                    }
                }
            }
        }
        return false;
    }
}