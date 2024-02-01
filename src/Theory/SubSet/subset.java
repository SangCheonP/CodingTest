package Theory.SubSet;

public class subset {
    static int[] cards = {-7,-3,-2, 5, 8};
    static boolean isSelected[] = new boolean[cards.length];
    public static void main(String[] args) {

        subset(0);
    }

    public static void subset(int idx){
        if(idx == cards.length) {
            for(int i = 0; i < cards.length; i++){
                int result = 0;
                if(isSelected[i])
                    System.out.print(cards[i] + " ");
            }
            System.out.println();
            return;
        }

        isSelected[idx] = true;
        subset(idx + 1);
        isSelected[idx] = false;
        subset(idx + 1);
    }
}