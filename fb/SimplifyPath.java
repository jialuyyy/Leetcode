//".." means back to previous dir
//"." means remain on current dir
//"//" ignore
//split the string
//if the stack is not empty and the current string equals "..", pop the value of the stack
//if the current string equals .., ., or "", skip
//otherwise push it into the stack

public class SimplifyPath {
    public String simplifyPath(String path) {
        String ret = "";
        Deque<String> stack = new ArrayDeque<String>();
        
        String[] str = path.split("/");
        
        for (String s: str) {
            if (s.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (s.equals("..") || s.equals(".") || s.equals("")) {
                continue;
            } else {
                stack.push(s);
            }
        }
        
        while (!stack.isEmpty()) {
            ret = "/" + stack.pop() + ret;
        }
        
        return ret.length() == 0 ? "/" : ret;
    }
}
