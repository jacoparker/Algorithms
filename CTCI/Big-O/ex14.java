class ex14 {
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

    public static long goodFib(int num) {
        System.out.println("Fibonacci number 0 is: 0");
        if (num > 1) {
            System.out.println("Fibonacci number 1 is: 1");            
        } else if (num == 1) {
            System.out.println("Fibonacci number 1 is: 1");
            return 1;
        } else {
            return 0;
        }
        
        long table[] = new long[num+1];
        table[0] = 0; table[1] = 1;

        for (int i=2; i < table.length; i++) {
            table[i] = table[i-1] + table[i-2];
            System.out.println("Fibonacci number " + i + " is: " + table[i]);
        }

        return table[num-1];
    }

    public static void main(String []args) {
        if (args.length < 1) {
            System.out.println("Usage: java ex14.java <number>");
            System.exit(1);
        } else if (Integer.parseInt(args[0]) < 0) {
            System.out.println("Number must be non negative.");
            System.exit(1);
        }

        long result = goodFib(Integer.parseInt(args[0]));
        // System.out.println("Result: " + result);
    }

}