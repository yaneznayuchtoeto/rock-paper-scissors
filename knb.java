
    import java.util.Random;
import java.util.Scanner;

    public class knb {
        private User user;
        private Computer computer;
        private int userScore;
        private int computerScore;
        private int numberOfGames;

        private enum Move {
            k, n, b;


            public int compareMoves(Move otherMove) {
                if (this == otherMove)
                    return 0;

                switch (this) {
                    case k:
                        return (otherMove == n ? 1 : -1);
                    case b:
                        return (otherMove == k ? 1 : -1);
                    case n:
                        return (otherMove == b ? 1 : -1);
                }


                return 0;
            }
        }

        private class User {
            private Scanner inputScanner;

            public User() {
                inputScanner = new Scanner(System.in);
            }

            public Move getMove() {
                System.out.print("камень, ножницы или бумага? ");

                String userInput = inputScanner.nextLine();
                userInput = userInput.toUpperCase();
                char firstLetter = userInput.charAt(0);
                if (firstLetter == 'К' || firstLetter == 'Н' || firstLetter == 'Б') {
                    switch (firstLetter) {
                        case 'К':
                            return Move.k;
                        case 'Н':
                            return Move.n;
                        case 'Б':
                            return Move.b;
                    }
                }


                return getMove();
            }


        }

        private class Computer {
            public Move getMove() {
                Move[] moves = Move.values();
                Random random = new Random();
                int index = random.nextInt(moves.length);
                return moves[index];
            }
        }

        public knb() {
            user = new User();
            computer = new Computer();
            userScore = 0;
            computerScore = 0;
            numberOfGames = 0;
        }

        public void startGame() {



            Move userMove = user.getMove();
            Move computerMove = computer.getMove();
            System.out.println("\nваш ход " + userMove + ".");
            System.out.println("ход компьютера " + computerMove + ".\n");


            int compareMoves = userMove.compareMoves(computerMove);
            switch (compareMoves) {
                case 0:
                    System.out.println("Tie!");
                    break;
                case 1:
                    System.out.println(userMove + " beats " + computerMove + " вы победили");
                    userScore++;
                    break;
                case -1:
                    System.out.println(computerMove + " beats " + userMove + " вы проиграли");
                    computerScore++;
                    break;
            }
            numberOfGames++;



        }




        public static void main(String[] args) {
            knb game = new knb();
            game.startGame();
        }
    }

