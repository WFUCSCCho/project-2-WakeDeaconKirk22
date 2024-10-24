/***************************************************************************
 @file: TestAvlTree.java
 @description: This is the main function of the program where it record the
 run times of AVL and BST trees using a Array List
 @author:  Kennedy Kirk
 @date  Oct 24 ,2024

 *******************************************************************************/
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Collections;
// hello
public class Proj2 {

    public static void main(String[] args) throws IOException {
        // Use command line arguments to specify the input file
        ArrayList<String>NBAPlayer = new ArrayList<>();
        ArrayList<String>Backup=new ArrayList<>();
        BST<NBAPlayer> mybst = new BST<>();
        AvlTree<NBAPlayer> avlTree = new AvlTree<>();

        if (args.length != 2) {
            System.err.println("Usage: java TestAvl <input file> <number of lines>");
            System.exit(1);
        }


        String inputFileName = args[0];
        int numLines = Integer.parseInt(args[1]);

        // For file input
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream(inputFileName);
        inputFileNameScanner = new Scanner(inputFileNameStream);

        // ignore first line
        inputFileNameScanner.nextLine();
        for(int i = 0; i<numLines; i++) {
            NBAPlayer.add(inputFileNameScanner.nextLine());
        }
        Backup=NBAPlayer;

	// FINISH ME

// Takes the intial


     Collections.shuffle(NBAPlayer);
//Gives the rand insertion time
    long avlRandInsertTime = insertTime(avlTree, NBAPlayer);
    long bstRandInsertTime = insertTime(mybst, NBAPlayer);

    long bstSearchTimeRandom = searchTime(mybst,Backup);
    long avlSearchTimeRandom = searchTime(avlTree,Backup);

    Collections.sort(NBAPlayer);
    long  bstSortedSearchTime = searchTime(mybst,NBAPlayer);
    long avlSortedSearchTime = searchTime(avlTree,NBAPlayer);


        long avlSortedInsertTime = insertTime(avlTree,NBAPlayer);;
        long bstSortedInsertTime = insertTime(mybst,NBAPlayer);




        String result =
                         "Random Insertion Time:\n" + "AVL:" + avlRandInsertTime + "\n" + "BST:"+ bstRandInsertTime + "\n" +
                        "Sorted Insertion Time:\n" + "AVL:"+ avlSortedInsertTime + "\n" + "BST:"+ bstSortedInsertTime + "\n"
                        +"Random Search Time:\n" + "AVL:" + avlSearchTimeRandom  +"\n"+  "BST:" + bstSearchTimeRandom+
                       "\n"+ "Sorted Search Time:\n"+ "AVL:"+ avlSortedSearchTime+ "\n" + "BST:" + bstSortedSearchTime ;

        System.out.println(result);



String outFilePath = "./output.txt";




  writeToFile(result,outFilePath);


    }
    private static long insertTime(BST<NBAPlayer> bst , ArrayList<String>NBAPlayer) {
        long time = System.nanoTime();

            for(int i = 0; i < NBAPlayer.size(); i++) {
                String[] command = NBAPlayer.get(i).split(",");
                NBAPlayer player = new NBAPlayer( Integer.parseInt(command[0]), // id
                        command[1],//name
                        command[2], // team
                        Double.parseDouble(command[3]), // age
                        Double.parseDouble(command[4]), // player height
                        Double.parseDouble(command[5]), // player weight
                        command[6], // college name
                        command[7], // country name
                        command[8], // draft year
                        command[9], // draft round
                        command[10], // draft number
                        command[11], // games played (gp)
                        Double.parseDouble(command[12]), // points
                        Double.parseDouble(command[13]), // rebounds
                        Double.parseDouble(command[14]), // assists
                        Double.parseDouble(command[15]), // net rating
                        Double.parseDouble(command[16]), // offensive rebound percentage
                        Double.parseDouble(command[17]), // defensive rebound percentage
                        Double.parseDouble(command[18]), // usage percentage
                        Double.parseDouble(command[19]), // assist percentage
                        Double.parseDouble(command[20]),
                        command[21]);
                bst.insert(player);

        }
        long end = System.nanoTime();
        return end - time;
    }

