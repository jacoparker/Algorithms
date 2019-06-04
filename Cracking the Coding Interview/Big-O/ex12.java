class ex12 {

    public static int counter = 0;

    public static void permutation(String str) {
        permutation(str, "");
    }

    public static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix + " " + ++counter);
        } else {
            for (int i=0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i+1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    public static void main(String []args) {
        if (args.length < 1) {
            System.out.println("Usage: java ex12.java <str>");
            System.exit(1);
        }

        permutation(args[0]);
    }
}