public class Main {

    public static void main(String[] args) {
        runProgram();
    }

    static void runProgram() {
        Participant[] participant = new Participant[3];
        participant[0] = new Human("Петя", 1000, 4);
        participant[1] = new Cat("Васька", 800, 10);
        participant[2] = new Robot("Терминатор", 1500, 5);

        Obstacle[] obstacle = new Obstacle[2];
        obstacle[0] = new ObstacleTrack(1000);
        obstacle[1] = new ObstacleWall(5);

        for (int i = 0; i < participant.length; i++) {
            participant[i].run(obstacle[0]);
            participant[i].jump(obstacle[1]);
            participant[i].infoRun();
            participant[i].infoJump();
        }
    }
}