    private static long insertTime(AvlTree<NBAPlayer> AvlTree, ArrayList<String>NBAPlayer) {
        long time = System.nanoTime();
        for(int i = 0; i < NBAPlayer.size(); i++) {
            String[] command = NBAPlayer.get(i).split(",");
            NBAPlayer player = new NBAPlayer( Integer.parseInt(command[0]), // id
                    command[1],//name
                    command[2], // team
                    Double.parseDouble(command[3]), // age
                    Double.parseDouble(command[4]), // player height
                    Double.parseDouble(command[5]), // player weight
                    command[6], // college name
                    command[7], // country name
                    command[8], // draft year
                    command[9], // draft round
                    command[10], // draft number
                    command[11], // games played (gp)
                    Double.parseDouble(command[12]), // points
                    Double.parseDouble(command[13]), // rebounds
                    Double.parseDouble(command[14]), // assists
                    Double.parseDouble(command[15]), // net rating
                    Double.parseDouble(command[16]), // offensive rebound percentage
                    Double.parseDouble(command[17]), // defensive rebound percentage
                    Double.parseDouble(command[18]), // usage percentage
                    Double.parseDouble(command[19]), // assist percentage
                    Double.parseDouble(command[20]),
                    command[21]);
            AvlTree.insert(player);
        }
        long end = System.nanoTime();
        return end - time;
    }

private static long searchTime(AvlTree<NBAPlayer> AvlTree, ArrayList<String>NBAPlayer) {
        long time = System.nanoTime();
        for(int i = 0; i < NBAPlayer.size(); i++) {
            String[] command = NBAPlayer.get(i).split(",");
            NBAPlayer player = new NBAPlayer( Integer.parseInt(command[0]), // id
                    command[1],//name
                    command[2], // team
                    Double.parseDouble(command[3]), // age
                    Double.parseDouble(command[4]), // player height
                    Double.parseDouble(command[5]), // player weight
                    command[6], // college name
                    command[7], // country name
                    command[8], // draft year
                    command[9], // draft round
                    command[10], // draft number
                    command[11], // games played (gp)
                    Double.parseDouble(command[12]), // points
                    Double.parseDouble(command[13]), // rebounds
                    Double.parseDouble(command[14]), // assists
                    Double.parseDouble(command[15]), // net rating
                    Double.parseDouble(command[16]), // offensive rebound percentage
                    Double.parseDouble(command[17]), // defensive rebound percentage
                    Double.parseDouble(command[18]), // usage percentage
                    Double.parseDouble(command[19]), // assist percentage
                    Double.parseDouble(command[20]),
                    command[21]);
            AvlTree.contains(player);
        }
    long end = System.nanoTime();
    return end - time;
}
private static long searchTime(BST<NBAPlayer>bst ,ArrayList<String>NBAPlayer) {
        long time = System.nanoTime();
        for(int i = 0; i < NBAPlayer.size(); i++) { String[] command = NBAPlayer.get(i).split(",");
            NBAPlayer player = new NBAPlayer( Integer.parseInt(command[0]), // id
                    command[1],//name
                    command[2], // team
                    Double.parseDouble(command[3]), // age
                    Double.parseDouble(command[4]), // player height
                    Double.parseDouble(command[5]), // player weight
                    command[6], // college name
                    command[7], // country name
                    command[8], // draft year
                    command[9], // draft round
                    command[10], // draft number
                    command[11], // games played (gp)
                    Double.parseDouble(command[12]), // points
                    Double.parseDouble(command[13]), // rebounds
                    Double.parseDouble(command[14]), // assists
                    Double.parseDouble(command[15]), // net rating
                    Double.parseDouble(command[16]), // offensive rebound percentage
                    Double.parseDouble(command[17]), // defensive rebound percentage
                    Double.parseDouble(command[18]), // usage percentage
                    Double.parseDouble(command[19]), // assist percentage
                    Double.parseDouble(command[20]),
                    command[21]);
            bst.search(player);
        }
    long end = System.nanoTime();
    return end - time;
  }

    public static void writeToFile(String content, String filePath) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filePath, true))) {
            printWriter.println(content);
        } catch (IOException e) {
            System.out.println("Error found while writing" + e.getMessage());
        }

    }
}





