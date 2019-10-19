/*On a single threaded CPU, we execute some functions.  Each function has a unique id between 0 and N-1.

We store logs in timestamp order that describe when a function is entered or exited.

Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".  For example, "0:start:3" means the function with id 0 started at the beginning of timestamp 3.  "1:end:2" means the function with id 1 ended at the end of timestamp 2.

A function's exclusive time is the number of units of time spent in this function.  Note that this does not include any recursive calls to child functions.

The CPU is single threaded which means that only one function is being executed at a given time unit.

Return the exclusive time of each function, sorted by their function id.*/

//logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
//Output: [3, 4]

/*
Using a stack to keep track of the functions. Using a prev variable to keep track of the previous timestamp. If the current one is
a start function, just update the exclusive time of the top function on the stack using curTimestamp - pre; If the current one
is an ending function, pop the top function on the stack and update the exclusive time using curTimestamp - prev + 1 and update the 
prev.
*/
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null || logs.size() == 0)
            return new int[]{};
        
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        String[] s = logs.get(0).split(":");
        //stack to store the id of each event
        stack.push(Integer.parseInt(s[0]));
        
        int i = 1, prev = Integer.parseInt(s[2]);
        
        while(i < logs.size()) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                }
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }
        
        return res;
        
    }
}
