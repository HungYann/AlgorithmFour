import java.util.Stack;

public class DecimalToBinary {

        public static void main(String[] args) {
            int n =50;
            Stack<Integer> stack = new Stack<>();
            while(n>0){
                stack.push(n%2);
                n/=2;
            }

            while(!stack.isEmpty()){
                System.out.println(stack.pop());
            }


        }

    }


