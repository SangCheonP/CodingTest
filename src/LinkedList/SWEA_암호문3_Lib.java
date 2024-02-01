package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_암호문3_Lib {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = 1;

        while((st = new StringTokenizer(br.readLine())) != null){
            int wordsN = Integer.parseInt(st.nextToken());
            List<Integer> wordsArr = new ArrayList<>();
            int commandN;

            st = new StringTokenizer(br.readLine());

            for(int size = 0; size < wordsN; size++){
                wordsArr.add(Integer.parseInt(st.nextToken()));
            }

            commandN = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                String command = st.nextToken();
                if(command.equals("I")){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for(int i = 0; i < y; i++){
                        wordsArr.add(x, Integer.parseInt(st.nextToken()));
                        x++;
                    }

                }else if(command.equals("D")){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for(int i = 0; i < y; i++) {
                        wordsArr.remove(x);
                    }
                }else {
                    int y = Integer.parseInt(st.nextToken());

                    for(int i = 0; i < y; i++){
                        wordsArr.add(Integer.parseInt(st.nextToken()));
                    }
                }
            }

            System.out.print("#" + tc++);
            for(int i = 0; i < wordsArr.size(); i++){
                if(i == 10)
                    break;
                System.out.print(" " + wordsArr.get(i));
            }
            System.out.println();
        }
    }
}
