public class Obstacle implements InterfaceObstacle {
    private int param;

    public Obstacle() {

    }

    public boolean runTrack(int RunDistance) {
        return param - RunDistance <= 0;
    }

    public boolean jumpWall(int JumpHeight) {
        return param - JumpHeight <= 0;
    }
}